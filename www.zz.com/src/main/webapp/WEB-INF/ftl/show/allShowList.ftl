<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath}">
    <title>V2-设备信息列表</title>          
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
	<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
	<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${basePath}/css/common/base.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/woodare/css/comm.css" />
		<script src="${basePath}/woodare/js/jquery-1.9.1.min.js"></script>
	<script src="${basePath}/woodare/js/menu.js"></script>
	<script  src="${basePath}/js/common/layer/layer.js"></script>
	<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script  src="${basePath}/js/shiro.demo.js"></script>
	<link rel="stylesheet" href="${basePath}/woodare/css/zTreeStyle/zTreeStyle.css" type="text/css" />
	<script type="text/javascript" src="${basePath}/woodare/js/jquery.ztree.core.min.js"></script>
	<script type="text/javascript">
	        $(document).ready(function(e){
	        	<!--初始化加载时默认将左侧菜单收缩-->
	         var mapID  = $("#mapIframe")[0];
	          <!--此处 if...else...是一种兼容ie的写法  ，注意需要等地图加载完毕后，在加载菜单和地图坐标 和箱变信息-->
	         if (mapID.attachEvent) {
	             mapID.attachEvent("onload", function() {      
                <!--iframe加载完成后你需要进行的操作-->
                  menu.loadMenuTree();    
                  });    
	           }
	         else
	         {
	          mapID.onload = function() {      
                 <!--iframe加载完成后你需要进行的操作    -->
                  menu.loadMenuTree();
                };
	         }
	            });
     
	        $(function(){  
	            changeWH(); 
	        });  
	  
	    function changeWH(){    
	        $("#mapIframe").height($(document).height());  
	        $("#mapIframe").width($(document).width());  
	    } ;  
    	window.onresize=function(){ 
         changeWH();     
    		};
      </script>
	<script type="text/javascript"> 
	
	<!--展开节点-->
		function expendNode(nodeId){
		  var zTree = $.fn.zTree.getZTreeObj("treeNone");
		  var node = zTree.getNodeByParam("id",nodeId);
		  zTree.cancelSelectedNode();<!--先取消所有的选中状态-->
          zTree.selectNode(node,true);<!--将指定ID的节点选中-->
          zTree.expandNode(node, true, false);<!--将指定ID节点展开-->
          return node;
		  <!-- zTree.expandNode(node, true, true, true,true);-->
		}
	  function getEpuInfo(event, treeId, treeNode, clickFlag) {
       var type = treeNode.type;
        if (type == 3) {
      		<!--tab-begin-->
      	   $("#cityName").val(treeNode.cityName);
           $("#epuCity").val(treeNode.cityCode);
           $("#epuDistrict").val("");
           $("#rowId").val(treeNode.id);
           $("#epuName").val(treeNode.name);
           $("#epuLocal").val(treeNode.epuLocal);
           $("#epuXscale").val(treeNode.epuXscale);
           $("#epuYscale").val(treeNode.epuYscale);
           thisPageAddTab(treeNode.id,treeNode.name);
        }	  
	 }
  	 var menu = {
	    setting : {
	        data : {
	            simpleData : {
	                enable : true
	            }
	        },
	        keep : {
	            parent : true
	        },
	        
	        callback : { 
	        	<!-- 回调函数-->
	            onClick : getEpuInfo
	        }
	    },
	    <!--考虑到从箱变的预警提示，链接到实时监控，并打开相应的箱变信息。省，市，区，箱变四级 菜单不能采用原先的 异步加载的方式，需要一次性加载完成-->
	    loadMenuTree : function() {
	    	<!--$(".loading").show();<!--显示蒙层-->
	        $.post("${basePath}/epu/renderTree.shtml", null, function(data) {
	           	 $.fn.zTree.init($("#treeNone"), menu.setting, data);
	           	 $(".loading").hide();<!--隐藏蒙层-->
	           	 var substainRowId= '${substainRowId?default('')}'
	           	 if(substainRowId!=null && substainRowId!="")
	           	 {
	           	 <!-- 打开节点-->
	           	  var treeNode =expendNode(substainRowId);
	           	$("#cityName").val(treeNode.cityName);
	           $("#epuCity").val(treeNode.cityCode);
	           $("#epuDistrict").val("");
	           $("#rowId").val(treeNode.id);
	           $("#epuName").val(treeNode.name);
	           $("#epuLocal").val(treeNode.epuLocal);
	           $("#epuXscale").val(treeNode.epuXscale);
	           $("#epuYscale").val(treeNode.epuYscale);
	          <!--初始化箱变节点数据   	 -->
	          thisPageAddTab(treeNode.id,treeNode.name);			
			
	           	 }
        	});
	    }
	};
	
	so.init(function(){
       <!-- menu.loadMenuTree();-->
		
	});
	<!--tab --滚动条 区域 begin-->
	$(function() {
		$(".data-bar h4").click(function(){
			$(this).addClass("on");
			$("ul.tab-nav li").removeClass("on");
		});
					
		$(".data-bar span.left").click(function(){
			var dom = $(".data-bar ul.tab-nav .all");
			var marginLeft = parseInt(dom.css("margin-left"));
			if(marginLeft+207>0){
				dom.css("margin-left",0);
			}else{
				dom.css("margin-left",marginLeft+207);
			}
		});
		
		$(".data-bar span.right").click(function(){
			var dom = $(".data-bar ul.tab-nav .all");
			var marginLeft = parseInt(dom.css("margin-left"));
			var maxLeft = dom.width()-dom.parent().width()
			if(0-(marginLeft-207)>maxLeft){
				dom.css("margin-left",0-maxLeft);
			}else{
				dom.css("margin-left",marginLeft-207);
			}
		});
	});
	function thisPageAddTab(rowId,name){//当前画面点击TAB或者树时清除预警消息存放的信息，这样加载时不要默认显示故障定位
		$("#topoErrorLoadJson").text("");//清除点击预警消息时存放的内容
		addTab(rowId,name);
	}
	<!--tab --滚动条 区域 end-->
	<!--动态追加TAB-->
	function addTab(rowId,name){
		$("#rowId").val(rowId);
		<!--隐藏地图iframe-->
		$("#mapDivIframe").hide();
		$(".data-bar h4").removeClass("on");
		$("ul.tab-nav li, ul.tab-nav li font").removeClass("on");
		if($("#tab_" + rowId).length > 0){<!--已存在的箱变TAB-->
			$("#tab_" + rowId).addClass("on");
			if($("#tab_" + rowId).hasClass("on")){<!--若是选中地图，则加载信息-->
				$(".all li").each(function(){
					var thisRowId = $(this).attr("id").replace("tab_","");
					if($(this).hasClass("on")){<!--当前选中-->
						$("#"+thisRowId+"tabShow").show();
					}else{<!--其他禁用-->
						$("#"+thisRowId+"tabShow").hide();
					}
				});
			}
		}else{<!--新增TAB-->
			$("<li class='on' id='tab_" + rowId + "' onclick=\"thisPageAddTab('"+rowId+"','"+name+"')\">" + name + "<font onclick=\"removeTab(event,'"+rowId+"',this)\">关闭</font></li>").appendTo($("ul.tab-nav .all"));
			<!--创建拓扑图-->
			$(".loading").show();<!--显示蒙层-->
			$("#appendIframe").append("<div class=\"box\" id=\""+rowId+"tabShow\" style=\"display: none;\"></div>");
			var iframe = document.createElement('iframe'); 
			iframe.src="${basePath}/html/topologyHtml.html";  
			iframe.id= rowId + "Iframe";
			iframe.scrolling= "no";
			iframe.frameBorder= "0";
			$("#"+rowId+"tabShow").append(iframe);
			$(".all li").each(function(){
				var thisRowId = $(this).attr("id").replace("tab_","");
				if($(this).hasClass("on")){<!--当前选中-->
					$("#"+thisRowId+"tabShow").show();
				}else{<!--其他禁用-->
					$("#"+thisRowId+"tabShow").hide();
				}
			});
		}
		$(function() {
			var wid = $(".data-bar ul.tab-nav").width(); <!--tab最大宽度-->
			var linum = $(".data-bar ul.tab-nav li").length; <!--li最大个数-->
			var allwid = 207 * linum; <!--tab实际宽度-->
			if(wid<allwid){
				$(".data-bar span").show();
				$(".data-bar ul.tab-nav .all").width(allwid);		
				$(".data-bar ul.tab-nav").addClass("mrr");	
				$(".data-bar ul.tab-nav .all").css("margin-left",-(allwid-wid));
			}else{}
			$(".data-bar ul.tab-nav li").click(function(){
				$("ul.tab-nav li, ul.tab-nav li font").removeClass("on");
				$(this).addClass("on");
				$("font",this).addClass("on");
				$(".data-bar h4").removeClass("on");
			});

		});
	}
	<!--移除-->
	function removeTab(event,rowId,obj){
		$(obj).parent().remove();
		var wid = $(".data-bar ul.tab-nav").width(); <!--tab最大宽度-->
		var linum = $(".data-bar ul.tab-nav li").length; <!--li最大个数-->
		var allwid = 207 * linum; <!--tab实际宽度-->

		if(wid<allwid){
			$(".data-bar ul.tab-nav .all").width(allwid);	
			$(".data-bar ul.tab-nav .all").css("margin-left",-(allwid-wid));
		}else{
			$(".data-bar span").hide();
			$(".data-bar ul.tab-nav").removeClass("mrr");
			$(".data-bar ul.tab-nav .all").width(wid);	
			$(".data-bar ul.tab-nav .all").css("margin-left",0);
		}
		$("#"+rowId+"tabShow").remove();
		event.stopPropagation(); 
		var count = $(".all li").each(function(){}).length;
		if(count == 0){
			mapClick();<!--重新加载地图-->
		}
	}
	/**
	*重新加载地图
	**/
	function mapClick(){
		$("#mapDivIframe").show();
		$("#tab_map").addClass("on");
		var mapID  = $("#mapIframe")[0];
        <!--mapID.contentWindow.location.reload(true); <!--重新加载-->
        var  rowId= $("#rowId").val();
        var  cityName=$("#cityName").val();
        var  epuName= $("#epuName").val();
        var  epuLocal=$("#epuLocal").val();
        var epuXscale=$("#epuXscale").val();
        var epuYscale=$("#epuYscale").val();
        <!--不需要重新加载地图，刷新标注信息。-->
        <!--mapID.contentWindow.addMarker(rowId,cityName,rowId,epuName,epuLocal,epuXscale,epuYscale);-->
          mapID.contentWindow.locationMark(epuXscale, epuYscale);	
		$(".all li").each(function(){
			var thisRowId = $(this).attr("id").replace("tab_","");
			$("#"+thisRowId+"tabShow").hide();<!--除地图其他TAB全部隐藏-->
		});
	}
