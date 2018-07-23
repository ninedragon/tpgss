package com.zz.deviceAndData.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zz.common.dao.t_cal_zMapper;
import com.zz.common.model.cal_topo_bo;
import com.zz.deviceAndData.service.ImpedanceService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.common.controller.BaseController;
import com.zz.deviceAndData.bo.CmdBO;
import com.zz.deviceAndData.service.na.service.appAccessSecurity.Authentication;
import com.zz.deviceAndData.service.na.service.dataCollection.SubscribeNotification;
import com.zz.deviceAndData.service.na.service.signalingDelivery.PostAsynCommandV4;
import com.zz.edata.service.EdataService;
import com.zz.user.service.UUserService;

@Controller
@Scope(value = "prototype")
@RequestMapping("dad")
public class DADController extends BaseController {

	private static final int SUCCESS = 0;
	private static final int FAIL = 1;
	@Autowired
	EdataService edataService;
	@Autowired
	UUserService userService;
	@Autowired
	ImpedanceService impedanceService;
	@Autowired
	t_cal_zMapper t_cal_zMapper1;
	private String filename;

	/**
	 * 
	 * @param modelMap
	 * @param pageNo
	 * @param findContent
	 * @return
	 */

	// 【1】北向应用controller
	@RequestMapping(value = "appSet")
	public ModelAndView na(ModelMap modelMap) {
		System.out.println("appSet");

		return new ModelAndView("dad/appSet");
	}

