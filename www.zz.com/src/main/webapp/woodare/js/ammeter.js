
d3.namespace("xmlns:cge","http://iec.ch/TC57/2005/SVG-schema#");

var lbss = [];
var svgSnap = d3.select("body").append("svg");
var svg_width = 10000;
svgSnap.attr("width", svg_width - 25)
   .attr("height", 3960)
   .attr("xmlns", "http://www.w3.org/2000/svg")
   .attr("xmlns:xlink", "http://www.w3.org/1999/xlink")
   .attr("xmlns:cge", "http://iec.ch/TC57/2005/SVG-schema#");

var grid = 64;
var currentSnapX = grid * 1;
var currentSnapY = grid * 1;
var javaScriptObj = {
		svgObj:null,//当前SVG
		substationId:null,//箱变ID
		meterBoxXYJSON:{},//表箱XY坐标
		interval:null//定时器资源
}
var scaleZoom = 1;
var dataTemp = null;
function createTextEl(layer, data, position) {
	position.rotate =position.rotate || 0;
	var g = layer.append("g").attr("id", data.id);
	var x = position.x;
	var y = position.y;
	var size = position.size || 14;
	var txtCls = position.txt || "fText";
	var anchor = position.anchor || "end";
	var tspan = data.tspan || false;
	if(tspan){
		var txt = g.append('text').attr("text-anchor", anchor).attr("font-size", size).attr("stroke", "rgb(255,0,0)").attr("fill","rgb(255,0,0)").html(data.title).attr("class", txtCls).attr("transform","scale(" + position.scale + ") translate(0 0) rotate(" + position.rotate + " " + x + " " + y + ")");
	}else{
		var txt = g.append('text').attr("text-anchor", anchor).attr("font-size", size).attr("stroke", "rgb(255,0,0)").attr("fill","rgb(255,0,0)").attr("x", x).attr("y", y).text(data.title).attr("class", txtCls).attr("transform","scale(" + position.scale + ") translate(0 0) rotate(" + position.rotate + " " + x + " " + y + ")");
	}
}
function createUseEl(layer, data, position) {
	position.rotate= position.rotate||0;
	data.id = data.id || "";
	var g = layer.append("g").attr("id", data.id);
	var symbol = getSymbolByType(data.type)
	var x = position.x;
	var y = position.y;
	var transX = 0;
	var transY = 0;
	var rotate = position.rotate
	var rotateX = x + grid / 2;
	var rotateY = y + grid / 2;
	 g.append('use').attr("width", grid).attr("height", grid).attr("transform","scale(" + position.scale + ") translate(" + transX + " " + transY + ") rotate(" + position.rotate + " " + rotateX + " " + rotateY + ")").attr("xlink:href", "#" + symbol.id ).attr("x", x).attr("y", y).attr("class", data.cls);
}

function createLineEl(layer, data, position) {
	data.id = data.id || "";
	var g = layer.append("g").attr("id", data.id);
	var x = position.x * position.scale;
	var y = position.y * position.scale;
	var x2 = position.x2 * position.scale;
	var y2 = position.y2 * position.scale;
	var path = g.append('path').attr("stroke-width", 2).attr("stroke", "rgb(0,0,0)").attr("fill","none").attr("d", "M " + x + "," + y + " L " + x2 + "," + y2 + "");
	
	if (data.dash) {
		path.attr("stroke-dasharray", "3 3");
	}
}

