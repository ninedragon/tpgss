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
	<script >
		var obj = {
			self
		}
			<@shiro.hasPermission name="/member/changeSessionStatus.shtml">
			$(function(){
				$("span[v=onlineDetails]").on('click',function(){
					var self = $(this);
				var text = $.trim(self.text());
				$("#statusSpan").html("确定"+text+"这个用户？");
				$(".wapp-layer").show();
				obj.self = self;
				});
			});
			<#--改变状态-->
			function changeSessionStatus(sessionIds,status,self){
				status = !parseInt(status);
				<#--loading-->
				var load = layer.load();
				$.post("${basePath}/member/changeSessionStatus.shtml",{status:status,sessionIds:sessionIds},function(result){
					layer.close(load);
					if(result && result.status == 200){
						$(".wapp-layer").hide();
						return $("span[sessionId='"+sessionIds+"']").text(result.sessionStatusText),
									 $("span[sessionId='"+sessionIds+"']").attr('status',result.sessionStatus),
										 $("span[sessionId='"+sessionIds+"']").parent().prev().text(result.sessionStatusTextTd);
										layer.msg('操作成功'),!1;
					}else{
						return layer.msg(result.message,function(){}),!1;
					}		
				},'json');
			}
			</@shiro.hasPermission>
			<#--激活、踢出更新-->
			function updatestatus(){
				changeSessionStatus(obj.self.attr('sessionId'),obj.self.attr('status'),self);
			}
		</script>
  </head>
  
  <body>
   <!--页眉开始-->
	<@_top.top 1/>
	<!--页眉结束/-->

	<!--左侧导航开始-->
	<@_left.top 1/>
	<!--左侧导航结束/-->

<!--主体开始-->
<div class="wapp-main">
	<h4>在线用户</h4>	
    
    <!--表格开始-->
    <div class="table-box">
         <form method="post" action="" id="formId" class="form-inline">
	        <table width="100%">
	            <tr>
	                <th>SessionID</th>
	                <th>昵称</th>
	                <th>Email账号</th>
	                <th>创建回话</th>
	                <th>回话最后活动</th>
	                <th>状态</th>
	                <th>操作</th>
	            </tr>
	             <#if list?exists && list?size gt 0 >
	            		<#list list as it>	            		
	            			<tr>
				                <td align="center">${it.sessionId!''}</td>
				                <td align="center">${it.nickname!''}</td>
				                <td align="center">${it.email!''}</td>
				                <td align="center">${it.startTime?string('yyyy-MM-dd HH:mm')}</td>
				                <td align="center">${it.lastAccess?string('yyyy-MM-dd HH:mm')}</td>
				                <td align="center">${(it.sessionStatus)?string('有效','已踢出')}</td>
				            	<td>
										<span class="icon05" onClick="location.href='${basePath}/member/onlineDetails/${it.sessionId}.shtml'">详情</span>
										<@shiro.hasPermission name="/member/changeSessionStatus.shtml">
											<span class="icon06 layb-js" v="onlineDetails" sessionId="${it.sessionId}" status="${(it.sessionStatus)?string(1,0)}">${(it.sessionStatus)?string('踢出','激活')}</span>
										</@shiro.hasPermission>
									</td>
				            </tr>
	            			</#list>
	            	 <#else>
	            		<tr>
							<td class="center-block" callspan="4">没有用户</td>
						</tr>
	            	</#if>
	        </table>
        </form>
    </div>
	<!--表格结束/-->
    
    <!--分页开始-->
    <!--分页结束/-->
</div>
<!--主体结束/-->
</body>
</html>
<!--弹层开始-->
<div class="wapp-layer">
	<div class="box tips">
    	<h4>提示信息<span class="close-js" " onclick="$('.wapp-layer').hide();">关闭</span></h4>
        <div class="edit">
            <p id="statusSpan"></p>
            <div class="but-nav">
                <span class="but" onclick="updatestatus();">确&nbsp;&nbsp;定</span>
                <span class="but miss close-js" onclick="$('.wapp-layer').hide();">取&nbsp;&nbsp;消</span>
            </div>
        </div>
    </div>
</div>
<!--弹层结束/-->