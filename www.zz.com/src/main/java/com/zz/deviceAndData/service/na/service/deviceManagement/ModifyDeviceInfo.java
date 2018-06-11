package com.zz.deviceAndData.service.na.service.deviceManagement;

import java.util.HashMap;
import java.util.Map;

import com.zz.deviceAndData.service.na.utils.Constant;
import com.zz.deviceAndData.service.na.utils.HttpsUtil;
import com.zz.deviceAndData.service.na.utils.JsonUtil;
import com.zz.deviceAndData.service.na.utils.StreamClosedHttpResponse;

/**
 * Set device information:
 * This interface is used by an NA to set or modify device information.
 */
public class ModifyDeviceInfo {

	public static void main(String args[]) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;

        //please replace the deviceId, when you use the demo.
        String deviceId = "09744012-7e3a-4ad7-b927-9d45f625b4bb";
        String urlModifyDeviceInfo = Constant.MODIFY_DEVICE_INFO + "/" + deviceId;

        //please replace the following parameter values, when you use the demo.
        //And those parameter values must be consistent with the content of profile that have been preset to IoT platform.
        //The following parameter values of this demo are use the watermeter profile that already initialized to IoT platform.
        String manufacturerId= "eSDK";
        String manufacturerName = "eSDK_Huawei";
        String deviceType = "MultiSensor";
        String model = "v01";
        String protocolType = "CoAP";

        Map<String, Object> paramModifyDeviceInfo = new HashMap<>();
        paramModifyDeviceInfo.put("manufacturerId", manufacturerId);
        paramModifyDeviceInfo.put("manufacturerName", manufacturerName);
        paramModifyDeviceInfo.put("deviceType", deviceType);
        paramModifyDeviceInfo.put("model", model);
        paramModifyDeviceInfo.put("protocolType", protocolType);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramModifyDeviceInfo);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseModifyDeviceInfo = httpsUtil.doPutJsonGetStatusLine(urlModifyDeviceInfo,
                header, jsonRequest);

        System.out.println("ModifyDeviceInfo, response content:");
        System.out.print(responseModifyDeviceInfo.getStatusLine());
        System.out.println(responseModifyDeviceInfo.getContent());
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