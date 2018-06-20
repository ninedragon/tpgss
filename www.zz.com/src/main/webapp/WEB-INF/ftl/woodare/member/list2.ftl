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
			list:null,//列表所有数据
			status : null,//状态值
			id : null,//记录主键
			ids : null,//多个记录主键
			operate : null //何种动作操作 forbid ：禁止或激活  del：删除
		};
			so.init(function(){
				//初始化全选。
				so.checkBoxInit('#checkAll','[check=box]');
				//全选
				so.id('deleteAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要删除的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return _delete(array);
				});
				//单击新增
				$("span.icon01").on('click',function(){
					$.post('${basePath}/member/ajax_getFindUsersBy',{id:null},function(result){
						$("#divContent").html(result);
						obj.operate = "save";
						$("#titleSpan").html("新增居民信息");
						$("#saveDiv").show();
					});
				});
			});
			//根据ID数组，删除
			function _delete(ids){
				obj.ids =ids;
				obj.operate="del";
				$("#statusSpan").html("确定删除这"+ ids.length +"个用户？");
				$("#message").show();
			}
			//编辑
			function edit(id){
					$.post('${basePath}/member/ajax_getFindUsersBy',{id:id},function(result){
						$("#divContent").html(result);
						obj.operate = "edit";
						$("#titleSpan").html("修改居民信息");
						$("#saveDiv").show();
					});
			}
			function updatestatus(){
				if(obj.operate == "save"){
					//新增
				}else if(obj.operate == "edit"){
					//编辑
				}else if(obj.operate == "del"){
					var load = layer.load();
					$.post('${basePath}/Home/Delete',{ids:obj.ids.join(',')},function(result){
						layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!0;
						}else{
							$("#message").hide();
							layer.msg('删除成功');
							setTimeout(function(){
								$('#formId').submit();
							},1000);
						}
					},'json').error(function(){
						//处理
							obj.operate="error";
							layer.close(load);
							$("#statusSpan").html("操作异常!");
						}
					);
				}else if(obj.operate == "error"){
					$("#message").hide();
				}
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
		<form method="post" action="" id="formId" class="form-inline">
	<h4>居民列表</h4>	
    <!--搜索开始-->
	<div class="search">
        <lable>
        	<span>昵称</span>
            <input  id="nickname" name ="nickname" type="text"  value="${nickname!''}">
    	</lable>
        <lable>
        	<span>Email</span>
            <input  id="email" name="email" type="text" value="${email!''}">
    	</lable>
        <lable>
        	<span>登录状态</span>
            <select id="status" name="status" >
            	<option value="">请选择</option>
                           <#if (status?? && status== '0')>
	            	
	            			<option  value="0"  selected="selected">禁止</option>
	            		 <#else>
	            			<option  value="0"  >禁止</option>
	            		</#if>
	            	  <#if (status?? && status== '1')>
	            			<option  value="1" selected="selected" >有效</option>
	            		 <#else>
	            			<option  value="1" >有效</option>
	            		</#if>
            </select>
    	</lable>
        <lable>
        	<span>创建时间</span>
            <input id="createTime" name="createTime" type="text" value="${createTime!''}">
    	</lable>
        <lable>
        	<span>最后登录时间</span>
            <input  id="lastLoginTime" name="lastLoginTime" type="text" value="${lastLoginTime!''}">
    	</lable>
        <lable>
        	<span>电表号</span>
            <input id="meter" name="meter" type="text" value="${meter!''}">
    	</lable>
        <lable>
        	<span>供电单位</span>
            <input id="supply" name="supply" type="text" value="${supply!''}">
    	</lable>
        <lable>
        	<span>家庭地址</span>
            <input id="location" name="location" type="text" value="${location!''}">
    	</lable>
        <lable>
        	<span>门牌号</span>
            <input id="housenum" name="housenum" type="text" value="${housenum!''}">
    	</lable>
        <lable>
        	<span>SIM卡号</span>
            <input id="sim" name="sim" type="text" value="${sim!''}">
    	</lable>
        <lable>
        	<span>绝对编号</span>
            <input id="absid" name="absid" type="text" value="${absid!''}">
    	</lable>
        <lable>
        	<span>设备版本号</span>
            <input id="version" name="version" type="text" value="${version!''}">
    	</lable>
        <lable>
        	<span>ID</span>
            <input id="id" name="id" type="text" value="${id!''}">
    	</lable>
        <div class="but-nav">
