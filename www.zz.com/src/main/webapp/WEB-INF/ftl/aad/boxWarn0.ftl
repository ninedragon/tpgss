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
        <@_top.top 6/>
        <div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 100px;">
            <div class="row">
                <#--引入左侧菜单-->
                    <@_left.aad 1/>
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
           <div>
            <input type="button" id="btnConnection" value="连接8" />
            <input type="button" id="btnClose" value="关闭" />
            <input type="button" id="btnSend" value="发送" />
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
            var socket;
            if(typeof(WebSocket) == "undefined") {
                alert("您的浏览器不支持WebSocket,请使用非IE内核浏览器");
            }

            $("#btnConnection").click(function() {
                //实现化WebSocket对象，指定要连接的服务器地址与端口
                socket = new WebSocket("ws://192.168.0.107:8081/${basePath}/ws/jqs");
                //打开事件
                socket.onopen = function() {
                    alert("Socket 已打开");
                    //socket.send("这是来自客户端的消息" + location.href + new Date());
                };
                //获得消息事件
                socket.onmessage = function(msg) {
                    alert(msg.data);
                };
                //关闭事件
                socket.onclose = function() {
                    alert("Socket已关闭");
                };
                //发生了错误事件
                socket.onerror = function() {
                    alert("发生了错误");
                }
            });
            
            //发送消息
            $("#btnSend").click(function() {
                socket.send("这是来自客户端的消息" + location.href + new Date());
            });
            
            //关闭
            $("#btnClose").click(function() {
                socket.close();
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