<!DOCTYPE html>
<!-- <html> -->
  <head>
    
    <title>V2-用电数据汇总</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link rel="stylesheet" type="text/css" href="${basePath}/woodare/css/comm.css" />
	<script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
	<script baseUrl="${basePath}" src="${basePath}/js/user.login.js"></script>
	<script  src="${basePath}/js/common/layer/layer.js"></script>
	<script src="${basePath}/woodare/js/menu.js"></script>
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
	<h4>个人资料</h4>
    
    <!--资料编辑开始-->
    <div class="datum">
        <table width="100%">
            <tr>
                <td width="35%" align="center">昵称</td>
                <td width="65%" align="center">${token.nickname?default('未设置')}</td>
            </tr>
            <tr>
                <td align="center">Email账号</td>
                <td align="center">${token.email?default('未设置')}</td>
            </tr>
            <tr>
                <td align="center">创建时间</td>
                <td align="center">
                	${token.createTime?string('yyyy-MM-dd HH:mm')}
                </td>
            </tr>
            <tr>
                <td align="center">最后登录时间</td>
                <td align="center">${token.lastLoginTime?string('yyyy-MM-dd HH:mm')}</td>
            </tr>
        </table>
    </div>
    <!--资料编辑结束/-->
</div>
<!--主体结束/-->
  </body>
</html>
