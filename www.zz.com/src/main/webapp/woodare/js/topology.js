//var mySvg = SVG_HELPER.drawSvg(allData, 'body');


/**
 * 获取项目根
 * **/
function getRootPath_web() {
	 //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	 var curWwwPath = window.document.location.href;
	 //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	 var pathName = window.document.location.pathname;
	 var pos = curWwwPath.indexOf(pathName);
	 //获取主机地址，如： http://localhost:8083
	 var localhostPaht = curWwwPath.substring(0, pos);
	 //获取带"/"的项目名，如：/uimcardprj
	 var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	 return (localhostPaht + projectName);
}  
var mySvg = null;
var dataTemp = null;
var javaScriptObj = {
		substationId:null,//箱变ID
		branchboxIDArray:null,
		keyArray:null,
		keyJsonArray :null,
		buttonAction :0,//0表示默认没有执行过，不需要清理样式
		interval:null//定时器资源
}
/**
 * 展示拓扑
 * **/
function showTop(rowId){
	if(null != rowId && "" != rowId){
		javaScriptObj.substationId = rowId;
		parent.$(".loading").show();//显示蒙层
		$.ajax({ 
			 type: "post",
	         url:  getRootPath_web() + "/epu/getEupInfosTree.shtml",
	         data: {
	        	 rootId: rowId
	         },
	         async:true,
	         dataType: "json",
	         cache: false,
	         success: function(allData){ 
	        	 parent.$(".loading").hide();//隐藏蒙层
	        	 if(allData){
	        		 mySvg = SVG_HELPER.drawSvg(allData, 'body');
	        		 $("#falutDiv").css("top",( mySvg.topoHeight()- 460)+"px");
	        		 //加载故障
	        		 so.initFaultTypeList();
	        		 //填充隐藏域strBranchboxIDArray，topo错误所需分支箱KEY_ID
        			 javaScriptObj.branchboxIDArray =  mySvg.branchboxIDArray;
        			 //填充隐藏域strKeyArray，故障定位所需KEY_ID
        			 var strKeyArray = "";
        			 if(mySvg.keyArray){
        				 if(null != mySvg.keyArray && mySvg.keyArray.length > 0){
        					 strKeyArray = mySvg.keyArray.join(",")
        				 }
        			 }
        			 $("#strKeyArray").val(strKeyArray);
        			 javaScriptObj.keyArray = mySvg.keyArray;
        			 javaScriptObj.keyJsonArray = mySvg.keyJsonArray;
	        		 initList();
	        		 dataTemp = allData;
	        		 var wd = parseFloat($("#wd").val() || 1) ;
	        		 mySvg.scale(wd);
	        		 //加载表格
	        		 branchboxTableUipq(mySvg);
	        		 //开启定时器
	        		 var myVar =  setInterval(function(){
	        	    	 //加载当前表箱下电表表格
	        			 clearInterval(myVar);//清除定时器
	        			 var timeoutVar =  setTimeout(function(){
	        				 clearInterval(timeoutVar);//清除定时器
	        				 showTop(rowId);
	        			 }, (1000 * 20) );//(1000 * 20) 延迟20秒
	        			
	        	     },(1000 * 60 * 5));//(1000 * 60 * 4)
	        		 javaScriptObj.interval = myVar;
	        	 }
	        } 
		});
	}
}

var obj =  parent.$(".all li[class='on']");
var rowId = obj.attr("id").replace("tab_","");
if(obj.attr("isShow") != "yes"){//如果是第一次，则加载
	obj.attr("isShow","yes");
	showTop(rowId);//初始化加载
}
/**
 * 加载表格
 * */
