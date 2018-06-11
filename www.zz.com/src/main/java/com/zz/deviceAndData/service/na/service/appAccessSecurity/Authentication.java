package com.zz.deviceAndData.service.na.service.appAccessSecurity;

import java.util.HashMap;
import java.util.Map;

import com.zz.deviceAndData.service.na.utils.Constant;
import com.zz.deviceAndData.service.na.utils.HttpsUtil;
import com.zz.deviceAndData.service.na.utils.JsonUtil;
import com.zz.deviceAndData.service.na.utils.StreamClosedHttpResponse;

/**
 *  Auth:
 *  This interface is used to authenticate third-party systems before third-party systems access open APIs.
 */
public class Authentication {
    @SuppressWarnings({ "resource", "unchecked" })
//    public static void main(String args[]) throws Exception {
//
//        // Two-Way Authentication
//        HttpsUtil httpsUtil = new HttpsUtil();
//        httpsUtil.initSSLConfigForTwoWay();
//
//        String appId = Constant.APPID;
//        String secret = Constant.SECRET;
//        String urlLogin = Constant.APP_AUTH;
//
//        Map<String, String> param = new HashMap<>();
//        param.put("appId", appId);
//        param.put("secret", secret);
//
//        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, param);
//
//        System.out.println("app auth success,return accessToken:");
//        System.out.print(responseLogin.getStatusLine());
//        System.out.println(responseLogin.getContent());
//        System.out.println();
//
//        //resolve the value of accessToken from responseLogin.
//        Map<String, String> data = new HashMap<>();
//        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
//        String accessToken = data.get("accessToken");
//        System.out.println("accessToken:" + accessToken);
//
//    }
    public  Map<String, Object> authentication() throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> param = new HashMap<>();
        param.put("appId", appId);
        param.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, param);

        System.out.println("app auth success,return accessToken:");
        System.out.print(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        //resolve the value of accessToken from responseLogin.
        Map<String, String> data = new HashMap<>();
        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        String accessToken = data.get("accessToken");
        System.out.println("accessToken:" + accessToken);
        Map<String, Object> msgMap = new HashMap<>();
        return msgMap;


    }
    public static void main(String args[]) throws Exception {
    	String  rootpath="zz/WEB-INF/classes";
    	rootpath=rootpath.substring(0,rootpath.lastIndexOf("/") );
    	    	rootpath=rootpath.substring(0,rootpath.lastIndexOf("/")+1 );
    	System.out.println("ok");
    	///D:/004NIS开发ing/000相关/005tomcat/apache-tomcat-7.0.85_1nis/webapps/zz/WEB-INF/classes	}
    }
}
