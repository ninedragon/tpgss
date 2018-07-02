
var falutReasonJson = {};
falutReasonJson["t_ableakage_i"] = "异常漏电";
falutReasonJson["t_abnormal_u"] = "异常电压";
falutReasonJson["t_abnormal_z"] = "异常阻抗";
falutReasonJson["t_leakage_i"] = "周期漏电";
falutReasonJson["t_short_i"] = "短路电流";

function initList(pageNo) {
	$("#loadingDiv").show(); 
     var tbody = '';
     var dataArray = new Array();
     var t_ableakage_iArray =  faultSourceData["t_ableakage_i"]; //异常漏电
     if(t_ableakage_iArray){
      if(null != t_ableakage_iArray && t_ableakage_iArray.length > 0){
       for(var i= 0;i < t_ableakage_iArray.length; i++){
       	var json = t_ableakage_iArray[i];
       	var epuName = json["epuName"] ||"";
       	var occurTime = json["occurTime"] ||"";
       	var newJson = {};
       	newJson["epuName"] = epuName;
       	newJson["faultType"] = "t_ableakage_i";
       	newJson["occurTime"] = occurTime;
       	dataArray.push(newJson);
       }
      }
     }
     var t_abnormal_uArray =  faultSourceData["t_abnormal_u"];//异常电压
     if(t_abnormal_uArray){
      if(null != t_abnormal_uArray && t_abnormal_uArray.length > 0){
       for(var i= 0;i < t_abnormal_uArray.length; i++){
       	var json = t_abnormal_uArray[i];
       	var epuName = json["epuName"] ||"";
       	var occurTime = json["occurTime"] ||"";
       	var newJson = {};
       	newJson["epuName"] = epuName;
       	newJson["faultType"] = "t_abnormal_u";
       	newJson["occurTime"] = occurTime;
       	dataArray.push(newJson);
       }
      }
     }
     var t_abnormal_zArray =  faultSourceData["t_abnormal_z"]; //异常阻抗
     if(t_abnormal_zArray){
      if(null != t_abnormal_zArray && t_abnormal_zArray.length > 0){
       for(var i= 0;i < t_abnormal_zArray.length; i++){
       	var json = t_abnormal_zArray[i];
       	var epuName = json["epuName"] ||"";
       	var occurTime = json["C_RecordInsertTime"] ||"";
       	var newJson = {};
       	newJson["epuName"] = epuName;
       	newJson["faultType"] = "t_abnormal_z";
       	newJson["occurTime"] = occurTime;
       	dataArray.push(newJson);
       }
      }
     }
     var t_leakage_iArray =  faultSourceData["t_leakage_i"];  //周期漏电
     if(t_leakage_iArray){
      if(null != t_leakage_iArray && t_leakage_iArray.length > 0){
       for(var i= 0;i < t_leakage_iArray.length; i++){
       	var json = t_leakage_iArray[i];
       	var epuName = json["epuName"] ||"";
       	var occurTime = json["C_RecordInsertTime"] ||"";
       	var newJson = {};
       	newJson["epuName"] = epuName;
       	newJson["faultType"] = "t_leakage_i";
       	newJson["occurTime"] = occurTime;
       	dataArray.push(newJson);
       }
      }
     }
     var t_short_iArray =  faultSourceData["t_short_i"];  //短路电流
     if(t_short_iArray){
      if(null != t_short_iArray && t_short_iArray.length > 0){
       for(var i= 0;i < t_short_iArray.length; i++){
       	var json = t_short_iArray[i];
       	var epuName = json["epuName"] ||"";
       	var occurTime = json["occurTime"] ||"";
       	var newJson = {};
       	newJson["epuName"] = epuName;
       	newJson["faultType"] = "t_short_i";
       	newJson["occurTime"] = occurTime;
       	dataArray.push(newJson);
       }
      }
     }
      if(null != dataArray && dataArray.length > 0){
      	 var newDataArray = new Array();
      	 var param_epuName = $("#epuName").val();
 		 var param_falutReason = $("#falutReason").val();
      	 for(var i= 0;i < dataArray.length; i++){
       		var json = dataArray[i];
       		var faultType = json["faultType"];
	        var epuName = json["epuName"];
           	if(("" == param_epuName || null == param_epuName) && ("" == param_falutReason|| null == param_falutReason)){
		    	newDataArray.push(json); 
		    }else if(("" != param_epuName && null != param_epuName) && ("" != param_falutReason && null != param_falutReason)){
		    	 if((faultType == param_falutReason || faultType == param_falutReason) && epuName.indexOf(param_epuName) !=-1){
				    	newDataArray.push(json);
				  }
		    }else if(("" == param_epuName || null == param_epuName) && ("" != param_falutReason&& null != param_falutReason)){
		    	if(faultType == param_falutReason || faultType == param_falutReason){
			    	newDataArray.push(json);
			    }
		    }else if(("" != param_epuName&& null != param_epuName) && ("" == param_falutReason  || null == param_falutReason)){
		    	if(epuName.indexOf(param_epuName) !=-1 ){
			    	newDataArray.push(json);
			    }
		    }		                            
    	}
      	for(var i= 0;i < newDataArray.length; i++){
       		var json = newDataArray[i];
       		  tbody += '<tr>';
              tbody += '<td align="center"><div>' + json.epuName+ '</div></td>';
              tbody += '<td align="center"><div>' + (falutReasonJson[json.faultType] ||"") + '</div></td>';
              tbody += '<td align="center"><div>' + json.occurTime+ '</div></td>';
              tbody += '</tr>';			                            
    	}
      }
    $("#faultListTable").html(tbody);
    $("#loadingDiv").hide(); 
}

function showList(rowId,tableBoxId,uipqData,branchBoxId,meterboxId,meterboxEpuName){
	//填充故障原因下拉
	 var selectHtml = "";
	  selectHtml += "<option value=''></option>";
	  selectHtml += "<option value='t_ableakage_i'>异常漏电</option>";
	  selectHtml += "<option value='t_abnormal_u'>异常电压</option>";
	  selectHtml += "<option value='t_abnormal_z'>异常阻抗</option>";
	  selectHtml += "<option value='t_leakage_i'>周期漏电</option>";
	  selectHtml += "<option value='t_short_i'>短路电流</option>";
	  $("#falutReason").html(selectHtml); 	
	  //加载故障列表
	  so.init(function(){
			 initList();
	});
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
	 var widthVal = 500;
	 var heightVal = 900;
	 var temp = heightVal ;
	 parent.$("#tab4Iframe").attr("width", widthVal).attr("height", temp);
	 parent.$("#branchBoxDiv").css("height", "auto");
	 parent.$(".branchBox").css("width", (widthVal + 20)+"px").css("height", (heightVal - 150)+ "px");
}
