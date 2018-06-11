<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>应用设置</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}f/avicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/js/layui/css/layui.css" rel="stylesheet"/>

		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<#-- <script  src="${basePath}/js/common/layer/layer.js"></script> -->
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		<script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
        <script type="text/javascript" src='${basePath}/js/echarts.js'></script>
		<script type="text/javascript">
             $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
        </script> 
        <script type="text/javascript" src='${basePath}/js/layui/layui.js'></script>
	</head>
	<body data-target="#one" data-spy="scroll">
		<#--引入头部-->
		<@_top.top 5/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 100px;">
			<div class="row">
				<#--引入左侧菜单-->
				<@_left.dad 1/>
				<div class="col-md-10">
					<h2>北向应用简易版</h2>
					<hr>
				    第一步：鉴权（鉴权一次即可，后续无需鉴权）<br>
					<span class=""> <#--pull-right -->
				         	<button  type="button" class="btn btn-primary" onClick="authentication()">鉴权</button> 	
				    </span><br/>
				    第二步：打开回调<br>
				    <span class=""> <#--pull-right -->
				    	   回调地址<input type="text" name="callbackBaseUrl" id ="callUrl" value="http://117.62.172.216:8081">
				    </span>
				    <span class="">
				    <button  type="button" class="btn btn-primary" onClick="callUrl()">打开回调</button>
				     </span>	
				    <br/>
				    第三步：发送命令<br>
				    <span class="">
				    	   命令<input type="text" name="indicateCmd" id ="indicateCmd" value="680C000C00680312041e00010100170107045C16">
				    	   deviceId<input type="text" name="nbDeviceId" id ="nbDeviceId" value="74094ae8-27e9-462e-a521-9e6e821cca86">
				    	   <label>终端id(目前无用)</label style="color: red"><input type="text" name="ndtuId" id ="ndtuId" value="9999">
				         	<button  type="button" class="btn btn-primary" onClick="postAsynCommandV4()">发送命令</button> 	
				    </span><br/>
				</div>
			</div>
		</div>
	</body>
	<table>
         <tr></tr>
	</table>
<script type="text/javascript">	
	//一共分为鉴权，打开回调，开启服务器，或者一次性的接口
	//1.1鉴权
	function authentication(){
	$.post('${basePath}/dad/authentication.shtml', {name:1}, function(data, textStatus, xhr) {
		/*optional stuff to do after success */
		alert(data.isSuccess);
	});
	}
	//1.2打开回调
	function callUrl(){
		var callbackBaseUrl=$("#callbackBaseUrl").val();
	$.post('${basePath}/dad/callUrl.shtml', {callbackBaseUrl,callbackBaseUrl}, function(data, textStatus, xhr) {
		/*optional stuff to do after success */
		alert(data.isSuccess);
	});
	}
 //    //1.3启动监听服务器
 //    function startup(){
	// 	var callbackBaseUrl=$("#callbackBaseUrl").val();
	// 	console.log(callbackBaseUrl);
	// $.post('${basePath}/dad/postAsynCommandV4.shtml', {indicateCmd,indicateCmd}, function(data, textStatus, xhr) {
	// 	/*optional stuff to do after success */

	// 	alert("发送命令");
	// });
	// }	
	function postAsynCommandV4(){
		var indicateCmd=$("#indicateCmd").val();
		var nbDeviceId=$("#nbDeviceId").val();

		console.log(indicateCmd);
	    $.post('${basePath}/dad/postAsynCommandV4.shtml', {indicateCmd:indicateCmd,nbDeviceId:nbDeviceId}, function(data, textStatus, xhr) {
		/*optional stuff to do after success */

		alert(data.isSuccess);
	});
	}

</script>
</html>