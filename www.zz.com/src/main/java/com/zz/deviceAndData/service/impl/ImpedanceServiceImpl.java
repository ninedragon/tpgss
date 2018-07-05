package com.zz.deviceAndData.service.impl;

import com.zz.common.dao.t_abnormal_zMapper;
import com.zz.common.dao.t_cal_zMapper;
import com.zz.common.model.t_abnormal_z;
import com.zz.common.model.t_abnormal_zExample;
import com.zz.common.model.t_cal_z;
import com.zz.common.utils.linear.DataPoint;
import com.zz.common.utils.linear.RegressionLine;
import com.zz.deviceAndData.service.ImpedanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 90807 on 2018/6/28.
 */
@Service
public class ImpedanceServiceImpl implements ImpedanceService {
    private Logger logger = LoggerFactory.getLogger(ImpedanceServiceImpl.class);
   private int record_date;
   private String district;
   private int address;
   private int channel;

    @Autowired
    t_abnormal_zMapper t_abnormal_zMapper1;
    @Autowired
    t_cal_zMapper t_cal_zMapper1;
    /*
    * @param 查询所需数据
    * @return 将计算后的数据插入表中
    * */
    @Override
    public void calImpedance(int  recorddate,String district,int address,int channel) {
        // 【1】所有阻抗数据
        // 【1.1】re
        this.record_date=recorddate;
        this.district=district;
        this.address=address;
        this.channel=channel;
        t_abnormal_zExample t_abnormal_zExample1 = new t_abnormal_zExample();
        t_abnormal_zExample.Criteria criteria = t_abnormal_zExample1.createCriteria();
        criteria.andRecordDateBCDEqualTo(180630).andC_DistrictBCDIdEqualTo("2721").andC_AddressIdEqualTo(1).andC_ChannelIdEqualTo(5);
        t_abnormal_zExample1.setOrderByClause("TSegmentId asc");
        List<t_abnormal_z> t_abnormal_zList = t_abnormal_zMapper1.selectByExample(t_abnormal_zExample1);
        if (t_abnormal_zList.size() != 288) {
            return;
        }
        float uaArray[] = new float[288];
        float ubArray[] = new float[288];
        float ucArray[] = new float[288];
        // 数据库查出数据
        for (int i = 0; i < 288; i++) {
            uaArray[i] = t_abnormal_zList.get(i).getUa();
            ubArray[i] = t_abnormal_zList.get(i).getUb();
            ucArray[i] = t_abnormal_zList.get(i).getUc();
        }
        float iArray[] = new float[288];
        for (int i = 0; i < 288; i++) {
            iArray[i] = t_abnormal_zList.get(i).getI();
        }
        // 【1.2】生成deltaU，deltaI，计算
        float delta_ua_array[] = new float[288];
        float delta_ub_array[] = new float[288];
        float delta_uc_array[] = new float[288];
        for (int i = 0; i < 287; i++) {
            float deltaUa = uaArray[i] - uaArray[i + 1];
            float deltaUb = ubArray[i] - ubArray[i + 1];
            float deltaUc = ucArray[i] - ucArray[i + 1];
            delta_ua_array[i] = deltaUa;
            delta_ub_array[i] = deltaUb;
            delta_uc_array[i] = deltaUc;
        }
        float delta_i_array[] = new float[288];
        for (int i = 0; i < 287; i++) {
            float deltaI = iArray[i + 1] - iArray[i];
            delta_i_array[i] = deltaI;
        }
        // 【1.3】统计deltaI个数并计算
        int n10 = 0;// 大于10A的个数
        int n8 = 0;
        int n5 = 0;
        int n3 = 0;
        ArrayList<Object> di_list = new ArrayList<>();
        // 【1.3.1】先算出各种判断条件
        for (int i = 0; i < 287; i++) {
            if (delta_i_array[i] > 10) {
                n10++;
            }
            if (delta_i_array[i] > 8) {
                n8++;
            }
            if (delta_i_array[i] > 5) {
                n5++;
            }
            if (delta_i_array[i] > 3) {
                n3++;
            }


        // 【1.4】判断并根据情况执行

        }
        if (n10 >= 10) {//第一种情形：
            calZ(delta_ua_array, delta_ub_array, delta_uc_array, delta_i_array, di_list,10,true);

        } else if (n8 >= 10) {
            calZ(delta_ua_array, delta_ub_array, delta_uc_array, delta_i_array, di_list,8,true);
        } else if (n5 >= 10) {
            calZ(delta_ua_array, delta_ub_array, delta_uc_array, delta_i_array, di_list,5,true);

        } else if (n3 >= 10) {
            calZ(delta_ua_array, delta_ub_array, delta_uc_array, delta_i_array, di_list,3,true);

        } else if (n3 >= 5) {
            calZ(delta_ua_array, delta_ub_array, delta_uc_array, delta_i_array, di_list,3,false);
        } else {// 不计算，写数据库

        }
    }

    /*
    * 计算阻抗
    * */
    private void calZ(float[] delta_ua_array, float[] delta_ub_array, float[] delta_uc_array, float[] delta_i_array, ArrayList<Object> di_list,int bound,Boolean is_valid) {
        ArrayList<Object> ua_list = new ArrayList<>();
        ArrayList<Object> ub_list = new ArrayList<>();
        ArrayList<Object> uc_list = new ArrayList<>();
        for (int i = 0; i < 287; i++) {
            if (delta_i_array[i] > bound) {
                di_list.add(delta_i_array[i]);
                ua_list.add(delta_ua_array[i]);
                ub_list.add(delta_ub_array[i]);
                uc_list.add(delta_uc_array[i]);
            }
        }
        float za = calZ2(di_list, ua_list);
        float zb = calZ2(di_list, ub_list);
        float zc = calZ2(di_list, uc_list);
        t_cal_z t_cal_z1 = new t_cal_z();
        t_cal_z1.setC_DistrictBCDId(district);
        t_cal_z1.setC_AddressId(address);
        t_cal_z1.setC_ChannelId(channel);
        t_cal_z1.setIs_valid(is_valid);
        t_cal_z1.setRecord_date(record_date);
        t_cal_z1.setZa(za);
        t_cal_z1.setZb(zb);
        t_cal_z1.setZc(zc);
        t_cal_zMapper1.insertSelective(t_cal_z1);
    }



    /*
    线性相关计算
    * */
    private float calZ2(ArrayList<Object> di_list, ArrayList<Object> u_list) {
        RegressionLine line = new RegressionLine();
        for (int i = 0; i < di_list.size(); i++) {
            float x=Float.parseFloat(di_list.get(i).toString());
            float y=Float.parseFloat(u_list.get(i).toString());
            line.addDataPoint(new DataPoint(x,y));
        }

        return line.getA1();//返回k值
    }
    public static void main(String[] args) {
        RegressionLine line = new RegressionLine();
        line.addDataPoint(new DataPoint(1,1));
       System.out.println( "a1:"+line.getA1());
       System.out.println("a0:"+ line.getA0());
    }
}