	// 【1.1】应用鉴权controller
	@RequestMapping(value = "authentication", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> authentication() {
		// Map<String, Object> msgmap =new HashMap<>();

		Map<String, Object> msgmap = null;
		try {
			msgmap = new Authentication().authentication();
		} catch (Exception e) {
			e.printStackTrace();
			msgmap.put("isSuccess", "鉴权出现异常");
			return msgmap;
		}
		msgmap.put("isSuccess", "鉴权正常");
		return msgmap;
		
		
	}

    
	// 【1.2】basecallback controller
	@RequestMapping(value = "callUrl", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> callUrl(String callbackBaseUrl, HttpServletRequest request) {
		Map<String, Object> msgmap = new HashMap<String ,Object>();
		try {
			msgmap = new SubscribeNotification().subscribeNotification(callbackBaseUrl);
		} catch (Exception e) {
			e.printStackTrace();
			msgmap.put("isSuccess", "设置回调url出现异常");
			return msgmap;
		}
		msgmap.put("isSuccess", "设置回调url正常");
		return msgmap;
		
	}
	// 【1.3】postAsynCommandV4 controller
	@RequestMapping(value = "postAsynCommandV4", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> postAsynCommandV4(CmdBO cmdBO, HttpServletRequest request) {
		 Map<String, Object> msgmap =new HashMap<>();
//		Map<String, Object> msgmap = null;
		try {
			msgmap = new PostAsynCommandV4().postAsynCommandV4(cmdBO);
		} catch (Exception e) {
			e.printStackTrace();
			msgmap.put("isSuccess", "发送命令异常");
			return msgmap;
		}
		msgmap.put("isSuccess", "发送命令正常");
		return msgmap;
		
	}

	//【2】模拟终端发送信号
	//【2.1】发送A3信号
	@RequestMapping(value = "sendB3")
	@ResponseBody
	String sendB3()  {
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"000A681A001A0068A316010700000101180711230041FA72C4412C6AA93EBB50083F9716\"},\"eventTime\":\"20180711T150046Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.2】发送A32信号,缺相数据
	@RequestMapping(value = "sendB32")
	@ResponseBody
	String sendB32()  {
		//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681A001A0068A31601070000010118071120110732D06943FE79653ED650183E6F16\"},\"eventTime\":\"20180711T121143Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.2】发送A321信号,只缺C相数据
	@RequestMapping(value = "sendB321")
	@ResponseBody
	String sendB321()  {
		//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681A001A0068A31601070000010118071120110732D0694332D06943D650183E0316\"},\"eventTime\":\"20180711T121143Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.3】发送A33信号，超限数据
	@RequestMapping(value = "sendB33")
	@ResponseBody
	String sendB33()  {
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0045681A001A0068A316010700000101180712103659A1656743CAAC3443761D34433A16\"},\"eventTime\":\"20180712T023705Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.3】发送A34信号，电压恢复数据
	@RequestMapping(value = "sendB34")
	@ResponseBody
	String sendB34()  {//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681A001A0068A31601070000010018071120110732D06943FE79653ED650183E6E16\"},\"eventTime\":\"20180711T121143Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.5】发送A0信号，短路信号
	@RequestMapping(value = "sendB0")
	@ResponseBody
	String sendB0()  {
		//, @RequestBody NDTUData ndtudata
        String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681300130068A01601070000010101180716165102F769C642C716\"},\"eventTime\":\"20180628T060120Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.5】发送A0信号，短路信号
	@RequestMapping(value = "sendB02")
	@ResponseBody
	String sendB02()  {
		//, @RequestBody NDTUData ndtudata
		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681300130068A01601070000010102180716165102F769C642C816\"},\"eventTime\":\"20180628T060120Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.5】发送A0信号，短路信号
	@RequestMapping(value = "sendB03")
	@ResponseBody
	String sendB03()  {
		//, @RequestBody NDTUData ndtudata
		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681300130068A01601070000010103180716165102F769C642C916\"},\"eventTime\":\"20180628T060120Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.5】发送A1信号，正常漏电信号
	@RequestMapping(value = "sendA1")
	@ResponseBody
	String sendA1()  {
		//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0013682B002B0068A1160113000001180712B2020607D27CF639081E8EC73A098595D43A0A8C76653B0BEB666F3B0C16E53B3B5016\"},\"eventTime\":\"20180712T033014Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0013682B002B0068A1160113000001180712B2020607D27CF639081E8EC73A098595D43A0A8C76653B0BEB666F3B0C16E53B3B5016\"},\"eventTime\":\"20180712T033014Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}
	//【2.6】发送A2信号，发送异常漏电数据
	@RequestMapping(value = "sendA2")
	@ResponseBody
	String sendA2()  {
		//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2160113000001010A011807121045096CB62D3DF416\"},\"eventTime\":\"20180628T073047Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.6】发送A22信号，发送异常漏电恢复数据
	@RequestMapping(value = "sendA22")
	@ResponseBody
	String sendA22()  {
		//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2160113000001010A00180712104532EA24213BFA16\"},\"eventTime\":\"20180628T073047Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.1】发送A3信号
	@RequestMapping(value = "sendA3")
	@ResponseBody
	String sendA3()  {
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"000A681A001A0068A316011300000101180711230041FA72C4412C6AA93EBB50083FA316\"},\"eventTime\":\"20180711T150046Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.2】发送A32信号,缺相数据
	@RequestMapping(value = "sendA32")
	@ResponseBody
	String sendA32()  {
		//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681A001A0068A31601130000010118071120110732D06943FE79653ED650183E7B16\"},\"eventTime\":\"20180711T121143Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.2】发送A321信号,只缺C相数据
	@RequestMapping(value = "sendA321")
	@ResponseBody
	String sendA321()  {
		//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681A001A0068A31601130000010118071120110732D0694332D06943D650183E0F16\"},\"eventTime\":\"20180711T121143Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.3】发送A33信号，超限数据
	@RequestMapping(value = "sendA33")
	@ResponseBody
	String sendA33()  {
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0045681A001A0068A316011300000101180712103659A1656743CAAC3443761D34434616\"},\"eventTime\":\"20180712T023705Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.3】发送A34信号，电压恢复数据
	@RequestMapping(value = "sendA34")
	@ResponseBody
	String sendA34()  {//, @RequestBody NDTUData ndtudata
//		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006681400140068A2212701000001010A0118062814302200000000A416\"},\"eventTime\":\"20180628T063434Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681A001A0068A31601130000010018071120110732D06943FE79653ED650183E7A16\"},\"eventTime\":\"20180711T121143Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	//【2.5】发送A0信号，短路信号
	@RequestMapping(value = "sendA0")
	@ResponseBody
	String sendA0()  {
		//, @RequestBody NDTUData ndtudata
		String	json ="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0000681300130068A01601130000010101180716165102F769C642D316\"},\"eventTime\":\"20180628T060120Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}
	//【2.6】发送A4信号，发送阻抗数据
	@RequestMapping(value = "sendA4")
	@ResponseBody
	String sendA4()  {
		String json="{\"deviceId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"gatewayId\":\"74094ae8-27e9-462e-a521-9e6e821cca86\",\"notifyType\":\"deviceDataChanged\",\"service\":{\"data\":{\"reportData\":\"0006686700670068A4160113000001180712B7026F6269433E8A513E47A3183E0601F210A740DA3DE940D4E1013D02AAE1B83F08B1B7BB29653E3D03E219BD3F7BD658BB2DDF303D04DE7744401860044181B0193D059BBC7E40D65A1141FE90223D06785E52C04845313F95F7B83C9416\"},\"eventTime\":\"20180628T073047Z\",\"serviceId\":\"ElecticMeterBasic\",\"serviceType\":\"ElecticMeterBasic\"}}";
		return sendA(json);
	}

	/*
	* 发送json数据
	* */
	private String sendA(String json) {
		Date nowtime = new Date();
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String time = format0.format(nowtime.getTime());// 这个就是把时间戳经过处理得到期望格式的时间
		System.out.println(
				time + "  INFO " + "34356 " + "---" + " [sendA3]" + "sendA3");
		// 【1】发送请求到服务器
		String url = "http://117.62.173.203:8081/zz/fetch/updateDeviceData";
		// POST的URL
		HttpPost httppost = new HttpPost(url);
		// 建立HttpPost对象
		// 建立一个NameValuePair数组，用于存储欲传送的参数
		// 添加参数
		//【2】转化为json数据
		//数据为三个数据都很小

		//2、使用JSONArray
		try {
			httppost.setEntity(new StringEntity(json, "application/json", "UTF-8"));
			// 设置编码
			HttpResponse response = new DefaultHttpClient().execute(httppost);
			// 发送Post,并返回一个HttpResponse对象
			if (response.getStatusLine().getStatusCode() == 200) {// 如果状态码为200,就是正常返回
//				String result = EntityUtils.toString(				.getEntity());
				// 【1】dataFetch校验格式

				// 【2】dataAnalysis

				// 【3】dataWrite

				// dataCollectionService.dataProcess(ndtudata);

			}
		} catch (Exception e) {
		}
		return "ok";
	}

	@RequestMapping(value = "calZ")
	@ResponseBody
	public String calZ(String json) {
//		impedanceService.calImpedance(1);
		return "1";
	}

	@RequestMapping(value = "cal_topo")
	@ResponseBody
	public String cal_topo(cal_topo_bo topo_bo) {
//		impedanceService.calImpedance(1);

		t_cal_zMapper1.cal_topo(topo_bo);
		return "1";
	}

	@RequestMapping(value = "cal_topo_all")
	@ResponseBody
	public String cal_topo_all() {
//		impedanceService.calImpedance(1);
		try {
			t_cal_zMapper1.cal_topo_all();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		return "1";
	}
}
