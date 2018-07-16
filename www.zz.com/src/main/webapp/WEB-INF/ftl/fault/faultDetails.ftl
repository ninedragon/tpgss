<div class="box" style="width: 800px;">
	<h4 style="margin-left:-30px;width: 830px;">
		故障来源<span class="close-js" onclick="closeFalutDetails('${cation}');">关闭</span>
	</h4>
	<!-- 资料编辑开始-->
	<div class="edit">
		<!-- 短路电流t_short_i     1 -->
		<#if faultSourceMap["1"] !=''>
		<div class="table-box" style="margin:0px 0px 0px 0px;">
			<h3
				style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
				短路电流</h3>
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
		<script>
			function t_short_i_initList(pageNo) {
				$("#loadingDiv").show();
				var cation = $.trim($("#action").val() || "");
				$.ajax({
					url : "${basePath}/shortI/queryList.shtml",
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						record_ids : "${faultSourceMap['1']}",
						pageNo : pageNo,
						pageSize : 10
					},
					success : function(data) {
						var page = data.page;
						var tbody = '';
						if (page != null) {
							var faultList = page.list;
							if (faultList != null && faultList.length > 0) {
								for (var i = 0; i < faultList.length; i++) {
									var json = faultList[i];
									 var cRecordinserttime = getTime(json,"cRecordinserttime","yyyy-MM-dd hh:mm:ss");
									 var occurtime = getTime(json,"occurtime","yyyy-MM-dd hh:mm:ss");
									tbody += '<tr>';
									tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cChannelid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + cRecordinserttime + '</div></td>';
									tbody += '<td align="center"><div>' + occurtime + '</div></td>';
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
					error : function() {
						//分页
						/*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
								                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
								                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
								                PAGINATION_UTIL.pagination(currentPage); */
						$(".loading").hide();
					}
				});
		
			}
			;
			t_short_i_initList();
		</script>
		</#if> 
		<!-- 周期漏电t_leakage_i  2 -->
		<#if faultSourceMap["2"] !=''>
		<div class="table-box" style="margin:0px 0px 0px 0px;">
			<h3
				style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
				周期漏电</h3>
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
		<script>
			function t_leakage_i_initList(pageNo) {
				$("#loadingDiv").show();
				var cation = $.trim($("#action").val() || "");
				$.ajax({
					url : "${basePath}/leakageI/queryList.shtml",
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						record_ids : "${faultSourceMap['2']}",
						pageNo : pageNo,
						pageSize : 10
					},
					success : function(data) {
						var page = data.page;
						var tbody = '';
						if (page != null) {
							var faultList = page.list;
							if (faultList != null && faultList.length > 0) {
								for (var i = 0; i < faultList.length; i++) {
									var json = faultList[i];
									var cRecordinserttime = getTime(json,"cRecordinserttime","yyyy-MM-dd hh:mm:ss");
									tbody += '<tr>';
									tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cChannelid + '</div></td>';
									tbody += '<td align="center"><div>' + json.tsegmentid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
									tbody += '<td align="center"><div>' + json.recorddatebcd + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + cRecordinserttime + '</div></td>';
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
					error : function() {
						//分页
						/*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
								                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
								                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
								                PAGINATION_UTIL.pagination(currentPage); */
						$(".loading").hide();
					}
				});
		
			}
			;
			t_leakage_i_initList();
		</script>
		</#if>
		<#if faultSourceMap["3"] !=''>
		<!-- 异常电压ableakageI  3-->
		<!--表格开始-->
		<div class="table-box" style="margin: 0px 0px 0px 0px;">
			<h3
				style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
				异常漏电</h3>
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
		<!-- 异常电压ableakageI  3-->
		<script>
			function t_ableakage_i_initList(pageNo) {
				$("#loadingDiv").show();
				var cation = $.trim($("#action").val() || "");
				$.ajax({
					url : "${basePath}/ableakageI/queryList.shtml",
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						record_ids : "${faultSourceMap['3']}",
						pageNo : pageNo,
						pageSize : 10
					},
					success : function(data) {
						var page = data.page;
						var tbody = '';
						if (page != null) {
							var faultList = page.list;
							if (faultList != null && faultList.length > 0) {
								for (var i = 0; i < faultList.length; i++) {
									var json = faultList[i];
									var cRecordinserttime = getTime(json,"cRecordinserttime","yyyy-MM-dd hh:mm:ss");
									var occurtime = getTime(json,"occurtime","yyyy-MM-dd hh:mm:ss");
									tbody += '<tr>';
									tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cChannelid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + json.isAbnormal + '</div></td>';
									tbody += '<td align="center"><div>' + cRecordinserttime + '</div></td>';
									tbody += '<td align="center"><div>' + occurtime + '</div></td>';
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
					error : function() {
						//分页
						/*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
								                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
								                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
								                PAGINATION_UTIL.pagination(currentPage); */
						$(".loading").hide();
					}
				});
		
			}
			;
			t_ableakage_i_initList();
		</script>
		</#if>
		<!-- 异常漏电t_abnormal_u  4-->
		<#if faultSourceMap["4"] !=''>
		<div class="table-box" style="margin: 0px 0px 0px 0px;">
			<h3
				style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
				异常电压</h3>
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
		<script>
			function abnormal_u_initList(pageNo) {
				$("#loadingDiv").show();
				var cation = $.trim($("#action").val() || "");
				$.ajax({
					url : "${basePath}/abnormalU/queryList.shtml",
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						record_ids : "${faultSourceMap['4']}",
						pageNo : pageNo,
						pageSize : 10
					},
					success : function(data) {
						var page = data.page;
						var tbody = '';
						if (page != null) {
							var faultList = page.list;
							if (faultList != null && faultList.length > 0) {
								for (var i = 0; i < faultList.length; i++) {
									var json = faultList[i];
									var cRecordinserttime = getTime(json,"cRecordinserttime","yyyy-MM-dd hh:mm:ss");
									var occurtime = getTime(json,"occurtime","yyyy-MM-dd hh:mm:ss");
									tbody += '<tr>';
									tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.ua || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.ub || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.uc || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + cRecordinserttime + '</div></td>';
									tbody += '<td align="center"><div>' + occurtime + '</div></td>';
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
					error : function() {
						//分页
						/*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
								                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
								                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
								                PAGINATION_UTIL.pagination(currentPage); */
						$(".loading").hide();
					}
				});
			}
			;
			abnormal_u_initList();
		</script>
		</#if>
		<!-- 异常阻抗t_abnormal_z   5 -->
		<#if faultSourceMap["5"] !=''>
		<div class="table-box" style="margin:0px 0px 0px 0px;">
			<h3
				style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
				异常阻抗</h3>
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
		<script>
			function t_abnormal_z_initList(pageNo) {
				$("#loadingDiv").show();
				var cation = $.trim($("#action").val() || "");
				$.ajax({
					url : "${basePath}/abnormalZ/queryList.shtml",
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						record_ids : "${faultSourceMap['5']}",
						pageNo : pageNo,
						pageSize : 10
					},
					success : function(data) {
						var page = data.page;
						var tbody = '';
						if (page != null) {
							var faultList = page.list;
							if (faultList != null && faultList.length > 0) {
								for (var i = 0; i < faultList.length; i++) {
									var json = faultList[i];
									var cRecordInsertTime = getTime(json,"cRecordInsertTime","yyyy-MM-dd hh:mm:ss");
									tbody += '<tr>';
									tbody += '<td align="center"><div>' + json.cDistrictBCDId + '</div></td>';
									tbody += '<td align="center"><div>' + json.cAddressId + '</div></td>';
									tbody += '<td align="center"><div>' + json.cChannelId + '</div></td>';
									tbody += '<td align="center"><div>' + json.cFrameCmdId + '</div></td>';
									tbody += '<td align="center"><div>' + cRecordInsertTime + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.ua || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.ub || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.uc || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.p || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.q || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i || 0).toFixed(2) + '</div></td>';
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
					error : function() {
						//分页
						/*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
								                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
								                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
								                PAGINATION_UTIL.pagination(currentPage); */
						$(".loading").hide();
					}
				});
		
			}
			;
			t_abnormal_z_initList();
		</script>
		</#if>
		<!-- 电源质量t_power_quality   6 -->
		<#if faultSourceMap["6"] !=''>
		<div class="table-box" style="margin:0px 0px 0px 0px;">
			<h3
				style="width:100%; float:left; font-size:20px; color:#333; text-align:left; border-bottom:1px solid #EEE; padding:0px 0px 10px 0px;">
				电源质量</h3>
			<table width="100%">
				<tr>
				<th>C_DistrictBCDId</th>
				<th>C_AddressId</th>
				<th>C_FrameCmdId</th>
				<th>C_RecordInsertTime</th>
				<th>C_FaultId</th>
				<th>ua</th>
				<th>ub</th>
				<th>uc</th>
				<th>RecordDateBCD</th>
				<th>TSegmentId</th>
				<th>C_ChannelId</th>
				<th>p</th>
				<th>q</th>
				<th>i1</th>
				<th>i2</th>
				<th>i3</th>
				<th>i4</th>
				<th>i5</th>
				<th>i6</th>
				<th>i7</th>
				</tr>
				<tbody id="t_power_quality_tbody"></tbody>
			</table>
		</div>
		<!--表格结束开始-->
		<!--     分页开始 -->
		<div class="pagination pull-right t_power_quality"></div>
		<!-- 分页结束/ -->
		<script>
			function t_power_quality_initList(pageNo) {
				$("#loadingDiv").show();
				var cation = $.trim($("#action").val() || "");
				$.ajax({
					url : "${basePath}/powerQuality/queryList.shtml",
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						record_ids : "${faultSourceMap['6']}",
						pageNo : pageNo,
						pageSize : 10
					},
					success : function(data) {
						var page = data.page;
						var tbody = '';
						if (page != null) {
							var faultList = page.list;
							if (faultList != null && faultList.length > 0) {
								for (var i = 0; i < faultList.length; i++) {
									var json = faultList[i];
									var cRecordinserttime = getTime(json,"cRecordinserttime","yyyy-MM-dd hh:mm:ss");
									tbody += '<tr>';
									tbody += '<td align="center"><div>' + json.cDistrictbcdid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cAddressid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cFramecmdid + '</div></td>';
									tbody += '<td align="center"><div>' + cRecordinserttime + '</div></td>';
									tbody += '<td align="center"><div>' + json.cFaultid + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.ua || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.ub || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.uc || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + json.recorddatebcd + '</div></td>';
									tbody += '<td align="center"><div>' + json.tsegmentid + '</div></td>';
									tbody += '<td align="center"><div>' + json.cChannelid + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.p || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.q || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i1 || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i2 || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i3 || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i4 || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i5 || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i6 || 0).toFixed(2) + '</div></td>';
									tbody += '<td align="center"><div>' + parseFloat(json.i7 || 0).toFixed(2) + '</div></td>';
									tbody += '</tr>';
								}
								var a = page.pageHtml;
								var b = a.substring(0, a.lastIndexOf('\<script'));
								var pageHtml = b.replace(/_submitform/g, 't_abnormal_z_initList');
								$(".t_power_quality").html(pageHtml);
							}
							$("#t_power_quality_tbody").html(tbody);
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
					error : function() {
						//分页
						/*   TRADEZONE_MANAGE_PAGE.totalCount = 0;
								                PAGINATION_UTIL.callbackObj = TRADEZONE_MANAGE_PAGE; //一定要有这句
								                //PAGINATION_UTIL.inputName = "startPage";//一个页面有多个列表时需要这个值不一样
								                PAGINATION_UTIL.pagination(currentPage); */
						$(".loading").hide();
					}
				});
		
			}
			;
			t_power_quality_initList();
		</script>
		</#if>
		<div class="but-nav">
			<span class="but miss close-js"
				onclick="closeFalutDetails('${cation}');">关&nbsp;&nbsp;闭</span>
		</div>
	</div>
</div>
<script>
	/**
	*关闭弹出层
	**/
	function closeFalutDetails(cation) {
		$('#showFaultBase').hide();
		if (cation == "ammeter") {
			parent.$("#messageAmmeter").show();
		} else if (cation == "branchBox") {
			parent.$("#messageBranchBox").show();
		}
	}
	/**
	*获取格式化的时间
	*/
	function getTime(json,key,formatStyle){
		 var time = "";
         if(json[key]){
         	if(null != json[key] && "" != json[key]){
         		time =  (new Date(json[key])).Format(formatStyle);
         	}
         }
         return time;
     }
</script>
