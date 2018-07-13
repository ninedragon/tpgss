var javaScriptObj = {
		interval:null//定时器资源
}
/**
 * 获取项目根
 * **/
function getRootPath_web() {
	 //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	 var curWwwPath = window.document.location.href;
	 //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	 var pathName = window.document.location.pathname;
	 var pos = curWwwPath.indexOf(pathName);
	 //获取主机地址，如： http://localhost:8083
	 var localhostPaht = curWwwPath.substring(0, pos);
	 //获取带"/"的项目名，如：/uimcardprj
	 var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	 return (localhostPaht + projectName);
}  


function showList(rowId,tableBoxId,branchBoxId,meterboxId,meterboxEpuName,children){
	var strKeyArray = ""
	 $(children).each(function(index) {
		 strKeyArray += this.rowId + ",";
	  });
	strKeyArray = strKeyArray.substring(0, strKeyArray.lastIndexOf(","));
	 //加载故障
	 so.initFaultTypeList();
	 $("#strKeyArray").val(strKeyArray);
	 initList();
	//遍历当前分支箱下的表箱ID
	 selectMeterBoxUIPQ(meterboxId);
	  //开启定时器
		 var myVar =  setInterval(function(){
	    	 //加载当前表箱下电表表格
			 clearInterval(myVar);//清除定时器
			 var timeoutVar =  setTimeout(function(){
				 clearInterval(timeoutVar);//清除定时器
				 showList(rowId,tableBoxId,branchBoxId,meterboxId,meterboxEpuName,children);
			 }, (1000 * 20) );//(1000 * 20) 延迟20秒
	     },(1000 * 60 * 5));//(1000 * 60 * 4)
		 javaScriptObj.interval = myVar;
		 
	//设置弹出层画面高宽
	 var widthVal = 800;
	 var heightVal = 900;
	 var temp = heightVal ;
	 $("#falutDiv").css("width",widthVal+ "px").css("top",( temp - 500)+"px");
	 parent.$("#tab4Iframe").attr("width", widthVal).attr("height", temp);
//	 parent.$("#branchBoxDiv").css("height", "auto");
//	 parent.$(".branchBox").css("width", (widthVal + 20)+"px").css("height", (heightVal - 150)+ "px");
	 
	 parent.$("#branchBoxDiv").css("height", "auto");
	 parent.$(".branchBox").css("width", "850px");
//	$("#falutDiv").css("width", "950px");
}

function selectMeterBoxUIPQ(meterboxId){
	 $("#loadingDiv").show();
		$("#uipqDiv").html("");
	    $.ajax({
	        url: getRootPath_web() + "/abnormalZ/selectMeterBoxUIPQ.shtml",
	        type: 'POST',
	        timeout : 5000, //超时时间设置，单位毫秒
	        dataType: 'json',
	        async: true,
	        data: {
	        	meterBoxId: meterboxId
	        },
	        success: function(meterBoxList) {
	        	//处理表箱表格
				 var  ua = 0;
				 var  ia = 0;
				 var  pa = 0;
				 var qa = 0;
				 var ub = 0;
				 var ib = 0;
				 var pb = 0;
				 var qb = 0;
				 var uc = 0;
				 var ic = 0;
				 var pc = 0;
				 var qc = 0;
	        	if(meterBoxList){
					if(null != meterBoxList && meterBoxList.length > 0){
			        	for(var i = 0;i < meterBoxList.length;i++){
			        		var json = meterBoxList[i];
			        		var phaseRemark = json["phaseRemark"];
			        		if(phaseRemark == 1 || phaseRemark == "1"){
			        			  ua = parseFloat(json["u"] ||0).toFixed(2);
			        			  ia = parseFloat(json["i"] ||0).toFixed(2);
			        			  pa = parseFloat(json["p"] ||0).toFixed(2);
			        			  qa = parseFloat(json["q"] ||0).toFixed(2);
			        		}else if(phaseRemark == 2 || phaseRemark == "2"){
			        			  ub = parseFloat(json["u"] ||0).toFixed(2);
			        			  ib = parseFloat(json["i"] ||0).toFixed(2);
			        			  pb = parseFloat(json["p"] ||0).toFixed(2);
			        			  qb = parseFloat(json["q"] ||0).toFixed(2);
			        		}else if(phaseRemark == 3|| phaseRemark == "3"){
			        			  uc = parseFloat(json["u"] ||0).toFixed(2);
			        			  ic = parseFloat(json["i"] ||0).toFixed(2);
			        			  pc = parseFloat(json["p"] ||0).toFixed(2);
			        			  qc = parseFloat(json["q"] ||0).toFixed(2);
			        		}
			        	}
			        	var uipqHtml = "";
			        	uipqHtml +="<h4>UIPQ列表</h4>	";
						  uipqHtml +=" <div class=\"table-box\">";
						  uipqHtml +="  <table width=\"100%\">";
						  uipqHtml +="  <tr>";
						  uipqHtml +="	<th></th>";
						  uipqHtml +="	<th>U</th>";
						  uipqHtml +="	<th>I</th>";				
						  uipqHtml +="	<th>P</th>";			
						  uipqHtml +="	<th>Q</th>";				
						  uipqHtml +="</tr>";
						  
						 uipqHtml += '<tr>';
						 uipqHtml += '<td align="center"><div>A</div></td>';
						 uipqHtml += '<td align="center"><div>' + ua + '</div></td>';
						 uipqHtml += '<td align="center"><div>' + ia+ '</div></td>';
						 uipqHtml += '<td align="center"><div>' + pa+ '</div></td>';
						 uipqHtml += '<td align="center"><div>' + qa+ '</div></td>';
						 uipqHtml += '</tr>';	
						 uipqHtml += '<tr>';
						 uipqHtml += '<td align="center"><div>B</div></td>';
						 uipqHtml += '<td align="center"><div>' + ub + '</div></td>';
						 uipqHtml += '<td align="center"><div>' + ib+ '</div></td>';
						 uipqHtml += '<td align="center"><div>' + pb+ '</div></td>';
						 uipqHtml += '<td align="center"><div>' + qb+ '</div></td>';
						 uipqHtml += '</tr>';	
						 uipqHtml += '<tr>';
						 uipqHtml += '<td align="center"><div>C</div></td>';
						 uipqHtml += '<td align="center"><div>' + uc + '</div></td>';
						 uipqHtml += '<td align="center"><div>' + ic+ '</div></td>';
						 uipqHtml += '<td align="center"><div>' + pc+ '</div></td>';
						 uipqHtml += '<td align="center"><div>' + qc+ '</div></td>';
						 uipqHtml += '</tr>';	
						 uipqHtml +=" </table>";
						  uipqHtml +=" </div>";
						  $("#uipqDiv").html(uipqHtml);
			        	
					}else{
						//清除表箱表格
					}
	        	}else{
	        		//清除表箱表格
	        	}
	            $(".loading").hide();
	        },
	        error: function() {
	            $(".loading").hide();
	        }
	    });
}


/**
 * 电表弹出层关闭
 * */
function closeBranchBox(){
	clearInterval(javaScriptObj.interval);//清除定时器
	parent.$("#messageBranchBox").hide();
}