function getSymbolByType(type) {
	var data = {
		id: "",
		x: "",
		y: ""
	};
	var id = "";
	switch(type) {
	case 'TableBox':
		data = {
			id: "TableBox_PD_表箱",
			x: 8,
			y: 12,
			txt: 'bkkV110',
			size:28,
			r: [0, 0]
		};
		break;
	case 'tableList':
		data = {
			id: "TableBox_PD_列表",
			x: 12,
			y: 12,
			r: [0, 90]
		};
		break;
	case 'tableList1':
		data = {
			id: "TableBox_PD_列表01",
			x: 12,
			y: 12,
			r: [0, 90]
		};
		break;
	case 'meterBox':
		data = {
			id: "MeterBox_PD_电表",
			x: 12,
			y: 12,
			r: [0, 90]
		};
		break;
	case 'meterBox1':
		data = {
			id: "MeterBox_PD_电表1",
			x: 12,
			y: 12,
			r: [0, 90]
		};
		break;
	default:
		break;
	}
	return data;
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

/**
 * 展示电表信息
 * @param rowIdParam 箱变根
 * @param tableBoxId 表箱ID
 */
function showTop(data,rowId,tableBoxId){
	javaScriptObj.substationId = rowId;
    //只有电表TAB可以执行此动作
    parent.$("#messageAmmeter").show();
	var keyArray = new Array(); 
	svgSnap.select("g[id='ammeter_Layer']").remove();
	var layerSnap = svgSnap.append("g").attr("id","ammeter_Layer");
	dataTemp = data;
//	 eupType ： 
//	 M0001 箱变
//	 M0002 出线柜
//	 M0003 分支箱
//	 M0004 表箱
	var ammterXYArray = new Array();
	if((null != rowId && "" != rowId ) && (null != tableBoxId && "" != tableBoxId )){
				setScale(svgSnap,1);
            	 if(null != data && data.length > 0){
     	         	var branchBoxDifference = 100;//差值
 	        		var branchBoxRelative = 100;//没有表箱的分支箱相对位置
 	        	   	var gird = 100;
 		        	var tempXAll = null;
 		        	var ammeterX = 100;//电表X绝对位置
	     		    var ammeterY = 500;//电表Y绝对位置	
	     			var branchBoxX = ammeterX;//分支箱X绝对位置
 	        		var branchBoxY = ammeterY;//分支箱Y绝对位置    
	     		         
 	        		var cabinetsX = branchBoxX;//出线柜X绝对位置
 	        		var cabinetsY = branchBoxY;//出现柜Y绝对位置
 	        		var cabinetsDifference = 300;
 	        		
 	        		
        		   var tempCount = 0;//获取分线箱的组中位数
  		           var tempBranchBoxX = 0;//获取到分线箱的下宽度
  		           var tempBranchBoxY = 0;//获取到分线箱的下高
  		           var tempBranchBoxLineX = 0;//获取到分线箱的上宽度
  		           var tempBranchBoxLineY = 0;//获取到分线箱的上高
     			   var rootList  = getRootData("M0004",tableBoxId,data);//表箱
     			   if(null != rootList && rootList.length > 0){//有表箱集合的
     				  var lsitBranchBoxXY = new Array();//定义出线柜的上处划线的上宽度 上高度
     					//表箱循环-begin
	       			 	for(var i= 0; i < rootList.length;i ++){
		       			 	var i_json = rootList[i];
	    			 		var i_epuParentId = i_json["rowId"];
	    			 		var ammeterList = new Array();
	    			 		getNextData("M0005",i_epuParentId,data,ammeterList);//电表(epuId根据这个找下级)
	    			 		if(null != ammeterList && ammeterList.length > 0){//有电表集合的
	    			 			tempCount = ammeterList.length-1 / 2;
	        			 		//电表循环 -begin
	        			 		for(var x = 0;x < ammeterList.length ;x ++){
	        			 			var x_json = ammeterList[x];
	        			 			var x_rowId = x_json["rowId"];//电表ID
	        			 			var x_name = x_json["ammeterName"];//电表名称
	        			 			keyArray.push(x_rowId);
	        			 			//展示电表 
	        			 			ammeterX = ammeterX + gird;
	        			 			var meterCircleX = (ammeterX - 23);
	        			 			var meterCircleY = (ammeterY - 3);
	        			 			setCreateUseEl_meter(layerSnap,"meterCircle_"+x_rowId,"meterBox",meterCircleX,meterCircleY);
	        			 			//电表号
	        			 			 splitRemarks(layerSnap,"meter_no_" + x_rowId,x_json["ammeterId"],(ammeterX +60) ,(ammeterY+40),"fText",10,false);
	 	    						//电表文本引入
//	    		        			 var textNewlineArr = textNewline(x_name,6,ammeterTxtX-20,ammeterTxtY + 25,20);
//	    		    		         splitRemarks(layerSnap,"meterText_" + x_rowId,textNewlineArr[0],0 ,0,"fText",12,true);//电表文本文本内容
	    		    		         createMeterText(layerSnap,x_rowId,(ammeterX -10),(ammeterY - 25) , x_name);
	    		    		         //table
	    		    		         var table_ammeterY =meterCircleY + 320;
	    		    		         ammterXYArray.push({KEY:x_rowId,X:meterCircleX - 50,Y:table_ammeterY});
	    		    		 		//电表分割备注
	    		    		         if(x == 0){
		 		    		        	splitRemarks(layerSnap,"ammeterTxtID","电表",70,(ammeterY + 40),"fText",24);
	    		    		         }
	 		    		        	 //引入电表与分支箱线
	    		        			 createLineEl(layerSnap, {
			    		        			id :"meterLine_" + x_rowId,
			    		        			type: "TableBox"
			    		        		}, {
			    		        			x: ammeterX + 32,//下宽度
			    		        			y: ammeterY + 13,//下高
			    		        			x2: ammeterX + 32,//上宽度
			    		        			y2: ammeterY - 58,//上高
			    		        			scale: 1
			    		        		});
	    		        			 //展示分支箱图形
	 	    						 branchBoxX = ammeterX;
	 	    		        		 branchBoxY = ammeterY- branchBoxDifference;
	 	    		        		 //合并分支箱
	 		    		        	 branchBoxLineX = branchBoxX + 32;//下宽度
	 		    		        	 branchBoxLineY = branchBoxY + 50;//下高
	 		    		        	 branchBoxLineX2 = branchBoxX + 32;//上宽度
	 		    		        	 branchBoxLineY2 = branchBoxY - 80;//上高
	 		    		        	 if (!tempXAll) {
	     		        				 tempXAll = branchBoxLineX + (ammeterList.length -1) * gird / 2;
	     		        			 }
	     		        			 pos={
	  		    		        			x: tempXAll,//下宽度
	  		    		        			y: branchBoxLineY2,//下高
	  		    		        			x2: branchBoxLineX,//上宽度
	  		    		        			y2: branchBoxLineY,//上高
	  		    		        			id:x_rowId,
	  		    		        			scale: 1
	  		    		        		};
	     		        			 setPos(layerSnap,pos);
	     		        			if(tempCount >x && tempCount < ( x + 1)){
	   		        				  tempBranchBoxX = tempXAll;//下宽度
	   		          		          tempBranchBoxY = branchBoxLineY;//下高
	   		          		          tempBranchBoxLineX = branchBoxLineX2;//上宽度
	   		          		          tempBranchBoxLineY = branchBoxLineY2;///上高
	     		        			}
	        			 		}
	        			 		//电表循环 -end
	    			 		}else{
	    			 			 parent.$("#tableBoxDiv").css("overflow", "auto");
	    			 			$("#falutDiv").css("width", "950px");
	    			 			return false;
	    			 		}
	       			 	}
	       			 	//表箱循环-end
    					 tempXAll = null;//清空
    			 		//没有数据的电表 -end
	    				cabinetsX = branchBoxX;
	    		         cabinetsY = branchBoxY - cabinetsDifference ;
	    		       //表箱
	    		         //文本内容
	    		         var tableBoTxtX = tempBranchBoxX - 25;
	    		         var tableBoTxtY = cabinetsY + 10;
	    		         //组织表箱图标
	    		         var svgimg = setSvgimg("70","70", "../woodare/image/boxImg.png",(tableBoTxtX -10),(tableBoTxtY - 27),("meterBoxImg_"+i_epuParentId));
		  		         $("#ammeter_Layer").append(svgimg);
	    		         var i_epuName = i_json["epuName"]||"";
	    		         var textNewlineArr = textNewline(i_epuName,6,tableBoTxtX- 50,(tableBoTxtY - 33),20);
	    		         splitRemarks(layerSnap,"meterBoxText_" + i_epuParentId,textNewlineArr[0],0 ,0,"fText",12,true);//表箱文本内容
	    		         //table
	    		       //展示table信息
	    		         javaScriptObj.meterBoxXYJSON ={KEY:i_epuParentId,X:(tempBranchBoxX+30), Y : cabinetsY + 135};
	    		         
	    		        	//出线柜分割备注
	    		        	splitRemarks(layerSnap,"cabinetsID","表箱",70,(cabinetsY),"fText",24);
	    		        	//出线柜往下画线
	    		        	var lowerCabinetsLineX = tempBranchBoxX;//下宽度（出线柜下处宽度）
	    		        	var lowerCabinetsLineY = cabinetsY + 100;//下高（分线柜下处高度）
	    		        	var lowerCabinetsLineX1 = tempBranchBoxX ;//上宽度
	    		        	var lowerCabinetsLineY1 = cabinetsY + 50;//上高
	    		        	createLineEl(layerSnap, {
	    		        		id :"lowerCabinetsID" + i_epuParentId,
	    		        		type: "TableBox"
	    		        	}, {
	    		        		x: lowerCabinetsLineX,//下宽度
	    		        		y: lowerCabinetsLineY,//下高
	    		        		x2: lowerCabinetsLineX1,//上宽度
	    		        		y2: lowerCabinetsLineY1,//上高
	    		        		scale: 1
	    		        	});
	    		        	 if(ammeterList.length > 0){//分线箱下面有表箱(有表箱，表箱与分纤箱一对一)的执行如下：
	    		        		var lowerBranchBoxX = tempBranchBoxX;//下宽度
	    		        		var lowerBranchBoxY = tempBranchBoxLineY;//下高
	    		        		 createLineEl(layerSnap, {
	    		        			id : i_epuParentId +"_meterBox_line",
	    		        			type: "TableBox"
	    		        		}, {
	    		        			x: lowerBranchBoxX,//下宽度
	    		        			y: lowerBranchBoxY,//下高
	    		        			x2: lowerCabinetsLineX1,//上宽度
	    		        			y2: lowerCabinetsLineY1 ,//上高
	    		        			scale: 1
	    		        		});
	    		        		 pos = {
		    		        			x: lowerCabinetsLineX1,//下宽度 (分线箱上处宽度)
		    		        			y: lowerCabinetsLineY1,//下高(分线箱上处高度)
		    		        			x2: lowerCabinetsLineX,//上宽度
		    		        			y2: lowerCabinetsLineY,//上高
		    		        			id:i_epuParentId,
		    		        			scale: 1
		    		        		};
	    		        		 setPos(layerSnap,pos);
	    		        	 }else{//没有表箱的默认
 	 	    		        	 createLineEl(layerSnap, {
 	 	    		        		id : i_epuParentId +"_meterBox_line",
			    		        			type: "TableBox"
			    		        		}, {
			    		        			x: tempBranchBoxX,//下宽度
			    		        			y: tempBranchBoxLineY,//下高
			    		        			x2: tempBranchBoxLineX - 0.5,//上宽度
			    		        			y2: cabinetsY + 50,//上高
			    		        			scale: 1
			    		        		});
	 	    		        	 }
     			   }
            	}
	}
	 var widthVal = (ammeterX + 350);
	 var heightVal = (table_ammeterY + 150);
	  var temp = heightVal + 600 ;
	 svgSnap.attr("width", widthVal).attr("height", temp)
	 parent.$("#tableBoxDiv").css("overflow", "auto");
	 $("#falutDiv").css("top",( temp - 720)+"px");
	 parent.$("#tab3Iframe").attr("height", (temp));
	 
	 javaScriptObj.svgObj = layerSnap;
	 //加载故障
	 so.initFaultTypeList();
	 var strKeyArray = "";
	 if(keyArray){
		if(null != keyArray && keyArray.length > 0){
			strKeyArray = keyArray.join(",")
		}
	 }
	 $("#strKeyArray").val(strKeyArray);
	 initList();
	 $("#strKeyRenderingArray").val(strKeyArray+"," + tableBoxId);//拼接表箱 渲染
	 //执行故障渲染
	 setFalut();
	 //加载表格
	 ammterTableUipq(tableBoxId,ammterXYArray);
     //开启定时器
	 var myVar =  setInterval(function(){
    	 //加载当前表箱下电表表格
		 clearInterval(myVar);//清除定时器
		 var timeoutVar =  setTimeout(function(){
			 clearInterval(timeoutVar);//清除定时器
			 showTop(data,rowId,tableBoxId);
		 }, (1000 * 20) );//(1000 * 20) 延迟20秒
		
     },(1000 * 60 * 5));//(1000 * 60 * 4)
	 javaScriptObj.interval = myVar;
	 //加载webSocket
	 loadWebsocket();
} 
/**
 * 
 * 加载当前表箱下电表表格
 * @param: meterBoxId 表箱ID
 * @param: ammterXYArray 当前表箱下所有电表XY坐标
 * **/
function ammterTableUipq(meterBoxId,ammterXYArray){
	$("#loadingDiv").show();
    $.ajax({
        url: getRootPath_web() + "/abnormalZ/selectMeterAndMeterBoxUIPQ.shtml",
        type: 'POST',
        timeout : 5000, //超时时间设置，单位毫秒
        dataType: 'json',
        async: true,
        data: {
        	meterBoxId: meterBoxId
        },
        success: function(data) {
        	//处理电表
        	var meterList = data.meterList;
        	var meterBoxList = data.meterBoxList;
        	if(null != ammterXYArray && ammterXYArray.length > 0){
        		for(var i = 0 ;i < ammterXYArray.length; i++){
        			var ammterXYJson = ammterXYArray[i];
        			var key = ammterXYJson["KEY"];
        			var x = parseInt(ammterXYJson["X"]);
        			var y = parseInt(ammterXYJson["Y"]);
        			if(meterList){
        				if(null != meterList && meterList.length > 0){
		        			for(var j = 0 ;j < meterList.length; j++){
		        				var j_json = meterList[j];
		        				var meterId = j_json["meterId"];
		        				if(meterId == key){
		        					 var u_value = parseFloat(j_json["ua"] ||0).toFixed(2);
		    						 var i_value = parseFloat(j_json["i"] ||0).toFixed(2);
		    						 var p_value = parseFloat(j_json["p"] ||0).toFixed(2);
		    						 var q_value = parseFloat(j_json["q"] ||0).toFixed(2);
		    						 setammeterTable(javaScriptObj.svgObj,key,x,y,u_value,i_value,p_value,q_value);
		        				}
		        			}
        				}else{
        					 var u_value = "无";
        					 var i_value = "无";
        					 var p_value = "无";
        					 var q_value = "无";
        					//清除TABLE
        					 setammeterTable(javaScriptObj.svgObj,key,x,y,u_value,i_value,p_value,q_value);
        				}
        			}else{
        				 var u_value = "无";
    					 var i_value = "无";
    					 var p_value = "无";
    					 var q_value = "无";
        				//清除TABLE
        				 setammeterTable(javaScriptObj.svgObj,key,x,y,u_value,i_value,p_value,q_value);
        			}
        		}
        	}
        	//处理表箱表格
        	if(meterBoxList){
				if(null != meterBoxList && meterBoxList.length > 0){
					 var  ua = "无";
					 var  ia = "无";
					 var  pa = "无";
					 var qa = "无";
					 var ub = "无";
					 var ib = "无";
					 var pb = "无";
					 var qb = "无";
					 var uc = "无";
					 var ic = "无";
					 var pc = "无";
					 var qc = "无";
		        	for(var i = 0;i < meterBoxList.length;i++){
		        		var json = meterBoxList[i];
		        		var phaseRemark = json["phaseRemark"];
		        		if(phaseRemark == 1 || phaseRemark == "1"){
		        			  ua = parseFloat(json["u"] || 0).toFixed(2);
		        			  ia = parseFloat(json["i"] || "无").toFixed(2);
		        			  pa = parseFloat(json["p"] ||0).toFixed(2);
		        			  qa = parseFloat(json["q"] ||0).toFixed(2);
		        		}else if(phaseRemark == 2 || phaseRemark == "2"){
		        			  ub = parseFloat(json["u"]||0).toFixed(2);
		        			  ib = parseFloat(json["i"]||0).toFixed(2);
		        			  pb = parseFloat(json["p"]||0).toFixed(2);
		        			  qb = parseFloat(json["q"] ||0).toFixed(2);
		        		}else if(phaseRemark == 3 || phaseRemark == "3"){
		        			  uc = parseFloat(json["u"] || 0).toFixed(2);
		        			  ic = parseFloat(json["i"] ||0).toFixed(2);
		        			  pc = parseFloat(json["p"]||0).toFixed(2);
		        			  qc = parseFloat(json["q"]).toFixed(2);
		        		}
		        	}
		        	setCabinetsXTable(javaScriptObj.svgObj,meterBoxId,javaScriptObj.meterBoxXYJSON.X,javaScriptObj.meterBoxXYJSON.Y,ua,ia,pa,qa,ub,ib,pb,qb,uc,ic,pc,qc);
				}else{
					//清除表箱表格
					 var  ua = "无";
					 var  ia = "无";
					 var  pa = "无";
					 var qa = "无";
					 var ub = "无";
					 var ib = "无";
					 var pb = "无";
					 var qb = "无";
					 var uc = "无";
					 var ic = "无";
					 var pc = "无";
					 var qc = "无";
					 setCabinetsXTable(javaScriptObj.svgObj,meterBoxId,javaScriptObj.meterBoxXYJSON.X,javaScriptObj.meterBoxXYJSON.Y,ua,ia,pa,qa,ub,ib,pb,qb,uc,ic,pc,qc);
				}
        	}else{
        		//清除表箱表格
        		 var  ua = "无";
				 var  ia = "无";
				 var  pa = "无";
				 var qa = "无";
				 var ub = "无";
				 var ib = "无";
				 var pb = "无";
				 var qb = "无";
				 var uc = "无";
				 var ic = "无";
				 var pc = "无";
				 var qc = "无";
				 setCabinetsXTable(javaScriptObj.svgObj,meterBoxId,javaScriptObj.meterBoxXYJSON.X,javaScriptObj.meterBoxXYJSON.Y,ua,ia,pa,qa,ub,ib,pb,qb,uc,ic,pc,qc);
        	}
            $(".loading").hide();
        },
        error: function() {
            $(".loading").hide();
        }
    });
}

function setPos(lay,pos){
	
	if (pos.x != pos.x2 && pos.y != pos.y2) {
		createLineEl(lay,{
			id: pos.id + "_line_1"
		}, {
			scale: pos.scale,
			x: pos.x ,
			y: pos.y,
			x2: pos.x2,
			y2: pos.y
		});
		createLineEl(lay,{
			id: pos.id + "_line_2"
		}, {
			scale: pos.scale,
			x: pos.x2 ,
			y: pos.y,
			x2: pos.x2,
			y2: pos.y2
		});
	} else {
		createLineEl(lay,{
			id: pos.id + "_line"
		}, pos);
	}
}
/**
 * 引入图状
 * **/
function setCreateUseEl(layerSnap,id,type,x,y){
	createUseEl(layerSnap, {
		id :id,
		type: type
	}, {
		x: x,
		y: y,
		scale: 1
	});
}

/**
 * 引入电表图状
 * **/
function setCreateUseEl_meter(layerSnap,id,type,x,y){
	createUseEl_meter(layerSnap, {
		id :id,
		type: type
	}, {
		x: x,
		y: y,
		scale: 1
	});
}
function createUseEl_meter(layer, data, position) {
	position.rotate= position.rotate||0;
	data.id = data.id || "";
	var x = position.x;
	var y = position.y;
	var g = layer.append("g").attr("id", data.id).attr("x",x).attr("y",y);
	var symbol = getSymbolByType(data.type)
	var transX = 0;
	var transY = 0;
	var rotate = position.rotate
	var gridTemp = 100;
	var rotateX = x + gridTemp / 2;
	var rotateY = y + gridTemp / 2;
	 g.append('use').attr("width", gridTemp).attr("height", gridTemp).attr("transform","scale(" + position.scale + ") translate(" + transX + " " + transY + ") rotate(" + position.rotate + " " + rotateX + " " + rotateY + ")").attr("xlink:href", "#" + symbol.id ).attr("x", x).attr("y", y).attr("class", data.cls);
}

/**
 * 分割备注
 * **/
function splitRemarks(layerSnap,id,title,x,y,txt,size,tspan){
	createTextEl(layerSnap, {
		id:id,
		title : title,
		tspan : tspan
	}, {
		x: x,
		y: y,
		scale: 1, 
		rotate: 0,
		txt: txt,//黑色字体样式
		size:size
	});
}


/**
 **获取上级节点信息
 *param：paramEpuType 类型
 *param：rowIdParam ROW_ID
 *param：data 数据集合
 ***/
function getRootData(paramEpuType,rowIdParam,data){
	var arrayList = new Array();
	for(var i= 0; i< data.length; i++){
		var json = data[i];
		var rowId = json["rowId"];
		var epuType = json["epuType"];//
		if(epuType == paramEpuType && rowIdParam == rowId){//展示箱变图像
			arrayList.push(json);
		}
	}
	return arrayList;
}

/**
 **获取下级节点信息
  *param：paramEpuType 类型
 *param：paramEpuParentId 父节点
 *param：data 数据集合
 ***/
function getNextData(paramEpuType,paramEpuParentId,data,arrayList){
	for(var i= 0; i< data.length; i++){
		var json = data[i];
		var epuParentId = json["epuId"];
		var epuType = json["epuType"];
		if(epuType == paramEpuType ){
			if(epuParentId == paramEpuParentId){
				arrayList.push(json);
			}
		}
	}
	return arrayList;
}


function setCabinetsXTable(layerSnap,id,cabinetsX,cabinetsY,ua,ia,pa,qa,ub,ib,pb,qb,uc,ic,pc,qc){
	var idTableNull_X = cabinetsX;
	var idTableNull_Y = cabinetsY - 150;
	setCreateUseEl(layerSnap,"idTitleNull" + id, "tableList1",(idTableNull_X + 33),idTableNull_Y);//空框
	
	var idTableU_X = cabinetsX +58;
	var idTableU_Y = cabinetsY -150;
	setCreateUseEl(layerSnap,"idTitleU" + id, "tableList",idTableU_X,idTableU_Y);//u框
	splitRemarks(layerSnap,"idTitleUtxt" + id,"U",idTableU_X + 37,idTableU_Y+22,"fText",18);//U文字
	
	var idTableI_X = idTableU_X +58;
	var idTableI_Y = cabinetsY -150;
	setCreateUseEl(layerSnap,"idTitleI" + id, "tableList",idTableI_X,idTableI_Y);//i框
	splitRemarks(layerSnap,"idTitleItxt" + id,"I",idTableI_X + 37,idTableI_Y+22,"fText",18);//I文字
	
	var idTableP_X = idTableI_X +58;
	var idTableP_Y = cabinetsY -150;
	setCreateUseEl(layerSnap,"idTableU" + id, "tableList",idTableP_X,idTableP_Y);//P框
	splitRemarks(layerSnap,"idTitlePtxt" + id,"P",idTableP_X + 37,idTableP_Y+22,"fText",18);//P文字
	
	var idTableQ_X = idTableP_X +58;
	var idTableQ_Y = cabinetsY -150;
	setCreateUseEl(layerSnap,"idTitleQ" + id, "tableList",idTableQ_X,idTableQ_Y);//Q框
	splitRemarks(layerSnap,"idTitleQtxt" + id,"Q",idTableQ_X + 37,idTableQ_Y+22,"fText",18);//Q文字
	
	
	
	var idTableA_X = idTableNull_X;
	var idTableA_Y = idTableNull_Y+ 26;
	
	var idTableAU_X = idTableA_X +58;
	var idTableAU_Y = idTableNull_Y+ 26;
	setCreateUseEl(layerSnap,"idUA" + id, "tableList",idTableAU_X,idTableAU_Y);//ua框
	splitRemarks(layerSnap,"idUAtxt" + id,ua,idTableAU_X + 55,idTableAU_Y+22,"fText",14);//ua文字
	
	setCreateUseEl(layerSnap,"idTitleNull" + id, "tableList1",(idTableNull_X + 33),idTableAU_Y);//空框
	splitRemarks(layerSnap,"idTitleAtxt" + id,"A",idTableAU_X ,idTableAU_Y+22,"fText",18);//A
	
	var idTableAI_X = idTableAU_X +58;
	var idTableAI_Y = idTableNull_Y+ 26;
	setCreateUseEl(layerSnap,"idIA" + id, "tableList",idTableAI_X,idTableAI_Y);//ia框
	splitRemarks(layerSnap,"idIAtxt" + id,ia,idTableAI_X + 55,idTableAI_Y+22,"fText",14);//ia文字
	
	var idTableAP_X = idTableAI_X +58;
	var idTableAP_Y = idTableNull_Y+ 26;
	setCreateUseEl(layerSnap,"idPA" + id, "tableList",idTableAP_X,idTableAP_Y);//pa框
	splitRemarks(layerSnap,"idPAtxt" + id,pa,idTableAP_X + 55,idTableAP_Y+22,"fText",14);//pa文字
	
	var idTableAQ_X =  idTableAP_X+58;
	var idTableAQ_Y = idTableNull_Y+ 26;
	setCreateUseEl(layerSnap,"idQA" + id, "tableList",idTableAQ_X,idTableAQ_Y);//qa框
	splitRemarks(layerSnap,"idQAtxt" + id,qa,idTableAQ_X + 55,idTableAQ_Y+22,"fText",14);//qa文字



	
	
	
	var idTableBU_X = idTableA_X +58;
	var idTableBU_Y = idTableNull_Y+ 52;
	setCreateUseEl(layerSnap,"idUB" + id, "tableList",idTableBU_X,idTableBU_Y);//ub框
	splitRemarks(layerSnap,"idUBtxt" + id,ub,idTableBU_X + 55,idTableBU_Y+22,"fText",14);//ub文字
	
	setCreateUseEl(layerSnap,"idTitleNull" + id, "tableList1",(idTableNull_X + 33),idTableBU_Y);//空框
	splitRemarks(layerSnap,"idTitleBtxt" + id,"B",idTableBU_X ,idTableBU_Y+22,"fText",18);//B
	
	var idTableBI_X = idTableBU_X +58;
	var idTableBI_Y = idTableNull_Y+ 52;
	setCreateUseEl(layerSnap,"idIB" + id, "tableList",idTableBI_X,idTableBI_Y);//IB框
	splitRemarks(layerSnap,"idIBtxt" + id,ib,idTableBI_X + 55,idTableBI_Y+22,"fText",14);//ib文字
	
	
	var idTableBP_X = idTableBI_X +58;
	var idTableBP_Y = idTableNull_Y+ 52;
	setCreateUseEl(layerSnap,"idPB" + id, "tableList",idTableBP_X,idTableBP_Y);//pb框
	splitRemarks(layerSnap,"idPBtxt" + id,pb,idTableBP_X + 55,idTableBP_Y+22,"fText",14);//pb文字
	
	var idTableBQ_X = idTableBP_X +58;
	var idTableBQ_Y = idTableNull_Y+ 52;
	setCreateUseEl(layerSnap,"idQB" + id, "tableList",idTableBQ_X,idTableBQ_Y);//bq框
	splitRemarks(layerSnap,"idQBtxt" + id,qb,idTableBQ_X + 55,idTableBQ_Y+22,"fText",14);//qb文字



	
	
	
	
	var idTableCU_X = idTableA_X +58;
	var idTableCU_Y = idTableNull_Y+ 78;
	setCreateUseEl(layerSnap,"idUC" + id, "tableList",idTableCU_X,idTableCU_Y);//uc框
	splitRemarks(layerSnap,"idUCtxt" + id,uc,idTableCU_X + 55,idTableCU_Y+22,"fText",14);//UC文字
	
	setCreateUseEl(layerSnap,"idTitleNull" + id, "tableList1",(idTableNull_X + 33),idTableCU_Y);//空框
	splitRemarks(layerSnap,"idTitleCtxt" + id,"C",idTableCU_X ,idTableCU_Y+22,"fText",18);//C
	
	var idTableCI_X = idTableCU_X +58;
	var idTableCI_Y = idTableNull_Y+ 78;
	setCreateUseEl(layerSnap,"idIC" + id, "tableList",idTableCI_X,idTableCI_Y);//ic框
	splitRemarks(layerSnap,"idICtxt" + id,ic,idTableCI_X + 55,idTableCI_Y+22,"fText",14);//ic文字
	
	
	var idTableCP_X = idTableCI_X +58;
	var idTableCP_Y = idTableNull_Y+ 78;
	setCreateUseEl(layerSnap,"idPC" + id, "tableList",idTableCP_X,idTableCP_Y);//pc框
	splitRemarks(layerSnap,"idPCtxt" + id,pc,idTableCP_X + 55,idTableCP_Y+22,"fText",14);//pc文字
	
	var idTableCQ_X =  idTableCP_X+58;
	var idTableCQ_Y = idTableNull_Y+ 78;
	setCreateUseEl(layerSnap,"idQC" + id, "tableList",idTableCQ_X,idTableCQ_Y);//qc框
	splitRemarks(layerSnap,"idQCtxt" + id,qc,idTableCQ_X + 55,idTableCQ_Y+22,"fText",14);//qc文字
}


/**
 * 电表信息
 * **/
function setammeterTable(layerSnap,id,cabinetsX,cabinetsY,u,i,p,q){
	var UbTemp_Y = 150; 
	var idTableUb_X = cabinetsX + 58;
	var idTableUb_Y = cabinetsY - UbTemp_Y;
	setCreateUseEl(layerSnap,"idU" + id, "tableList1",idTableUb_X,idTableUb_Y);//u框
	splitRemarks(layerSnap,"idUtxt" + id,"U",idTableUb_X + 25,idTableUb_Y + 22,"fText",18);//Ub文字
	var idTableUb1_X = idTableUb_X + 26;
	var idTableUb1_Y = cabinetsY - UbTemp_Y;
	setCreateUseEl(layerSnap,"idTableU" + id, "tableList",idTableUb1_X,idTableUb1_Y);//u框
	splitRemarks(layerSnap,"idTableUtxt" + id,u,idTableUb1_X + 60,idTableUb1_Y+22,"fText",14);//u文字
	
	var IbTemp_Y = 124; 
	var idTableIb_X = cabinetsX + 58;
	var idTableIb_Y = cabinetsY - IbTemp_Y;
	setCreateUseEl(layerSnap,"idI" + id, "tableList1",idTableIb_X,idTableIb_Y);//i框
	splitRemarks(layerSnap,"idItxt" + id,"I",idTableIb_X + 25,idTableIb_Y + 22,"fText",18);//I文字
	var idTableIb1_X = idTableIb_X + 26;
	var idTableIb1_Y = cabinetsY - IbTemp_Y;
	setCreateUseEl(layerSnap,"idTableI" + id, "tableList",idTableIb1_X,idTableIb1_Y);//i框
	splitRemarks(layerSnap,"idTableItxt" + id,i,idTableIb1_X + 60,idTableIb1_Y+22,"fText",14);
	
	
	var pTemp_Y = 98; 
	var idTableP_X = cabinetsX + 58;
	var idTableP_Y = cabinetsY - pTemp_Y;
	setCreateUseEl(layerSnap,"idP" + id, "tableList1",idTableP_X,idTableP_Y);//p框
	splitRemarks(layerSnap,"idPtxt" + id,"P",idTableP_X + 25,idTableP_Y + 22,"fText",18);//P文字
	var idTableP1_X = idTableP_X + 26;
	var idTableP1_Y = cabinetsY - pTemp_Y;
	setCreateUseEl(layerSnap,"idTableP" + id, "tableList",idTableP1_X,idTableP1_Y);//p框
	splitRemarks(layerSnap,"idTablePtxt" + id,p,idTableP1_X + 60,idTableP1_Y+22,"fText",14);
	
	var qTemp_Y = 72; 
	var idTableQ_X = cabinetsX + 58;
	var idTableQ_Y = cabinetsY - qTemp_Y;
	setCreateUseEl(layerSnap,"idQ" + id, "tableList1",idTableQ_X,idTableQ_Y);//q框
	splitRemarks(layerSnap,"idQtxt" + id,"Q",idTableQ_X + 25,idTableQ_Y + 22,"fText",18);//q文字
	var idTableQ1_X = idTableQ_X + 26;
	var idTableQ1_Y = cabinetsY - qTemp_Y;
	setCreateUseEl(layerSnap,"idTableQ" + id, "tableList",idTableQ1_X,idTableQ1_Y);//q框
	splitRemarks(layerSnap,"idTableQtxt" + id,q,idTableQ1_X + 60,idTableQ1_Y+22,"fText",14);
}

/**
 * 文本换行符转换
 * strParam:传输的文本
 * start:以多少字符为一组范围
 * x:横向坐标
 * y:纵向坐标
 * number:y轴，累加数
 * ***/
function textNewline(strParam,start,x,y,number)
{	var str='';
	for(var i = 0;i < strParam.length;i ++){
		var chaTxt = strParam[i];
		 str += chaTxt;
		 if(!((i+1) % start)){
			str += 'woodare';
		 }
	}
	var arrs = str.split("woodare");
	var newStr = "";
	for(var i = 0;i< arrs.length;i++){
		y += number;
		newStr += "<tspan x=\"" + x + "\" y=\"" + y + "\">" + arrs[i] + "</tspan>";
	}
	y += number;
	newStr += "<tspan x=\"" + x + "\" y=\"" + y + "\"></tspan>";
	y += number;
	newStr += "<tspan x=\"" + x + "\" y=\"" + y + "\"></tspan>";
	return [newStr,y];
}

/**
* 单击执行放大缩小
**/
function clickScale(param){
	scaleZoom = scaleZoom || 1;
	if(param == "max"){
		if(scaleZoom < 0.9){
			scaleZoom = scaleZoom + 0.1;
			setScale(svgSnap,scaleZoom);
		}else if(scaleZoom >= 0.9){
			var rowId = parent.$("#rowId").val();
			var tableBoxId = parent.$("#tableBoxId").val();
			scaleZoom = 1;//每次单击菜单，缩放级别回归到1
			$("#wd").val(scaleZoom);//文本框内容缩放级别值
			$("#wdPercentage").val((scaleZoom * 100)+"%"); //文本框内容缩放级别值
			showTop(dataTemp,rowId,tableBoxId);
		}
	}else if(param == "min"){
		if(scaleZoom > 0.2){
			scaleZoom = scaleZoom - 0.1;
			setScale(svgSnap,scaleZoom);
		}
	} 
}

function setScale(svgSnap,zoom){
	var x = 0;
	var y = 0;
	if(zoom < 1){
		zoom = zoom.toFixed(1);
	}
	$("#wd").val(zoom);//文本框内容缩放级别
   $("#wdPercentage").val((zoom * 100)+"%"); //文本框内容缩放级别值值
	svgSnap.attr("transform","scale(" + zoom + " " + zoom + ") translate(" + x + " " + y + ")");
}

/**
 * 电表故障渲染
 * @param rowId 箱变ID
 */
function setFalut(){
	$("#loadingDiv").show();
	$.ajax({ 
		 type: "post",
        url:  getRootPath_web() + "/fault/selectFaultByRootId.shtml",
        data: {
       	 strKeyArray : $.trim($("#strKeyRenderingArray").val()||""),
        },
        async:true,
        dataType: "json",
        cache: false,
        success: function(allData){ 
        	faultNowData = allData ;
	       	var faultNowMeterArray = new Array();
	    	var faultNowMeterBoxArray = new Array();
	    	var faultNowMeterErrorArray = new Array();
	    	var faultNowMeterBoxErrorArray = new Array();
	    	if(null != faultNowData && faultNowData.length > 0){
	    		for(var tempI= 0;tempI < faultNowData.length;tempI++){
	    			var faultNowJson = faultNowData[tempI];
	    			var type = faultNowJson["type"];
	    			var is_repaired = faultNowJson["is_repaired"] || "";//是否被修复，1表示是
    				var is_cancelled = faultNowJson["is_cancelled"] || "";//是否被取消，1表示是
	    			if(is_repaired != "1" && is_cancelled !="1" ){//未修复/未取消
		    			if(type == "M0005"){//电表ID
		    				faultNowMeterArray.push(faultNowJson);
		    			}
		    			if(type == "M0004"){//表箱ID
		    				faultNowMeterBoxArray.push(faultNowJson);
		    			}
	    			}else if(is_repaired == "1" || is_cancelled =="1"){//修复/被取消
	    				if(type == "M0005"){//电表ID
	    					faultNowMeterErrorArray.push(faultNowJson);
		    			}
		    			if(type == "M0004"){//表箱ID
		    				faultNowMeterBoxErrorArray.push(faultNowJson);
		    			}
	    			}
	    		}
	    	}
	    	var bool = ($.trim( $(window.parent.$("#"+javaScriptObj.substationId+"Iframe")).contents().find(".a-hov span[class='on']").text()) == "故障定位");//主面板点击了故障定位,则渲染电表故障
	    	if(!bool){//主面板未点击了故障定位,则清除渲染电表故障
	    		clearFalut(faultNowMeterArray,faultNowMeterBoxArray);
		    }
	    	if((null != faultNowMeterErrorArray && faultNowMeterErrorArray.length >0) || (null != faultNowMeterBoxErrorArray && faultNowMeterBoxErrorArray.length >0) ){
	    		clearFalut(faultNowMeterErrorArray,faultNowMeterBoxErrorArray);
	    	}
	    	if(bool){
	    		//处理表箱
	    		for(var i = 0;i < faultNowMeterBoxArray.length ;i++){
	    			var json = faultNowMeterBoxArray[i];
	    			var key = json["key"]|| "";
	    			var faultType = json["faultType"];
	    			var epuName = json["epuName"];
	    			  var faultTypeName = json["faultTypeName"];
	    			//找到异常表箱图标，设置
	    			$("#ammeter_Layer").find("image[id='meterBoxImg_"+key+"']").attr("href","../woodare/image/boxImgError.png");
	    			 var count = $("#meterBoxText_"+key).find("text tspan").length||0;
	    			if(null != faultTypeName && faultTypeName != ""){
	    				$("#meterBoxText_" + key+ " text").find("tspan").eq((count - 2)).text("故障原因:" );
	    				$("#meterBoxText_" + key+ " text").find("tspan").eq((count - 1)).text(faultTypeName);
	    			}
	    			updateClass("meterBoxText_"+key+" text", "error");
	    			
	    			updateClass(key+"_meterBox_line", "error");
	    			updateClass(key+"_line", "error");
	    		}
	    		//处理电表
	    		for(var i = 0;i < faultNowMeterArray.length ;i++){
	    			var json = faultNowMeterArray[i];
	    			var key = json["key"]|| "";
	    			var faultType = json["faultType"];
	    			var epuName = json["epuName"];
	    			  var faultTypeName = json["faultTypeName"];
	    			//找到异常电表图标，设置
	    			  var x = $("#meterCircle_" + key).attr("x");
	    			  var y = $("#meterCircle_" + key).attr("y");
	    			  //移除原始框
	    			  $("#meterCircle_"+key).remove();
	    			  //添加红色框
	    			setCreateUseEl_meter(javaScriptObj.svgObj,"meterCircle_"+key,"meterBox1",x,y);
	    			updateClass("meter_no_" + key+ " text", "error");//电表号置为红色
	    			
	    			meterTxtError(key,epuName,"故障原因:"+faultTypeName,"error");
	    			
	    			updateClass("meterText_" + key+ " text", "error");
	    			updateClass("meterLine_" +key, "error");
//	    			updateClass(key + "_line_1", "error");
	    			updateClass(key + "_line_2", "error");
	    			updateClass(key + "_line", "error");
	    		
	    		}
	    	}  
		    $("#loadingDiv").hide();
       } 
	});
	
}

/**
 * 还原
 * **/
function clearFalut(faultNowMeterArray,faultNowMeterBoxArray){
	for(var i = 0;i < faultNowMeterBoxArray.length ;i++){
		var json = faultNowMeterBoxArray[i];
		var key = json["key"]|| "";
		var faultType = json["faultType"];
		var epuName = json["epuName"];
		  var faultTypeName = json["faultTypeName"];
		//找到异常表箱图标，设置
		$("#ammeter_Layer").find("image[id='meterBoxImg_"+key+"']").attr("href","../woodare/image/boxImg.png");
		var count = $("#meterBoxText_"+key).find("text tspan").length||0;
		if(null != faultTypeName && faultTypeName != ""){
			$("#meterBoxText_" + key+ " text").find("tspan").eq((count - 2)).text("");
			$("#meterBoxText_" + key+ " text").find("tspan").eq((count - 1)).text("");
		}
		updateClass("meterBoxText_"+key+" text", "fText");
		
		updateClass(key+"_meterBox_line", "fText");
		updateClass(key+"_line", "fText");
	}
	//处理电表
	for(var i = 0;i < faultNowMeterArray.length ;i++){
		var json = faultNowMeterArray[i];
		var key = json["key"]|| "";
		var faultType = json["faultType"];
		var epuName = json["epuName"];
		  var faultTypeName = json["faultTypeName"];
		  var x = $("#meterCircle_" + key).attr("x");
		  var y = $("#meterCircle_" + key).attr("y");
		  //移除原始框
		  $("#meterCircle_"+key).remove();
		  //添加红色框
		  setCreateUseEl_meter(javaScriptObj.svgObj,"meterCircle_"+key,"meterBox",x,y);
		  updateClass("meter_no_" + key+ " text", "fText");//电表号置为黑色色
		  
		  meterTxtError(key,epuName,"","fText");
		
		updateClass("meterText_" + key+ " text", "fText");
		
		updateClass("meterLine_" +key, "fText");
		updateClass(key + "_line_1", "fText");
		updateClass(key + "_line_2", "fText");
		updateClass(key + "_line", "fText");
	}
}
/*
 * 更新样式
 * **/
function updateClass(key, cls) {
	$("#" + key).attr("class",cls);
	$("#" + key).find("rect").attr("class",cls);
	$("#" + key).find("path").attr("class",cls);
}
/**
 * 获取组织的SVG图片
 * height:高度
 * width:宽度
 * srcPath:图片地址
 * x:X坐标
 * y:Y坐标
 * id:图片绑定元素ID
 * **/
function setSvgimg(height,width,srcPath,x,y,id){
   var svgimg = document.createElementNS('http://www.w3.org/2000/svg','image');
   svgimg.setAttributeNS(null,"height",height);
   svgimg.setAttributeNS(null,"width",width);
//   svgimg.setAttributeNS(null,"cursor","pointer");
   svgimg.setAttributeNS("http://www.w3.org/1999/xlink","href", srcPath);
   svgimg.setAttributeNS(null,"x", x);
   svgimg.setAttributeNS(null,"y",y);
   svgimg.setAttributeNS(null,"id",id);
   svgimg.setAttributeNS(null, "visibility", "visible");
   return svgimg;
}

$(function() {
	  //绑定事件
	parent.$("#tableBoxDiv").scroll(function(){
	 	$(".gj").css("top", ($(this).scrollTop() ));
  		$(".gj").css("left", ($(this).scrollLeft() ));
	 });
	
});
/**加载Websocket
 * **/
function loadWebsocket(){
	 var websocket;
	 var basePath = parent.$("#basePath").val();//项目地址
	 var web_socket_ip = parent.$("#web_socket_ip").val();//WebSocket握手IP地址
	 var token_id = parent.$("#token_id").val();//登录人ID
     if('WebSocket' in window) {
          console.log("此浏览器支持websocket");
         websocket = new WebSocket("ws://"+web_socket_ip + basePath +"/chat/"+token_id);
     } else if('MozWebSocket' in window) {
         alert("此浏览器只支持MozWebSocket");
     } else {
         alert("此浏览器只支持SockJS");
     }
     websocket.onopen = function(evnt) {
         //打开监听,连接open后给前端和后端同时发送open信号，两个线程不会阻塞。但是我的后端open事件一定要先执行，这样前端请求时，才能有足够的时间等待后端生成userSocket
         //加载故障数据
//          alert("链接服务器成功,加载故障数据!");
     };
     websocket.onmessage = function(evnt) {
    	 //"{\"name\":\"faultRendering\",\"key\":\"38f04bc0-6c40-4535-ba36-7dbc1d6d2536\"}"
    	 if(evnt.data.indexOf("faultRendering") !=-1){
    		 var json = JSON.parse(evnt.data);
    		 if(json.key == javaScriptObj.substationId){
    			 setFalut();
    		 }
    	 }
    	 //得到消息通知，执行加载故障数据
     };
     websocket.onerror = function(evnt) {};
     websocket.onclose = function(evnt) {
//    	 alert("与服务器断开了链接!");
     }
}


/**
* 创建电表图标及文本展示
**/
 function createMeterText(layer, id, x, y, name) {
     var g = layer.append("g").attr("id", "meterbox_" + id).attr("name", name).attr("x", x).attr("y", y);
     g.append('title').text(name);
     var k = 0;
     if (name && name.length) {
    	 if(name.length > 21){
    		 name = name.substring(0,21)+"...";
    	 }
         var size = 6;
         for (var i = 0; i < name.length / size; i++) {
             g.append('text').attr("font-size", "14").attr("cursor", "pointer").attr("text-align", "center").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text(name.substring(i * size, i * size + size)).attr("x", x).attr("y", y + 108 + 20 * i);
             k++;
         }
     }
 }
 
 function meterTxtError(key,epuName,epuNameError,cls){
 	var x = $("#meterbox_" + key).attr("x");
     var y = $("#meterbox_" + key).attr("y");
     var k = 0;
     x = parseInt(x);
     y = parseInt(y);
     var k = 0;
     epuName = epuName + epuNameError;
     if (epuName && epuName.length) {
         var size = 6;
         javaScriptObj.svgObj.select("g[id='meterbox_"+key+"']").each(function(){
          	$(this).children("text").each(function(){
          		$(this).remove();
          	});
          	$(this).children("title").remove();//清除原始标题
          });
          var g = javaScriptObj.svgObj.select("g[id='meterbox_"+key+"']");
          g.append('title').text(epuName);
          if(epuName.length > 21){
     		 epuName = epuName.substring(0,21)+"...";
     	 }
         for (var i = 0; i < epuName.length / size; i++) {
             g.append('text').attr("font-size", "14").attr("cursor", "pointer").attr("text-align", "center").attr("class", cls).attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text(epuName.substring(i * size, i * size + size)).attr("x", x).attr("y", y + 108 + 20 * i);
             k++;
         }
     }
 }
/**
 * 电表弹出层关闭
 * */
function closeAmmeter(){
	clearInterval(javaScriptObj.interval);//清除定时器
	parent.$("#messageAmmeter").hide();
}

