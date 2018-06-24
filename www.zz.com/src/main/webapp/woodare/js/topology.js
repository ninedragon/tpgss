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
		substationId:null
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
	        				 var kaiguanxianWarningArray = new Array();
	        				 kaiguanxianWarningArray.push(key);
	        				 mySvg.kaiguanxianWarning(kaiguanxianWarningArray);//开关线 标蓝
	        				 continue;
	        			 }else if(fault_type =="0" || fault_type == 0){//2、	branchbox fault type为0的时候用红色标识，判断下级设备的fault point，为1的时候标红，否则是黑
	        				 var kaiguanxianErrorArray = new Array();
	        				 kaiguanxianErrorArray.push(key);
	        				 var rel = json["rel"];
	        				 for(var k = 0;k < rel.length;k++){//判断下级设备的fault point，为1的时候标红，否则是黑
	        					 var relJson = rel[k];
	        					 var rel_fault_point = relJson["fault_point"];
	        					 var rel_key = relJson["key"];
	        					 if(rel_fault_point =="1" || rel_fault_point == 1 ){
	        						 kaiguanxianErrorArray.push(rel_key);
	        					 }else{
	        						 var kaiguanxianClearArray = new Array();
	    	        				 kaiguanxianClearArray.push(rel_key);
	    	        				mySvg.kaiguanxianClear(kaiguanxianClearArray);//清空样式  默认黑色
	        					 }
	        				 }
	        				 mySvg.kaiguanxianError(kaiguanxianErrorArray);//开关线  标红
	        			 }else{
	        				 var kaiguanxianClearArray = new Array();
	        				 kaiguanxianClearArray.push(key);
	        				 mySvg.kaiguanxianClear(kaiguanxianClearArray);//清空样式  默认黑色
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
});

/**
 * 故障定位
 * selectedFlag: true 删除故障渲染  false 添加故障渲染
 * */
function faultClick(selectedFlag){
	var substationId = javaScriptObj.substationId;
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
	kaiguanxianErrorArray.push("1305ca7c-463d-4aea-ae0c-7dc712470ab4");
	kaiguanxianErrorArray.push("b758d4ca-7b31-41e3-99f3-231904a78198");
	
	var boxErrorArray = new Array();
	boxErrorArray.push("372d7733-da1a-4a6e-b993-70560a92b1d4");
	boxErrorArray.push("45a86a64-902a-43c6-98b4-034c0f50ebd4");
	if(!selectedFlag){
		mySvg.kaiguanxianError(kaiguanxianErrorArray);//开关线 标红,
		mySvg.boxError(boxErrorArray);//出线柜/分支箱  整体状态 标红, 
	}else{
		mySvg.kaiguanxianClear(kaiguanxianErrorArray);//开关线 标红,
		mySvg.boxClear(boxErrorArray);//出线柜/分支箱  整体状态 标红, 
	}
}