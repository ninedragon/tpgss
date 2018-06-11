package com.zz.deviceAndData.service.na.service.signalingDelivery;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zz.deviceAndData.service.na.utils.Constant;
import com.zz.deviceAndData.service.na.utils.HttpsUtil;
import com.zz.deviceAndData.service.na.utils.JsonUtil;
import com.zz.deviceAndData.service.na.utils.StreamClosedHttpResponse;

public class TmpPost {

    public static void main(String[] args) throws Exception {
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
       
		// 【1】生成url
		// 【2】传入请求头
		// 【3】传入content
		// [4]发送请求

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String urlPostAsynCmd = Constant.POST_ASYN_CMD;
        String appId = Constant.APPID;

        //please replace the deviceId, when you use the demo.
        String deviceId = "3fa2bfca-dca1-465d-8637-aa3b6e3c700a";
        String callbackUrl = Constant.REPORT_CMD_EXEC_RESULT_CALLBACK_URL;

        //please replace the following parameter values, when you use the demo.
        //And those parameter values must be consistent with the content of profile that have been preset to IoT platform.
        //The following parameter values of this demo are use the watermeter profile that already initialized to IoT platform.
        String serviceId = "IndicateCmd";
        String method = "DELIVER_DEVICE_CMD";
        ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"value\":\"12\"}");
      
        Map<String, Object> paramCommand = new HashMap<>();
        paramCommand.put("serviceId", serviceId);
        paramCommand.put("method", method);
        paramCommand.put("paras", paras);      
        
        Map<String, Object> paramPostAsynCmd = new HashMap<>();
        paramPostAsynCmd.put("deviceId", deviceId);
        paramPostAsynCmd.put("command", paramCommand);
        paramPostAsynCmd.put("callbackUrl", callbackUrl);
        
        String jsonRequest = JsonUtil.jsonObj2Sting(paramPostAsynCmd);
                
        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        //执行请求，三个参数，请求，header，json
        HttpResponse responsePostAsynCmd = httpsUtil.doPostJson(urlPostAsynCmd, header, jsonRequest);

        String responseBody = httpsUtil.getHttpResponseBody(responsePostAsynCmd);

        System.out.println("PostAsynCommand, response content:");
        System.out.print(responsePostAsynCmd.getStatusLine());
        System.out.println(responseBody);
        System.out.println();
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
