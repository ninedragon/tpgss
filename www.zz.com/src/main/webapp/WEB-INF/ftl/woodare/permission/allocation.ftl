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
	<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
	<script src="${basePath}/woodare/js/menu.js"></script>
	<script  src="${basePath}/js/common/layer/layer.js"></script>
	<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script  src="${basePath}/js/shiro.demo.js"></script>
			<script >
		so.init(function(){
				//初始化全选。
				so.checkBoxInit('#checkAll','[check=box]');
				<@shiro.hasPermission name="/permission/clearPermissionByRoleIds.shtml">
				//全选
				so.id('deleteAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要清除的角色。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return deleteById(array);
				});
				</@shiro.hasPermission>
			});
			<@shiro.hasPermission name="/permission/clearPermissionByRoleIds.shtml">
			<!--根据ID数组清空角色的权限-->
			function deleteById(ids){
				var index = layer.confirm("确定清除这"+ ids.length +"个角色的权限？",function(){
					var load = layer.load();
					$.post('${basePath}/permission/clearPermissionByRoleIds.shtml',{roleIds:ids.join(',')},function(result){
						layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!0;
						}else{
							layer.msg(result.message);
							setTimeout(function(){
								$('#formId').submit();
							},1000);
						}
					},'json');
					layer.close(index);
				});
			}
			</@shiro.hasPermission>
			<@shiro.hasPermission name="/permission/addPermission2Role.shtml">
			<!--选择权限后保存-->
			function selectPermission(){
				var checked = $("#controlDiv  :checked");
				var ids=[],names=[];
				$.each(checked,function(){
					ids.push(this.id);
					names.push($.trim($(this).attr('name')));
				});
				var index = layer.confirm("确定操作？",function(){
					<!--loding-->
					var load = layer.load();
					$.post('${basePath}/permission/addPermission2Role.shtml',{ids:ids.join(','),roleId:$('#selectRoleId').val()},function(result){
						layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!1;
						}
						$("#controlDiv").hide();
						layer.msg('添加成功。');
						setTimeout(function(){
							$('#formId').submit();
						},1000);
					},'json');
				});
			}
			/*
			*根据角色ID选择权限，分配权限操作。
			*/
			function selectPermissionById(id){
				var load = layer.load();
				$.post("${basePath}/permission/control",{id:id},function(result){
					$('#selectRoleId').val(id);
					layer.close(load);
					if(result && result.length){
						$("#controlDiv").html(result);
						so.checkBoxInit('[selectAllBox]','[selectBox]'),
						$("#controlDiv").show();
					}
				});
			}
			</@shiro.hasPermission>
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
	<h4>权限分配-阶跃</h4>	
	<form method="post" action="" id="formId" class="form-inline">
    <!--搜索开始-->
	<div class="search">
        <lable>
        	<span class="wd01">角色名称/类型</span>
            <input  value="${findContent!''}" name="findContent" id="findContent"  type="text" class="long" placeholder="输入角色名称/类型">
    	</lable>
        <div class="but-nav">
        	<button type="submit" class="btn btn-primary" style="background-color: #169274;">查询</button>
        </div>
	</div>
    <!--搜索结束/-->
     
    <!--其他操作开始-->
    <div class="other-nav">
    	<div class="but-nav">
    		<@shiro.hasPermission name="/permission/clearPermissionByRoleIds.shtml">
        		<span class="icon05"   id="deleteAll" >清空角色权限</span>
        	</@shiro.hasPermission>
        </div>
    </div>
    <!--其他操作结束/-->
    <!--表格开始-->
    <div class="table-box">
    	<input type="hidden" id="selectRoleId">
        <table width="100%">
            <tr>
                 <th><input type="checkbox" id="checkAll"/></th>
                <th>角色名称</th>
                <th>角色类型</th>
                <th>拥有的权限</th>
                <th>操作</th>
            </tr>           
             <#if page??>            	
            			 <#if page.list??>
            				<#list page.list as it> 
		            			 <tr>
									<td align="center"><input value="${it.id}" check='box' type="checkbox" /></td>
									<td align="center" >${it.name!''}</td>
									<td align="center" >${it.type!''}</td>
									<td align="center"  permissionIds="${it.permissionIds!''}">${it.permissionNames!''}</td>
									<td align="center" >
										<@shiro.hasPermission name="/permission/addPermission2Role.shtml">
											<span class="icon07" onclick="javascript:selectPermissionById('${it.id}');">选择权限</span>
										</@shiro.hasPermission>
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
	<!--表格结束/-->
 <!--弹层开始-->
<div class="wapp-layer" id="controlDiv">
</div>
<!--弹层结束/-->
	<#if page??>
        <#if page.list?? >
	   		 <div class="pagination pull-right">
				${page.pageHtml}
			 </div>
		</#if>
	</#if>
	<!--     分页结束  -->
	</form>
</div>    
	<!-- 表格结束 -->
	</html>
</body>


