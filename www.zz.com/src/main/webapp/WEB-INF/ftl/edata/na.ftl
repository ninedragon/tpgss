<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>v2-用电数据汇总</title>
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
		<@_top.top 4/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 100px;">
			<div class="row">
				<#--引入左侧菜单-->
				<@_left.edata 10/>
				<div class="col-md-10">
					<h2>北向应用简易版</h2>
					<hr>
					<form method="post" action="" id="formId" class="form-inline">
				    第一步：鉴权（鉴权一次即可，后续无需鉴权）<br>
					<span class=""> <#--pull-right -->
				         	<button  type="button" class="btn btn-primary" onClick="authentication()">鉴权</button> 	
				    </span><br/>
				    第二步：发送命令<br>
				    <span class=""> <#--pull-right -->
				    	   <input type="text" name="indicateCmd" id ="indicateCmd" value="9999">
				         	<button  type="button" class="btn btn-primary" onClick="postAsynCommandV4()">发送命令</button> 	
				    </span><br/>
					</form>
				</div>
			</div><#--/row-->
		</div>
	</body>
	<table>
         <tr></tr>
	</table>
<script type="text/javascript">	
	function authentication(){
	$.post('${basePath}/edata/authentication.shtml', {name:1}, function(data, textStatus, xhr) {
		/*optional stuff to do after success */
		alert("鉴权成功");
	});
	}
	function postAsynCommandV4(){
		var indicateCmd=$("#indicateCmd").val();
		console.log(indicateCmd);
	$.post('${basePath}/edata/postAsynCommandV4.shtml', {indicateCmd,indicateCmd}, function(data, textStatus, xhr) {
		/*optional stuff to do after success */

		alert("发送命令");
	});
	}
</script>
</html>