<!--         	<span class="but" id="btn_query" >查&nbsp;&nbsp;询</span> -->
        	<button type="submit" class="btn btn-primary" style="background-color: #169274;">查询</button>
        </div>
	</div>
    <!--搜索结束/-->
    
    <!--其他操作开始-->
    <div class="other-nav">
<!--         <div class="sec-box"> -->
<!--         	<input name="" type="text"><span>搜索</span> -->
<!--         </div> -->
    	<div class="but-nav">
        	<span class="icon01">新增</span>
            <span class="icon03" id="deleteAll">删除</span>
        </div>
    </div>
    <!--其他操作结束/-->
    <!--表格开始-->
    <div class="table-box">
        <table width="100%">
            <tr>
                <th><input  type="checkbox" id="checkAll"></th>
                <th>ID</th>
                <th>昵称</th>
                <th>Email</th>
                <th>登录状态</th>
                <th>创建时间</th>
                <th>最后登录时间</th>
                <th>电表号</th>
                <th>供电单位</th>
                <th>家庭地址</th>
                <th>门牌号</th>
                <th>SIM卡号</th>
                <th>绝对编号</th>
                <th>设备版本号</th>
                 <th>操作</th>
            </tr>
         
            	 <#if page??>
            		 <#if page.list??>
            				<#list page.list as it>
		            			 <tr>
					                <td align="center"><input value="${it.id}" check='box' type="checkbox" ></td>
					                <td align="center">${it.id!''}</td>
					                <td align="center">${it.nickname!''}</td>
					                <td align="center">${it.email!''}</td>
					                <td align="center">${(it.status== 1) ?string('有效', '禁止')}</td>
					                <td align="center">${it.createTime?string('yyyy-MM-dd HH:mm')}</td>
					                <td align="center">${it.lastLoginTime?string('yyyy-MM-dd HH:mm')}</td>
					                <td align="center">${it.meter!'-'}</td>
					                <td align="center">${it.supply!'-'}</td>
					                <td align="center">${it.location!'-'}</td>
					                <td align="center">${it.housenum!'-'}</td>
					                <td align="center">${it.sim!'-'}</td>
					                <td align="center">${it.absid!'-'}</td>
					                <td align="center">${it.version!'-'}</td>
					                <td align="center">
										<a href="javascript:edit('${it.id}');">修改</a>
										<a href="javascript:_delete([${it.id}]);">删除</a>
					                
					                </td>
					            </tr>
		            		</#list>
            			 <#else>
            				<tr>
								<td class="text-center danger" colspan="13">没有找到用户</td>
							</tr>
            			</#if>
            	 <#else>
            		<tr>
						<td class="text-center danger" colspan="13">没有找到用户</td>
					</tr>
            </#if>
        </table>
    </div>
	<!--表格结束/-->
    
<!--     分页开始 -->
<#if page??>
        <#if page.list?? >
	   		 <div class="pagination pull-right">
				${page.pageHtml}
			 </div>
		</#if>
	</#if>
<!--     分页结束/ -->
 </form>
</div>
<!--主体结束/-->
</body>
</html>
<!--弹层开始-->
<div class="wapp-layer" id="saveDiv">
	<div class="box">
    	<h4>
    	<!-- 标题 -->
    	<label id="titleSpan" ></label>
    	<span class="close-js" onclick="$('#saveDiv').hide();">关闭</span></h4>
    	<!-- 填充内容区域 开始 -->
    	<span id="divContent"></span>
    	<!-- 填充内容区域 结束-->
    </div>
</div>
<!--弹层结束/-->
<!--弹层开始-->
<div class="wapp-layer" id="message">
	<div class="box tips">
    	<h4>提示信息<span class="close-js" onclick="$('#message').hide();">关闭</span></h4>
        <div class="edit">
            <p><sapn id="statusSpan"></sapn></p>
            <div class="but-nav">
                <span class="but" onclick="updatestatus();">确&nbsp;&nbsp;定</span>
                <span class="but miss close-js" onclick="$('#message').hide();">取&nbsp;&nbsp;消</span>
            </div>
        </div>
    </div>
</div>
<!--弹层结束/-->
  </body>
</html>
