
<!DOCTYPE html>
<!-- <html> -->
  <head>
    <base href="${basePath}">
    <title>V2-ndtu设备列表</title>
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
		<script language="javascript" type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
			<script >
			so.init(function(){
			  so.checkBoxInit('#checkAll','[check=box]');
				 	so.id('excuteAll').on('click',function(){
					var checkeds = $('[check=box]:checked');
					if(!checkeds.length){
						return layer.msg('请选择要执行的选项。',so.default),!0;
					}
					var array = [];
					checkeds.each(function(){
						array.push(this.value);
					});
					return so.excuteCmd(array);
				}); 
				  initList();
				
			});
			
			so.excuteCmd= function excuteCmd(ids){
				var index = layer.confirm("确定需要执行命令？",function(){
					//var load = layer.load();
					<#-- $.post('${basePath}/ammeter/delEpuInfo.shtml',{rowIds:ids.join(',')},function(result){
						layer.close(load);
						if(result && result.status != 200){
							return layer.msg(result.message,so.default),!0;
						}else{
							layer.msg('删除成功');
							setTimeout(function(){
								$('#formId').submit();
							},1000);
							 window.location="${basePath}/ammeter/showAmList.shtml";
						}
					},'json');-->
					//layer.close(index); 
				});
			}
			  so.editEpuInfo=function editEpuInfo(id) {				 
				 window.location="${basePath}/nDtu/editInit.shtml?id=" + id;
			 };
			 so.delEpuInfo=function delEpuInfo(id) {				
				if(confirm('确实要删除该内容吗?')){
	   				  $("#loadingDiv").show();
	   				 $.ajax({
	   		  			    url:"${basePath}/nDtu/delDtu.shtml",
	   		  			    type:'POST',
	   		  			    dataType:'json',
	   		  			    data:{id:id},
	   		  			    success:function(data){
	   		  			    	if(data.error=="删除失败!"){
	   		  			    	layer.msg(data.error,function(){});
	   		  			    	$("#loadingDiv").hide();
	   		  			    	}else{ 
	   		  			     	layer.msg("删除成功!",function(){});
	   		  					 window.location="${basePath}/nDtu/showDtuList.shtml";
	   		  			    	$("#loadingDiv").hide();
	   		  			    	}
	   		  			    }
	   		  			    
	   		  			  });
	   			  }
		
			 };
			  function initList(pageNo) {
			    	 $("#loadingDiv").show(); 

			        $.ajax({
			            url: "${basePath}/nDtu/queryDtuList.shtml",
			            type: 'POST',
			            dataType: 'json',
			            async:false,
			            data: {			          
			            	cDistrictbcdid: $(".search #cDistrictbcdid").val(),
			            	cAddressid: $(".search #cAddressid").val(),
			            	cInstalldateBegin: $(".search #cInstalldateBegin").val(),
			            	cInstalldateEnd: $(".search #cInstalldateEnd").val(),
			            	pageNo:pageNo,
			            	pageSize:10
			            },
			            success: function (data) {
			            	var page=data.page;
			                if (page != null ) {
			                    var epuList = page.list;			                   
			                    if (epuList!=null && epuList.length>0) {
			                    	 var tbody = '';
			                        for (var i = 0; i < epuList.length; i++) {			                          
			                             var cLastcomtime=epuList[i].cLastcomtime==null?"":epuList[i].cLastcomtime;
			                            var cSoftupdatedate=epuList[i].cSoftupdatedate==null?"":epuList[i].cSoftupdatedate;
			                            var  cInstalldate=epuList[i].cInstalldate==null?"":epuList[i].cInstalldate;
			                            var  nbdeviceid=epuList[i].nbdeviceid==null?"":epuList[i].nbdeviceid;
			                            tbody += '<tr>';
			                             tbody += '<td align="center"><input value="'+epuList[i].rowId+'" check="box" type="checkbox" /></td>';
			                           	 tbody += '<td align="center"><div><a href="javascript:epuEdit.saveShow(\''+epuList[i].id+'\');">编辑</a>&nbsp;&nbsp;<a href="javascript:so.delEpuInfo(\''+epuList[i].id+'\');">删除</a>&nbsp;&nbsp;<a href="javascript:so.excuteCmd('+epuList[i].id+');">执行</a>';			                      
			                           	 tbody += '<td align="center">';
			                           	/*  tbody += '<select id="cmdList" name="cmdList"><option value ="1">call 1.cmd</option>';
										 tbody += '<option value="2">call 2.cmd</option>';
										 tbody += '<option value="3">call 3.cmd</option>';
										 tbody += '<option value="4">call 4.cmd</option>';
										tbody += '</select>'; */
			                           	tbody += '</td>';	             
			                            tbody += '<td align="center"><div>' + epuList[i].cDistrictbcdid+ '</div></td>';
			                            tbody += '<td align="center"><div>' + epuList[i].cAddressid + '</div></td>';
			                            tbody += '<td align="center"><div>' + epuList[i].cChannelnum+ '</div></td>';
			                            tbody += '<td align="center"><div>' + epuList[i].cHardwarever + '</div></td>';
			                            
			                            tbody += '<td align="center"><div>' + epuList[i].cSoftwarever+ '</div></td>';
			                            tbody += '<td align="center"><div>' +epuList[i].cFixip + '</div></td>';	    
			                            
			                             tbody += '<td align="center"><div>' + cLastcomtime+ '</div></td>';
			                            tbody += '<td align="center"><div>' +cSoftupdatedate + '</div></td>';
			                            
			                            tbody += '<td align="center"><div>' + cInstalldate+ '</div></td>';
			                            tbody += '<td align="center"><div>' +nbdeviceid + '</div></td>';	                          
			                            tbody += '<td align="center"><div>' +epuList[i].cDesp + '</div></td>';			                  
			                            tbody += '</tr>';			                            
			                        }
			                        $("#epuListTable").html(tbody);
			                          so.checkBoxInit('#checkAll','[check=box]');
			                         // var pageHtml=page.pageHtml.replace(new RegExp("_submitform","gm"),"javascript:so.initList");
			                         var a = page.pageHtml;
									var b = a.substring(0,a.lastIndexOf('\<script'));  
			                        var pageHtml=b.replace(/_submitform/g,'initList');
			                       $(".pagination").html(pageHtml);
			                         $("#loadingDiv").hide(); 
			                    }else
			                    {
			                    	  $("#epuListTable").html('');
			                    }
			                 
			                } else {
			                
			                }
			            
			            },
			            error: function () {
			                $("#loadingDiv").hide();
			            }
			        });

			    };
			 
		</script>
		
		<script >
		var epAdd= {};
			
				 
			 epAdd.submitFun=function submitFun(flag){
				var errorMsg="";
 				if (flag=="1")
				{
						var list=$(".request");
						for(i=0,len=list.length;i<len;i++){
							var element=list[i];
							var value=list[i].value;
							if(value==null||value==""){
								errorMsg+=element.title+"<br>";
							}
						}
						
						
						var elementRequiredSelects = $(".requiredSelect");
						var selectSize = elementRequiredSelects.length;
						for (var index = 0; index < selectSize; index++) {
							var element = elementRequiredSelects[index];
							
							var str = element.value;
							if (str == null || str == undefined || str == '') {
								var displayText=element.title;
								errorMsg+=displayText+"<br>";
							}
						}
					
					
					var elementNums = $(".requiredNum");
					var numSize = elementNums.length;
					for (var index = 0; index < numSize; index++) {
						var element = elementNums[index];
						var str = element.value;
						if (str == null || str == undefined || str == '') {
							var displayText=element.title;
							errorMsg+=displayText+"<br>";
						}
					}
					var elementInts = $(".requiredInt");
					var size = elementInts.length;
					for (var index = 0; index < size; index++) {
						var element = elementInts[index];
						var str = element.value;
						if (str == null || str == undefined || str == '') {
							var displayText=element.title;
							errorMsg+=displayText+"<br>";
						}
					}
				}
					if(errorMsg.length>0){
						errorMsg='页面有未填项，请检查！<br>'+errorMsg;	
					} 
					//$('input[name="flag"]').val(flag);
					var id=$("#saveDiv #id").val();
					var cDistrictbcdid=$("#saveDiv #cDistrictbcdid").val();
					var cAddressid=$("#saveDiv #cAddressid").val();
					var cChannelnum=$("#saveDiv #cChannelnum").val();									
					var cHardwarever=$("#saveDiv #cHardwarever").val();
					var cSoftwarever=$("#saveDiv #cSoftwarever").val();
					var cFixip=$("#saveDiv #cFixip").val();
					
					var cInstalldate=$("#saveDiv #cInstalldate").val();
					var nbdeviceid=$("#saveDiv #nbdeviceid").val();
					var cDesp=$("#saveDiv #cDesp").val();									
				
				
					var returnFlag=true;
					//当设备名称发生变化，需要校验设备名称同区域性的唯一性
					<#-- if( $("#saveDiv #epuNameBefore").val()!=epuName)
					{
							$.ajax({
							url : "${basePath}/epu/checkEpName.shtml",
							type : 'POST',
							dataType : 'json',
							async : false,
							data : {						
								epuDistrict:epuDistrict,						
								epuName:epuName,
								epuType:'M0002'
							
							},
							success : function(data) {
								  if(data.stauts!='0' && data.stauts!='')
								  {
								  layer.msg('同区域下的设备,名称不能重复，请修改!',function(){});
								  //alert('同区域下的设备,名称不能重复，请修改!');
								  returnFlag=false;
								  }
							
							}
				
						});
					} -->

                    if(errorMsg.length>0)
					{
						layer.msg(errorMsg,function(){});
						return false;
                    }
					if(returnFlag)
					{
				   $("#loadingDiv").show();
					$.ajax({
						url : "${basePath}/nDtu/updateDtu.shtml",
						type : 'POST',
						dataType : 'json',
						async : false,
						data : {
							id,
							cDistrictbcdid:cDistrictbcdid,
							cAddressid:cAddressid,
							cChannelnum:cChannelnum,
							cHardwarever:cHardwarever,
							cSoftwarever:cSoftwarever,
							cFixip:cFixip,
							cInstalldate:cInstalldate,
							
							nbdeviceid:nbdeviceid,
							cDesp:cDesp
						
						},
						success : function(data) {
							   $("#loadingDiv").hide();
							   $('#saveDiv').hide();
							   
								window.location="${basePath}/nDtu/showDtuList.shtml";						
						}
			
					});
					}
			}			
			  epAdd.saveShow=function saveShow(){
			  
			    $("#saveDiv #id").val('');
				$("#saveDiv #cDistrictbcdid").val('');
				$("#saveDiv #cAddressid").val('');
				$("#saveDiv #cChannelnum").val('');												
				$("#saveDiv #cHardwarever").val('');
				$("#saveDiv #cSoftwarever").val('');
				$("#saveDiv #cFixip").val('');
				
				$("#saveDiv #cInstalldate").val('');												
				$("#saveDiv #nbdeviceid").val('');
				$("#saveDiv #cDesp").val('');
				$("#saveDiv").show();
				 /*  epAdd.initProvince();
				  epAdd.registEvent(); */
			}
		</script>
		<script type="text/javascript">
   var epuEdit={};
			//初始化页面数据
			    epuEdit.initPage= function initPage() {
				
			};
		
			 epuEdit.registEvent=function registEvent() {
					  
			 };
			 
		          epuEdit.saveShow=function saveShow(id){
			  
							$("#loadingDiv").show();		 
						$.ajax({
							url : "${basePath}/nDtu/editInit.shtml",
							type : 'POST',
							dataType : 'json',
							async : false,
							data : {
								id:id
							
							},
							success : function(data) {
							
							  var  epuInfo=data.dtu;
										$("#saveDiv #id").val(epuInfo.id );				
										$("#saveDiv #cDistrictbcdid").val(epuInfo.cDistrictbcdid );
										$("#saveDiv #cAddressid").val(epuInfo.cAddressid );
									    
									    
									    $("#saveDiv #cChannelnum").val(epuInfo.cChannelnum );				
										$("#saveDiv #cHardwarever").val(epuInfo.cHardwarever );
										$("#saveDiv #cSoftwarever").val(epuInfo.cSoftwarever );
										
										$("#saveDiv #cFixip").val(epuInfo.cFixip );				
										$("#saveDiv #cInstalldate").val(epuInfo.cInstalldate );
										$("#saveDiv #nbdeviceid").val(epuInfo.nbdeviceid );
								       $("#saveDiv #cDesp").val(epuInfo.cDesp );						
								        $("#saveDiv").show();
								  
				                       $("#loadingDiv").hide();							
							}        
							});
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
		
	<h4>NDTU设备列表</h4>	
    <!--搜索开始-->
	<div class="search">
	   <lable>
        	<span>区域码:</span>
        	 <input name="cDistrictbcdid" id="cDistrictbcdid" type="text"    />
    	</lable>
    	   <lable>
        	<span>地址号:</span>
             <input name="cAddressid" id="cAddressid" type="text"    />
    	</lable>
    	  <lable>
        	<span>安装日期:</span>
        	 <input name="cInstalldateBegin" id="cInstalldateBegin" type="text"   onClick="WdatePicker()"  />        	 
    	</lable> 	
        <lable>       
        	<span>到 :</span>
        	 <input name="cInstalldateEnd" id="cInstalldateEnd" type="text"   onClick="WdatePicker()"  />
    	</lable>     
        <div class="but-nav">
<!--         	<span class="but" id="btn_query" >查&nbsp;&nbsp;询</span> -->
        	 <button type="button"   id="excuteAll"    class="btn btn-primary" style="background-color: #169274;">批量执行命令</button>
        	<button type="button"  onclick="javascript:initList();"       class="btn btn-primary" style="background-color: #169274;">查询</button>
        	<button type="button"  onclick="javascript:epAdd.saveShow();"       class="btn btn-primary" style="background-color: #169274;">新增</button>
        </div>
	</div>
    <!--搜索结束/-->
    
    <!--其他操作开始-->
    <div class="other-nav">
<!--         <div class="sec-box"> -->
<!--         	<input name="" type="text"><span>搜索</span> -->
<!--         </div> -->
    	<!-- <div class="but-nav">
        	<span class="icon01">新增</span>
            <span class="icon03" id="deleteAll">删除</span>
        </div> -->
    </div>
    <!--其他操作结束/-->
    <!--表格开始-->
    <div class="table-box">
        <table width="100%">
            <tr>  <th><input  type="checkbox" id="checkAll"></th>
                            <th>操作</th>  
							<th>命令</th>
							<th>区域码</th>
							<th>地址号</th>
							<th>通道数</th>
							<th>硬件版本</th>
							<th>软件版本</th>							
							<th>固定IP</th>
							<th>最后通信时间</th>
							<th>软件更新时间</th>							
							<th>安装日期</th>														
							<th>nb设备id</th>
							<th>描述信息</th>										
            </tr>
           <tbody id="epuListTable"></tbody>
        </table>
    </div>
	<!--表格结束/-->
    
<!--     分页开始 -->

	   		 <div class="pagination pull-right">
			 </div>
<!--     分页结束/ -->
 </form>
</div>
<!--主体结束/-->
</body>
</html>
<!--弹层开始-->
<div class="wapp-layer"  id="saveDiv">
      <div class="box" style="height:auto">
	<h4>新增ndtu设备<span class="close-js"  onclick="$('#saveDiv').hide();">关闭</span></h4>
	  <input name="id" type="hidden" id="id"  value="">
	 
        <div class="edit" style="height:auto">
             <lable>
                <span>区域码</span>
                  <input name="cDistrictbcdid" id="cDistrictbcdid"   type="text" class="text request" title="区域码" maxlength="100"/>
            </lable>
             <lable>
                <span>地址号</span>
                 <input name="cAddressid" id="cAddressid"   type="text" class="text request" title="地址号" maxlength="100"/>
            </lable>
            <lable>
                <span>通道数</span>
                  <input name="cChannelnum" id="cChannelnum"   type="text" class="text request" title="通道数" maxlength="10"/>
            </lable>
             <lable>
                <span>硬件版本</span>
                 <input name="cHardwarever" id="cHardwarever"   type="text" class="text" title="硬件版本" maxlength="100"/>  
            </lable>
            <lable>
                <span>软件版本</span>
                <input name="cSoftwarever" id="cSoftwarever"   type="text" class="text" title="软件版本" maxlength="100"/>
            </lable>
            <lable>
                <span>固定IP</span>
                <input name="cFixip"  id="cFixip" type="text" class="text" title="固定IP" maxlength="100"/>                         
            </lable>           
              <lable>
                <span>安装日期</span>
                  <input name="cInstalldate" id="cInstalldate" type="text"   onClick="WdatePicker()"  title="安装日期" />
            </lable>      
            <lable>
                <span>nb设备id</span>
                <input name="nbdeviceid"  id="nbdeviceid" type="text" class="text" title="nb设备id" maxlength="100" />
                         
            </lable>    
              <lable>
                <span>描述</span>
                <input name="cDesp" id="cDesp"   type="text" class="text" title="描述" maxlength="1000" />
            </lable>       
                            
	        <div class="but-nav" style="margin:0px 0px 20px 0px">
                <span class="but" onclick="javascript:epAdd.submitFun('1');">保&nbsp;&nbsp;存</a></span>
                <span class="but miss close-js" onclick="$('#saveDiv').hide();">取&nbsp;&nbsp;消</span>
            </div>        
            
            </div>         
    </div>
</div>
<!--弹层结束/-->
<!--弹层开始-->
<div class="wapp-layer" id="message">
	<div class="box tips">
    	<h4>提示信息<span class="close-js" onclick="$('#message').hide();">关闭</span></h4>
    		<form id="boxRoleForm">
        <div class="edit">
            <p><sapn id="statusSpan"></sapn></p>

            <div class="but-nav">
                <span class="but" onclick="updatestatus();">确&nbsp;&nbsp;定</span>
                <span class="but miss close-js" onclick="$('#message').hide();">取&nbsp;&nbsp;消</span>
            </div>
        </div>
        </form>
    </div>
</div>
<!--弹层结束/-->
  </body>
</html>
