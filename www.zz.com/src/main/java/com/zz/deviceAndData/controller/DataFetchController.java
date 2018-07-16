package com.zz.deviceAndData.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.zz.analysisAndDisplay.controller.MessageController;
import com.zz.deviceAndData.utils.HexStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.common.controller.BaseController;
import com.zz.deviceAndData.bo.NDTUData;
import com.zz.deviceAndData.service.DataCollectionService;

@Controller
@Scope(value = "prototype")
@RequestMapping("fetch")
		public class DataFetchController extends BaseController {
	@Autowired
	DataCollectionService dataCollectionService;
	@RequestMapping(value = "registerDevice")
	String registerDevice(HttpServletRequest request, String name) {
		System.out.println("registerDevice-------------------------");
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {

			System.out.println("Key = " + entry.getKey(	) + ", Value = " + entry.getValue());

		}
		return "你好吗!" + name;
	}

	@RequestMapping(value = "updateDeviceInfo")
	String updateDeviceInfo(String name) {
		System.out.println("updateDeviceInfo-------------------------");
		return "你好吗!" + name;
	}

	/**
	 * @param request
	 * @param ndtudata  得到的初始json数据
	 * @param name
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "updateDeviceData")
	@ResponseBody
	String updateDeviceData(HttpServletRequest request, @RequestBody NDTUData ndtudata) throws IOException {
		int[] buff = HexStringUtil.hexString2ints(ndtudata.getService().getData().getReportData().substring(4));
		if(buff[6]==0xA2) {
			String json = JSON.toJSONString(ndtudata);
			System.out.println(json);

		}
		if(buff[6]==0xA3) {
			String json = JSON.toJSONString(ndtudata);
			System.out.println(json);
		}

		if(buff[6]==0xA1) {
			String json = JSON.toJSONString(ndtudata);
			System.out.println(json);
		}

		if(buff[6]==0xA4) {
			String json = JSON.toJSONString(ndtudata);
			System.out.println(json);
		}
		Date nowtime = new Date();
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String time = format0.format(nowtime.getTime());// 这个就是把时间戳经过处理得到期望格式的时间
		System.out.println(
				time + "  INFO " + "34356 " + "---" + " [updateDeviceData]" + "notifyType()=deviceDataChanged");
		
		//【1】dataFetch校验格式

		//【2】dataAnalysis

		//【3】dataWrite
		 dataCollectionService.dataProcess(ndtudata);
		return "ok";
	}

	@RequestMapping(value = "deletedDevice")
	String deletedDevice(String name) {
		System.out.println("deletedDevice-------------------------");
		return "你好吗!" + name;
	}

	@RequestMapping(value = "commandConfirmData")
	String commandConfirmData(String name) {
		System.out.println("commandConfirmData-------------------------");
		return "你好吗!" + name;
	}

	@RequestMapping(value = "updateServiceInfo")
	String updateServiceInfo(String name) {
		System.out.println("updateServiceInfo-------------------------");
		return "你好吗!" + name;
	}

	@RequestMapping(value = "commandRspData")
	String commandRspData(String name) {
		System.out.println("commandRspData-------------------------");
		return "你好吗!" + name;
	}

	@RequestMapping(value = "DeviceEvent")
	String DeviceEvent(String name) {
		System.out.println("DeviceEvent-------------------------");
		return "你好吗!" + name;
	}

	@RequestMapping(value = "RulEevent")
	String RulEevent(String name) {
		System.out.println("RulEevent-------------------------");
		return "你好吗!" + name;
	}

	@RequestMapping(value = "updateDeviceDatas")
	@ResponseBody
	String updateDeviceDatas(HttpServletRequest request, String name) throws IOException, IOException {
		Date nowtime = new Date();
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String time = format0.format(nowtime.getTime());// 这个就是把时间戳经过处理得到期望格式的时间
		System.out.println(
				time + "  INFO " + "34356 " + "---" + " [updateDeviceDatas]" + " notifyType()=deviceDataChanged");
		BufferedReader br = new BufferedReader(
				new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
		}
		br.close();
		String params = sb.toString();
		System.out.println(params);
		return "ok";
	}

	/*main方法以后可能用到
	 * public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}*/
}
