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


so.initFaultTypeList = function initFaultTypeList() {
    var basePath = getRootPath_web();
    var codeTypes = "F0001,F0002,F0003,F0004";//默认所有
    var action = $.trim($("#action").val()||"");
    switch(action){
	    case "branchBox":
	    	codeTypes = "F0002";// 表箱
	    	break;
	    case "ammeter":
	    	codeTypes = "F0001";// 电表
	    	break;
    }
    $.ajax({
        type: "post",
        url: basePath + "/fault/faultTypeList.shtml",
        data: {codeTypes:codeTypes},
        async: true,
        dataType: "json",
        cache: false,
        error: function(a, b, c) {},
        success: function(data) {
            if (data) {
                if (null != data && data.length > 0) {
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
	$("#loadingDiv").show();
    var basePath = getRootPath_web();
    var cation =  $.trim($("#action").val()||"");
    $.ajax({
        url: basePath + "/fault/queryList.shtml",
        type: 'POST',
        dataType: 'json',
        async: true,
        data: {
            row_name: $.trim($("#row_name").val()),
            fault_type: $.trim($("#fault_type").val()),
            strKeyArray : $.trim($("#strKeyArray").val()||""),
            str_occur_time : $.trim($("#str_occur_time").val()||""),
            is_repaired : $.trim($("#is_repaired").val()||""),
            action : $.trim($("#action").val()||""),
            pageNo: pageNo,
            pageSize: 10
        },
        success: function(data) {
            var page = data.page;
            var tbody = '';
            if (page != null) {
                var faultList = page.list;
                if (faultList != null && faultList.length > 0) {
                    for (var i = 0; i < faultList.length; i++) {
                        var json = faultList[i];
                        var occur_time = "";
                        if(json.occur_time){
                        	if(null != json.occur_time && "" != json.occur_time){
                        		 occur_time =  (new Date(json.occur_time)).Format("yyyy-MM-dd hh:mm:ss");
                        	}
                        }
                        var repair_time = "";
                        if(json.repair_time){
                        	if(null != json.repair_time && "" != json.repair_time){
                        		repair_time =  (new Date(json.repair_time)).Format("yyyy-MM-dd hh:mm:ss");
                        	}
                        }
                        tbody += '<tr>';
                        tbody += '<td align="center"><div>' + (json.row_name || "") + '</div></td>';
                        tbody += '<td align="center"><div>' + (json.epu_type_name || "") + '</div></td>';
                        tbody += '<td align="center"><div>' + (json.faultTypeName || "") + '</div></td>';
                        tbody += '<td align="center"><div>' + occur_time + '</div></td>';
                        tbody += '<td align="center"><div>' + (json.is_cancelled_name || "") + '</div></td>';
                        tbody += '<td align="center"><div>' + (json.is_repaired_name || "") + '</div></td>';
                        tbody += '<td align="center"><div>' + repair_time + '</div></td>';
                        tbody += '<td align="center"><div>' + (json.epu_province_name|| "") + '</div></td>';
                        tbody += '<td align="center"><div>' + (json.epu_city_name || "") + '</div></td>';
                        tbody += '<td align="center"><div>' + (json.epu_district_name || "") + '</div></td>';
                        tbody += '<td align="center"><div><a href="javascript:showFaultBase(\''+json.id+'\',\''+cation+'\');">故障来源</a></div></td>';
                        tbody += '</tr>';
                    }
                    var a = page.pageHtml;
                    var b = a.substring(0, a.lastIndexOf('\<script'));
                    var pageHtml = b.replace(/_submitform/g, 'initList');
                    $(".pagination").html(pageHtml);
                }
                $("#faultListTable").html(tbody);
                //分页
                // TRADEZONE_MANAGE_PAGE.totalCount = data.recordsTotal;
            } else {
                //分页
                //TRADEZONE_MANAGE_PAGE.totalCount = 0;
            }
            $(".loading").hide();
            // PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
            //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
            //PAGINATION_UTIL.pagination(currentPage);
        },
        error: function() {
            //分页
            /*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
	                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
	                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
	                PAGINATION_UTIL.pagination(currentPage); */
            $(".loading").hide();
        }
    });
};
/**
 * 故障来源
 * **/
function showFaultBase(fault_base_id,cation){
	$("#loadingDiv").show();
	$.post(getRootPath_web() + '/fault/ajax_faultDetails',{fault_base_id:fault_base_id,cation:cation},function(result){
		$("#loadingDiv").hide();
		if(cation == "all"){
			$("#showFaultBase").html(result).show();
		}else  if(cation == "topo"){
			parent.$("#showFaultBase").html(result).show();
		}else  if(cation == "ammeter"){
			parent.$("#messageAmmeter").hide();
			parent.$("#showFaultBase").html(result).show();
		}else if(cation == "branchBox"){
			parent.$("#messageBranchBox").hide();
			parent.$("#showFaultBase").html(result).show();
		}
	});
}
