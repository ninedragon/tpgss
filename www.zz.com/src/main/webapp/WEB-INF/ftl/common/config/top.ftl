<#macro top index>
<#if index ==1 >
 <script  src="${basePath}/js/common/layer/layer.js"></script>
<script baseUrl="${basePath}" src="${basePath}/js/user.login.js"></script>
<div class="wapp-head">
	<span class="link"></span>
	<div class="info" onclick="selectFaultNews();">消息</div>
    <div class="lay" style="left:auto;right:0px;">
        <ul style="overflow-y: auto;height: 280px;" id="falutNewsUL">
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
	function clickFaultNews(substainRowId,epuName,action){
		var isShow = $("#tab_" + substainRowId).attr("isShow");
		var pageName = $("#pageName").val();//当前页面名称
		if(isShow == "yes"){//当前箱变TAB存在，则不需要加载页面
		    var iframeID = $("#" + substainRowId + "Iframe")[0]; //获取iframe的ID
		    $(".all li").each(function(){
		    	$(this).removeClass("on");
		    	var thisRowId = $(this).attr("id").replace("tab_","");
		    	if('tab_'+substainRowId ==  $(this).attr("id")){
					$(this).addClass("on");
					$("#"+thisRowId+"tabShow").show();
				}else{
					$("#"+thisRowId+"tabShow").hide();
				}
		    });
		    iframeID.contentWindow.$(".a-hov span").each(function(){
				$(this).removeClass("on");
				if('故障定位' ==  $(this).text()){
					$(this).addClass("on");
				}
			});
		    $("#tab_" + substainRowId).addClass("on");
		    iframeID.contentWindow.faultClick(false);
		}else if(pageName == "allShowList"){
			$("#topoErrorLoadJson").html("{\"action\":\""+action+"\",\"key\":\""+substainRowId+"\"}");
			addTab(substainRowId,epuName);//动态追加TAB
		}else {
	        var form = $("<form></form>");
	        form.attr('action',"${basePath}/epu/allShowList.shtml");
	        form.attr('method','post');
	        input1 = $("<input type='hidden' name='substainRowId' id='substainRowId' value='" + substainRowId + "' />")
	        input2 = $("<input type='text' name='action' id='action' value='" + action + "' />")
	        form.append(input1)
	        form.append(input2)
	        form.appendTo("body")
	        form.css('display','none')
	        form.submit();
		}
	}
	function selectFaultNews(){
		$("#loadingDiv").show();
		$.ajax({ 
			 type: "post",
		     url:  "${basePath}/fault/selectFaultNews.shtml",
		     data: {
		     },
		     async:true,
		     dataType: "json",
		     success: function(allData){ 
		    	 var htmls = "";
		    	 if(allData){
			    	 if(null != allData && allData.length > 0){
			    		 for(var i = 0;i < allData.length;i++){
		        				var json = allData[i];
		        				var key = json["key"];
		        				var epuName = json["epuName"];
		        				htmls +="<li class=\"mrr\"><a onclick=\"clickFaultNews('"+key+"','"+epuName+"','flaut');\" >"+epuName+"</a></li>";
			    		 }
			    	 }
		    	 }
			     $("#falutNewsUL").html(htmls);
		    	 $("#loadingDiv").hide();
		    } 
		});
	}
	
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
		if(evnt.data.indexOf("falutNews") !=-1){
			//加载
			selectFaultNews();
		 }
		 //得到消息通知，执行加载故障数据
	};
	websocket.onerror = function(evnt) {};
	websocket.onclose = function(evnt) {
// 		 alert("与服务器断开了链接!");
	}
</script>
</#if>
</#macro>