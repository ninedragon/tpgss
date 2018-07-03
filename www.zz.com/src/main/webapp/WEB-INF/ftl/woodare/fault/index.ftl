<!DOCTYPE html>
<!-- <html> -->
  <head>
    
    <title>V2-用电数据汇总</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
	<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
	<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${basePath}/css/common/base.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/woodare/css/comm.css" />
		<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
	<script src="${basePath}/woodare/js/menu.js"></script>
	<script src="${basePath}/woodare/js/faultLocation.js"></script>
	<script  src="${basePath}/js/common/layer/layer.js"></script>
	<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script  src="${basePath}/js/shiro.demo.js"></script>
	<script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
  </head>
  
  <body>
    <!--页眉开始-->
<!-- 	<%--引入头部<@_top.top 3/>--%> -->
		<@_top.top 1/>
	<!--页眉结束/-->

	<!--左侧导航开始-->
	<@_left.top 1/>
	<!--左侧导航结束/-->
<!--主体开始-->
<div class="wapp-main">
		<form method="post" action="" id="formId" class="form-inline">
		
	<h4>故障定位列表</h4>	
    <!--搜索开始-->
	<div class="search">
	    	 <lable>
        	<span>设备名称</span>
               <input id="epuName" type="text" name="epuName" value="" />
    	</lable>
    	<lable>       
        	<span>故障原因 </span>
              <select id="falutReason" name="falutReason" >
            	<option></option>
				 <#if falutReasonMap?exists>
					        <#list jsonArrayFalutReason as x>
                                 <option value="${x.key}">${x.value}</option>
                            </#list>	
				 </#if>   
            </select>
    	</lable>
        <div class="but-nav">
        	<button type="button"  onclick="javascript:initList();"       class="btn btn-primary" style="background-color: #169274;">查询</button>
        </div>
	</div>
    <!--搜索结束/-->
    <!--表格开始-->
    <div class="table-box">
        <table width="100%">
            <tr>   
							<th>设备名称</th>
							<th>故障原因</th>
							<th>故障发生时间</th>
							<th>是否取消</th>
							<th>是否修复</th>
							<th>修复时间</th>						
				
            </tr>
           <tbody id="faultListTable"></tbody>
        </table>
    </div>
	<!--表格结束/-->
    
<!--     分页开始 -->

	   		 <div class="pagination pull-right">
			 </div>
<!--     分页结束/ -->
 </form>
</div>
<!--主体结束/-->
<!--主体结束/-->
<script >
		so.init(function(){
				 initList();
		});
		 function initList(pageNo) {
		 	var param_epuName = $("#epuName").val();
		 	var param_falutReason = $("#falutReason").val();
			$("#loadingDiv").show(); 
	        var tbody = '';
	        var falutReasonJson = {};
	        falutReasonJson["0"] = "短路";
	        falutReasonJson["1"] = "异常漏电";
	        falutReasonJson["2"] = "缺相";
	        falutReasonJson["3"] = "停电";
	        var isFalutJson = {};
	        isFalutJson["0"] = "否";
	        isFalutJson["1"] = "是";
	        var isCancelledJson = {};
	        isCancelledJson["0"] = "否";
	        isCancelledJson["1"] = "是";
	         if (faultLocationData !=null && faultLocationData.length>0) {
	         	var newArray = new Array();
	            for (var i = 0; i < faultLocationData.length; i++) {
	             var json = faultLocationData[i];
	            	var faultType = json["faultType"];
	            	var epuName = json["epuName"];
	             	  if(("" == param_epuName || null == param_epuName) && ("" == param_falutReason|| null == param_falutReason)){
					    	newArray.push(json); 
					    }else if((""!= param_epuName && null != param_epuName) && ("" != param_falutReason && null != param_falutReason)){
					    	 if((faultType == param_falutReason || faultType == param_falutReason) && epuName.indexOf(param_epuName) !=-1){
							    	newArray.push(json);
							  }
					    }else if(("" == param_epuName || null == param_epuName) && ("" != param_falutReason&& null != param_falutReason)){
					    	if(faultType == param_falutReason || faultType == param_falutReason){
						    	newArray.push(json);
						    }
					    }else if(("" != param_epuName&& null != param_epuName) && ("" == param_falutReason  || null == param_falutReason)){
					    	if(epuName.indexOf(param_epuName) !=-1 ){
						    	newArray.push(json);
						    }
					    }
	             }
	             for (var i = 0; i < newArray.length; i++) {
	             	var json = newArray[i];
	                 tbody += '<tr>';
	                 tbody += '<td align="center"><div>' + json.epuName+ '</div></td>';
	                 tbody += '<td align="center"><div>' + (falutReasonJson[json.faultType] ||"") + '</div></td>';
	                 tbody += '<td align="center"><div>' + json.occur_time+ '</div></td>';
	                 tbody += '<td align="center"><div>' + isCancelledJson[json.is_cancelled]+ '</div></td>';
	                 tbody += '<td align="center"><div>' + isFalutJson[json.is_repaired] + '</div></td>';			                            
	                 tbody += '<td align="center"><div>' + json.repair_time+ '</div></td>';
	                 tbody += '</tr>';			                            
	             }
	           }
	           $("#faultListTable").html(tbody);
	           $("#loadingDiv").hide(); 
           }
		</script>
</body>
</html>

