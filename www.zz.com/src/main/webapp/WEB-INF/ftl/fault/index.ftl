<!DOCTYPE html>
<!-- <html> -->
  <head>
  <base href="${basePath}">
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
	<script  src="${basePath}/js/common/layer/layer.js"></script>
	<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script  src="${basePath}/js/shiro.demo.js"></script>
	<script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
	<input type="hidden" id="action" name="action" value="all">
	<input type="hidden" id="strKeyArray" name="strKeyArray"/>
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
          <input id="row_name" type="text" name="row_name" value="" /></lable>
    	<lable>       
        	<span>故障原因 </span>
          <select id="fault_type" name="fault_type" onchange="changeFault(this);"></select>
    	</lable>
    	<!-- 二级故障原因 -->
    	<lable id="secondLevelFalut"></lable>
    	 <lable>
        	<span>是否修复</span>
        	<select id="is_repaired" name="is_repaired">
        		<option value="">--请选择--</option>
        		<option value="1">已修复</option>
        		<option value="0">未修复</option>
        	</select>
         </lable>
         <lable>
        	<span>故障发生时间</span>
         	 <input id="str_occur_time" type="text" name="str_occur_time" value="" onClick="WdatePicker()"/>
         </lable>
        <div class="but-nav">
          <button type="button" onclick="javascript:initList();" class="btn btn-primary" style="background-color: #169274;">查询</button></div>
	</div>
    <!--搜索结束/-->
    <!--表格开始-->
    <div class="table-box">
        <table width="100%">
            <tr>   
							<th>设备名称</th>
            <th>设备类型</th>
							<th>故障原因</th>
							<th>故障发生时间</th>
							<th>是否取消</th>
							<th>是否修复</th>
							<th>修复时间</th>						
            <th>省份</th>
            <th>城市</th>
            <th>区县</th>
             <th>操作</th>
            </tr>
           <tbody id="faultListTable"></tbody>
        </table>
    </div>
	<!--表格结束/-->
<!--     分页开始 -->
      <div class="pagination pull-right"></div>
      <!-- 分页结束/ --></form>
			 </div>
<!--主体结束/-->
<!--loading开始-->
	<div class="loading">
		<div class="spinner">加载中
			<div class="double-bounce1"></div>
			<div class="double-bounce2"></div>
		</div>
	</div>
	<!--loading结束/-->
	<!--弹层开始-->
<div class="wapp-layer" id="showFaultBase">
</div>
<!--弹层结束/-->
  <script src="${basePath}/woodare/js/dateFormat.js"></script>
  <script src="${basePath}/woodare/js/faultLocationList.js"></script>
	<script >
		so.init(function(){
		so.initFaultTypeList();
				 initList();
		});
		</script>
</body>
</html>