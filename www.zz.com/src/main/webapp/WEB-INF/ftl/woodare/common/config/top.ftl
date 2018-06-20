<#macro top index>
<#if index ==1 >
 <script  src="${basePath}/js/common/layer/layer.js"></script>
<script baseUrl="${basePath}" src="${basePath}/js/user.login.js"></script>
<div class="wapp-head">
	<span class="link"></span>
	<div class="info">消息</div>
    <div class="lay" style="left:auto;right:0px;">
        <ul style="overflow-y: auto;height: 280px;">
        	<#list 0..20 as x>
            <li class="mrr"><a href="${basePath}/epu/allShowList.shtml?substainRowId=ce70837b-ccb5-4e6b-b9a1-4a421829f24f">江苏省南京市雨花台区${x}号变箱</a></li>
        	</#list>
        </ul>
    </div>
	<div class="user">
	<!-- 登录用户信息名称 -->
	${token.nickname?default('阿西吧')}
	<span class="caret"></span></div>
    <div class="lay">
			<@shiro.user>  
				<span class="caret"></span></a>
				<ul userid="${token.id}">
					<li><a href="${basePath}/user/index.shtml">个人资料</a></li>
					<li><a href="${basePath}/role/mypermission.shtml">我的权限</a></li>
					<li><a onclick="logout();">退出登录</a></li>
				</ul>
			</@shiro.user>  
			<@shiro.guest> 
			<ul userid="${token.id}">
				<li><aonclick="logout();">登录</a></li>
			</ul>
			</@shiro.guest>  
    </div>
</div>
</#if>
</#macro>