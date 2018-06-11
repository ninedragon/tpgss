package com.zz.deviceAndData.service.na.service.signalingDelivery;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.zz.deviceAndData.service.na.utils.Constant;
import com.zz.deviceAndData.service.na.utils.HttpsUtil;
import com.zz.deviceAndData.service.na.utils.JsonUtil;
import com.zz.deviceAndData.service.na.utils.StreamClosedHttpResponse;

public class SendCommand {

	public static void main(String[] args) throws Exception {
		/*
		 * the device must connect to IoT platform before na post asyn command
		 * to device
		 */
		// {
		// "_class" : "com.huawei.iom.iocm.domain.nsse.NsseRoute",
		// "deviceId" : "8c23b6b4-ea68-48fb-9c2f-90452a81ebb1",
		// "appId" : "pAw9x9zinQnQkYSLWbiGI_O6iBUa",
		// "nsseId" : "http://185.11.1.43:8096",
		// "edgeGwId" : "MeterCig",
		// "edgeGwType" : "CoAP",
		// "status" : "ONLINE"
		// }
		// 【1】生成url
		HttpsUtil httpsUtil = new HttpsUtil();
		httpsUtil.initSSLConfigForTwoWay();

		// Authentication，get token
		String accessToken = login(httpsUtil);

		// Please make sure that the following parameter values have been
		// modified in the Constant file.
		String urlSendCmd = Constant.SendCmd;
		String deviceId = "3fa2bfca-dca1-465d-8637-aa3b6e3c700a";
		String serviceId = "IndicateCmd";
		urlSendCmd=urlSendCmd.replaceFirst("%s", deviceId).replaceFirst("%s", serviceId);
		
		// 【2】传入请求头
		String appId = Constant.APPID;
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put(Constant.HEADER_APP_KEY, appId);
		headerMap.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
		
		// 【3】传入content
		Map<String, Object> contentbody = new HashMap<>();
		Map<String, Object> header = new HashMap<>();
		header.put("mode", "NOACK");
		header.put("from", "/user/001");
		header.put("method", "DELIVER_DEVICE_CMD");
		Map<String, Object> body = new HashMap<>();
		body.put("indicateCmd", "helloworld");
		contentbody.put("header", header);
		contentbody.put("body", body);
		Map<String, Object> aMap = new HashMap<>();
		contentbody.put("header", header);
		String content = JsonUtil.jsonObj2Sting(contentbody);
		
		// [4]发送请求
		HttpResponse responseSendCmd = httpsUtil.doPostJson(urlSendCmd, headerMap, content);
		String responseBody = httpsUtil.getHttpResponseBody(responseSendCmd);
		System.out.println("SendCommand, response content:");
		System.out.print(responseSendCmd.getStatusLine());
		System.out.println(responseBody);
		System.out.println();
	}

	/**
	 * Authentication，get token
	 */
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
