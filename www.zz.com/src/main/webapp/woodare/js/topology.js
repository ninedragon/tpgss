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
		substationId:null//箱变ID
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
	         async:false,
	         dataType: "json",
	         cache: false,
	         success: function(allData){ 
	        	 parent.$(".loading").hide();//隐藏蒙层
	        	 if(allData){
	        		 mySvg = SVG_HELPER.drawSvg(allData, 'body');
	        		 //加载故障
	        		 so.initFaultTypeList();
	        		 var strKeyArray = "";
        			 if(mySvg.keyArray){
        				if(null != mySvg.keyArray && mySvg.keyArray.length > 0){
        					strKeyArray = mySvg.keyArray.join(",")
        				}
        			 }
        			 $("#strKeyArray").val(strKeyArray);
	        		 initList();
	        		 dataTemp = allData;
	        		 var wd = parseFloat($("#wd").val() || 1) ;
	        		 mySvg.scale(wd);
	        		 
	        		 //展示topo错误数据
//	        		 /**
//	        		 以下方法 参数 都是 ID
//	        		 boxError: 出线柜/分支箱  整体状态 标红, 
//	        		 boxWarning: 出线柜/分支箱  整体状态 标蓝,
//	        		 boxClear: 出线柜/分支箱  整体状态 恢复,
//	        		 kaiguanxianError: 开关线 标红,
//	        		 kaiguanxianWarning: 开关线 标蓝,
//	        		 kaiguanxianClear: 开关线 恢复
//	        		 **/
	        		 for(var i=0;i < topoError.length;i++){
	        			 var json = topoError[i];
	        			 var fault_type = json["fault_type"];
	        			 var key = json["key"];
	        			 if(fault_type =="1" || fault_type == 1){//1、	branchbox fault type为1的时候用蓝色标识 ，不用判断下级设备
	        				 mySvg.kaiguanxianWarning(new Array(json));//开关线 标蓝
	        				 continue;
	        			 }
	        			 else if(fault_type =="0" || fault_type == 0){//2、	branchbox fault type为0的时候用红色标识，判断下级设备的fault point，为1的时候标红，否则是黑
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
		}else{
			//还原topo图无故障定位显示
			faultClick(true);
		}
	});
	  //绑定事件
	var obj =  parent.$(".all li[class='on']");
	var rowId = obj.attr("id").replace("tab_","");
	parent.$("#" + rowId + "tabShow").scroll(function(){
	 	    $(".box").css("top", ($(this).scrollTop() ));
    		$(".box").css("left", ($(this).scrollLeft() ));
	 });
	$("#falutDiv").css("top",( mySvg.topoHeight()- 460)+"px");
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
 * 故障定位
 * selectedFlag: true 删除故障渲染  false 添加故障渲染
 * */
function faultClick(selectedFlag){
	$("#loadingDiv").show();
	$.ajax({ 
		 type: "post",
         url:  getRootPath_web() + "/fault/selectFaultByRootId.shtml",
         data: {
        	 strKeyArray : $.trim($("#strKeyArray").val()||""),
         },
         async:true,
         dataType: "json",
         cache: false,
         success: function(allData){ 
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
        		
        		if(!selectedFlag){//点击时故障定位时，显示故障渲染
        			mySvg.kaiguanxianError(kaiguanxianErrorArray);//开关线 标红,
        			mySvg.boxError(boxErrorArray);//出线柜/分支箱  整体状态 标红, 
        		}else{
        			mySvg.kaiguanxianClear(kaiguanxianErrorArray);//清理开关线渲染颜色等
        			mySvg.boxClear(boxErrorArray);//清理出线柜/分支箱  渲染颜色等, 
        		}
        		if(null != boxErrorClearArray && boxErrorClearArray.length > 0 ){
        			mySvg.boxClear(boxErrorClearArray);//清理出线柜/分支箱  渲染颜色等,
        		}
        		if(null != kaiguanxianErrorClearArray && kaiguanxianErrorClearArray.length > 0 ){
        			mySvg.kaiguanxianClear(kaiguanxianErrorClearArray);//清理开关线渲染颜色等
        		}
        	 $("#loadingDiv").hide();
        } 
	});
}
