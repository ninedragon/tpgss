<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8" />
    <title>表箱告警</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <link rel="icon" href="${basePath}f/avicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${basePath}/favicon.ico" />
    <link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet" />
    <link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet" />
    <link href="${basePath}/js/layui/css/layui.css" rel="stylesheet" />
    <script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
    <#-- <script src="${basePath}/js/common/layer/layer.js"></script> -->
    <script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="${basePath}/js/shiro.demo.js"></script>
    <script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src='${basePath}/js/echarts.js'></script>
    <script type="text/javascript">
    $(".form_datetime").datetimepicker({ format: 'yyyy-mm-dd hh:ii' });
    </script>
    <script type="text/javascript" src='${basePath}/js/layui/layui.js'></script>
<#-- 3、bootstrap table组件以及中文包的引用 -->
    <script src="${basePath}/js/common/bootstrap-table/bootstrap-table.js"></script>
    <link href="${basePath}/js/common/bootstrap-table/bootstrap-table.css" rel="stylesheet" />
    <script src="${basePath}/js/common/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>    
</head>

<body data-target="#one" data-spy="scroll">
    <#--引入头部-->
        <div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 100px;">
            <div class="row">
                <#--引入左侧菜单-->
                    <div class="col-md-10">
                        <h2>表箱告警</h2>
                        <div id="toolbar" class="btn-group">
                            <button id="btn_add" type="button" class="btn btn-default">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                            </button>
                            <button id="btn_edit" type="button" class="btn btn-default">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                            </button>
                            <button id="btn_delete" type="button" class="btn btn-default">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                            </button>
                        </div>
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">
												模态框（Modal）标题
											</h4>
                                    </div>
                                    <div class="modal-body">
                                        <#-- <div class="form-group">
                                            <label for="txt_departmentname">部门名称</label>
                                            <input type="text" name="txt_departmentname" class="form-control" id="txt_departmentname" placeholder="部门名称">
                                    </div> -->
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                    </button>
                                    <button type="button" class="btn btn-primary" id="btn_submit">
                                        提交更改
                                    </button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <table id="tb_warn"></table>
            </div>
           </div>
           <div>
				<div id="result"></div>
           </div>
        <div class="page-header" id="tou">
            webSocket多终端聊天测试
        </div>
        <#-- <button class="btn btn-default" type="button" id="closeListen" onclick="closeListen()">关闭监听异常事件</button>
        <div id="state" value="1"></div> -->
        <div class="well" id="msg"></div>
        <div class="col-lg">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="发送信息..." id="message">
                <span class="input-group-btn">
                            <button class="btn btn-default" type="button" id="send" >发送</button>
                        </span>
            </div>
        </div>
        </div>
</body>
<#--服务器发送事件<script>-->
<#--if(typeof(EventSource)!=="undefined")-->
  <#--{-->
		  <#--var source=new EventSource("${basePath}/aad/getDate.json");-->
		  <#--source.onopen = function(){-->
			  <#---->
		  <#--}-->
		  <#--source.onmessage=function(event) {-->
			<#---->
		    	<#--document.getElementById("result").innerHTML=event.data('name', 'value') + "change8"+"<br />";-->
		   <#--};-->
  <#--}else{-->
  		<#--document.getElementById("result").innerHTML="Sorry, your browser does not support server-sent events...";-->
  <#--}-->
<#--</script>-->
<script src="${basePath}/js/aad/table.js"></script>	
 <script type="text/javascript">
        //     function closeListen(){//一开始想写个关闭监听的功能想想没必要，不用管了，以后再写
        //         var openListen =$("#state").val();
        //         if(openListen==1){
        //         $.post('${basePath}/listen/openListen.shtml', {openListen: "0"}, function(data, textStatus, xhr) {
        //             /*optional stuff to do after success */

        //             console.log("关闭监听异常事件");
        //             $("#state").html("已关闭");
        //             $("#closeListen").html("打开监听异常事件");
        //             $("#state").val(0);

        //         });
        //     }else{
        //         $.post('${basePath}/listen/openListen.shtml', {openListen: '1'}, function(data, textStatus, xhr) {
        //             /*optional stuff to do after success */
        //             console.log("打开监听异常事件");
        //             $("#state").html("已开启");
        //             $("#closeListen").html("开启监听异常事件");
        //            $("#state").val(1);
        //         });
        //     }
        // }
            $(function() {
                
               
                var websocket;
                if('WebSocket' in window) {
                                        console.log("此浏览器支持websocket");
                    websocket = new WebSocket("ws://192.168.0.109:8080${basePath}/chat/12345");
                } else if('MozWebSocket' in window) {
                    alert("此浏览器只支持MozWebSocket");
                } else {
                    alert("此浏览器只支持SockJS");
                }
                websocket.onopen = function(evnt) {
                    //打开监听,连接open后给前端和后端同时发送open信号，两个线程不会阻塞。但是我的后端open事件一定要先执行，这样前端请求时，才能有足够的时间等待后端生成userSocket
                    setTimeout("console.log('等待后端执行完毕')", 500 );
                     $.post('${basePath}/listen/openListen.shtml', {openListen: '1'}, function(data, textStatus, xhr) {
                    /*optional stuff to do after success */
                    console.log("开启监听异常事件");
                });
                    $("#tou").html("链接服务器成功!")
                };
                websocket.onmessage = function(evnt) {
                    $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
                };
                websocket.onerror = function(evnt) {};
                websocket.onclose = function(evnt) {
                    $("#tou").html("与服务器断开了链接!")
                }
                
                $('#send').click(function(){
                    send();
                });

                function send() {
                    if(websocket != null) {
                        var message = document.getElementById('message').value;
                        websocket.send(message);
                    } else {
                        alert('未与服务器链接.');
                    }
                }
            });
</script>
<#-- 廖雪峰文章里的websocket<script type="text/javascript">
	var ws = new WebSocket("wss://echo.websocket.org");

    ws.onopen = function(evt) { 
      console.log("Connection open ..."); 
      ws.send("Hello WebSockets!");
    };

    ws.onmessage = function(evt) {
      console.log( "Received Message: " + evt.data);
      ws.close();
    };

    ws.onclose = function(evt) {
      console.log("Connection closed.");


};  
</script> -->

</html>