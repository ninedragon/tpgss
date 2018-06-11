package com.zz.deviceAndData.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import com.zz.analysisAndDisplay.socket.WSServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.dao.AbleakageIMapper;
import com.zz.common.dao.AbnormalUMapper;
import com.zz.common.dao.AbnormalZMapper;
import com.zz.common.dao.LeakageIMapper;
import com.zz.common.dao.OpdataMapper;
import com.zz.common.dao.PowerQualityMapper;
import com.zz.common.dao.ShortIMapper;
import com.zz.common.model.AbleakageI;
import com.zz.common.model.AbnormalU;
import com.zz.common.model.AbnormalZ;
import com.zz.common.model.LeakageI;
import com.zz.common.model.Opdata;
import com.zz.common.model.PowerQuality;
import com.zz.common.model.ShortI;
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
    AbnormalZMapper abnormalZMapper;
    @Autowired
    PowerQualityMapper powerQualityMapper;
    @Override
    public int dataProcess(NDTUData ndtudata) {
        // 三步处理
        if (WRONGFORMAT == dataFetch(ndtudata)) {
            return WRONGFORMAT;
        }
        ;
        dataAnalysis(ndtudata);
        // dataWrite(ndtudata);
        return SUCCESSPROCESS;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.zz.deviceAndData.service.DataCollectionService#DataFetch(com.zz.
     * deviceAndData.bo.NDTUData) 数据获取判断是否合法
     */
    @Override
    public int dataFetch(NDTUData ndtudata) {
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
        String className = object.getClass().getSimpleName();
        switch (className) {
            case "Opdata":
                return opdataMapper.insertSelective((Opdata) object);
            case "ShortI":// 短路电流
                int errorCode=shortIMapper.insertSelective((ShortI) object);
                WSServer.loop=false;
                WSServer.data="event occur!";
                return errorCode;
            case "LeakageI":// 正常漏电电流
                return leakageIMapper.insertSelective((LeakageI) object);
            case "AbleakageI":// 异常漏电电流
                return ableakageIMapper.insertSelective((AbleakageI) object);
            case "AbnormalU":// 异常电压
                return abnormalUMapper.insertSelective((AbnormalU) object);
            case "AbnormalZ":// 异常阻抗
                return abnormalZMapper.insertSelective((AbnormalZ) object);
            case "PowerQuality":// 电能质量
                return powerQualityMapper.insertSelective((PowerQuality) object);
            default:
                return NO_SUCH_OBJECT;
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

    public void dealReceiveData(NDTUData ndtudata) {
        // 到这，说明已经校验成功，需要按照不同的命令字进行处理
        // 入库之后，再进行应答
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

    /**短路电流
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

    /**正常漏电流
     * @param ndtudata
     * @return
     */
    public boolean dealReceiveDataA1(NDTUData ndtudata) {

        // 处理应答数据83_84
        // 均为1个通道，存在多个电器的情况
        // 每个电器长度 13个， 公共数据16个， 头尾8 个 总常：13n+16 +8 ；数据长度L1=L2=13n+16
        // int iLen = buff.length;
        // 【1】先把公共字段都保存
        int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
        int iLen1 = buff[1] + (buff[2] << 8);
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
            tmp.setTsegmentid(buff[16]);
            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            tmp.setcFramecmdid("A1");
            tmp.setRecorddatebcd(recorddatebcd);
            // 【2】保存非公共信息
            for (int i = 0; (6 * i + 13) <= iLen1; i++) {// 11表示每一个电器数据的字节数，9表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                tmp.setcChannelid(buff[19 + 6 * i]);
                tmp.setI(Ints2floatUtil.ints2float(buff, 20 + 6 * i));// 起始位置
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

    /**异常漏电流
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
            if (0x0 == buff[13]) {
                tmp.setIsAbnormal(false);
            } else if (0x1 == buff[13]) {
                tmp.setIsAbnormal(true);
            }
            ;

            // 【2】保存非公共信息
            for (int i = 0; (11 * i + 15) <= iLen1; i++) {// 11表示每一个电器数据的字节数，15表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                Date occurtime;
                String occurtimeString = "20" + String.format("%02x%02x%02x%02x%02x%02x", buff[16 + 11 * i],
                        buff[17 + 11 * i], buff[18 + 11 * i], buff[19 + 11 * i], buff[20 + 11 * i], buff[21 + 11 * i]);
                occurtime = DateUtil.stringToDate(occurtimeString, DateUtil.DATE_PATTERN, true);
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setcChannelid(buff[15 + 11 * i]);
                tmp.setI(Ints2floatUtil.ints2float(buff, 22 + 11 * i));// 起始位置
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

    /**电压异常
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
                        buff[15 + 19 * i], buff[16 + 19 * i], buff[17 + 19 * i], buff[18 + 19 * i], buff[19 + 19* i]);
                occurtime = DateUtil.stringToDate(occurtimeString, DateUtil.DATE_PATTERN, true);
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                if(0x00==buff[13]){
                    tmp.setIsAbnormal(false);
                }
                else if(0x01==buff[13]){
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
            AbnormalZ tmp = new AbnormalZ();
            Integer recorddatebcd;
            recorddatebcd = Integer.parseInt(String.format("%02x%02x%02x", buff[13], buff[14], buff[15]));
            tmp.setcDistrictbcdid(cDistrictId);
            tmp.setcAddressid(deviceId);
            tmp.setcFramecmdid("A4");
            tmp.setRecorddatebcd(recorddatebcd);
            tmp.setTsegmentid(buff[16]);
            tmp.setUa(Ints2floatUtil.ints2float(buff, 18 ));
            tmp.setUb(Ints2floatUtil.ints2float(buff, 22 ));
            tmp.setUc(Ints2floatUtil.ints2float(buff, 26 ));
            // 【2】保存非公共信息
            for (int i = 0; (13 * i + 31) <= iLen1; i++) {// 19表示每一个电器数据的字节数，13表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setcChannelid(buff[31+13*i]);
                tmp.setP(Ints2floatUtil.ints2float(buff, 32 + 13 * i));
                tmp.setQ(Ints2floatUtil.ints2float(buff, 36 + 13 * i));
                tmp.setI(Ints2floatUtil.ints2float(buff, 40 + 13 * i));
                tmp.setcRecordinserttime(timeStamp);
                insertData(tmp);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /**电能质量
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
            tmp.setTsegmentid(buff[16]);
            tmp.setUa(Ints2floatUtil.ints2float(buff, 18 ));
            tmp.setUb(Ints2floatUtil.ints2float(buff, 22 ));
            tmp.setUc(Ints2floatUtil.ints2float(buff, 26 ));
            // 【2】保存非公共信息
            for (int i = 0; (37 * i + 31) <= iLen1; i++) {// 19表示每一个电器数据的字节数，13表示电器数据的起始位置
                // 每个漏电数据入库
                // 通道号，时间，电流
                // 【2.1】
                Date date = new Date();
                Timestamp timeStamp = new Timestamp(date.getTime());
                tmp.setcChannelid(buff[31+37*i]);
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
