
function showList(rowId,tableBoxId,uipqData,branchBoxId,meterboxId,meterboxEpuName,children){
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
	  	var uipqHtml = "";
		  for(var k =0;k < uipqData.length;k++){
			 var json = uipqData[k];
			 var type = json["type"];
			 var key = json["key"];
			 if(type == "meterBox" && key == meterboxId){//找到对应的表箱
				 var  ua = json["ua"];
				 var  ia = json["ia"];
				 var  pa = json["pa"];
				 var qa = json["qa"];
				 var ub = json["ub"];
				 var ib = json["ib"];
				 var pb = json["pb"];
				 var qb = json["qb"];
				 var uc = json["uc"];
				 var ic = json["ic"];
				 var pc = json["pc"];
				 var qc = json["qc"];
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
				  break;
			 }
	  }
	  $("#uipqDiv").html(uipqHtml);
	//设置弹出层画面高宽
	 var widthVal = 800;
	 var heightVal = 900;
	 var temp = heightVal ;
	 parent.$("#tab4Iframe").attr("width", widthVal).attr("height", temp);
//	 parent.$("#branchBoxDiv").css("height", "auto");
//	 parent.$(".branchBox").css("width", (widthVal + 20)+"px").css("height", (heightVal - 150)+ "px");
	 
	 parent.$("#branchBoxDiv").css("height", "auto");
	 parent.$(".branchBox").css("width", "850px");
//	$("#falutDiv").css("width", "950px");
}
