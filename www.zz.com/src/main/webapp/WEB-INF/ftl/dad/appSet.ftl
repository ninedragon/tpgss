<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8"/>
    <title>应用设置</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>
    <link rel="icon" href="${basePath}f/avicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="${basePath}/favicon.ico"/>
    <link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
    <link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
    <link href="${basePath}/js/layui/css/layui.css" rel="stylesheet"/>

    <script src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
<#-- <script  src="${basePath}/js/common/layer/layer.js"></script> -->
    <script src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="${basePath}/js/shiro.demo.js"></script>
    <script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src='${basePath}/js/echarts.js'></script>
    <script type="text/javascript">
        $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii'});
    </script>
    <script type="text/javascript" src='${basePath}/js/layui/layui.js'></script>
</head>
<body data-target="#one" data-spy="scroll">
<#--引入头部-->
<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 100px;">
    <div class="row">
    <#--引入左侧菜单-->
        <div class="col-md-10">
            <h2>北向应用简易版</h2>
            <hr>
            第一步：鉴权（鉴权一次即可，后续无需鉴权）<br>
            <span class=""> <#--pull-right -->
                <button type="button" class="btn btn-primary" onClick="authentication()">鉴权</button>
				    </span><br/>
            第二步：打开回调<br>
            <span class=""> <#--pull-right -->
                回调地址<input type="text" name="callbackBaseUrl" id="callUrl" value="http://117.62.172.216:8081">
				    </span>
            <span class="">
				    <button type="button" class="btn btn-primary" onClick="callUrl()">打开回调</button>
				     </span>
            <br/>
            第三步：发送命令<br>
            <span class="">
				    	   命令<input type="text" name="indicateCmd" id="indicateCmd"
                                    value="680C000C00680312041e00010100170107045C16">
				    	   deviceId<input type="text" name="nbDeviceId" id="nbDeviceId"
                                          value="74094ae8-27e9-462e-a521-9e6e821cca86">
				    	   <label>终端id(目前无用)</label style="color: red"><input type="text" name="ndtuId" id="ndtuId"
                                                                              value="9999">
				         	<button type="button" class="btn btn-primary" onClick="postAsynCommandV4()">发送命令</button>
				    </span><br/>
        </div>
        <hr>
        <div>
            <table border="1">
                <tr>
                    <th>编号</th>
                    <th>描述</th>
                    <th>数据</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>发送停电</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendA3()">发送停电数据</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>发送BC缺相数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendA32()">发送BC缺相数据</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>发送只缺C相数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendA321()">发送只缺C相数据</button>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>发送超限数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendA33()">发送超限数据</button>
                    </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>发送电压异常恢复数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendA34()">发送电压恢复数据</button>
                    </td>
                <tr>
                    <td>编号</td>
                    <td>描述</td>
                    <td>数据</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>发送短路数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendA0()">发送短路数据A0</button>
                    </td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>发送正常漏电数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendA1()">发送正常漏电数据A1</button>
                    </td>
                </tr>
                <tr>
                    <td>31</td>
                    <td>发送异常漏电数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendA2()">发送异常漏电数据A2</button>
                    </td>
                </tr>
                <tr>
                    <td>31</td>
                    <td>发送异常漏电恢复数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendA22()">发送异常漏电恢复数据A22</button>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <button></button>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>发送bdtu停电</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendB3()">发送bdtu停电数据</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>发送BC缺相数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendB32()">发送bdtu的BC缺相数据</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>发送只缺C相数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendB321()">发送bdtu的只缺C相数据</button>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>发送超限数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendB33()">发送bdtu的超限数据</button>
                    </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>发送电压异常恢复数据</td>
                    <td></td>
                    <td>
                        <button onclick="sendB34()">发送bdtu电压恢复数据</button>
                    </td>
                <tr>
                    <td>编号</td>
                    <td>描述</td>
                    <td>数据</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>发送短路数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendB0()">发送bdtu A相短路数据A0</button>
                    </td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>发送短路数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendB02()">发送bdtu B相短路数据A0</button>
                    </td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>发送短路数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendB03()">发送bdtu C相短路数据A0</button>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <button></button>
                    </td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>发送阻抗数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="sendA4()">发送阻抗数据</button>
                    </td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>计算阻抗数据</td>
                    <td>00123</td>
                    <td>
                        <button onclick="calZ()">计算阻抗数据</button>
                    </td>
                </tr>
            </table>

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
    function authentication() {
        $.post('${basePath}/dad/authentication.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            alert(data.isSuccess);
        });
    }
    //1.2打开回调
    function callUrl() {
        var callbackBaseUrl = $("#callbackBaseUrl").val();
        $.post('${basePath}/dad/callUrl.shtml', {callbackBaseUrl, callbackBaseUrl}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            alert(data.isSuccess);
        });
    }
    //    //1.3启动监听服务器
    //    function startup(){
    // 	var callbackBaseUrl=$("#callbackBaseUrl").val();
    // 	console.log(callbackBaseUrl);
    // $.post('${basePath}
    // /dad/postAsynCommandV4.shtml', {indicateCmd,indicateCmd}, function(data, textStatus, xhr) {
    // 	/*optional stuff to do after success */

    // 	alert("发送命令");
    // });
    // }
    function postAsynCommandV4() {
        var indicateCmd = $("#indicateCmd").val();
        var nbDeviceId = $("#nbDeviceId").val();

        console.log(indicateCmd);
        $.post('${basePath}/dad/postAsynCommandV4.shtml', {
            indicateCmd: indicateCmd,
            nbDeviceId: nbDeviceId
        }, function (data, textStatus, xhr) {
            /*optional stuff to do after success */

            alert(data.isSuccess);
        });
    }

    //【2】模拟终端
    function sendA3() {
        $.post('${basePath}/dad/sendA3.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("断电数据发送成功");
        });
    }

    function sendA32() {
        $.post('${basePath}/dad/sendA32.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("缺相数据发送成功");
        });
    }

    function sendA321() {
        $.post('${basePath}/dad/sendA321.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("只缺C相数据发送成功");
        });
    }

    function sendA33() {
        $.post('${basePath}/dad/sendA33.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("缺BC相数据发送成功");
        });
    }

    function sendA34() {
        $.post('${basePath}/dad/sendA34.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("电压恢复正常数据发送成功");
        });
    }


    function sendA0() {
        $.post('${basePath}/dad/sendA0.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("短路数据发送成功");
        });
    }

    function sendA1() {
        $.post('${basePath}/dad/sendA1.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("正常漏电发送成功");
        });
    }

    function sendA2() {
        $.post('${basePath}/dad/sendA2.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("异常漏电发送成功");
        });
    }

    function sendA22() {
        $.post('${basePath}/dad/sendA22.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("异常漏电恢复发送成功");
        });
    }

    function sendB3() {
        $.post('${basePath}/dad/sendB3.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("断电数据发送成功");
        });
    }

    function sendB32() {
        $.post('${basePath}/dad/sendB32.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("缺相数据发送成功");
        });
    }

    function sendB321() {
        $.post('${basePath}/dad/sendB321.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("只缺C相数据发送成功");
        });
    }

    function sendB33() {
        $.post('${basePath}/dad/sendB33.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("缺BC相数据发送成功");
        });
    }

    function sendB34() {
        $.post('${basePath}/dad/sendB34.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("电压恢复正常数据发送成功");
        });
    }


    function sendB0() {
        $.post('${basePath}/dad/sendB0.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("短路数据发送成功");
        });
    }

    function sendB02() {
        $.post('${basePath}/dad/sendB02.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("B相短路数据发送成功");
        });
    }

    function sendB03() {
        $.post('${basePath}/dad/sendB03.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("C相短路数据发送成功");
        });
    }

    function sendA4() {
        $.post('${basePath}/dad/sendA4.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("阻抗数据发送成功");
        });
    }

    function calZ() {
        $.post('${basePath}/dad/calZ.shtml', {name: 1}, function (data, textStatus, xhr) {
            /*optional stuff to do after success */
            console.log("测试阻抗数据");
        });

    }
</script>
</html>