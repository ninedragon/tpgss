package com.zz.deviceAndData.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zz.analysisAndDisplay.service.WSMessageService;
import com.zz.common.dao.*;
import com.zz.common.model.*;
import com.zz.core.shiro.session.CustomSessionManager;
import com.zz.user.bo.UserOnlineBo;
import com.zz.user.service.UUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.utils.DateUtil;
import com.zz.deviceAndData.bo.NDTUData;
import com.zz.deviceAndData.service.DataCollectionService;
import com.zz.deviceAndData.utils.HexStringUtil;
import com.zz.deviceAndData.utils.Ints2floatUtil;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

    private static final int WRONGFORMAT = -1;
    private static final int NO_SUCH_OBJECT = -1;
    private static final int RIGTHFORMAT = 0;
    private static final int SUCCESSPROCESS = 0;
    private Logger logger = LoggerFactory.getLogger(DataCollectionServiceImpl.class);
    @Autowired
    CustomSessionManager customSessionManager;
    @Autowired
    OpdataMapper opdataMapper;
    @Autowired
    ShortIMapper shortIMapper;
    @Autowired
    LeakageIMapper leakageIMapper;
    @Autowired
    AbleakageIMapper ableakageIMapper;
    @Autowired
    AbnormalUMapper abnormalUMapper;
    @Autowired
    t_abnormal_zMapper t_abnormalZMapper1;
    @Autowired
    PowerQualityMapper powerQualityMapper;
    @Autowired
    t_bdtuMapper t_bdtuMapper1;
    @Autowired
    t_fault_baseMapper t_fault_baseMapper1;
    @Autowired
    t_fault_nowMapper t_fault_nowMapper1;
    @Autowired
    t_fault_sourceMapper t_fault_sourceMapper1;
    @Autowired
    t_ndtuMapper t_ndtuMapper1;
    @Autowired
    t_meterMapper t_meterMapper1;
    @Autowired
    t_meterboxMapper t_meterboxMapper1;
    @Autowired
    t_branchboxMapper t_branchboxMapper1;
    @Autowired
    t_outgoingcabinetMapper t_outgoingcabinetMapper1;
    @Autowired
    t_substainMapper t_substainMapper1;
    @Autowired
    UUserService userService;

    @Autowired
    private WSMessageService wsMessageService;

    @Override
    public int dataProcess(NDTUData ndtudata) {
        // 三步处理
        if (WRONGFORMAT == dataValidation(ndtudata)) {
            return WRONGFORMAT;
        }
        ;
        dealReceiveData(ndtudata);
        return SUCCESSPROCESS;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.zz.deviceAndData.service.DataCollectionService#DataFetch(com.zz.
     * deviceAndData.bo.NDTUData) 数据获取判断是否合法
     */
    @Override
    public int dataValidation(NDTUData ndtudata) {
        // 判断是否合法等
        // 0表示合法，-1表示非法
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        return frameFormatCheck(buff);
    }

	/*
     * (non-Javadoc)
	 *
	 * @see com.zz.deviceAndData.service.DataCollectionService#DataWrite()
	 * 写入数据库操作
	 */

    @Override
    public Opdata dataAnalysis(NDTUData ndtudata) {
        Opdata opdata = new Opdata();
        dealReceiveData(ndtudata);
        return opdata;
    }

	/*
     * (non-Javadoc)
	 *
	 * @see com.zz.deviceAndData.service.DataCollectionService#DataAnalysis()
	 * 根据控制码处理不同的流程
	 */

    @Override
    public int insertData(Object object) {
        int errorCode = 0;
        String className = object.getClass().getSimpleName();
        switch (className) {
            case "Opdata":
                return opdataMapper.insertSelective((Opdata) object);
            case "ShortI":// 短路电流
                shortIMapper.insertSelective((ShortI) object);
                String shortIrecordId = ((ShortI) object).getId() + "";
                insertShortIFault(object, shortIrecordId);// 11表示短路

                return errorCode;
            case "LeakageI":// 正常漏电电流
                return leakageIMapper.insertSelective((LeakageI) object);
            case "AbleakageI":// 异常漏电电流
                ableakageIMapper.insertSelective((AbleakageI) object);
                String ableakageIrecordId = ((AbleakageI) object).getId() + "";
                AbleakageI ableakageI = (AbleakageI) object;//object每次都要写转换看着累，就先转了算了
                Boolean isLeakageAbnormal = (ableakageI).getIsAbnormal();
                //其实终端已经做过异常，恢复异常校验，但是再校验也没什么的
                Float abnormalBound = 0.03f;// 漏电超过30mA被认为异常
                Float normalBound = 0.02f;// 电流恢复为20mA被认为恢复
                Boolean isAbLeakage = (ableakageI.getI() >= abnormalBound);
                Boolean isNormal = (ableakageI.getI() <= normalBound);
                if (isLeakageAbnormal) {// 【1】异常产生
                    if (isAbLeakage) {// 【1.1】异常漏电上报走的流程
                        insertAbLeakageFault(object, ableakageIrecordId, 12);
                    }
                } else if (isNormal) {// 【2】异常被修复
                    updateFault(object, ableakageIrecordId);
                } else {
                    logger.error("终端上报的异常漏电数据在20mA和30mA之间，终端程序可能出现异常");
                }
                return errorCode;
            case "AbnormalU":// 异常电压
                abnormalUMapper.insertSelective((AbnormalU) object);
                String recordId = ((AbnormalU) object).getId() + "";
                AbnormalU abnormalU = (AbnormalU) object;//object每次都要写转换看着累，就先转了算了
                Boolean isAbnormal = (abnormalU).getIsAbnormal();
                Float uaBound = 100f;// a 相临界值
                Float ubcBound = 100f;// b 相临界值
                Float uabcAbnoramlMax = 240f;// 电压最大值
                Float uabcAbnoramlMin = 200f;// 电压最小值
                Boolean isPowerFailure = (abnormalU.getUa() <= ubcBound);
                Boolean isPhaseLoss = (abnormalU.getUb() <= ubcBound) || (abnormalU.getUc() <= ubcBound);
                Boolean b_is_loss = (abnormalU.getUb() <= ubcBound) && (abnormalU.getUc() > ubcBound);
                Boolean c_is_loss = (abnormalU.getUc() <= ubcBound) && (abnormalU.getUb() > ubcBound);
                Boolean bc_is_loss = (abnormalU.getUc() <= ubcBound) && (abnormalU.getUb() <= ubcBound);
                Boolean isOverFlow = (abnormalU.getUa() < uabcAbnoramlMin) || (abnormalU.getUa() > uabcAbnoramlMax) || (abnormalU.getUb() < uabcAbnoramlMin) || (abnormalU.getUb() > uabcAbnoramlMax) || (abnormalU.getUc() < uabcAbnoramlMin) || (abnormalU.getUc() > uabcAbnoramlMax);
//                停电：A相电压小于100V时认为停电；
//                缺相：B、C相电压小于100V时认为缺相；
//                电压超限：A、B、C三相电压小于200V或大于240V时认为电压异常（不存在以上两种的情况下）；
                int deviceType = Integer.parseInt(abnormalU.getcAddressid().toString().substring(0, 1));
                if (deviceType == 1) {// 表示ndtu
                    if (isAbnormal) {// 【1】异常产生
                        if (isPowerFailure) {// 【1.1】停电上报走的流程

                            insertFaultPowerFailure(object, recordId, 21);// TODO: 2018/6/27 以后可能把停电缺相超限方法分开
                        } else if (isPhaseLoss)//
                        {
                            System.out.println("缺相");// 目前看来逻辑好像和停电是一样的
                            if (b_is_loss) {
                                insertFaultPowerFailure(object, recordId, 221);
                            } else if (c_is_loss) {
                                insertFaultPowerFailure(object, recordId, 222);
                            } else if (bc_is_loss) {
                                insertFaultPowerFailure(object, recordId, 223);
                            }
                        } else if (isOverFlow) {
                            System.out.println("超限");// 目前看来逻辑好像和停电是一样的
                            insertFaultPowerFailure(object, recordId, 23);
                        }
                    } else {// 【2】异常被修复
                        //【2.1】故障修改：只需要更新now故障表就行，没有问题的话
                        //【2.2】通知websocket服务端
                        updateFault(object, recordId);


                    }
                } else if (deviceType == 7) {// 表示bdtu
                    if (isAbnormal) {// 【1】异常产生
                        if (isPowerFailure) {// 【1.1】停电上报走的流程

                            insertFaultPowerFailure(object, recordId, 41);// TODO: 2018/6/27 以后可能把停电缺相超限方法分开
                        } else if (isPhaseLoss)//
                        {
                            System.out.println("缺相");// 目前看来逻辑好像和停电是一样的
                            if (b_is_loss) {
                                insertFaultPowerFailure(object, recordId, 421);
                            } else if (c_is_loss) {
                                insertFaultPowerFailure(object, recordId, 422);
                            } else if (bc_is_loss) {
                                insertFaultPowerFailure(object, recordId, 423);
                            }
                        } else if (isOverFlow) {
                            System.out.println("超限");// 目前看来逻辑好像和停电是一样的
                            insertFaultPowerFailure(object, recordId, 43);
                        }
                    } else {// 【2】异常被修复
                        //【2.1】故障修改：只需要更新now故障表就行，没有问题的话
                        //【2.2】通知websocket服务端
                        updateFault(object, recordId);


                    }
                }

                return errorCode;
            case "t_abnormal_z":// 异常阻抗
                return t_abnormalZMapper1.insertSelective((t_abnormal_z) object);
            case "PowerQuality":// 电能质量
                return powerQualityMapper.insertSelective((PowerQuality) object);
            default:
                return NO_SUCH_OBJECT;
        }
    }

    private void insertAbLeakageFault(Object object, String recordId, int fault_type) {
        {
            // 【1】插入base表
            String substainId = "";
            t_fault_base t_fault_base1 = new t_fault_base();
            AbleakageI ableakageI = (AbleakageI) object;
            //【1.1】判断类型是bdtu还是
            int deviceType = Integer.parseInt(ableakageI.getcAddressid().toString().substring(0, 1));
            if (deviceType == 1)//1表示是ndtu,2表示bdtu。目前为了测试数据
            {   // (1)
                substainId = t_substainMapper1.selectSubstainIdByNdtu(ableakageI.getcDistrictbcdid().toString(), ableakageI.getcAddressid());
                t_fault_base1.setSubstain_id(substainId);
                t_fault_base1.setType(1);//表示表出现故障
                // (2)
                t_meterExample t_meterExample1 = new t_meterExample();
                t_meterExample.Criteria criteria = t_meterExample1.createCriteria();
                criteria.andC_AddressIdEqualTo(ableakageI.getcAddressid().toString()).andC_DistrictBCDIdEqualTo(ableakageI.getcDistrictbcdid()).andLeak_channel_idEqualTo(ableakageI.getcChannelid());
                List<t_meter> t_meterList = t_meterMapper1.selectByExample(t_meterExample1);
                t_fault_base1.setKey_id(t_meterList.get(0).getMeterId().toString());
                t_fault_base1.setFault_type(fault_type);
            } else {

            }
            t_fault_base1.setOccur_time(ableakageI.getOccurtime());
            t_fault_base1.setIs_cancelled(0);//否
            t_fault_base1.setRepair_time(null);
            t_fault_base1.setIs_repaired(0);//否
            t_fault_baseExample t_fault_baseExample1 = new t_fault_baseExample();
            t_fault_baseExample1.setOrderByClause("occur_time DESC");
            t_fault_baseExample.Criteria criteria = t_fault_baseExample1.createCriteria();
            criteria.andFault_typeEqualTo(t_fault_base1.getFault_type()).andKey_idEqualTo(t_fault_base1.getKey_id()).andIs_repairedEqualTo(0).andIs_sameEqualTo(false);
            List<t_fault_base> t_fault_bases = t_fault_baseMapper1.selectByExample(t_fault_baseExample1);
            if (t_fault_bases.size() == 1) {//表示存在重复数据，不需要进行更新操作
                t_fault_base1.setIs_same(true);
                t_fault_base1.setFault_base_id(t_fault_bases.get(0).getId().toString());
            } else if (t_fault_bases.size() == 0) {
                // b.设置开始的base故障为false
                t_fault_base1.setIs_same(false);
            }
            t_fault_baseMapper1.insertSelective(t_fault_base1);
            long id = t_fault_base1.getId();
            //【2】插入source表
            t_fault_source t_fault_source1 = new t_fault_source();
            t_fault_source1.setFault_id(id + "");
            t_fault_source1.setTable_name("3");
            t_fault_source1.setRecord_id(recordId);
            t_fault_sourceMapper1.insertSelective(t_fault_source1);
            noticeServer(substainId);
        }
    }


    /*
    * 插入短路故障逻辑
    * */

    private void insertShortIFault(Object object, String recordId) {
        // 【1】插入base表
        String substainId = "";
        t_fault_base t_fault_base1 = new t_fault_base();
        ShortI shortI = (ShortI) object;
        // 【1】插入base表
        /*`id` bigint(20) NOT NULL AUTO_INCREMENT,
        `type` int(11) DEFAULT NULL COMMENT '属于哪种类型的节点，1表示表，2表示表箱，3表示分支箱，4表示出线柜，5表示箱变',
        `key_id` varchar(36) DEFAULT NULL COMMENT '对应的topo结构表中的id',
        `fault_type` int(11) DEFAULT NULL COMMENT '错误类型10表（11表示用户短路，12表示用户异常漏电），20表箱（21停电，221缺B相，222缺C相，223缺BC相，23超限），30分支箱故障（31表示停电，32表示缺相，33表示超限，34表示短路），40出线柜故障，50箱变故障',
        `occur_time` datetime DEFAULT NULL COMMENT '故障发生时间',
        `is_cancelled` int(11) DEFAULT NULL COMMENT '故障是否取消，由于进一步判断故障被替换成另一个故障',
        `repair_time` datetime DEFAULT NULL COMMENT '修复时间',
        `is_repaired` int(11) DEFAULT NULL COMMENT '是否修复',
        `substain_id` varchar(36) DEFAULT NULL,
        `is_same` tinyint(4) DEFAULT NULL,
        `fault_base_id` varchar(36) DEFAULT NULL COMMENT '表示与t_fault_base表中的哪条记录关联',*/

        //【1.1】先判断type
        //【1.1】
        // (1)去找substain_id,插入substain_id
        // (2)再根据type的add，dis，chan去数据库找对应的设备，从而得到key_id,再插入fault_type
        // (3)插入发生时间，setIs_cancelled，setIs_repaired，setRepair_time
        //（4）根据key_id,fault_type,is_same为0找到是否有记录，
        //    有就插入is_same为1,同时返回fault_base_id插入到其中
        // (4.1)如果还有其它缺相数据一律先恢复
        //【2】插入source表
        /* `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '1表示t_short_i，2表示t_leakage_i，3表示t_ableakage_i，4表示t_abnormal_u,5表示t_abnormal_z，6表示t_power_quality',
        `fault_id` varchar(36) DEFAULT NULL COMMENT '表示t_fault_now的id',
        `table_name` varchar(255) DEFAULT NULL,
        `record_id` varchar(36) DEFAULT NULL,
        PRIMARY KEY (`id`)*/
        // (1)插入fault_id,table_name，record_id
        int deviceType = Integer.parseInt(shortI.getcAddressid().toString().substring(0, 1));
        if (deviceType == 1)//1表示是ndtu,2表示bdtu。目前为了测试数据
        { //(1)
            substainId = t_substainMapper1.selectSubstainIdByNdtu(shortI.getcDistrictbcdid().toString(), shortI.getcAddressid());
            t_fault_base1.setSubstain_id(substainId);
            t_fault_base1.setType(1);//表示表出现故障
            //(2)
            t_meterExample t_meterExample1 = new t_meterExample();
            t_meterExample.Criteria criteria = t_meterExample1.createCriteria();
            criteria.andC_AddressIdEqualTo(shortI.getcAddressid().toString()).andC_DistrictBCDIdEqualTo(shortI.getcDistrictbcdid()).andC_ChannelIdEqualTo(shortI.getcChannelid());
            List<t_meter> t_metersList = t_meterMapper1.selectByExample(t_meterExample1);//在资产相关表中查出id
            t_fault_base1.setKey_id(t_metersList.get(0).getMeterId().toString());//
            t_fault_base1.setFault_type(11);// 表示电表短路

        } else if (deviceType == 7) {
            int channel_id = shortI.getcChannelid();
            substainId = t_substainMapper1.selectSubstainIdByBdtu(shortI.getcDistrictbcdid().toString(), shortI.getcAddressid());
            t_fault_base1.setSubstain_id(substainId);
            t_fault_base1.setType(3);//表示分支箱异常
            t_branchboxExample t_branchboxExample1 = new t_branchboxExample();
            t_branchboxExample.Criteria criteria = t_branchboxExample1.createCriteria();
            criteria.andC_AddressIdEqualTo(shortI.getcAddressid().toString()).andC_DistrictBCDIdEqualTo(shortI.getcDistrictbcdid()).andC_ChannelIdEqualTo(shortI.getcChannelid());
            t_branchboxExample.Criteria criteria_b = t_branchboxExample1.createCriteria();
            t_branchboxExample1.or(criteria_b);
            criteria_b.andC_AddressIdEqualTo(shortI.getcAddressid().toString()).andC_DistrictBCDIdEqualTo(shortI.getcDistrictbcdid()).andC_ChannelId_bEqualTo(shortI.getcChannelid());
            t_branchboxExample.Criteria criteria_c = t_branchboxExample1.createCriteria();
            criteria_c.andC_AddressIdEqualTo(shortI.getcAddressid().toString()).andC_DistrictBCDIdEqualTo(shortI.getcDistrictbcdid()).andC_ChannelId_cEqualTo(shortI.getcChannelid());
            t_branchboxExample1.or(criteria_c);
            List<t_branchbox> t_branchboxList = t_branchboxMapper1.selectByExample(t_branchboxExample1);//在资产相关表中查出id
            t_fault_base1.setKey_id(t_branchboxList.get(0).getBranchBoxId().toString());
            if (t_branchboxList.get(0).getC_ChannelId() == channel_id) {
                t_fault_base1.setFault_type(31);//表示分支箱A相短路
            } else if (t_branchboxList.get(0).getC_ChannelId_b() == channel_id) {
                t_fault_base1.setFault_type(32);//表示分支箱B相短路
            } else if (t_branchboxList.get(0).getC_ChannelId_c() == channel_id) {
                t_fault_base1.setFault_type(33);//表示分支箱C相短路
            }
        }
        // (1)
        t_fault_base1.setOccur_time(shortI.getOccurtime());
        t_fault_base1.setIs_cancelled(0);//否
        t_fault_base1.setRepair_time(null);
        t_fault_base1.setIs_repaired(0);//否
        // (4)
        t_fault_base1.setOccur_time(shortI.getOccurtime());
        t_fault_base1.setIs_cancelled(0);//否
        t_fault_base1.setRepair_time(null);
        t_fault_base1.setIs_repaired(0);//否
        // (4)
        t_fault_baseExample t_fault_baseExample1 = new t_fault_baseExample();
        t_fault_baseExample1.setOrderByClause("occur_time DESC");
        t_fault_baseExample.Criteria criteria = t_fault_baseExample1.createCriteria();
        criteria.andFault_typeEqualTo(t_fault_base1.getFault_type()).andKey_idEqualTo(t_fault_base1.getKey_id()).andIs_repairedEqualTo(0).andIs_sameEqualTo(false);
        List<t_fault_base> t_fault_bases = t_fault_baseMapper1.selectByExample(t_fault_baseExample1);
        if (t_fault_bases.size() == 1) {//表示存在重复数据，不需要进行更新操作
            t_fault_base1.setIs_same(true);
            t_fault_base1.setFault_base_id(t_fault_bases.get(0).getId().toString());
        } else if (t_fault_bases.size() == 0) {// 表示无重复数据
            t_fault_base1.setIs_same(false);
        }
        t_fault_baseMapper1.insertSelective(t_fault_base1);
        long id = t_fault_base1.getId();
        //【2】插入source表
        t_fault_source t_fault_source1 = new t_fault_source();
        t_fault_source1.setFault_id(id + "");
        t_fault_source1.setTable_name("1");
        t_fault_source1.setRecord_id(recordId);
        t_fault_sourceMapper1.insertSelective(t_fault_source1);
        noticeServer(substainId);

    }

    private void updateFault(Object object, String recordId) {
        String substainId = "";
        String className = object.getClass().getSimpleName();
        int deviceType = 0;
        if ("Opdata".equals(className)) {
        } else if ("ShortI".equals(className)) {
        } else if ("LeakageI".equals(className)) {
        } else if ("AbleakageI".equals(className)) {
            // 【1.1】异常电流恢复
            // 【1.1.1】（根据传来的object）得到一个now和base的基本数据，
            t_fault_base t_fault_base1 = new t_fault_base();
            AbleakageI ableakageI = (AbleakageI) object;
            //判断类型是bdtu还是ndtu
            deviceType = Integer.parseInt(ableakageI.getcAddressid().toString().substring(0, 1));
            int type = 0;
            if (deviceType == 1)//1表示是ndtu,2表示bdtu。目前为了测试数据 //更新电表异常电流恢复
            {
                substainId = t_substainMapper1.selectSubstainIdByNdtu(ableakageI.getcDistrictbcdid().toString(), ableakageI.getcAddressid());
                t_fault_base1.setSubstain_id(substainId);
                t_fault_base1.setType(1);//电表故障
                t_meterExample t_meterExample1 = new t_meterExample();
                t_meterExample.Criteria criteria = t_meterExample1.createCriteria();
                criteria.andC_DistrictBCDIdEqualTo(ableakageI.getcDistrictbcdid()).andC_AddressIdEqualTo(ableakageI.getcAddressid().toString()).andLeak_channel_idEqualTo(ableakageI.getcChannelid());
                List<t_meter> t_meterList = t_meterMapper1.selectByExample(t_meterExample1);
                t_fault_base1.setKey_id(t_meterList.get(0).getMeterId());// 根据电表得到电表id
                type = 1;
            } else {

            }
            t_fault_baseExample t_fault_baseExample2 = new t_fault_baseExample();
            t_fault_baseExample.Criteria criteria2 = t_fault_baseExample2.createCriteria();
            criteria2.andKey_idEqualTo(t_fault_base1.getKey_id()).andFault_typeEqualTo(12).andIs_repairedEqualTo(0).andIs_sameEqualTo(false);
            t_fault_base paramsMap = new t_fault_base();
            paramsMap.setIs_repaired(1);
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            paramsMap.setRepair_time(timeStamp);
            List<t_fault_base> t_fault_bases = t_fault_baseMapper1.selectByExample(t_fault_baseExample2);//是否故障的
            int updateCode = t_fault_baseMapper1.updateByExampleSelective(paramsMap, t_fault_baseExample2);
            if (updateCode == 0) {
                logger.info("终端的缺相异常故障目前只有一个");
            } else {
                logger.info("数据库中有" + updateCode + "条缺相故障被修复");
            }
            // 【2】插入source表，得先找到那些未被修复的非重复的故障的数据,同时直接将每条数据的id得到设置为base的id
            t_fault_source t_fault_source1 = new t_fault_source();
            t_fault_source1.setTable_name("4");
            t_fault_source1.setRecord_id(recordId);
            for (int i = 0; i < t_fault_bases.size(); i++) {
                t_fault_source1.setFault_id(t_fault_bases.get(i).getId() + "");
                t_fault_sourceMapper1.insertSelective(t_fault_source1);
            }
        } else if ("AbnormalU".equals(className)) {
            // 恢复为正常供电，将所有故障全部恢复
            //
            // 【步骤】更新base表，插入source表。
            // 【1】先根据条件判断是ndtu还是bdtu，更新base表，找到对应的记录的条件fault_type为电压的故障，key_id相等
            // 【2】插入source表，source表id写什么呢
            t_fault_base t_fault_base1 = new t_fault_base();
            AbnormalU abnormalU = (AbnormalU) object;
            //【1.1】判断类型是bdtu还是
            deviceType = Integer.parseInt(abnormalU.getcAddressid().toString().substring(0, 1));
            int type = 0;
            if (deviceType == 1)//1表示是ndtu,2表示bdtu。目前为了测试数据
            {
                substainId = t_substainMapper1.selectSubstainIdByNdtu(abnormalU.getcDistrictbcdid().toString(), abnormalU.getcAddressid());
                t_fault_base1.setSubstain_id(substainId);
                t_fault_base1.setType(2);//表箱故障
                t_meterboxExample t_meterboxExample1 = new t_meterboxExample();
                t_meterboxExample.Criteria criteria2 = t_meterboxExample1.createCriteria();
                criteria2.andC_DistrictBCDIdEqualTo(abnormalU.getcDistrictbcdid()).andC_AddressIdEqualTo(abnormalU.getcAddressid().toString());
                List<t_meterbox> t_meterboxList = t_meterboxMapper1.selectByExample(t_meterboxExample1);//目的在于得到表的id
                t_fault_base1.setKey_id(t_meterboxList.get(0).getMeterBoxId());
                type = 2;
            } else if (deviceType == 7) {
                substainId = t_substainMapper1.selectSubstainIdByBdtu(abnormalU.getcDistrictbcdid().toString(), abnormalU.getcAddressid());
                t_fault_base1.setSubstain_id(substainId);
                t_fault_base1.setType(4);//表示出线柜出现故障
                t_outgoingcabinetExample t_outgoingcabinetExample = new t_outgoingcabinetExample();
                t_outgoingcabinetExample.Criteria criteria3 = t_outgoingcabinetExample.createCriteria();
                criteria3.andC_DistrictBCDIdEqualTo(abnormalU.getcDistrictbcdid()).andC_AddressIdEqualTo(abnormalU.getcAddressid().toString());
                List<t_outgoingcabinet> t_outgoingcabinetList = t_outgoingcabinetMapper1.selectByExample(t_outgoingcabinetExample);
                t_fault_base1.setKey_id(t_outgoingcabinetList.get(0).getOutgoingCabinetId().toString());
                type = 4;
            }

            t_fault_baseExample t_fault_baseExample2 = new t_fault_baseExample();
            t_fault_baseExample.Criteria criteria2 = t_fault_baseExample2.createCriteria();
            criteria2.andKey_idEqualTo(t_fault_base1.getKey_id()).andTypeEqualTo(type).andIs_repairedEqualTo(0).andIs_sameEqualTo(false);
            t_fault_base paramsMap = new t_fault_base();
            paramsMap.setIs_repaired(1);
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            paramsMap.setRepair_time(timeStamp);
            List<t_fault_base> t_fault_bases = t_fault_baseMapper1.selectByExample(t_fault_baseExample2);//是否故障的
            int updateCode = t_fault_baseMapper1.updateByExampleSelective(paramsMap, t_fault_baseExample2);
            if (updateCode == 0) {
                logger.info("终端的缺相异常故障目前只有一个");
            } else {
                logger.info("数据库中有" + updateCode + "条缺相故障被修复");
            }
            // 【2】插入source表，得先找到那些未被修复的非重复的故障的数据,同时直接将每条数据的id得到设置为base的id
            t_fault_source t_fault_source1 = new t_fault_source();
            t_fault_source1.setTable_name("4");
            t_fault_source1.setRecord_id(recordId);
            for (int i = 0; i < t_fault_bases.size(); i++) {
                t_fault_source1.setFault_id(t_fault_bases.get(i).getId() + "");
                t_fault_sourceMapper1.insertSelective(t_fault_source1);
            }
        } else if ("AbnormalZ".equals(className)) {
        } else if ("PowerQuality".equals(className)) {
        }


    }

    // 增加电压类的故障
    private void insertFaultPowerFailure(Object object, String recordId, int fault_type) {
        // 参数是某条数据，根据类型进入逻辑
        // 异常电压及相应故障
        // （根据传来的object）得到一个now和base的基本数据，
        String substainId = "";
        t_fault_base t_fault_base1 = new t_fault_base();
        AbnormalU abnormalU = (AbnormalU) object;
        // 【1】插入base表
        /*`id` bigint(20) NOT NULL AUTO_INCREMENT,
        `type` int(11) DEFAULT NULL COMMENT '属于哪种类型的节点，1表示表，2表示表箱，3表示分支箱，4表示出线柜，5表示箱变',
        `key_id` varchar(36) DEFAULT NULL COMMENT '对应的topo结构表中的id',
        `fault_type` int(11) DEFAULT NULL COMMENT '错误类型10表（11表示用户短路，12表示用户异常漏电），20表箱（21停电，221缺B相，222缺C相，223缺BC相，23超限），30分支箱故障（31表示停电，32表示缺相，33表示超限，34表示短路），40出线柜故障，50箱变故障',
        `occur_time` datetime DEFAULT NULL COMMENT '故障发生时间',
        `is_cancelled` int(11) DEFAULT NULL COMMENT '故障是否取消，由于进一步判断故障被替换成另一个故障',
        `repair_time` datetime DEFAULT NULL COMMENT '修复时间',
        `is_repaired` int(11) DEFAULT NULL COMMENT '是否修复',
        `substain_id` varchar(36) DEFAULT NULL,
        `is_same` tinyint(4) DEFAULT NULL,
        `fault_base_id` varchar(36) DEFAULT NULL COMMENT '表示与t_fault_base表中的哪条记录关联',*/

        //【1.1】先判断type
        //【1.1】
        // (1)去找substain_id,插入substain_id
        // (2)再根据type的add，dis，chan去数据库找对应的设备，从而得到key_id,再插入fault_type
        // (3)插入发生时间，setIs_cancelled，setIs_repaired，setRepair_time
        //（4）根据key_id,fault_type,is_same为0找到是否有记录，
        //    有就插入is_same为1,同时返回fault_base_id插入到其中
        // (4.1)如果还有其它缺相数据一律先恢复
        //【2】插入source表
        /* `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '1表示t_short_i，2表示t_leakage_i，3表示t_ableakage_i，4表示t_abnormal_u,5表示t_abnormal_z，6表示t_power_quality',
        `fault_id` varchar(36) DEFAULT NULL COMMENT '表示t_fault_now的id',
        `table_name` varchar(255) DEFAULT NULL,
        `record_id` varchar(36) DEFAULT NULL,
        PRIMARY KEY (`id`)*/
        // (1)插入fault_id,table_name，record_id

        int deviceType = Integer.parseInt(abnormalU.getcAddressid().toString().substring(0, 1));
        if (deviceType == 1)//1表示是ndtu,2表示bdtu。目前为了测试数据
        {   //(1)
            substainId = t_substainMapper1.selectSubstainIdByNdtu(abnormalU.getcDistrictbcdid().toString(), abnormalU.getcAddressid());
            t_fault_base1.setSubstain_id(substainId);
            t_fault_base1.setType(2);//表示表箱出现故障
            //(2)
            t_meterboxExample t_meterboxExample1 = new t_meterboxExample();
            t_meterboxExample.Criteria criteria = t_meterboxExample1.createCriteria();
            criteria.andC_AddressIdEqualTo(abnormalU.getcAddressid().toString()).andC_DistrictBCDIdEqualTo(abnormalU.getcDistrictbcdid());
            List<t_meterbox> t_meterboxList = t_meterboxMapper1.selectByExample(t_meterboxExample1);
            t_fault_base1.setKey_id(t_meterboxList.get(0).getMeterBoxId().toString());//
            t_fault_base1.setFault_type(fault_type);
        } else {
            //(1)
            substainId = t_substainMapper1.selectSubstainIdByBdtu(abnormalU.getcDistrictbcdid().toString(), abnormalU.getcAddressid());
            t_fault_base1.setSubstain_id(substainId);
            t_fault_base1.setType(4);//表示出线柜出现故障
            //(2)
            t_outgoingcabinetExample t_outgoingcabinetExample = new t_outgoingcabinetExample();
            t_outgoingcabinetExample.Criteria criteria = t_outgoingcabinetExample.createCriteria();
            criteria.andC_AddressIdEqualTo(abnormalU.getcAddressid().toString()).andC_DistrictBCDIdEqualTo(abnormalU.getcDistrictbcdid());
            List<t_outgoingcabinet> t_outgoingcabinetList = t_outgoingcabinetMapper1.selectByExample(t_outgoingcabinetExample);
            t_fault_base1.setKey_id(t_outgoingcabinetList.get(0).getOutgoingCabinetId().toString());//
            t_fault_base1.setFault_type(fault_type);
        }
        // (1)
        t_fault_base1.setOccur_time(abnormalU.getOccurtime());
        t_fault_base1.setIs_cancelled(0);//否
        t_fault_base1.setRepair_time(null);
        t_fault_base1.setIs_repaired(0);//否
        // (4)
        t_fault_baseExample t_fault_baseExample1 = new t_fault_baseExample();
        t_fault_baseExample1.setOrderByClause("occur_time DESC");
        t_fault_baseExample.Criteria criteria = t_fault_baseExample1.createCriteria();
        criteria.andFault_typeEqualTo(t_fault_base1.getFault_type()).andKey_idEqualTo(t_fault_base1.getKey_id()).andIs_repairedEqualTo(0).andIs_sameEqualTo(false);
        List<t_fault_base> t_fault_bases = t_fault_baseMapper1.selectByExample(t_fault_baseExample1);
        if (t_fault_bases.size() == 1) {//表示存在重复数据，不需要进行更新操作
            t_fault_base1.setIs_same(true);
            t_fault_base1.setFault_base_id(t_fault_bases.get(0).getId().toString());
        } else if (t_fault_bases.size() == 0) {// 表示无重复数据，此时也需要先更新缺相的其它异常
            // a.如果异常为22开头，则需要更新其它的异常
            // 找到 key_id,faulttype 以22开头，且不等于传进来的fault_type
            // 更新is_repaired，repair_time
            if ((fault_type + "").startsWith("22") || (fault_type + "").startsWith("42")) {// 缺相异常
                t_fault_baseExample t_fault_baseExample2 = new t_fault_baseExample();
                t_fault_baseExample.Criteria criteria2 = t_fault_baseExample2.createCriteria();
                if ((fault_type + "").startsWith("22")) {
                    criteria2.andKey_idEqualTo(t_fault_base1.getKey_id()).andFault_typeBetween(220, 229).andFault_typeNotEqualTo(t_fault_base1.getFault_type()).andIs_sameEqualTo(false);
                } else if ((fault_type + "").startsWith("42")) {
                    criteria2.andKey_idEqualTo(t_fault_base1.getKey_id()).andFault_typeBetween(420, 429).andFault_typeNotEqualTo(t_fault_base1.getFault_type()).andIs_sameEqualTo(false);
                }
                t_fault_base paramsMap = new t_fault_base();
                paramsMap.setIs_repaired(1);
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                paramsMap.setRepair_time(timeStamp);
                int updateCode = t_fault_baseMapper1.updateByExampleSelective(paramsMap, t_fault_baseExample2);
                if (updateCode == 0) {
                    logger.info("终端的缺相异常故障目前只有一个");
                } else {
                    logger.info("数据库中有" + updateCode + "条缺相故障被修复");
                }
            }

            // b.设置开始的base故障为false
            t_fault_base1.setIs_same(false);
        }
        t_fault_baseMapper1.insertSelective(t_fault_base1);
        long id = t_fault_base1.getId();
        //【2】插入source表
        t_fault_source t_fault_source1 = new t_fault_source();
        t_fault_source1.setFault_id(id + "");
        t_fault_source1.setTable_name("4");
        t_fault_source1.setRecord_id(recordId);
        t_fault_sourceMapper1.insertSelective(t_fault_source1);
        noticeServer(substainId);
    }

    // 通知到前端
    private void noticeServer(String substainId) {
        List<UserOnlineBo> list = customSessionManager.getAllUser();
        for (int i = 0; i < list.size(); i++) {
            Long id = list.get(i).getId();
            wsMessageService.sendToAllTerminal(id + "", "{\"name\":\"falutNews\",\"key\":\"\"}");
            wsMessageService.sendToAllTerminal(id + "", "{\"name\":\"faultRendering\",\"key\":\"" + substainId + "\"}");

        }
    }

    public static int frameFormatCheck(int[] buff) {
        // 不要按照总长度iLen判断帧结尾和校验和，其实可以按照DataLen1，但是要判断DataLen1+8<=iLen才OK，否则会有问题，数组越界
        // 现在是严格的一帧数据一传的。

        // 接收数据帧，格式检查,静态方法，供所有调用，包括Auth
        int DataLen1, DataLen2, iLen; // Frame中内部数据长度
        iLen = buff.length;
        DataLen1 = buff[1] + (buff[2] << 8);
        DataLen2 = buff[3] + (buff[4] << 8);
        if (iLen < DataLen1 + 8) {
            return WRONGFORMAT;
        } else if (DataLen1 != DataLen2) { // 长度
            return WRONGFORMAT;
        } else if (!((buff[0] == 0x68) && (buff[5] == 0x68) && (buff[iLen - 1] == 0x16))) { // 帧头
            return WRONGFORMAT;
        }
        int cs = 0;
        for (int i = 6; i < iLen - 2; i++) {
            cs += buff[i];
        }
        cs = cs & 0xff;
        if (cs != buff[iLen - 2]) // 校验和
        {
            return WRONGFORMAT;
        }
        return RIGTHFORMAT;
    }

    @Override
    public void dealReceiveData(NDTUData ndtudata) {
        // 到这，说明已经校验成功，需要按照不同的命令字进行处理
        // 入库之后，再进行应答+
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        switch (buff[6]) {
            case 0x80: // 身份认证
                // DealReceiveData80(Buff, iLen);
                // Com00();
                break;
            case 0x81: // 心跳应答，什么也不需要做
                break;
            case 0x82: // 校时应答
                // 分成功和失败，即使失败了，也不需要重新发送。
                break;
            case 0x83: // 招测应答
                if (dealReceiveData83_84(ndtudata) == true) {
                    // 这时候，再给相应的Lostseg置位
                    // setLostSegPollReceive(Buff[11], Buff[14], Buff[15], Buff[16],
                    // Buff[17]);
                }
                break;
            case 0x84: // 主动上报 平台自动回复ack，若要回复则下发命令
                if ((buff[12] & 0x04) > 0) // 位3（0000 0100）上传阶跃数据；
                {
                    // DealReceiveDat84_Jump(Buff, iLen);
                } else {
                    if (dealReceiveData83_84(ndtudata) == true) {
                        // Com04(Buff[11], Buff[14], Buff[15], Buff[16], Buff[17]);
                    }
                }
                break;
            case 0x85: // 终端的状态统计数据
                // if (DealReceiveData85(Buff, iLen) == true)
            {
                // 无应答
            }
            break;
            case 0xA0: // 短路
                dealReceiveDataA0(ndtudata);
                break;
            case 0xA1: // 正常漏电
                dealReceiveDataA1(ndtudata);
                break;
            case 0xA2: // 异常漏电
                dealReceiveDataA2(ndtudata);
                break;
            case 0xA3: // 电压异常
                dealReceiveDataA3(ndtudata);
                break;
            case 0xA4: // 阻抗异常
                dealReceiveDataA4(ndtudata);
                break;
            case 0xA5: // 阻抗异常
                dealReceiveDataA5(ndtudata);
                break;
            default:
                // 该帧符合格式的数据直接丢弃
                break;
        }
    }

    public boolean dealReceiveData83_84(NDTUData ndtudata) {
        // 处理应答数据83_84
        // 均为1个通道，存在多个电器的情况
        // 每个电器长度 13个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);
        // 20170517增加了 12长度的，表示终端内无该时段数据。
        // if (iLen1 < 16) return false; //至少16个， 16个表示没有电器， 有电器至少29
        String cDistrictId;
        int deviceId;
        cDistrictId = String.format("%02x%02x", buff[8], buff[7]);
        deviceId = buff[9] + (buff[10] << 8);

        if (iLen1 < 12) {
            return false;
        }
        try {
            Opdata tmp = new Opdata();
            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            String strRecordDateBCD = "";
            strRecordDateBCD = String.format("%02x%02x%02x", buff[14], buff[15], buff[16]);
            try {
                tmp.setcRecorddatebcd(Integer.parseInt(strRecordDateBCD));
            } catch (Exception e) {
                String sErr;
                sErr = "--DateErr--" + cDistrictId + deviceId + "日期错误，上报日期为：" + strRecordDateBCD;
                System.out.println(sErr);
            }
            tmp.setcTsegmentid(buff[17]);
            tmp.setcChannelid(buff[11]);

            Float tkw = Ints2floatUtil.ints2float(buff, 18);
            tmp.setcTkwh(tkw);
            tmp.setcFaultid(buff[12]);
            // Date date = new Date();
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd
            // HH:mm:ss");
            // System.out.println(sdf.format(date));
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            tmp.setcRecordinserttime(timeStamp);
            tmp.setcFramecmdid(String.format("%02x", buff[6]));
            tmp.setEventTime(ndtudata.getService().getEventTime());
            if (iLen1 == 12) {
                tmp.setcTkwh((float) 0);
                tmp.setcEehexid("ee");
                tmp.setcEesequenceid(0);
                tmp.setcEekwh(0);
                tmp.setcEeopenminute(0);
                tmp.setcEecloseminute(0);
                tmp.setcEeopenclosetimes(0);
                tmp.setcEepeakw(0);
                insertData(tmp);
            } else if (iLen1 == 16) {
                tmp.setcTkwh((float) 0);
                tmp.setcEehexid("ff");
                tmp.setcEesequenceid(0);
                tmp.setcEekwh(0);
                tmp.setcEeopenminute(0);
                tmp.setcEecloseminute(0);
                tmp.setcEeopenclosetimes(0);
                tmp.setcEepeakw(0);
                insertData(tmp);
            } else {
                for (int i = 0; (13 * (i + 1) + 16) <= iLen1; i++) {// 13表示每一个电器数据的字节数，16表示电器数据的起始位置
                    // 每个电器，入库
                    tmp.setcEehexid(String.format("%2x", buff[22 + 13 * i]));
                    tmp.setcEesequenceid(buff[23 + 13 * i]);
                    tmp.setcEekwh(Ints2floatUtil.ints2float(buff, 24 + 13 * i));// C_EEKWh,4个字节
                    tmp.setcEeopenminute(buff[28 + 13 * i]);
                    tmp.setcEecloseminute(buff[29 + 13 * i]);
                    tmp.setcEeopenclosetimes(buff[34 + 13 * i]);
                    tmp.setcEepeakw(Ints2floatUtil.ints2float(buff, 30 + 13 * i));
                    insertData(tmp);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 短路电流
     *
     * @param ndtudata
     * @return
     */
    public boolean dealReceiveDataA0(NDTUData ndtudata) {

        // 处理应答数据83_84
        // 均为1个通道，存在多个电器的情况
        // 每个电器长度 13个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        // 【1】先把公共字段都保存
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);
        String cDistrictId;
        int deviceId;
        cDistrictId = String.format("%02x%02x", buff[8], buff[7]);
        deviceId = buff[9] + (buff[10] << 8);

        if (iLen1 < 12)
            return false;
        try {
            ShortI tmp = new ShortI();
            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            tmp.setcFramecmdid("A0");
            // 【2】保存电流信息
            for (int i = 0; (11 * i + 9) <= iLen1; i++) {// 11表示每一个电器数据的字节数，9表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                tmp.setcChannelid(buff[14 + 11 * i]);

                Date occurtime;
                String occurtimeString = "20" + String.format("%02x%02x%02x%02x%02x%02x", buff[15 + 11 * i],
                        buff[16 + 11 * i], buff[17 + 11 * i], buff[18 + 11 * i], buff[19 + 11 * i], buff[20 + 11 * i]);
                occurtime = DateUtil.stringToDate(occurtimeString, DateUtil.DATE_PATTERN, true);
                tmp.setOccurtime(occurtime);

                tmp.setI(Ints2floatUtil.ints2float(buff, 21 + 11 * i));// 起始位置

                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setcRecordinserttime(timeStamp);
                insertData(tmp);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 正常漏电流
     *
     * @param ndtudata
     * @return
     */
    public boolean dealReceiveDataA1(NDTUData ndtudata) {

        // 处理应答数据A1
        // 均为1个通道，存在多个电器的情况
        // 每个电器长度 14个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        // 【1】先把公共字段都保存
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);//L1（控制域、地址域、链路用户数据校验码结束符之和）；
        String cDistrictId;
        int deviceId;
        Integer recorddatebcd;
        recorddatebcd = Integer.parseInt(String.format("%02x%02x%02x", buff[13], buff[14], buff[15]));
        cDistrictId = String.format("%02x%02x", buff[8], buff[7]);
        deviceId = buff[9] + (buff[10] << 8);

        if (iLen1 < 12)
            return false;
        try {
            LeakageI tmp = new LeakageI();
            tmp.setTsegmentid(buff[16] + (buff[17] << 8));
            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            tmp.setcFramecmdid("A1");
            tmp.setRecorddatebcd(recorddatebcd);
            // 【2】保存非公共信息
            for (int i = 0; (5 * i + 14) <= iLen1; i++) {// 11表示每一个电器数据的字节数，9表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                tmp.setcChannelid(buff[19 + 5 * i]);
                tmp.setI(Ints2floatUtil.ints2float(buff, 20 + 5 * i));// 起始位置
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setcRecordinserttime(timeStamp);
                insertData(tmp);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 异常漏电流
     *
     * @param ndtudata
     * @return
     */
    public boolean dealReceiveDataA2(NDTUData ndtudata) {

        // 处理应答数据83_84
        // 均为1个通道，存在多个电器的情况
        // 每个电器长度 13个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        // 【1】先把公共字段都保存
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);
        String cDistrictId;
        int deviceId;
        cDistrictId = String.format("%02x%02x", buff[8], buff[7]);
        deviceId = buff[9] + (buff[10] << 8);
        if (iLen1 < 12)
            return false;
        try {
            AbleakageI tmp = new AbleakageI();

            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            tmp.setcFramecmdid("A2");


            // 【2】保存非公共信息
            for (int i = 0; (12 * i + 8) < iLen1; i++) {// 11表示每一个电器数据的字节数，15表示电器数据的起始位置
                // 每个漏电数据入库，其中8为ilen减掉一条数据长度
                // 通道号，时间，电流
                // 【2.1】
                Date occurtime;
                String occurtimeString = "20" + String.format("%02x%02x%02x%02x%02x%02x", buff[16 + 12 * i],
                        buff[17 + 12 * i], buff[18 + 12 * i], buff[19 + 12 * i], buff[20 + 12 * i], buff[21 + 12 * i]);
                occurtime = DateUtil.stringToDate(occurtimeString, DateUtil.DATE_PATTERN, true);
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setcChannelid(buff[14 + 12 * i]);
                if (0x0 == buff[15 + 12 * i]) {
                    tmp.setIsAbnormal(false);
                } else if (0x1 == buff[15 + 12 * i]) {
                    tmp.setIsAbnormal(true);
                }
                ;
                tmp.setI(Ints2floatUtil.ints2float(buff, 22 + 12 * i));// 起始位置
                tmp.setcRecordinserttime(timeStamp);
                tmp.setOccurtime(occurtime);
                insertData(tmp);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 电压异常
     *
     * @param ndtudata
     * @return
     */
    public boolean dealReceiveDataA3(NDTUData ndtudata) {

        // 处理应答数据A3
        // 每个电器长度 13个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        // 【1】先把公共字段都保存
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);
        String cDistrictId;
        int deviceId;
        cDistrictId = String.format("%02x%02x", buff[8], buff[7]);
        deviceId = buff[9] + (buff[10] << 8);
        if (iLen1 < 12)
            return false;
        try {
            AbnormalU tmp = new AbnormalU();
            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            tmp.setcFramecmdid("A3");
            // 【2】保存非公共信息
            for (int i = 0; (19 * i + 13) <= iLen1; i++) {// 19表示每一个电器数据的字节数，13表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                Date occurtime;
                String occurtimeString = "20" + String.format("%02x%02x%02x%02x%02x%02x", buff[14 + 19 * i],
                        buff[15 + 19 * i], buff[16 + 19 * i], buff[17 + 19 * i], buff[18 + 19 * i], buff[19 + 19 * i]);
                occurtime = DateUtil.stringToDate(occurtimeString, DateUtil.DATE_PATTERN, true);
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                if (0x00 == buff[13]) {
                    tmp.setIsAbnormal(false);
                } else if (0x01 == buff[13]) {
                    tmp.setIsAbnormal(true);
                }
                tmp.setUa(Ints2floatUtil.ints2float(buff, 20 + 19 * i));
                tmp.setUb(Ints2floatUtil.ints2float(buff, 24 + 19 * i));
                tmp.setUc(Ints2floatUtil.ints2float(buff, 28 + 19 * i));
                tmp.setcRecordinserttime(timeStamp);
                tmp.setOccurtime(occurtime);
                insertData(tmp);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**线路阻抗
     * @param ndtudata
     * @return
     */
    /**
     * @param ndtudata
     * @return
     */
    public boolean dealReceiveDataA4(NDTUData ndtudata) {

        // 处理应答数据A3
        // 每个电器长度 13个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        // 【1】先把公共字段都保存
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);
        String cDistrictId;
        int deviceId;
        cDistrictId = String.format("%02x%02x", buff[8], buff[7]);
        deviceId = buff[9] + (buff[10] << 8);
        if (iLen1 < 12)
            return false;
        try {
            t_abnormal_z tmp = new t_abnormal_z();
            Integer recorddatebcd;
            recorddatebcd = Integer.parseInt(String.format("%02x%02x%02x", buff[13], buff[14], buff[15]));
            tmp.setC_DistrictBCDId(cDistrictId);
            tmp.setC_AddressId(deviceId);
            tmp.setC_FrameCmdId("A4");
            tmp.setRecordDateBCD(recorddatebcd);
            tmp.setTSegmentId(buff[16] + (buff[17] << 8));
            tmp.setUa(Ints2floatUtil.ints2float(buff, 18));
            tmp.setUb(Ints2floatUtil.ints2float(buff, 22));
            tmp.setUc(Ints2floatUtil.ints2float(buff, 26));
            // 【2】保存非公共信息
            for (int i = 0; (13 * i + 31) <= iLen1; i++) {// 19表示每一个电器数据的字节数，13表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setC_ChannelId(buff[31 + 13 * i]);
                tmp.setP(Ints2floatUtil.ints2float(buff, 32 + 13 * i));
                tmp.setQ(Ints2floatUtil.ints2float(buff, 36 + 13 * i));
                tmp.setI(Ints2floatUtil.ints2float(buff, 40 + 13 * i));
                tmp.setC_RecordInsertTime(timeStamp);
                insertData(tmp);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 电能质量
     *
     * @param ndtudata
     * @return
     */
    public boolean dealReceiveDataA5(NDTUData ndtudata) {

        // 处理应答数据A3
        // 每个电器长度 13个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        // 【1】先把公共字段都保存
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);
        String cDistrictId;
        int deviceId;
        cDistrictId = String.format("%02x%02x", buff[8], buff[7]);
        deviceId = buff[9] + (buff[10] << 8);
        if (iLen1 < 12)
            return false;
        try {
            PowerQuality tmp = new PowerQuality();
            Integer recorddatebcd;
            recorddatebcd = Integer.parseInt(String.format("%02x%02x%02x", buff[13], buff[14], buff[15]));
            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            tmp.setcFramecmdid("A5");
            tmp.setRecorddatebcd(recorddatebcd);
            tmp.setTsegmentid(buff[16] + (buff[17] << 8));
            tmp.setUa(Ints2floatUtil.ints2float(buff, 18));
            tmp.setUb(Ints2floatUtil.ints2float(buff, 22));
            tmp.setUc(Ints2floatUtil.ints2float(buff, 26));
            // 【2】保存非公共信息
            for (int i = 0; (37 * i + 31) <= iLen1; i++) {// 19表示每一个电器数据的字节数，13表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setcChannelid(buff[31 + 37 * i]);
                tmp.setP(Ints2floatUtil.ints2float(buff, 32 + 37 * i));
                tmp.setQ(Ints2floatUtil.ints2float(buff, 36 + 37 * i));
                tmp.setI1(Ints2floatUtil.ints2float(buff, 40 + 37 * i));
                tmp.setI2(Ints2floatUtil.ints2float(buff, 44 + 37 * i));
                tmp.setI3(Ints2floatUtil.ints2float(buff, 48 + 37 * i));
                tmp.setI4(Ints2floatUtil.ints2float(buff, 52 + 37 * i));
                tmp.setI5(Ints2floatUtil.ints2float(buff, 56 + 37 * i));
                tmp.setI6(Ints2floatUtil.ints2float(buff, 60 + 37 * i));
                tmp.setI7(Ints2floatUtil.ints2float(buff, 64 + 37 * i));
                tmp.setcRecordinserttime(timeStamp);
                insertData(tmp);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Opdata record = new Opdata();
        record.setcDistrictbcdid("412");
    }
}
