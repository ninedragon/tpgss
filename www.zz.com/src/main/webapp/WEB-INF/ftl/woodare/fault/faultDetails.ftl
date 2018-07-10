<div class="box" style="width: 800px;">
    	<h4 style="margin-left:-30px;width: 830px;">故障来源<span class="close-js" onclick="closeFalutDetails('${cation}');">关闭</span></h4>
        <!-- 资料编辑开始-->
   		<div class="edit">
            <!--表格开始-->
   			 <div class="table-box" style="margin: 0px 0px 0px 0px;">
            	<h3 style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
            	异常电压
            	</h3>
		        <table width="100%">
		            <tr>   
		            	<th>C_DistrictBCDId</th>
						<th>C_AddressId</th>
						<th>C_ChannelId</th>
						<th>C_FrameCmdId</th>
						<th>i</th>
						<th>is_abnormal</th>
						<th>C_RecordInsertTime</th>
						<th>occurTime</th>
						<th>C_FaultId</th>
		            </tr>
		           <tbody id="t_ableakage_i_tbody"></tbody>
		        </table>
   			 </div>
   			  <!--表格结束开始-->
   			 <!--     分页开始 -->
		      <div class="pagination pull-right t_ableakage_i"></div>
		      <!-- 分页结束/ -->
   			 <div class="table-box" style="margin: 0px 0px 0px 0px;">
   				<h3 style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
   				异常漏电
   				</h3>
		        <table width="100%">
		             <tr>   
		            	<th>C_DistrictBCDId</th>
						<th>C_AddressId</th>
						<th>C_FrameCmdId</th>
						<th>ua</th>
						<th>ub</th>
						<th>uc</th>
						<th>C_RecordInsertTime</th>
						<th>occurTime</th>
						<th>C_FaultId</th>
						<th>is_abnormal</th>
		            </tr>
		           <tbody id="t_abnormal_u_tbody"></tbody>
		        </table>
   			 </div>
   			  <!--表格结束开始-->
   			 <!--     分页开始 -->
		      <div class="pagination pull-right t_abnormal_u"></div>
		      <!-- 分页结束/ -->
   			 <div class="table-box" style="margin:0px 0px 0px 0px;">
   			 	<h3 style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
   			 	异常阻抗
   			 	</h3>
		        <table width="100%">
		            <tr>   
						<th>C_DistrictBCDId</th>
						<th>C_AddressId</th>
						<th>C_ChannelId</th>
						<th>C_FrameCmdId</th>
						<th>C_RecordInsertTime</th>
						<th>ua</th>
						<th>ub</th>
						<th>uc</th>
						<th>p</th>
						<th>q</th>
						<th>i</th>
						<th>C_FaultId</th>
						<th>TSegmentId</th>
						<th>RecordDateBCD</th>
		            </tr>
		         <tbody id="t_abnormal_z_tbody"></tbody>
		        </table>
   			 </div>
   			  <!--表格结束开始-->
   			 <!--     分页开始 -->
		      <div class="pagination pull-right t_abnormal_z"></div>
		      <!-- 分页结束/ -->
   			  <div class="table-box" style="margin:0px 0px 0px 0px;">
   			 	<h3 style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
   			 	周期漏电
   			 	</h3>
		        <table width="100%">
		            <tr>   
							<th>C_DistrictBCDId</th>
							<th>C_AddressId</th>
							<th>C_ChannelId</th>
							<th>TSegmentId</th>
							<th>C_FrameCmdId</th>
							<th>RecordDateBCD</th>
							<th>i</th>
							<th>C_RecordInsertTime</th>
							<th>C_FaultId</th>
		            </tr>
		        <tbody id="t_leakage_i_tbody"></tbody>
		        </table>
   			 </div>
   			  <!--表格结束开始-->
   			 <!--     分页开始 -->
		      <div class="pagination pull-right t_leakage_i"></div>
		      <!-- 分页结束/ -->
   			 	  <div class="table-box" style="margin:0px 0px 0px 0px;">
   			 	<h3 style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
   			 	短路电流
   			 	</h3>
		        <table width="100%">
		            <tr>   
							<th>C_DistrictBCDId</th>
							<th>C_AddressId</th>
							<th>C_ChannelId</th>
							<th>C_FrameCmdId</th>
							<th>i</th>
							<th>C_RecordInsertTime</th>
							<th>occurTime</th>
							<th>C_FaultId</th>
		            </tr>
		  		        <tbody id="t_short_i_tbody"></tbody>
		        </table>
   			 </div>
   			  <!--表格结束开始-->
   			 <!--     分页开始 -->
		      <div class="pagination pull-right t_short_i"></div>
		      <!-- 分页结束/ -->
            <div class="but-nav">
                <span class="but miss close-js"  onclick="closeFalutDetails('${cation}');">关&nbsp;&nbsp;闭</span>
            </div>
        </div>
    </div>
	<!-- 异常电压 -->
	<#if faultSourceMap["t_abnormal_u"] !=''>
		<script>
			function abnormal_u_initList(pageNo) {
				$("#loadingDiv").show();
			    var cation =  $.trim($("#action").val()||"");
			    $.ajax({
			        url: "${basePath}/abnormalU/queryList.shtml",
			        type: 'POST',
			        dataType: 'json',
			        async: true,
			        data: {
			        	record_ids: "${faultSourceMap['t_abnormal_u']}",
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
			                        tbody += '<tr>';
			                        tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.ua + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.ub + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.uc + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.strCRecordinserttime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.strOccurTime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFaultid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.isAbnormal + '</div></td>';
			                        tbody += '</tr>';
			                    }
			                    var a = page.pageHtml;
			                    var b = a.substring(0, a.lastIndexOf('\<script'));
			                    var pageHtml = b.replace(/_submitform/g, 'abnormal_u_initList');
			                    $(".t_abnormal_u").html(pageHtml);
			                }
			                $("#t_abnormal_u_tbody").html(tbody);
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
			abnormal_u_initList();
		</script>
	</#if>
	<!-- 异常漏电 -->
	<#if faultSourceMap["t_ableakage_i"] !=''>
		<script>
			function t_ableakage_i_initList(pageNo) {
				$("#loadingDiv").show();
			    var cation =  $.trim($("#action").val()||"");
			    $.ajax({
			        url: "${basePath}/ableakageI/queryList.shtml",
			        type: 'POST',
			        dataType: 'json',
			        async: true,
			        data: {
			        	record_ids: "${faultSourceMap['t_ableakage_i']}",
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
			                        tbody += '<tr>';
			                        tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cChannelid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.i + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.isAbnormal + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.strCRecordinserttime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.strOccurTime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFaultid + '</div></td>';
			                        tbody += '</tr>';
			                    }
			                    var a = page.pageHtml;
			                    var b = a.substring(0, a.lastIndexOf('\<script'));
			                    var pageHtml = b.replace(/_submitform/g, 't_ableakage_i_initList');
			                    $(".t_ableakage_i").html(pageHtml);
			                }
			                $("#t_ableakage_i_tbody").html(tbody);
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
			t_ableakage_i_initList();
		</script>
	</#if>
	<!-- 异常阻抗 -->
	<#if faultSourceMap["t_abnormal_z"] !=''>
		<script>
			function t_abnormal_z_initList(pageNo) {
				$("#loadingDiv").show();
			    var cation =  $.trim($("#action").val()||"");
			    $.ajax({
			        url: "${basePath}/abnormalZ/queryList.shtml",
			        type: 'POST',
			        dataType: 'json',
			        async: true,
			        data: {
			        	record_ids: "${faultSourceMap['t_abnormal_z']}",
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
			                        tbody += '<tr>';
			                        tbody += '<td align="center"><div>' + json.cDistrictBCDId + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cAddressId + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cChannelId + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFrameCmdId + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cRecordInsertTime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.ua + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.ub + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.uc + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.p + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.q + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.i + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFaultId + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.tSegmentId + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.recordDateBCD + '</div></td>';
			                        tbody += '</tr>';
			                    }
			                    var a = page.pageHtml;
			                    var b = a.substring(0, a.lastIndexOf('\<script'));
			                    var pageHtml = b.replace(/_submitform/g, 't_abnormal_z_initList');
			                    $(".t_abnormal_z").html(pageHtml);
			                }
			                $("#t_abnormal_z_tbody").html(tbody);
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
			t_abnormal_z_initList();
		</script>
	</#if>
	<!-- 周期漏电 -->
	<#if faultSourceMap["t_leakage_i"] !=''>
		<script>
			function t_leakage_i_initList(pageNo) {
				$("#loadingDiv").show();
			    var cation =  $.trim($("#action").val()||"");
			    $.ajax({
			        url: "${basePath}/leakageI/queryList.shtml",
			        type: 'POST',
			        dataType: 'json',
			        async: true,
			        data: {
			        	record_ids: "${faultSourceMap['t_leakage_i']}",
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
			                        tbody += '<tr>';
			                        tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cChannelid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.tsegmentid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.recorddatebcd + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.i + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.strCRecordinserttime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFaultid + '</div></td>';
			                        tbody += '</tr>';
			                    }
			                    var a = page.pageHtml;
			                    var b = a.substring(0, a.lastIndexOf('\<script'));
			                    var pageHtml = b.replace(/_submitform/g, 't_leakage_i_initList');
			                    $(".t_leakage_i").html(pageHtml);
			                }
			                $("#t_leakage_i_tbody").html(tbody);
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
			t_leakage_i_initList();
		</script>
	</#if>
	<!-- 短路电流 -->
	<#if faultSourceMap["t_short_i"] !=''>
		<script>
			function t_short_i_initList(pageNo) {
				$("#loadingDiv").show();
			    var cation =  $.trim($("#action").val()||"");
			    $.ajax({
			        url: "${basePath}/shortI/queryList.shtml",
			        type: 'POST',
			        dataType: 'json',
			        async: true,
			        data: {
			        	record_ids: "${faultSourceMap['t_short_i']}",
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
			                        tbody += '<tr>';
			                        tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cChannelid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.i + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.strCRecordinserttime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.strOccurtime + '</div></td>';
			                        tbody += '<td align="center"><div>' + json.cFaultid + '</div></td>';
			                        tbody += '</tr>';
			                    }
			                    var a = page.pageHtml;
			                    var b = a.substring(0, a.lastIndexOf('\<script'));
			                    var pageHtml = b.replace(/_submitform/g, 't_short_i_initList');
			                    $(".t_short_i").html(pageHtml);
			                }
			                $("#t_short_i_tbody").html(tbody);
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
			t_short_i_initList();
		</script>
	</#if>
		<script>
			/**
			*关闭弹出层
			**/
			function closeFalutDetails(cation){
				$('#showFaultBase').hide();
				if(cation == "ammeter"){
					parent.$("#messageAmmeter").show();
				}else if(cation == "branchBox"){
					parent.$("#messageBranchBox").show();
				}
			}
		</script>