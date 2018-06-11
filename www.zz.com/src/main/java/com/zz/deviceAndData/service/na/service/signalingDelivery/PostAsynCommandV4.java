/*
 * File Name: com.huawei.service.signalingDelivery.PostAsynCommand.java
 *
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.zz.deviceAndData.service.na.service.signalingDelivery;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zz.deviceAndData.bo.CmdBO;
import com.zz.deviceAndData.bo.Data;
import com.zz.deviceAndData.service.na.utils.Constant;
import com.zz.deviceAndData.service.na.utils.HttpsUtil;
import com.zz.deviceAndData.service.na.utils.JsonUtil;
import com.zz.deviceAndData.service.na.utils.StreamClosedHttpResponse;

/**
 * Post Asynchronous Command to a specify device:
 * This interface is used by NAs to send messages to device.
 * If a device is not online,
 * the IoT platform buffers the message and delivers the message to the device after the device is online.
 * The NA can set the maximum buffering time.
 */
public class PostAsynCommandV4 {

    public  Map<String, Object> postAsynCommandV4(CmdBO cmdBO) throws Exception {
//    	String indicateCmd
        /*
         * the device must connect to IoT platform before na post asyn command to device
         */
//      {
//      "_class" : "com.huawei.iom.iocm.domain.nsse.NsseRoute",
//      "deviceId" : "8c23b6b4-ea68-48fb-9c2f-90452a81ebb1",
//      "appId" : "pAw9x9zinQnQkYSLWbiGI_O6iBUa",
//      "nsseId" : "http://185.11.1.43:8096",
//      "edgeGwId" : "MeterCig",
//      "edgeGwType" : "CoAP",
//      "status" : "ONLINE"
//  }
    	/*
    	 * 结构
    	 */
        //[0]登录及httputil
        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);
		// 【1】生成url
        String urlPostAsynCmd = Constant.POST_ASYN_CMD;
        
		// 【2】传入请求头
        String appId = Constant.APPID;
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put(Constant.HEADER_APP_KEY, appId);
        headerMap.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
		// 【3】传入content
        //Please make sure that the following parameter values have been modified in the Constant file.
        //please replace the deviceId, when you use the demo.
        String deviceId = cmdBO.getNbDeviceId();
        String callbackUrl = Constant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL;
        //please replace the following parameter values, when you use the demo.
        //And those parameter values must be consistent with the content of profile that have been preset to IoT platform.
        //The following parameter values of this demo are use the watermeter profile that already initialized to IoT platform.
        String serviceId = "IndicateCmd";
        String method = "DELIVER_DEVICE_CMD";
//        ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"msgType\":\"cloudReq\",\"serviceId\":\"IndicateCmd\",\"mid\":2016,\"cmd\":\"DELIVER_DEVICE_CMD\",\"paras\":{\"indicateCmd\":1234},\"hasMore\":0}}");//AT+NMGS=5,00012E1F63
        ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"indicateCmd\":\""+cmdBO.getIndicateCmd()+"\"}");
        
        
        Map<String, Object> paramCommand = new HashMap<>();
        paramCommand.put("serviceId", serviceId);
        paramCommand.put("method", method);
        paramCommand.put("paras", paras);      
        
        Map<String, Object> paramPostAsynCmd = new HashMap<>();
        paramPostAsynCmd.put("deviceId", deviceId);
        paramPostAsynCmd.put("command", paramCommand);
        paramPostAsynCmd.put("callbackUrl", callbackUrl);
//        Date date = new Date();
//        paramPostAsynCmd.put("executeTime", date.toString());
        paramPostAsynCmd.put("expireTime", 0);
        
        String content = JsonUtil.jsonObj2Sting(paramPostAsynCmd);
//        String content = JsonUtil.jsonObj2Sting(params);

        // [4]发送请求
        HttpResponse responsePostAsynCmd = httpsUtil.doPostJson(urlPostAsynCmd, headerMap, content);
        String responseBody = httpsUtil.getHttpResponseBody(responsePostAsynCmd);
        System.out.println("PostAsynCommand, response content:");
        System.out.print(responsePostAsynCmd.getStatusLine());
        System.out.println(responseBody);
        System.out.println();
        Map<String, Object> msgMap = new HashMap<>();
        return msgMap;
   

      
        //执行请求，三个参数，请求，header，json
       
    }
    
    public static void main(String[] args) throws Exception {
    	CmdBO cmdBO = new CmdBO();
    	cmdBO.setIndicateCmd("680C000C00680312041e00010100170107045C16");
    	cmdBO.setNbDeviceId("74094ae8-27e9-462e-a521-9e6e821cca86");;
    	new PostAsynCommandV4().postAsynCommandV4(cmdBO);
    }

    /**
     * Authentication，get token
     * */
    @SuppressWarnings("unchecked")
    public static String login(HttpsUtil httpsUtil) throws Exception {

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> paramLogin = new HashMap<>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);

        System.out.println("app auth success,return accessToken:");
        System.out.print(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        Map<String, String> data = new HashMap<>();
        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return data.get("accessToken");
    }

    
}
