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
<script type="text/javascript"> 
	var websocket;
	if('WebSocket' in window) {
	     console.log("此浏览器支持websocket");
	    websocket = new WebSocket("ws://${web_socket_ip}${basePath}/chat/${token.id}");
	} else if('MozWebSocket' in window) {
	    alert("此浏览器只支持MozWebSocket");
	} else {
	    alert("此浏览器只支持SockJS");
	}
	websocket.onopen = function(evnt) {
	    //打开监听,连接open后给前端和后端同时发送open信号，两个线程不会阻塞。但是我的后端open事件一定要先执行，这样前端请求时，才能有足够的时间等待后端生成userSocket
	    //加载故障数据
// 	     alert("链接服务器成功,加载故障数据!");
	};
	websocket.onmessage = function(evnt) {
		 if("falut" == evnt.data){
			 alert("得到消息通知，执行加载故障数据："+evnt.data);
		 }
		 //得到消息通知，执行加载故障数据
	};
	websocket.onerror = function(evnt) {};
	websocket.onclose = function(evnt) {
		 alert("与服务器断开了链接!");
	}
</script>
</#if>
</#macro>