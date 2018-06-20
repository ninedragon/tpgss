
<div class="box ">
    	<h4>选择角色<span class="close-js" onclick="$('#allotRoleDiv').hide();">关闭</span></h4>
        <div class="edit">
        	 <#if bosList??>
        			<#list bosList as bos>         
        			
        				 <lable>
						    <#if bos.check??>						    	
        				 		 	<input name="${bos.name }" id="${bos.id }"  checked="checked" type="checkbox" value="" class="checkbox"><span>${bos.name }</span>
	        				 <#else>
	        				 		 <input name="${bos.name }" id="${bos.id }" type="checkbox" value="" class="checkbox"><span>${bos.name }</span>
	        				</#if>
						       
				         </lable>
				       </#list>
        		
        	<#else>
        			 <lable>没有获取到用户数据，请先注册数据。</lable>
        	</#if>
        	
        	 <div class="but-nav">
                <span class="but" onclick="selectRole();">保&nbsp;&nbsp;存</span>
                <span class="but miss close-js"  onclick="$('#allotRoleDiv').hide();">取&nbsp;&nbsp;消</span>
            </div>