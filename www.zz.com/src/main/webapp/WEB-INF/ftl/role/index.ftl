<!DOCTYPE html>
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
				ids : null,<#--多个记录主键-->
				operate : null <#--何种动作操作 forbid ：禁止或激活  del：删除-->
			};
			so.init(function(){
				<#--初始化全选。-->
				so.checkBoxInit('#checkAll','[check=box]');
				
				<@shiro.hasPermission name="/role/deleteRoleById.shtml">
				<#--全选-->
				so.id('deleteAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要删除的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return deleteById(array);
				});
				</@shiro.hasPermission>
			});
			<@shiro.hasPermission name="/role/deleteRoleById.shtml">
			<#--根据ID数组删除角色-->
			function deleteById(ids){
				obj.ids =ids;
				obj.operate="del";
				$("#statusSpan").html("确定删除这"+ ids.length +"个角色？");
				$("#message").show();
			}
			</@shiro.hasPermission>
			<@shiro.hasPermission name="/role/addRole.shtml">
			<#--添加角色-->
			function addRole(){
				var name = $('#name').val(),
					type = $('#type').val();
				if($.trim(name) == ''){
					return layer.msg('角色名称不能为空。',so.default),!1;
				}
				if(!/^[a-z0-9A-Z]{6}$/.test(type)){
					return layer.msg('角色类型为6数字字母。',so.default),!1;
				}
				<#--loding-->
				var load = layer.load();
				$.post('${basePath}/role/addRole.shtml',{name:name,type:type},function(result){
					layer.close(load);
					if(result && result.status != 200){
						return layer.msg(result.message,so.default),!1;
					}
					$("#saveDiv").hide();
					layer.msg('添加成功。');
					setTimeout(function(){
						$('#formId').submit();
					},1000);
				},'json');
			}
			</@shiro.hasPermission>
			<#--回调函数-->
			function callback(){
				 if(obj.operate == "del"){
				 	var load = layer.load();
					$.post('${basePath}/role/deleteRoleById.shtml',{ids:obj.ids.join(',')},function(result){
						layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!0;
						}else{
							$("#message").hide();
							layer.msg(result.resultMsg);
							setTimeout(function(){
								$('#formId').submit();
							},1000);
						}
					},'json');
					layer.close(index);
				}
			}
			
			function saveShow(){
				$("#name").val("");
				$("#type").val("");
				$("#saveDiv").show();
			}
		</script>
  </head>
  
  <body>
   <#--页眉开始-->
	<@_top.top 1/>
	<#--页眉结束-->

	<#--左侧导航开始-->
	<@_left.top 1/>
	<#--左侧导航结束-->

<#--主体开始-->
<div class="wapp-main">
	<h4>角色列表</h4>	
	<form method="post" action="" id="formId" class="form-inline">
    <#--搜索开始-->
	<div class="search">
        <lable>
        	<span class="wd01">角色类型/名称</span>
            <input id="findContent" name="findContent"  value="${findContent!''}" type="text" class="long" placeholder="输入角色类型/名称">
    	</lable>
        <div class="but-nav">
<#--         	<span class="but">查&nbsp;&nbsp;询</span> -->
			<button type="submit" class="btn btn-primary" style="background-color: #169274;">查询</button>
        </div>
	</div>
    <#--搜索结束-->
    
    <#--其他操作开始-->
    <div class="other-nav">
    	<div class="but-nav">
    		<@shiro.hasPermission name="/role/addRole.shtml">
        		<span class="icon01" onclick="saveShow();">新增</span>
        	</@shiro.hasPermission>
        	<@shiro.hasPermission name="/role/deleteRoleById.shtml">
            	<span class="icon03" id="deleteAll">删除</span>
            </@shiro.hasPermission>
        </div>
    </div>
    <#--其他操作结束-->
    
    <#--表格开始-->
    <div class="table-box">
        <table width="100%">
            <tr>
                <th><input type="checkbox" id="checkAll"/></th>
                <th>角色名称</th>
                <th>角色类型</th>
                <th>操作</th>
            </tr>
            <#if page??>
            		      <#if page.list??>
            		      	<#list page.list  as it>
		            			 <tr>
					                <td align="center">
					                         <#if it.type?? && it.type=='888888'>
					                	
					                			<input value="${it.id}"  type="checkbox" />
					                		 <#else>
					                			<input value="${it.id}" check='box' type="checkbox" />
					                		 </#if>
					                	
					                </td>
					                <td align="center">${it.name!''}</td>
					                <td align="center">${it.type!''}</td>
					                <td align="center">
					                	  <#if it.type?? && it.type=='888888'>
					                		<#else>
					                			<@shiro.hasPermission name="/role/deleteRoleById.shtml">
												<span class="icon02" onclick="javascript:deleteById(['${it.id}']);">删除</span>
								         	</@shiro.hasPermission>
					                		 </#if>
					                	
					                </td>
					            </tr>
		            		 </#list>
            			  <#else>
            				<tr>
								<td class="text-center danger" colspan="4">没有找到角色</td>
							</tr>
            			 </#if>
            		
            	
            <#else>
            		<tr>
						<td class="text-center danger" colspan="4">没有找到角色</td>
					</tr>
            </#if>
           
        </table>
    </div>
	<#--表格结束-->
    
<#--     分页开始 -->
  <#if page??>
	<#if page.list??>       
	   		 <div class="pagination pull-right">
				${page.pageHtml}
			 </div>
		 </#if>
	 </#if>
<#--     分页结束 -->
</form>
</div>
<#--主体结束-->
</body>
</html>
<#--弹层开始-->
<div class="wapp-layer" id="saveDiv">
	<div class="box tips">
    	<h4>新增角色<span class="close-js"  onclick="$('#saveDiv').hide();">关闭</span></h4>
    	<form id="boxRoleForm">
        <div class="edit">
            <lable>
                <span>角色名称</span>
                <input name="name" id="name" type="text" value="">
            </lable>
            <lable>
                <span>角色类型</span>
                <input name="type" id="type" type="text" value="">
            </lable>
            <div class="but-nav">
                <span class="but"  onclick="addRole();">保&nbsp;&nbsp;存</span>
                <span class="but miss close-js"  onclick="$('#saveDiv').hide();" >取&nbsp;&nbsp;消</span>
            </div>
        </div>
        </form>
    </div>
</div>
<#--弹层结束-->
<#--弹层开始-->
<div class="wapp-layer" id="message">
	<div class="box tips">
    	<h4>提示信息<span class="close-js" onclick="$('#message').hide();">关闭</span></h4>
        <div class="edit">
            <p><sapn id="statusSpan"></sapn></p>
            <div class="but-nav">
                <span class="but" onclick="callback();">确&nbsp;&nbsp;定</span>
                <span class="but miss close-js" onclick="$('#message').hide();">取&nbsp;&nbsp;消</span>
            </div>
        </div>
    </div>
</div>
<#--弹层结束-->
  </body>
</html>