function branchboxTableUipq(obj){
	 var strKeyArray = "";
	 if(obj.outgoingCabinetArray){
		 if(null != obj.outgoingCabinetArray && obj.outgoingCabinetArray.length > 0){
			 strKeyArray = obj.outgoingCabinetArray.join(",")
		 }
	 }
	 $("#loadingDiv").show();
	    $.ajax({
	        url: getRootPath_web() + "/powerQuality/selectBranchboxUIPQ.shtml",
	        type: 'POST',
	        timeout : 5000, //超时时间设置，单位毫秒
	        dataType: 'json',
	        async: true,
	        data: {
	        	outgoingCabinetIds: strKeyArray
	        },
	        success: function(data) {
	        	var branchboxXYArray = obj.branchboxXYArray;
	        	if(null != branchboxXYArray && branchboxXYArray.length > 0){
	        		for(var i = 0 ;i < branchboxXYArray.length; i++){
	        			var branchboxXY_json = branchboxXYArray[i]; 
	        			var key = branchboxXY_json["KEY"];
	        			var x = branchboxXY_json["X"];
	        			var y = branchboxXY_json["Y"];
	        			var count = branchboxXY_json["COUNT"];
	        			var index = branchboxXY_json["INDEX"];
	        			if(data){
	        				if(null != data && data.length > 0){
	        					var  ua = 0;
	        					var  ia = 0;
	        					var  pa = 0;
	        					var qa = 0;
	        					var ub = 0;
	        					var ib = 0;
	        					var pb = 0;
	        					var qb = 0;
	        					var uc = 0;
	        					var ic = 0;
	        					var pc = 0;
	        					var qc = 0;
			        			for(var j = 0 ;j < data.length; j++){
			        				var j_json = data[j];
			        				var branchBoxId = j_json["branchBoxId"];
			        				if(branchBoxId == key){
			        					var cChannelid = j_json["cChannelid"];
			        					if(cChannelid == 1 || cChannelid == "1"){
						        			  ua = parseFloat(j_json["u"] || 0).toFixed(2);
						        			  ia = parseFloat(j_json["i"] || 0).toFixed(2);
						        			  pa = parseFloat(j_json["p"] || 0).toFixed(2);
						        			  qa = parseFloat(j_json["q"] || 0).toFixed(2);
						        		}else if(cChannelid == 2 || cChannelid == "2"){
						        			  ub = parseFloat(j_json["u"] || 0).toFixed(2);
						        			  ib = parseFloat(j_json["i"] || 0).toFixed(2);
						        			  pb = parseFloat(j_json["p"] || 0).toFixed(2);
						        			  qb = parseFloat(j_json["q"] || 0).toFixed(2);
						        		}else if(cChannelid == 3 || cChannelid == "3"){
						        			  uc = parseFloat(j_json["u"] || 0).toFixed(2);
						        			  ic = parseFloat(j_json["i"] || 0).toFixed(2);
						        			  pc = parseFloat(j_json["p"] || 0).toFixed(2);
						        			  qc = parseFloat(j_json["q"] || 0).toFixed(2);
						        		}
			        				}
			        			}
			        			obj.showTabData(obj.thisSvgObj, key, x, y, count, index, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
	        				}else{
	        					//清除TABLE
	        				}
	        			}else{
	        				//清除TABLE
	        			}
	        		}
	        	}
	            $(".loading").hide();
	        },
	        error: function() {
	            $(".loading").hide();
	        }
	    });
}

/**
* 单击执行放大缩小
**/
function clickScale(param){
	var wd = parseFloat($("#wd").val()) || 1;
	if(param == "max"){
		if(wd < 1){
			wd = wd + 0.1;
			mySvg.scale(wd);
		}
	}else if(param == "min"){
		if(wd > 0.2){
			wd = wd - 0.1;
			mySvg.scale(wd);
		}
	}
}


$(function() {
	var topoErrorLoadJson = $.trim(parent.$("#topoErrorLoadJson").text());
	if(null != topoErrorLoadJson && "" != topoErrorLoadJson){
		if(topoErrorLoadJson.indexOf("action")!=-1 && topoErrorLoadJson.indexOf("key")!=-1){
			var jsonTemp = JSON.parse(topoErrorLoadJson);
			var key = jsonTemp["key"];
			var action = jsonTemp["action"];
			if(action == "flaut"){//点击预警消息显示故障定位
				$(".a-hov span").each(function(){
					$(this).removeClass("on");
					if('故障定位' ==  $(this).text()){
						$(this).addClass("on");
						//加延迟原因：当前打开一个非故障箱变TOPO，点击预警消息加载故障的箱变，但是加载数据是异步，应进faultClick（）把原来从加载取的数据读后台数据库获取	,这里目前不加，用延迟了，后续看要求调整读库			
						//备注：参见top.ftl中的 pageName == "allShowList" 逻辑
						 var timeoutVar =  setTimeout(function(){
	        				 clearInterval(timeoutVar);//清除定时器
	        				 faultClick(false);
	        			 }, (1000 * 3) );//(1000 * 3) 延迟3秒 
					}
				});
			}
		}
	}
	//内部按钮
	$(".a-hov span").click(function(){
		var txtValue = $(this).text();
		$(".a-hov span").each(function(){
			if(txtValue !=  $(this).text()){
				$(this).removeClass("on");
			}
		});
		var selectedFlag = $(this).is(".on");//初始未点击时样式状态
		if(selectedFlag){
			$(this).removeClass("on");
		}else{
			$(this).addClass("on");
		}
		if(txtValue == "故障定位"){
			faultClick(selectedFlag);
		}else if(txtValue == "TOPO错误数据"){
			clickTopoError(selectedFlag);
		}else{
			javaScriptObj.buttonAction = 0;
			//TOPO错误数据和故障数据样式清除
       	 clickTopoStyle(javaScriptObj.keyJsonArray);
		}
	});
	  //绑定事件
	var obj =  parent.$(".all li[class='on']");
	var rowId = obj.attr("id").replace("tab_","");
	parent.$("#" + rowId + "tabShow").scroll(function(){
	 	    $(".box").css("top", ($(this).scrollTop() ));
    		$(".box").css("left", ($(this).scrollLeft() ));
	 });
	//加载Websocket
	loadWebsocket();
});

/**加载Websocket
 * **/
function loadWebsocket(){
	 var websocket;
	 var basePath = parent.$("#basePath").val();//项目地址
	 var web_socket_ip = parent.$("#web_socket_ip").val();//WebSocket握手IP地址
	 var token_id = parent.$("#token_id").val();//登录人ID
     if('WebSocket' in window) {
          console.log("此浏览器支持websocket");
         websocket = new WebSocket("ws://"+web_socket_ip + basePath +"/chat/"+token_id);
     } else if('MozWebSocket' in window) {
         alert("此浏览器只支持MozWebSocket");
     } else {
         alert("此浏览器只支持SockJS");
     }
     websocket.onopen = function(evnt) {
         //打开监听,连接open后给前端和后端同时发送open信号，两个线程不会阻塞。但是我的后端open事件一定要先执行，这样前端请求时，才能有足够的时间等待后端生成userSocket
     };
     websocket.onmessage = function(evnt) {
    	 //"{\"name\":\"faultRendering\",\"key\":\"38f04bc0-6c40-4535-ba36-7dbc1d6d2536\"}"
    	 if(evnt.data.indexOf("faultRendering") !=-1){
    		 var json = JSON.parse(evnt.data);
    		 if(json.key == javaScriptObj.substationId){
	    		 //故障渲染
	    		 faultClick(undefined);
    		 }
    	 }
    	 //得到消息通知，执行加载故障数据
     };
     websocket.onerror = function(evnt) {};
     websocket.onclose = function(evnt) {
    	 alert("与服务器断开了链接!");
     }
}


/**
 * TOPO错误数据
 * **/
function clickTopoError(selectedFlag){
	$("#loadingDiv").show();
	$.ajax({ 
		 type: "post",
         url:  getRootPath_web() + "/fault/selectTopoErrorByKeys.shtml",
         data: {
        	 strBranchboxIDArray : javaScriptObj.branchboxIDArray.join(",")
         },
         async:true,
         dataType: "json",
         cache: false,
         success: function(topoError){ 
        	//TOPO错误数据和故障数据样式清除
        	 if(javaScriptObj.buttonAction ==1){
        		 clickTopoStyle(javaScriptObj.keyJsonArray);
        	 }
        	 if(topoError){
        		 if(null != topoError && topoError.length > 0){
        			 if(!selectedFlag){//点击时TOPO错误数据时，显示故障渲染
        				 javaScriptObj.buttonAction = 1;
	        			 for(var i=0;i< topoError.length;i++){
	        				 var json = topoError[i];
	        				 var fault_type = json["fault_type"];
		        			 var key = json["key"];
		        			 if(fault_type =="1" || fault_type == 1){//1、	branchbox fault type为1的时候用蓝色标识 ，不用判断下级设备
		        				 mySvg.kaiguanxianWarning(new Array(json));//开关线 标蓝
		        				 continue;
		        			 }else if(fault_type =="0" || fault_type == 0){//2、	branchbox fault type为0的时候用红色标识，判断下级设备的fault point，为1的时候标红，否则是黑
		        				 var kaiguanxianErrorArray = new Array();
		        				 kaiguanxianErrorArray.push(json);
		        				 var rel = json["rel"];
		        				 for(var k = 0;k < rel.length;k++){//判断下级设备的fault point，为1的时候标红，否则是黑
		        					 var relJson = rel[k];
		        					 var rel_fault_point = relJson["fault_point"];
		        					 var rel_key = relJson["key"];
		        					 if(rel_fault_point =="1" || rel_fault_point == 1 ){
		        						 kaiguanxianErrorArray.push(relJson);
		        					 }else{
		    	        				mySvg.kaiguanxianClear(new Array(relJson));//清空样式  默认黑色
		        					 }
		        				 }
		        				 mySvg.kaiguanxianError(kaiguanxianErrorArray);//开关线  标红
		        			 }else{
		        				 mySvg.kaiguanxianClear(new Array(json));//清空样式  默认黑色
		        			 }
	        			 }
        			 }else{
        				 javaScriptObj.buttonAction = 0;
        			 }
        		 }else{
        			 javaScriptObj.buttonAction = 0;
        		 }
        	 }
        	 $("#loadingDiv").hide();
        } 
	});
}

/**
 * TOPO错误数据和故障数据样式清除
 * **/
function clickTopoStyle(keyJsonArray){
	 if(keyJsonArray){
		 if(null != keyJsonArray && keyJsonArray.length > 0){
			 for(var i=0;i< keyJsonArray.length;i++){
				 var json = keyJsonArray[i];
     			mySvg.kaiguanxianClear(new Array(json));//清空样式  默认黑色
     			mySvg.boxClear(new Array(json));//清理出线柜/分支箱  渲染颜色等, 
			 }
		 }
	 }
}
/**
 * 故障定位
 * selectedFlag: true 删除故障渲染  false 添加故障渲染
 * */
function faultClick(selectedFlag){
	 var strKeyArray = "";
	 if(javaScriptObj.keyArray){
		 if(null != javaScriptObj.keyArray && javaScriptObj.keyArray.length > 0){
			 strKeyArray = javaScriptObj.keyArray.join(",");
		 }
	 }
	$("#loadingDiv").show();
	$.ajax({ 
		 type: "post",
         url:  getRootPath_web() + "/fault/selectFaultByRootId.shtml",
         data: {
        	 strKeyArray : strKeyArray
         },
         async:true,
         dataType: "json",
         cache: false,
         success: function(allData){ 
        	//TOPO错误数据和故障数据样式清除
        	 if(javaScriptObj.buttonAction ==1){
        		 clickTopoStyle(javaScriptObj.keyJsonArray);
        	 }
        	 var faultNowData = allData ;
        		if(!selectedFlag){
        			if($("#"+javaScriptObj.substationId+"Iframe").contents().find(".a-hov span[class='on']").text() == "故障定位"){
        				selectedFlag = false;
        			}
        		}
        		 /**
        		 以下方法 参数 都是 ID
        		 boxError: 出线柜/分支箱  整体状态 标红, 
        		 boxWarning: 出线柜/分支箱  整体状态 标蓝,
        		 boxClear: 出线柜/分支箱  整体状态 恢复,
        		 kaiguanxianError: 开关线 标红,
        		 kaiguanxianWarning: 开关线 标蓝,
        		 kaiguanxianClear: 开关线 恢复
        		 **/
        		var kaiguanxianErrorArray = new Array();
        		var boxErrorArray = new Array();
        		
        		var kaiguanxianErrorClearArray = new Array();
        		var boxErrorClearArray = new Array();
        		if(null != faultNowData && faultNowData.length > 0){
        			for(var tempI= 0;tempI < faultNowData.length;tempI++){
        				var faultNowJson = faultNowData[tempI];
        				var type = faultNowJson["type"] || "";
        				var faultType = faultNowJson["faultType"] || "";
        				var key = faultNowJson["key"] || "";
        				var epuName = faultNowJson["epuName"] || "";
        				var is_repaired = faultNowJson["is_repaired"] || "";//是否被修复，1表示是
        				var is_cancelled = faultNowJson["is_cancelled"] || "";//是否被取消，1表示是
        				if(is_repaired != "1" && is_cancelled !="1" ){//未修复/未取消
        					if(type == "M0003" || type == "M0002"){//分支箱
        						boxErrorArray.push(faultNowJson);
        					}
        					if(type == "M0004"){//表箱ID
        						kaiguanxianErrorArray.push(faultNowJson);
        					}
        				}else if(is_repaired == "1" || is_cancelled =="1"){//修复/被取消
        					if(type == "M0003" || type == "M0002"){//分支箱
        						boxErrorClearArray.push(faultNowJson);
        					}
        					if(type == "M0004"){//表箱ID
        						kaiguanxianErrorClearArray.push(faultNowJson);
        					}
        				}
        			}
        		}
        		if(null != boxErrorClearArray && boxErrorClearArray.length > 0 ){
        			mySvg.boxClear(boxErrorClearArray);//清理出线柜/分支箱  渲染颜色等,
        		}
        		if(null != kaiguanxianErrorClearArray && kaiguanxianErrorClearArray.length > 0 ){
        			mySvg.kaiguanxianClear(kaiguanxianErrorClearArray);//清理开关线渲染颜色等
        		}
        		if(!selectedFlag){//点击时故障定位时，显示故障渲染
           		 	javaScriptObj.buttonAction = 1;
        			mySvg.kaiguanxianError(kaiguanxianErrorArray);//开关线 标红,
        			mySvg.boxError(boxErrorArray);//出线柜/分支箱  整体状态 标红, 
        		}else{
        			javaScriptObj.buttonAction = 0;
        			mySvg.kaiguanxianClear(kaiguanxianErrorArray);//清理开关线渲染颜色等
        			mySvg.boxClear(boxErrorArray);//清理出线柜/分支箱  渲染颜色等, 
        		}
        		
        	 $("#loadingDiv").hide();
        } 
	});
}
