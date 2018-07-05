
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
so.init(function(){
	so.initFaultTypeList();
	initList();
});

so.initFaultTypeList= function initFaultTypeList() {
	var basePath = getRootPath_web() ;
    $.ajax({
        type: "post",
        url:  basePath + "/fault/faultTypeList.shtml",
        data: {
        },
        async:true,
        dataType: "json",
        cache: false,
        error: function (a,b,c) {
        },
        success: function (data) {
        	if(data){
	            if(null != data && data.length >0){
	            	var length = data.length;
		            $('#fault_type').html('<option value="">--请选择--</option>');
		            for (var i = 0; i < length; i++) {
		                $('#fault_type').append('<option value="' + data[i].code + '">' + data[i].code_NAME + '</option>');
		            }
	            }
        	}
        }
    });
};
function initList(pageNo) {
		var basePath = getRootPath_web() ;
	    	 $("#loadingDiv").show(); 
	        $.ajax({
	            url: basePath + "/fault/queryList.shtml",
	            type: 'POST',
	            dataType: 'json',
	            async:true,
	            data: {	
	            	row_name : $.trim($("#row_name").val()),
	            	fault_type : $.trim($("#fault_type").val()),
	                pageNo:pageNo,
	            	pageSize:10
	            },
	            success: function (data) {
	            	var page=data.page;
	                var tbody = '';
	                if (page != null ) {
	                    var faultList = page.list;
	                    if (faultList!=null && faultList.length>0) {
	                        for (var i = 0; i < faultList.length; i++) {			                            
	         	             	var json = faultList[i];
	        	                 tbody += '<tr>';
	        	                 tbody += '<td align="center"><div>' + json.row_name+ '</div></td>';
	        	                 tbody += '<td align="center"><div>' + json.epu_type_name + '</div></td>';
	        	                 tbody += '<td align="center"><div>' + json.faultTypeName + '</div></td>';
	        	                 tbody += '<td align="center"><div>' + json.occur_time+ '</div></td>';
	        	                 tbody += '<td align="center"><div>' + json.is_cancelled_name+ '</div></td>';
	        	                 tbody += '<td align="center"><div>' + json.is_repaired_name + '</div></td>';			                            
	        	                 tbody += '<td align="center"><div>' + json.repair_time+ '</div></td>';
	        	                 tbody += '<td align="center"><div>' + json.epu_province_name+ '</div></td>';
	        	                 tbody += '<td align="center"><div>' + json.epu_city_name + '</div></td>';			                            
	        	                 tbody += '<td align="center"><div>' + json.epu_district_name+ '</div></td>';
	        	                 tbody += '</tr>';					                            
	                        }
	                          var a = page.pageHtml;
							var b = a.substring(0,a.lastIndexOf('\<script'));  
	                        var pageHtml=b.replace(/_submitform/g,'initList');
	                       $(".pagination").html(pageHtml);
	                         $("#loadingDiv").hide(); 
	                    }
	                     $("#faultListTable").html(tbody);
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