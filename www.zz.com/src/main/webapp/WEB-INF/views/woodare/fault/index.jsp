<%@ page language="java"  pageEncoding="UTF-8"%>
<%--shiro 标签 --%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
 %> 

<!DOCTYPE html>
<!-- <html> -->
  <head>
    <base href="<%=basePath%>">
    <title>V2-箱变信息列表</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<link   rel="icon" href="<%=basePath%>/favicon.ico" type="image/x-icon" />
	<link   rel="shortcut icon" href="<%=basePath%>/favicon.ico" />
	<link href="<%=basePath%>/js/common/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="<%=basePath%>/css/common/base.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/woodare/css/comm.css" />
		<script src="<%=basePath%>/js/common/jquery/jquery1.8.3.min.js"></script>
	<script src="<%=basePath%>/woodare/js/menu.js"></script>
	<script src="<%=basePath%>/woodare/js/faultLocation.js"></script>
	<script  src="<%=basePath%>/js/common/layer/layer.js"></script>
	<script  src="<%=basePath%>/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script  src="<%=basePath%>/js/shiro.demo.js"></script>
	<script language="javascript" type="text/javascript" src="<%=basePath%>/js/My97DatePicker/WdatePicker.js"></script>
	<script >
			so.init(function(){
				 initList();
				
			});
		
			  function initList(pageNo) {
			    	 $("#loadingDiv").show(); 
					
			        $.ajax({
			            url: "<%=basePath%>/fault/queryEpuList.shtml",
			            type: 'POST',
			            dataType: 'json',
			            async:false,
			            data: {	 		          
			            	epuName: $("#epuName").val(),
			            	falutOccurrenceTime: $("#falutOccurrenceTime").val(),
			            	falutReason: $("#falutReason").val(),
			            	isFalut: $("#isFalut").val(),
			            	falutRepairTime: $("#falutRepairTime").val(),
			            	isCancelled: $("#isCancelled").val(),
			            	stringData : JSON.stringify(dataTemp),
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
			                            tbody += '<tr>';
			                            tbody += '<td align="center"><div>' + epuList[i].epuName+ '</div></td>';
			                            tbody += '<td align="center"><div>' + (epuList[i].falutReason ||"") + '</div></td>';
			                            tbody += '<td align="center"><div>' + epuList[i].occur_time+ '</div></td>';
			                            tbody += '<td align="center"><div>' + epuList[i].isCancelled+ '</div></td>';
			                            tbody += '<td align="center"><div>' + epuList[i].isFalut + '</div></td>';			                            
			                            tbody += '<td align="center"><div>' + epuList[i].repair_time+ '</div></td>';
			                            tbody += '</tr>';			                            
			                        }
			                        $("#faultListTable").html(tbody);
			                         // var pageHtml=page.pageHtml.replace(new RegExp("_submitform","gm"),"javascript:so.initList");
			                         var a = page.pageHtml;
									var b = a.substring(0,a.lastIndexOf('\<script'));  
			                        var pageHtml=b.replace(/_submitform/g,'initList');
			                       $(".pagination").html(pageHtml);
			                         $("#loadingDiv").hide(); 
			                    }else
			                    {
			                    	  $("#faultListTable").html('');
			                    }
			                    //分页
			                   // TRADEZONE_MANAGE_PAGE.totalCount = data.recordsTotal;
			                } else {
			                    //分页
			                    //TRADEZONE_MANAGE_PAGE.totalCount = 0;
			                }
			               // PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
			                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
			                //PAGINATION_UTIL.pagination(currentPage);
			            },
			            error: function () {
			                //分页
			              /*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
			                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
			                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
			                PAGINATION_UTIL.pagination(currentPage); */ 
			                $("#loadingDiv").hide();
			            }
			        });

			    };
			 
		</script>
		
  </head>
  
  <body>
   <!--页眉开始-->
	<%--引入头部<@_top.top 3/>--%>
	<jsp:include page="../common/top.jsp"></jsp:include>
	<!--页眉结束/-->

	<!--左侧导航开始-->
	<jsp:include page="../common/left.jsp"></jsp:include>
	<!--左侧导航结束/-->

<!--主体开始-->
<div class="wapp-main">
		<form method="post" action="" id="formId" class="form-inline">
		
	<h4>故障定位列表</h4>	
    <!--搜索开始-->
	<div class="search">
	    	 <lable>
        	<span>设备名称</span>
               <input id="epuName" type="text" name="epuName" value="" />
    	</lable>
<!-- 	   <lable> -->
<!--         	<span>故障发生时间</span> -->
<!--            <input id="falutOccurrenceTime" type="text" name="falutOccurrenceTime" value="" onClick="WdatePicker()"/> -->
<!--     	</lable> -->
    	<lable>       
        	<span>故障原因 </span>
              <select id="falutReason" name="falutReason" >
            	<option></option>
            	<c:forEach items="${falutReasonMap}" var="map">  
				  <option value="${map.key}">${map.value}</option>
				</c:forEach>
            </select>
    	</lable>
<!--     	 <lable> -->
<!--         	<span>是否修复</span> -->
<!--             <select id="isFalut" name="isFalut" > -->
<!--             	<option></option> -->
<%--             	<c:forEach items="${isFalutMap}" var="map">   --%>
<%-- 				 	 <option value="${map.key}">${map.value}</option> --%>
<%-- 				</c:forEach> --%>
<!--             </select> -->
<!--     	</lable> -->
<!--     	  <lable> -->
<!--         	<span>故障修复时间</span> -->
<!--              <input id="falutRepairTime" type="text" name="falutRepairTime" value="" onClick="WdatePicker()"/> -->
<!--     	</lable> -->
<!--           	 <lable> -->
<!--         	<span>是否取消</span> -->
<!--             <select id="isCancelled" name="isCancelled" > -->
<!--             	<option></option> -->
<%--             	   	<c:forEach items="${isCancelledMap}" var="map">   --%>
<%-- 				 	 <option value="${map.key}">${map.value}</option> --%>
<%-- 				</c:forEach> --%>
<!--             </select> -->
<!--     	</lable> -->
        <div class="but-nav">
        	<button type="button"  onclick="javascript:initList();"       class="btn btn-primary" style="background-color: #169274;">查询</button>
        </div>
	</div>
    <!--搜索结束/-->
    <!--表格开始-->
    <div class="table-box">
        <table width="100%">
            <tr>   
							<th>设备名称</th>
							<th>故障原因</th>
							<th>故障发生时间</th>
							<th>是否取消</th>
							<th>是否修复</th>
							<th>修复时间</th>						
				
            </tr>
           <tbody id="faultListTable"></tbody>
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
  </body>
</html>
