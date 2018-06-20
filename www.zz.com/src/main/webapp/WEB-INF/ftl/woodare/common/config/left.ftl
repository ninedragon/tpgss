<#macro top index>
<#if index ==1 >
<ul class="left-nav">
	<h4>末端电网感知系统</h4>
	<ul class="<#if leftMenuview=='4'>  on </#if> big-js" <#if leftMenuview=='4'>  style="display:block" </#if>>
    <li onClick="location.href='${basePath}/epu/allShowList.shtml'">实时监控</li>
    </ul>
	<#--拥有 active888888（管理员） ||  100003（权限频道） edata数据的展示-->
	 <@shiro.hasAnyRoles name='888888,100001,200001'>
		<li class="<#if leftMenuview=='3'>  on </#if> big-js">用电曲线数据</li>
	    <ul class="side-nav"  <#if leftMenuview=='3'>  style="display:block" </#if>>
	    	 <@shiro.hasPermission name="/edata/zong.shtml">
    			<li onClick="location.href='${basePath}/edata/zong.shtml'">总体能耗数据</li>
	    	</@shiro.hasPermission>
	    	<@shiro.hasPermission name="/edata/fenxiang.shtml">
        		<li onClick="location.href='${basePath}/edata/fenxiang.shtml'">分项能耗数据</li>
	        </@shiro.hasPermission>
	        <@shiro.hasPermission name="/edata/yuanshi.shtml">
        		<li onClick="location.href='${basePath}/edata/yuanshi.shtml'">原始上传数据</li>
	        </@shiro.hasPermission>
	        <@shiro.hasPermission name="/edata/yuanshij.shtml">
	        	<li onClick="location.href='${basePath}/edata/yuanshij.shtml'">原始上传数据-阶跃</li>
	         </@shiro.hasPermission>
	    </ul>
    </@shiro.hasAnyRoles>   
	
	<li class="<#if leftMenuview=='4'>   on </#if> big-js">设备管理</li>	
    <ul class="side-nav" <#if leftMenuview=='4'>  style="display:block" </#if>>
    <li onClick="location.href='${basePath}/epu/showSubstainList.shtml'">箱变信息列表</li>
    <li onClick="location.href='${basePath}/epu/showOutgoingcabinetList.shtml'">出线柜信息列表</li>
    <li onClick="location.href='${basePath}/epu/showBranchboxList.shtml'">分支箱信息列表</li>
    <li onClick="location.href='${basePath}/epu/showMeterboxList.shtml'">表箱信息列表</li>
    <li onClick="location.href='${basePath}/ammeter/showAmList.shtml'">电表信息列表</li>
    </ul>
     <li class="<#if leftMenuview=='6'>   on </#if> big-js">终端管理</li>	
       <ul class="side-nav" <#if leftMenuview=='6'>  style="display:block" </#if>>
     <li onClick="location.href='${basePath}/nDtu/showDtuList.shtml'">ndtu设备信息列表</li>
      <li onClick="location.href='${basePath}/bDtu/showDtuList.shtml'">bdtu设备信息列表</li>
    </ul>
	<#--拥有 角色888888（管理员） ||  100001（用户中心）-->
	<@shiro.hasAnyRoles name='888888,100001'>          
		<li class="<#if leftMenuview=='1'>   on </#if>  big-js">用户中心</li>
	    <ul class="side-nav" <#if leftMenuview=='1'>  style="display:block" </#if>>
	    <@shiro.hasPermission name="/member/list.shtml">
	    	 <li onClick="location.href='${basePath}/member/list.shtml'">管理列表</li>
	    </@shiro.hasPermission>						
		<@shiro.hasPermission name="/member/online.shtml">
	    	 <li onClick="location.href='${basePath}/member/online.shtml'">在线用户</li>
	    </@shiro.hasPermission>
		<@shiro.hasPermission name="/member/list2.shtml">
	    	 <li  onClick="location.href='${basePath}/member/list2.shtml'">居民列表</li> 
	    </@shiro.hasPermission>
	    </ul>   
	</@shiro.hasAnyRoles>         
	<#--拥有 角色888888（管理员） ||  100001（权限频道）-->
	<@shiro.hasAnyRoles name='888888,100001'>
	   <li class="<#if leftMenuview=='2'>  on </#if> big-js">权限管理</li>
	    <ul class="side-nav" <#if leftMenuview=='2'>  style="display:block" </#if>>
	    	 <@shiro.hasPermission name="/role/index.shtml">
    			<li onClick="location.href='${basePath}/role/index.shtml'">角色列表</li>
	    	 </@shiro.hasPermission>
	    	 <@shiro.hasPermission name="/role/allocation.shtml">
        		<li onClick="location.href='${basePath}/role/allocation.shtml'">角色分配</li>
	        </@shiro.hasPermission>
	        <@shiro.hasPermission name="/permission/index.shtml">
        		<li onClick="location.href='${basePath}/permission/index.shtml'">权限列表</li>
	        </@shiro.hasPermission>
	        <@shiro.hasPermission name="/permission/allocation.shtml">
	        	<li onClick="location.href='${basePath}/permission/allocation.shtml'">权限分配-阶跃</li>
	       </@shiro.hasPermission>
	    </ul>
   	  </@shiro.hasAnyRoles>   
	    <li class="<#if leftMenuview=='0' || leftMenuview=='' > on </#if> big-js">个人中心</li>
	    <ul class="side-nav" <#if leftMenuview=='0' || leftMenuview==''> style="display:block;" </#if> >
		    <li onClick="location.href='${basePath}/user/index.shtml'">个人资料</li>
	        <li onClick="location.href='${basePath}/user/updateSelf.shtml'">资料修改</li>
	        <li onClick="location.href='${basePath}/user/updatePswd.shtml'">密码修改</li>
        	<li onClick="location.href='${basePath}/role/mypermission.shtml'">我的权限</li>
	    </ul>
</ul>

</#if>
</#macro>