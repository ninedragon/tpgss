 <div class="edit">
   <#if it??>
            <lable>
                <span>昵称</span>
                <input id="nickname" name="nickname" type="text" value="${it.nickname?default('未设置')}">
            </lable>
            <lable>
                <span>Email</span>
                <input id="email" name="email" type="text" value="${it.email?default('未设置')}">
            </lable>
            <lable>
                <span>登录状态</span>
             	   <select id="status" name="status" >
	            	<option value="">请选择</option>
	            	    <#if it.status?? && it.status== 0> 
	            		
	            			<option  value="0"  selected="selected">禁止</option>
	            		
	            		<#else>
	            			<option  value="0"  >禁止</option>
	            		</#if>
	            	
	            		 <#if it.status?? && it.status== 1> 
	            			<option  value="1" selected="selected" >有效</option>
	            		<#else>
	            			<option  value="1" >有效</option>
	            		</#if>
	            	
	            </select>
            </lable>
            <lable>
                <span>创建时间</span>
                ${it.createTime?string('yyyy-MM-dd HH:mm')}
            </lable>
            <lable>
                <span>最后登录时间</span>
                ${it.lastLoginTime?string('yyyy-MM-dd HH:mm')}
            </lable>
            <lable>
                <span>电表号</span>
                <input id="meter" name="meter" type="text" value="${it.meter!''}">
            </lable>
            <lable>
                <span>供电单位</span>
                <input id="supply" name="supply" type="text" value="${it.supply!''}">
            </lable>
            <lable>
                <span>家庭地址</span>
                <input id="location" name="location" type="text" value="${it.location!''}">
            </lable>
            <lable>
                <span>门牌号</span>
                <input id="housenum" name="housenum" type="text" value="${it.housenum!''}">
            </lable>
            <lable>
                <span>SIM卡号</span>
                <input id="sim" name="sim" type="text" value="${it.sim!''}">
            </lable>
            <lable>
                <span>绝对编号</span>
                <input id="absid" name="absid" type="text" value="${it.absid!''}">
            </lable>
            <lable>
                <span>设备版本号</span>
                <input id="version" name="version" type="text" value="${it.version!''}">
            </lable>
            <#else>
                        <lable>
                <span>昵称</span>
                <input id="nickname" name="nickname" type="text" value="">
            </lable>
            <lable>
                <span>Email</span>
                <input id="email" name="email" type="text" value="">
            </lable>
            <lable>
                <span>登录状态</span>
             	   <select id="status" name="status" >
	            	<option value="">请选择</option>	            		            		
	            			<option  value="0"  >禁止</option>
	            			<option  value="1" >有效</option>	            		            			
	            </select>
            </lable>
           <!--  <lable>
                <span>创建时间</span>
                <input id="create_time" name="create_time" type="text" value="">
            </lable>
            <lable>
                <span>最后登录时间</span>
                <input id="last_login_time" name="last_login_time" type="text" value="">
            </lable> -->
            <lable>
                <span>电表号</span>
                <input id="meter" name="meter" type="text" value="">
            </lable>
            <lable>
                <span>供电单位</span>
                <input id="supply" name="supply" type="text" value="">
            </lable>
            <lable>
                <span>家庭地址</span>
                <input id="location" name="location" type="text" value="">
            </lable>
            <lable>
                <span>门牌号</span>
                <input id="housenum" name="housenum" type="text" value="">
            </lable>
            <lable>
                <span>SIM卡号</span>
                <input id="sim" name="sim" type="text" value="">
            </lable>
            <lable>
                <span>绝对编号</span>
                <input id="absid" name="absid" type="text" value="">
            </lable>
            <lable>
                <span>设备版本号</span>
                <input id="version" name="version" type="text" value="">
            </lable>
            </#if>
            
            <div class="but-nav">
                <span class="but" >保&nbsp;&nbsp;存</span>
                <span class="but miss close-js"  onclick="$('#saveDiv').hide();">取&nbsp;&nbsp;消</span>
            </div>
        </div>