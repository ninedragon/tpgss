<div class="box">
    	<h4>选择权限<span class="close-js"  onclick="$('#controlDiv').hide();">关闭</span></h4>
        <div class="edit">
            <lable>
                <input name="" type="checkbox" selectAllBox="" value="" class="checkbox"><span class="other">全选</span>
            </lable>
           
	<#if permissionBosList??>
        			<#list permissionBosList as bos>       		
        				 <lable>
						 <#if bos.roleId??>						    
        				 		 	<input name="${bos.name }" id="${bos.id }" selectBox=''  checked="checked" type="checkbox" value="" class="checkbox"><span style="width:200px;">${bos.name }</span>
	        				 		<#else>
	        				 		 <input name="${bos.name }" id="${bos.id }" selectBox='' type="checkbox" value="" class="checkbox"><span style="width:200px;">${bos.name }</span>
	        			 </#if>  
						           
				         </lable>
				    </#list>

        	<#else>
        			 <lable>没有获取到权限数据，请先添加权限数据。</lable>
 </#if>       	
        	 <div class="but-nav">
                <span class="but"  onclick="selectPermission();">保&nbsp;&nbsp;存</span>
                <span class="but miss close-js"  onclick="$('#controlDiv').hide();">取&nbsp;&nbsp;消</span>
            </div>
        </div>
    </div>