</script>
  </head>
  <label id="topoErrorLoadJson" name="topoErrorLoadJson" style="display: none;">${topoErrorLoadJson}</label>
  <input type="hidden" id="pageName" name="pageName"  value="allShowList"/>
  <input type="hidden" id="tableBoxId" name="tableBoxId"  value=""/>
  <input type="hidden" id="branchBoxId" name="branchBoxId"  value=""/>
  
  <input type="hidden" id="basePath" name="basePath"  value="${basePath}"/>
  <input type="hidden" id="web_socket_ip" name="web_socket_ip"  value="${web_socket_ip}"/>
  <input type="hidden" id="token_id" name="token_id"  value="${token.id}"/>
  <body>
   <!--页眉开始-->
   <!--页眉开始-->
<!-- 	<%--引入头部<@_top.top 3/>--%> -->
		<@_top.top 1/>
	<!--页眉结束/-->

	<!--左侧导航开始-->
	<@_left.top 1/>
	<!--左侧导航结束/-->
	<!--主体开始-->
	<div class="wapp-main">
		<h4>实时监控展现</h4>
	    <form method="post" action="" id="formId" class="form-inline">
	        <input type="hidden" id="rowId" name="rowId"  value=""/>
	        <input type="hidden" id="epuName" name="epuName"  value=""/>
	        <input type="hidden" id="epuLocal" name="epuLocal"  value=""/>
	        <input type="hidden" id="epuXscale" name="epuXscale"  value=""/>
	        <input type="hidden" id="epuYscale" name="epuYscale"  value=""/>
	        <input type="hidden" id="epuCity" name="epuCity"  value=""/>
	        <input type="hidden" id="cityName" name="cityName"  value=""/>
	        <input type="hidden" id="epuDistrict" name="epuDistrict"  value=""/>
	    </form>
	    <!--动态信息开始-->
	    <div class="date-mode">
	        <!--树结构开始-->
	        <div class="tree-box ztree" id="treeNone"></div>
	        <!--树结构结束/-->
	        
	        <!--动态数据开始-->
	        <div class="data-bar">
	        	<div class="head">
	                <h4 class="on" id="tab_map" onclick="mapClick();">地图总览</h4>
	                <span class="left"></span>
	                <ul class="tab-nav">
	                	<div class="all"></div>
	                </ul>
	                <span class="right"></span>
	            </div>
	        	<div class="box" id="mapDivIframe" style="display: block;overflow: hidden;">         
		            <div class="tab_css" >  
		               <iframe  id="mapIframe" src="${basePath}/html/showMapMark.html" frameborder="0" scrolling="no"></iframe> 
		            </div>  
           		 </div>
           		 <!--  -->
           		 <div id="appendIframe"></div>
           		  <!--  -->
	        </div>
	        <!--动态数据结束/-->
	    </div>
	    <!--动态信息结束/-->
	</div>
	<!--主体结束/-->
	<!--分支箱弹层开始-->
	<div class="wapp-layer"  id="messageBranchBox" >
		<div class="box tips mrr branchBox" style="left:30%;">
	    	<h4 style="text-indent:0%; "><label style="width:90%" ><p id='branchBoxName' style="word-wrap:break-word; word-break:break-all;padding: 0px 0px 0px 10px;"></p></label><span class="close-js" onclick="$('#tab4Iframe')[0].contentWindow.closeBranchBox();">关闭</span></h4>
	       <div class="edit mrr"  id="branchBoxDiv">
			<iframe id="tab4Iframe" src="${basePath}/html/branchBox.html" frameborder="0" scrolling="no"></iframe>
	       </div>
       <div class="but-nav" style=" position: absolute; left:0px; bottom:30px; height:32px;">
           <span class="but" onclick=" $('#tab4Iframe')[0].contentWindow.closeBranchBox();">关&nbsp;&nbsp;闭</span>
        </div>
	    </div>
	</div> 
	<!--分支箱弹层结束/-->
    <!--电表弹层开始-->
	<div class="wapp-layer"  id="messageAmmeter" >
		<div class="box tips mrr ammeter" style="left:25%;">
	    	<h4 style="text-indent:0%; "><label style="width:90%" ><p id='tableBoxName' style="word-wrap:break-word; word-break:break-all;padding: 0px 0px 0px 10px;"></p></label><span class="close-js" onclick=" $('#tab3Iframe')[0].contentWindow.closeAmmeter();">关闭</span></h4>
	       <div class="edit mrr" id="tableBoxDiv">
			<iframe id="tab3Iframe" src="${basePath}/html/ammeter.html" width="10000" height="4000" frameborder="0" scrolling="no"></iframe>
	       </div>
       <div class="but-nav" style=" position: absolute; left:0px; bottom:30px; height:32px;">
           <span class="but" onclick=" $('#tab3Iframe')[0].contentWindow.closeAmmeter();">关&nbsp;&nbsp;闭</span>
        </div>
	    </div>
	</div> 
	<!--电表弹层开始-->
	<!--loading开始-->
	<div class="loading">
		<div class="spinner">加载中
			<div class="double-bounce1"></div>
			<div class="double-bounce2"></div>
		</div>
	</div>
	<!--loading结束/-->
			<!--弹层开始-->
		<div class="wapp-layer" id="showFaultBase">
		</div>
		<!--弹层结束/-->
		<script type="text/javascript">
			$(function(){   
			   $(".wapp-head span.link").click();<!--初始化隐藏左侧菜单-->
			 })
		</script>
  </body>
</html>
