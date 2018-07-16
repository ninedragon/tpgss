var SVG_HELPER = (function() {
    var iv = 10;
    var thisSvgObj = null;//当前SVG对象
    function drawSvg(svgModelData, el) {
        $("#Snap_Layer").remove();
        d3.namespace("xmlns:cge", "http://iec.ch/TC57/2005/SVG-schema#");
        var svgSnap = d3.select(el || "body").append("svg");
        svgSnap.attr("width", 6000).attr("height", 1700).attr("xmlns", "http://www.w3.org/2000/svg").attr("xmlns:xlink", "http://www.w3.org/1999/xlink").attr("xmlns:cge", "http://iec.ch/TC57/2005/SVG-schema#");
        var layerSnap = svgSnap.html("g").attr("id", "Snap_Layer");
        var startID = null; //"76c0acfe-cf97-4e5b-b966-9664bc252136";
        var list = [];
        // "M0001"
        $(svgModelData).each(function() {
            if (this.epuType == "M0001") {
                if (!startID || startID == this.rowId) {
                    list.push(this);
                }
            }
        });

        $(list).each(function() {
            getChildren(this);
        });
        var w1 = 0;
        var leftPad = 500;
        var x1 = leftPad;
        var x2 = leftPad;
        var x3 = leftPad;
        var x4 = leftPad;
        
        var branchboxXYArray = new Array();//分支箱XY坐标
        var keyArray = new Array();//故障定位所需key_id
        var keyJsonArray = new Array();//故障定位所需除电表所有节点信息
        var branchboxIDArray = new Array();//topo错误数据所需分支箱key_id
        var  outgoingCabinetArray = new Array();//出线柜ID
        $(list).each(function() {
            var w2 = 0;
            $(this.children).each(function() {
                var cids1 = [];
                var w3 = 0;
                $(this.children).each(function() {
                    var cIds = [];
                    var w4 = 0;
                    var branchboxID = this.rowId;
                    $(this.children).each(function() {
                    	keyArray.push(this.rowId); //M0004
                    	keyJsonArray.push({key:this.rowId,epuName:this.epuName}); //M0004
                    	getNextAmmeterId("M0005",this.rowId,svgModelData,keyArray);//电表(epuId根据这个找下级)
                        //M0004
                        this._x = x4;
                        this._y = 900;
                        createMeterBox(layerSnap, this.rowId, this._x, this._y, this.epuName);
                        x4 += this.width;
                        w4 += this.width;
                        cIds.push(this.rowId);
                        //组织表箱图标
                        var svgimg = setSvgimg("100", "100", "../woodare/image/boxImg.png", (this._x - 4), (this._y - 6), "meterboxImg_" + this.rowId);
                        $("#Snap_Layer").append(svgimg).find("g[id='meterbox_" + this.rowId + "'],image[id='meterboxImg_" + this.rowId + "']").attr("epuName", this.epuName).click(function() {
                            showAmmeter(this, svgModelData);
                        });
                    });
                    keyArray.push(this.rowId); //M0003 
                    keyJsonArray.push({key:this.rowId,epuName:this.epuName}); //M0003 
                    branchboxIDArray.push(branchboxID); //M0003 
                    //M0003
                    var tmpX = x3 + (w4 > this.width ? ((w4 - this.width) / 2) : 0);
                    this._x = tmpX;
                    this._y = 650;
                    createBox(layerSnap, this.rowId, this._x, this._y, this.epuName, cIds, "M0003",this.children);
                    x3 += Math.max(this.width, w4);
                    cids1.push(this.rowId);
                    x4 = Math.max(x4, x3);
                    w3 += Math.max(this.width, w4);
                    // 划线
                    var px = this._x;
                    var py = this._y;
                    var gird = 300 / (cIds.length + 1);
                    var half = cIds.length / 2
                    var h = 20;
                    $(this.children).each(function(index) {
                        if (this._x + 45 <= px + (index + 1) * gird || index < half) {
                            h = h + iv;
                        } else {
                            h = h - iv;
                            if (h < 0) {
                                h = 20;
                            }
                        }
                        createLineEl(layerSnap, {
                            x: this._x + 45,
                            y: this._y,
                            id: this.rowId,
                            x2: px + (index + 1) * gird,
                            y2: py + 180,
                            h: h
                        });
                    });

                });

                var tmpX = x2 + (w3 > this.width ? ((w3 - this.width) / 2) : 0);
                keyArray.push(this.rowId); //M0002
                keyJsonArray.push({key:this.rowId,epuName:this.epuName}); //M0002
                outgoingCabinetArray.push(this.rowId); //M0002
                //M0002
                this._x = tmpX;
                this._y = 300;
                createBox(layerSnap, this.rowId, this._x, this._y, this.epuName, cids1, "M0002",this.children);
                x2 += Math.max(this.width, w3) + 120; //加120 控制间距
                x3 = Math.max(x2, x3);
                x4 = Math.max(x4, x3);
                w2 += Math.max(this.width, w3);

                var px = this._x;
                var py = this._y;
                var gird = 300 / (cids1.length + 1);
                var half = cids1.length / 2
                var h = 80;
                var tempX = this._x;
                var tempY = this._y;
                var tempCount = $(this.children).length;
                $(this.children).each(function(index) {
                    if (this._x + 150 <= px + (index + 1) * gird || index < half) {
                        h = h + iv;
                    } else {
                        h = h - iv;
                        if (h < 0) {
                            h = 20;
                        }
                    }
                    createLineEl(layerSnap, {
                        x: this._x + 150,
                        y: this._y,
                        id: this.rowId,
                        x2: px + (index + 1) * gird,
                        y2: py + 180,
                        h: h
                    });
                    //展示table信息
                    branchboxXYArray.push({KEY:this.rowId,X:tempX,Y:tempY,COUNT:tempCount,INDEX:index});

                });
            });
            keyArray.push(this.rowId); //M0001
            keyJsonArray.push({key:this.rowId,epuName:this.epuName}); //M0001
            //M0001
            var tmpX = x1 + (w2 > this.width ? ((w2 - this.width) / 2) : 0);
            this._x = tmpX;
            this._y = 0;
            createXiangbian(layerSnap, this.rowId, this._x, this._y);
            x1 += Math.max(this.width, w2);
            x2 = Math.max(x2, x1);
            x3 = Math.max(x2, x3);
            x4 = Math.max(x4, x3);
            w1 += Math.max(this.width, w2);
            // 划线
            var px = this._x;
            var py = this._y;
            $(this.children).each(function(index) {
                createLineEl(layerSnap, {
                    x: this._x + 150,
                    y: this._y,
                    id: this.rowId,
                    x2: px + 64,
                    y2: py + 112,
                    h: 20
                });
            });
        });
        svgSnap.attr("width", w1 + leftPad + 100);
        var rowId = parent.$(".all li[class='on']").attr("id").replace("tab_", "");
        parent.$("#" + rowId + "Iframe").attr("height", svgSnap.attr("height")); //设置主体IFRAME的宽度
        parent.$("#" + rowId + "Iframe").attr("width", w1 + leftPad + 100); //设置主体IFRAME的宽度
        var wd = parseFloat($("#wd").val() || 1);
        if (wd < 1) {
            wd = wd.toFixed(1);
        }
        $("#wd").val(wd); //文本框内容缩放级别值
        $("#wdPercentage").val((wd * 100)+"%"); //文本框内容缩放级别值
        svgSnap.attr("transform", "scale(" + wd + " " + wd + ") translate(0 0)");
        // 画左侧标识
        svgSnap.append('text').attr("font-size", "36").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text("箱变").attr("x", 20).attr("y", 100);
        svgSnap.append('text').attr("font-size", "36").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text("出线柜").attr("x", 20).attr("y", 420);
        svgSnap.append('text').attr("font-size", "36").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text("分支箱").attr("x", 20).attr("y", 700);
        svgSnap.append('text').attr("font-size", "36").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text("表箱").attr("x", 20).attr("y", 960);
        thisSvgObj = svgSnap;//当前SVG对象
        
        function getChildren(item) {
            item.children = [];
            $(svgModelData).each(function() {
                if (this.epuParentId == item.rowId) {
                    var self = getChildren(this);
                    item.children.push(self);
                }
            });
            if (item.epuType == 'M0004') {
                item.width = 150;
            } else if (item.epuType == 'M0003') {
                item.width = 400;
            } else if (item.epuType == 'M0002') {
                item.width = 600;
            } else {
                item.width = 100;
            }
            return item;
        }
        return {
            scale: function(zoom) {
                var x = 0;
                var y = 0;
                svgSnap.attr("transform", "scale(" + zoom + " " + zoom + ") translate(" + x + " " + y + ")");
                if (zoom < 1) {
                    zoom = zoom.toFixed(1);
                }
                $("#wd").val(zoom); //文本框内容缩放级别值
                $("#wdPercentage").val((zoom * 100)+"%"); //文本框内容缩放级别值
            },
            topoHeight: function() {
                return svgSnap.attr("height");
            },
            boxError: function(boxErrorArray) {
                for (var i = 0; i < boxErrorArray.length; i++) {
                    var json = boxErrorArray[i];
                    var type = json["type"];
                    var key = json["key"];
                    var epuName = json["epuName"];
                    var faultType = json["faultType"];
                    var faultTypeName = json["faultTypeName"];
                    var error_num = json["error_num"] ||"";
                    $("#Snap_Layer").find("image[id='kaiguanxianImg_" + key + "']").attr("href", "../woodare/image/branchBoxError.png"); //分支箱/出线柜
                    updateBox(key, "error-box");
                    if (null != faultTypeName && "" != faultTypeName) {
                    	chuxianguiTxt(key,epuName,"故障原因:" + faultTypeName,"error");
                    } else {
                    	chuxianguiTxt(key,epuName,"在"+error_num+"个时间段监测出错误","error");
                        
                    }
                }
            },
            boxWarning: function(id) {
                updateBox(id, "warning-box");
            },
            boxClear: function(boxErrorArray) {
                for (var i = 0; i < boxErrorArray.length; i++) {
                    var json = boxErrorArray[i];
                    var key = json["key"];
                    var epuName = json["epuName"];
                    updateBox(key, "");
                    $("#Snap_Layer").find("image[id='kaiguanxianImg_" + key + "']").attr("href", "../woodare/image/branchBox.png"); //分支箱/出线柜
                    chuxianguiTxt(key,epuName,"","");
                    
                }
            },
            kaiguanxianError: function(kaiguanxianErrorArray) {
                for (var i = 0; i < kaiguanxianErrorArray.length; i++) {
                    var json = kaiguanxianErrorArray[i];
                    var type = json["type"];
                    var key = json["key"];
                    var epuName = json["epuName"];
                    var faultType = json["faultType"];
                    var faultTypeName = json["faultTypeName"];
                    var error_num = json["error_num"] ||"";
                    updateKaiguanxian(key, "error");
                    $("#kaiguanxian_line_" + key).find("rect").attr("class", "error");
                    $("#kaiguanxian_line_" + key).find("path").attr("class", "error");
                    $("#Snap_Layer").find("image[id='meterboxImg_" + key + "']").attr("href", "../woodare/image/boxImgError.png"); //电表
                    $("#Snap_Layer").find("image[id='kaiguanxianImg_" + key + "']").attr("href", "../woodare/image/branchBoxError.png"); //分支箱/出线柜
                    $("#meterbox_" + key).find("text").attr("class", "error");
                    if (null != faultTypeName && faultTypeName != "") {
                        meterboxTxt(key,epuName,("故障原因:" + faultTypeName),"error");
                    } else {
                        meterboxTxt(key,epuName,"","");
                        chuxianguiTxt(key,epuName,"在"+error_num+"个时间段监测出错误","error");
                    }

                }
            },
            kaiguanxianWarning: function(kaiguanxianWarningArray) {
                for (var i = 0; i < kaiguanxianWarningArray.length; i++) {
                    var json = kaiguanxianWarningArray[i];
                    var key = json["key"];
                    var epuName = json["epuName"]||"";
                    var error_num = json["error_num"]||"";
                    updateKaiguanxian(key, "warning");
                    chuxianguiTxt(key,epuName,"在"+error_num+"个时间段监测出错误","warning");
                    
                    $("#Snap_Layer").find("image[id='kaiguanxianImg_" + key + "']").attr("href", "../woodare/image/branchBoxBlueError.png"); //分支箱/出线柜
                }

            },
            kaiguanxianClear: function(kaiguanxianErrorArray) {
                for (var i = 0; i < kaiguanxianErrorArray.length; i++) {
                    var json = kaiguanxianErrorArray[i];
                    var key = json["key"];
                    var epuName = json["epuName"];
                    updateKaiguanxian(key, "");
                    $("#kaiguanxian_line_" + key).find("rect").attr("class", "");
                    $("#kaiguanxian_line_" + key).find("path").attr("class", "");
                    $("#Snap_Layer").find("image[id='meterboxImg_" + key + "']").attr("href", "../woodare/image/boxImg.png"); //电表
                    $("#Snap_Layer").find("image[id='kaiguanxianImg_" + key + "']").attr("href", "../woodare/image/branchBox.png"); //分支箱/出线柜
                    meterboxTxt(key,epuName,"","");
                }
            },
            /**
             *展示分支箱TABLE信息 
            **/
            showTabData :  function showTabData(layerSnap, rowId, tempX, tempY, tempCount, index, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc) {
                    if (tempCount == 1) {
                        setCabinetsXTable(layerSnap, rowId, tempX + 300, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                    } else if (tempCount == 2) {
                        switch ((index + 1)) {
                        case 1:
                            setCabinetsXTable(layerSnap, rowId, tempX - 350, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 2:
                            setCabinetsXTable(layerSnap, rowId, tempX + 280, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        }
                    } else if (tempCount == 3) {
                        switch ((index + 1)) {
                        case 1:
                            setCabinetsXTable(layerSnap, rowId, tempX - 350, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 2:
                            setCabinetsXTable(layerSnap, rowId, tempX + 150, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 3:
                            setCabinetsXTable(layerSnap, rowId, tempX + 280, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        }
                    } else if (tempCount == 4) {
                        switch ((index + 1)) {
                        case 1:
                            setCabinetsXTable(layerSnap, rowId, tempX - 350, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 2:
                            setCabinetsXTable(layerSnap, rowId, tempX - 80, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 3:
                            setCabinetsXTable(layerSnap, rowId, tempX + 150, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 4:
                            setCabinetsXTable(layerSnap, rowId, tempX + 280, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        }
                    } else if (tempCount == 5) {
                        switch ((index + 1)) {
                        case 1:
                            setCabinetsXTable(layerSnap, rowId, tempX - 350, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 2:
                            setCabinetsXTable(layerSnap, rowId, tempX - 190, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 3:
                            setCabinetsXTable(layerSnap, rowId, tempX + 30, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 4:
                            setCabinetsXTable(layerSnap, rowId, tempX + 250, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 5:
                            setCabinetsXTable(layerSnap, rowId, tempX + 350, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        }
                    } else if (tempCount == 6) {
                        switch ((index + 1)) {
                        case 1:
                            setCabinetsXTable(layerSnap, rowId, tempX - 400, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 2:
                            setCabinetsXTable(layerSnap, rowId, tempX - 350, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 3:
                            setCabinetsXTable(layerSnap, rowId, tempX - 140, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 4:
                            setCabinetsXTable(layerSnap, rowId, tempX + 70, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 5:
                            setCabinetsXTable(layerSnap, rowId, tempX + 280, tempY + 10, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        case 6:
                            setCabinetsXTable(layerSnap, rowId, tempX + 350, tempY + 200, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc);
                            break;
                        }
                    }
                },
            keyArray : keyArray,
            keyJsonArray : keyJsonArray,
            branchboxIDArray : branchboxIDArray,
            branchboxXYArray : branchboxXYArray,
            thisSvgObj : thisSvgObj,
            outgoingCabinetArray : outgoingCabinetArray
        }
    }
    //
    function updateBox(id, cls) {
        $("#chuxiangui_rect_" + id).attr("class", cls); //包围虚线框样式调整
        $("#kaiguanxian_" + id).find("rect").attr("class", cls);
        $("#kaiguanxian_" + id).find("path").attr("class", cls);
        $("#kaiguanxian_line_" + id).find("rect").attr("class", cls);
        $("#kaiguanxian_line_" + id).find("path").attr("class", cls);

        $("#chuxiangui_line01_" + id).find("rect").attr("class", cls);
        $("#chuxiangui_line01_" + id).find("path").attr("class", cls);
    }
    
     function chuxianguiTxt(key,epuName,epuNameError,cls){
    	var x = $("#chuxiangui_" + key).attr("x");
        var y = $("#chuxiangui_" + key).attr("y");
        var k = 0;
        x = parseInt(x);
        y = parseInt(y);
        if (epuName && epuName.length && !isNaN(x)) {
            var size = 1;
            thisSvgObj.select("g[id='chuxiangui_"+key+"']").each(function(){
            	$(this).children("text").each(function(){
            		$(this).remove();
            	})
            });
            var g = thisSvgObj.select("g[id='chuxiangui_"+key+"']");
            var yTemp = y + 18;
            for (var i = 0; i < epuName.length / size; i++) {
            	g.append('text').attr("font-size", "18").attr("class", cls).attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text(epuName.substring(i * size, i * size + size)).attr("x", (x- 30)).attr("y", yTemp + 20 * i);
                k++;
            }
            var yTemp = y + 18;
            for (var i = 0; i < epuNameError.length / size; i++) {
            	var nameError ="";
            	if(cls != "" && null != cls){
            		nameError = epuNameError.substring(i * size, i * size + size);
            	}
            	g.append('text').attr("font-size", "18").attr("class", cls).attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text(nameError).attr("x", (x- 60)).attr("y", yTemp + 20 * i);
                k++;
            }
        }
    }
     
     function meterboxTxt(key,epuName,epuNameError,cls){
     	var x = $("#meterbox_" + key).attr("x");
         var y = $("#meterbox_" + key).attr("y");
         var k = 0;
         x = parseInt(x);
         y = parseInt(y);
         var k = 0;
         epuName = epuName + epuNameError;
         if (epuName && epuName.length) {
             var size = 7;
             thisSvgObj.select("g[id='meterbox_"+key+"']").each(function(){
              	$(this).children("text").each(function(){
              		$(this).remove();
              	})
              });
              var g = thisSvgObj.select("g[id='meterbox_"+key+"']");
             for (var i = 0; i < epuName.length / size; i++) {
                 g.append('text').attr("font-size", "14").attr("class", cls).attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text(epuName.substring(i * size, i * size + size)).attr("x", x).attr("y", y + 108 + 20 * i);
                 k++;
             }
         }
     }

    function updateKaiguanxian(id, cls) {
        $("#kaiguanxian_" + id).find("rect").attr("class", cls);
        $("#kaiguanxian_" + id).find("path").attr("class", cls);

        $("#kaiguanxian_line_" + id).find("rect").attr("class", cls);
        $("#kaiguanxian_line_" + id).find("path").attr("class", cls);

        $("#chuxiangui_line01_" + id).find("rect").attr("class", cls);
        $("#chuxiangui_line01_" + id).find("path").attr("class", cls);
    }

    function createXiangbian(layer, id, x, y) {
        var grid = 128;
        var g = layer.append("g").attr("id", id);
        var transX = 0;
        var transY = 0;
        var rotateX = x + grid / 2;
        var rotateY = y + grid / 2;
        var useage = g.append('use').attr("width", grid).attr("height", grid).attr("transform", "scale(1) translate(" + transX + " " + transY + ") rotate(0 " + rotateX + " " + rotateY + ")").attr("xlink:href", "#EnergyConsumer_PD_单电源用户_2").attr("x", x).attr("y", y);
    }

    function createBox(layer, id, x, y, name, lines, type,svgModelData) {
        var g = layer.append("g").attr("id", "chuxiangui_" + id).attr("x", x).attr("y", y);
        g.append('rect').attr("stroke-width", 1).attr("stroke", "#000").attr("stroke-dasharray", "5,5").attr("fill", "none").attr("x", x).attr("y", y).attr("width", 300).attr("height", 180).attr("id", "chuxiangui_rect_" + id);

//        g.append('path').attr("id", "chuxiangui_text_01_" + id).attr("d", "M" + (x - 55) + "," + y + " L" + (x - 55) + "," + (y + 300)).attr("stroke-width", 0);
//        var txt = g.append('text').attr("font-size", "18").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)");
//        txt.append('textPath').attr("id", "textPath_01_" + id).attr("xlink:href", "#chuxiangui_text_01_" + id).text("");
//        
//        g.append('path').attr("id", "chuxiangui_text_" + id).attr("d", "M" + (x - 30) + "," + y + " L" + (x - 30) + "," + (y + 300)).attr("stroke-width", 0);
//        var txt = g.append('text').attr("font-size", "18").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)");
//        txt.append('textPath').attr("id", "textPath_" + id).attr("xlink:href", "#chuxiangui_text_" + id).text(name);
        
        var k = 0;
        if (name && name.length) {
            var size = 1;
            var yTemp = y + 18;
            for (var i = 0; i < name.length / size; i++) {
                g.append('text').attr("font-size", "18").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text(name.substring(i * size, i * size + size)).attr("x", (x- 30)).attr("y", yTemp + 20 * i);
                k++;
            }
        }
     
        if (lines && lines.length) {
            var start = x + 180;
            var end = x;
            var gird = 300 / (lines.length + 1);
            $(lines).each(function(index, item) {
                var ix = x + gird * (index + 1) - 8;
                start = Math.min(start, ix + 8);
                end = Math.max(end, ix + 8);
                createBranchBoxXian(g, item, ix, y + 30, 150, type, name, lines,svgModelData);
            });
            var g = layer.append("g").attr("id", "chuxiangui_line01_" + id);
            g.append('path').attr("d", "M" + start + "," + (y + 30) + " L" + end + "," + (y + 30)).attr("stroke-width", 2).attr("stroke", "#000").attr("fill", "none");
            g.append('path').attr("d", "M" + (x + 150) + "," + (y) + " L" + (x + 150) + "," + (y + 30)).attr("stroke-width", 2).attr("stroke", "#000").attr("fill", "none");

        }
    }

    /**
 * 创建分支箱/出线柜内的节点
 * **/
    function createBranchBoxXian(layer, id, x, y, height, type, name, lines,svgModelData) {
        height = height || 180;
        var g = layer.append("g").attr("id", "kaiguanxian_" + id);
        var gird = (height - 50) / 2;
        //组织分支箱/出线柜节点图标
        var svgimg = setSvgimg("50", "50", "../woodare/image/branchBox.png", (x - 17), (y + 50), "kaiguanxianImg_" + id, type);
        $("#Snap_Layer").append(svgimg).find("image[id='kaiguanxianImg_" + id + "']").attr("epuName", name).click(function() {
            if (type == "M0003") { //分支箱的弹出层单击事件
                showBranchBox(this, id,svgModelData);
            }
        });
        g.append('path').attr("stroke-width", 2).attr("stroke", "#000").attr("fill", "none").attr("d", "M " + (x + 8) + "," + y + " L " + (x + 8) + "," + (y + gird) + "");
        g.append('path').attr("stroke-width", 2).attr("stroke", "#000").attr("fill", "none").attr("d", "M " + (x + 8) + "," + (y + gird + 50) + " L " + (x + 8) + "," + (y + height) + "");
    }

    /**
 * 展示电表(弹出层)
 * desc:1、动态设置弹出层标题 2、弹出层 3、展示列表 4、 展示拓扑信息
 **/
    function showAmmeter(obj, svgModelData) {
        var txtID = $(obj).attr("id"); //展示的文字ID
        parent.$("#tableBoxId").val(txtID.replace("meterbox_", "").replace("meterboxImg_", "")); //当前表箱ID
        var textValue = $(obj).attr("epuName"); //展示的文字内容
        parent.$("#tableBoxName").attr("title", textValue + "单线图").text(textValue + "单线图"); //TAB
        var rowId = parent.$("#rowId").val(); //获取箱变根ID
        var iframeID = parent.$("#tab3Iframe")[0]; //获取iframe的ID
        var tableBoxId = parent.$("#tableBoxId").val(); //获取箱变根ID
        iframeID.contentWindow.showTop(svgModelData, rowId, tableBoxId);
    }

    /**
 * 展示分支箱(弹出层)
 * desc:1、动态设置弹出层标题 2、弹出层 3、展示列表
 **/
    function showBranchBox(obj,  meterboxId,svgModelData) {
        var meterboxEpuName = $("#meterbox_" + meterboxId).attr("name");
        var branchBoxId = $(obj).attr("id"); //展示的文字ID
        parent.$("#branchBoxId").val(branchBoxId.replace("kaiguanxianImg_", "")); //当前分支箱ID
        parent.$("#branchBoxName").attr("title", meterboxEpuName).text(meterboxEpuName); //TAB
        var rowId = parent.$("#rowId").val(); //获取箱变根ID
        var tableBoxId = parent.$("#tableBoxId").val(); //获取箱变根ID
        parent.$("#messageBranchBox").show();
        var iframeID = parent.$("#tab4Iframe")[0]; //获取iframe的ID
        iframeID.contentWindow.showList(rowId, tableBoxId,  branchBoxId, meterboxId, meterboxEpuName,svgModelData);
    }

    /**
 * 创建电表图标及文本展示
 **/
    function createMeterBox(layer, id, x, y, name) {
        var g = layer.append("g").attr("id", "meterbox_" + id).attr("name", name).attr("x", x).attr("y", y);

        var k = 0;
        if (name && name.length) {
            var size = 7;
            for (var i = 0; i < name.length / size; i++) {
                g.append('text').attr("font-size", "14").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text(name.substring(i * size, i * size + size)).attr("x", x).attr("y", y + 108 + 20 * i);
                k++;
            }
//            g.append('text').attr("font-size", "14").attr("stroke", "rgb(0,0,0)").attr("fill", "rgb(0,0,0)").text("").attr("x", x).attr("y", y + 108 + 20 * (k));
        }
    }

    /**
 * 创建单个连接线
 * **/
    function createLineEl(layer, position) {
        var g = layer.append("g");
        g = g.attr("id", "kaiguanxian_line_" + (position.id || ""));
        var x = position.x;
        var y = position.y;
        var x2 = position.x2;
        var y2 = position.y2;
        var h = position.h || 0;
        var path = g.append('path').attr("stroke-width", 2).attr("stroke", "rgb(0,0,0)").attr("fill", "none").attr("d", "M " + x2 + "," + (y2 + h) + " L " + x2 + "," + y2 + "");
        var path = g.append('path').attr("stroke-width", 2).attr("stroke", "rgb(0,0,0)").attr("fill", "none").attr("d", "M " + x + "," + (y2 + h) + " L " + x2 + "," + (y2 + h) + "");
        var path = g.append('path').attr("stroke-width", 2).attr("stroke", "rgb(0,0,0)").attr("fill", "none").attr("d", "M " + x + "," + y + " L " + x + "," + (y2 + h) + "");

    }

    /**
 * 组织画TABLE文本
 * **/
    function setCabinetsXTable(layerSnap, id, cabinetsX, cabinetsY, ua, ia, pa, qa, ub, ib, pb, qb, uc, ic, pc, qc) {
    	var idTableNull_X = cabinetsX;
    	var idTableNull_Y = cabinetsY - 150;
    	setCreateUseEl(layerSnap,"idTitleNull" + id, "tableList1",idTableNull_X + 32,idTableNull_Y);//空框
    	
    	var idTableU_X = cabinetsX + 58;
    	var idTableU_Y = cabinetsY - 150;
    	setCreateUseEl(layerSnap,"idTitleU" + id, "tableList",idTableU_X,idTableU_Y);//u框
    	splitRemarks(layerSnap,"idTitleUtxt" + id,"U",idTableU_X + 37,idTableU_Y+22,"fText",18);//U文字
    	
    	var idTableI_X = idTableU_X + 58;
    	var idTableI_Y = cabinetsY - 150;
    	setCreateUseEl(layerSnap,"idTitleI" + id, "tableList",idTableI_X,idTableI_Y);//i框
    	splitRemarks(layerSnap,"idTitleItxt" + id,"I",idTableI_X + 37,idTableI_Y+22,"fText",18);//I文字
    	
    	
    	var idTableQ_X = idTableI_X + 58;
    	var idTableQ_Y = cabinetsY - 150;
    	setCreateUseEl(layerSnap,"idTitleP" + id, "tableList",idTableQ_X,idTableQ_Y);//P框
    	splitRemarks(layerSnap,"idTitlePtxt" + id,"P",idTableQ_X+37,idTableQ_Y+22,"fText",18);//P文字
    	
    	var idTableP_X = idTableQ_X + 58;
    	var idTableP_Y = cabinetsY - 150;
    	setCreateUseEl(layerSnap,"idTitleQ" + id, "tableList",idTableP_X,idTableP_Y);//Q框
    	splitRemarks(layerSnap,"idTitleQtxt" + id,"Q",idTableP_X + 37,idTableP_Y+22,"fText",18);//Q文字
    	var idTableA_X = idTableNull_X;
    	var idTableA_Y = idTableNull_Y + 26;
    	
    	var idTableAU_X = idTableA_X + 58;
    	var idTableAU_Y = idTableNull_Y + 26;
    	setCreateUseEl(layerSnap,"idUA" + id, "tableList",idTableAU_X,idTableAU_Y);//ua框
    	splitRemarks(layerSnap,"idUAtxt" + id,ua,idTableAU_X + 55,idTableAU_Y+22,"fText",14);//ua文字
    	
    	setCreateUseEl(layerSnap,"idTitleUANulltxt" + id, "tableList1",idTableNull_X  + 32,idTableAU_Y);//空框
    	splitRemarks(layerSnap,"idTitleUAtxt" + id,"A",idTableAU_X - 5 ,idTableAU_Y+22,"fText",18);//A
    	
    	var idTableAI_X = idTableAU_X + 58;
    	var idTableAI_Y = idTableNull_Y + 26;
    	setCreateUseEl(layerSnap,"idIA" + id, "tableList",idTableAI_X,idTableAI_Y);//ia框
    	splitRemarks(layerSnap,"idIAtxt" + id,ia,idTableAI_X + 55,idTableAI_Y+22,"fText",14);//ia文字
    	
    	
    	
    	var idTableAP_X = idTableAI_X + 58;
    	var idTableAP_Y = idTableNull_Y + 26;
    	setCreateUseEl(layerSnap,"idPA" + id, "tableList",idTableAP_X,idTableAP_Y);//pa框
    	splitRemarks(layerSnap,"idPAtxt" + id,pa,idTableAP_X + 55,idTableAP_Y+22,"fText",14);//pa文字
    	
    	var idTableAQ_X =  idTableAP_X + 58;
    	var idTableAQ_Y = idTableNull_Y + 26;
    	setCreateUseEl(layerSnap,"idQA" + id, "tableList",idTableAQ_X,idTableAQ_Y);//qa框
    	splitRemarks(layerSnap,"idQAtxt" + id,qa,idTableAQ_X + 55,idTableAQ_Y+22,"fText",14);//qa文字


    	
    	
    	
    	var idTableBU_X = idTableA_X + 58;
    	var idTableBU_Y = idTableNull_Y + 52;
    	setCreateUseEl(layerSnap,"idUB" + id, "tableList",idTableBU_X,idTableBU_Y);//ub框
    	splitRemarks(layerSnap,"idUBtxt" + id,ub,idTableBU_X + 55,idTableBU_Y + 22,"fText",14);//ub文字
    	
    	setCreateUseEl(layerSnap,"idTitleUBNull" + id, "tableList1",idTableNull_X + 32,idTableBU_Y);//空框
    	splitRemarks(layerSnap,"idTitleUBNulltxt" + id,"B",idTableBU_X - 5,idTableBU_Y + 22,"fText",18);//B
    	
    	var idTableBI_X = idTableBU_X + 58;
    	var idTableBI_Y = idTableNull_Y + 52;
    	setCreateUseEl(layerSnap,"idIB" + id, "tableList",idTableBI_X,idTableBI_Y);//ib框
    	splitRemarks(layerSnap,"idIBtxt" + id,ib,idTableBI_X + 55,idTableBI_Y + 22,"fText",14);//ib文字
    	
    	var idTableBP_X = idTableBI_X + 58;
    	var idTableBP_Y = idTableNull_Y + 52;
    	setCreateUseEl(layerSnap,"idPB" + id, "tableList",idTableBP_X,idTableBP_Y);//pb框
    	splitRemarks(layerSnap,"idPBtxt" + id,pb,idTableBP_X + 55,idTableBP_Y + 22,"fText",14);//pb文字
    	
    	var idTableBQ_X =  idTableBP_X + 58;
    	var idTableBQ_Y = idTableNull_Y + 52;
    	setCreateUseEl(layerSnap,"idQB" + id, "tableList",idTableBQ_X,idTableBQ_Y);//qb框
    	splitRemarks(layerSnap,"idQBtxt" + id,qb,idTableBQ_X + 55,idTableBQ_Y + 22,"fText",14);//qb文字


    	
    	
    	
    	var idTableCU_X = idTableA_X + 58;
    	var idTableCU_Y = idTableNull_Y + 78;
    	setCreateUseEl(layerSnap,"idUC" + id, "tableList",idTableCU_X,idTableCU_Y);//uc框
    	splitRemarks(layerSnap,"idUCtxt" + id,uc,idTableCU_X + 55,idTableCU_Y + 22,"fText",14);//uc文字
    	
    	setCreateUseEl(layerSnap,"idTitleUcNull" + id, "tableList1",idTableNull_X + 32,idTableCU_Y);//空框
    	splitRemarks(layerSnap,"idTitleUcNulltxt" + id,"C",idTableCU_X - 5,idTableCU_Y + 22,"fText",18);//C
    	
    	var idTableCI_X = idTableCU_X + 58;
    	var idTableCI_Y = idTableNull_Y + 78;
    	setCreateUseEl(layerSnap,"idIC" + id, "tableList",idTableCI_X,idTableCI_Y);//ic框
    	splitRemarks(layerSnap,"idICtxt" + id,ic,idTableCI_X + 55,idTableCI_Y + 22,"fText",14);//ic文字
    	
    	
    	var idTableCP_X = idTableCI_X + 58;
    	var idTableCP_Y = idTableNull_Y + 78;
    	setCreateUseEl(layerSnap,"idPC" + id, "tableList",idTableCP_X,idTableCP_Y);//pc框
    	splitRemarks(layerSnap,"idPCtxt" + id,pc,idTableCP_X + 55,idTableCP_Y + 22,"fText",14);//pc文字
    	
    	var idTableCQ_X = idTableCP_X + 58;
    	var idTableCQ_Y = idTableNull_Y + 78;
    	setCreateUseEl(layerSnap,"idQC" + id, "tableList",idTableCQ_X,idTableCQ_Y);//qc框
    	splitRemarks(layerSnap,"idQCtxt" + id,qc,idTableCQ_X + 55,idTableCQ_Y + 22,"fText",14);//qc文字
    }

    /**
 * 分割备注
 * **/
    function splitRemarks(layerSnap, id, title, x, y, txt, size, tspan) {
        createTextEl(layerSnap, {
            id: id,
            title: title,
            tspan: tspan
        },
        {
            x: x,
            y: y,
            scale: 1,
            rotate: 0,
            txt: txt,
            //黑色字体样式
            size: size
        });
    }

    /**
 * 图标类型
 * */
    function getSymbolByType(type) {
        var data = {
            id: "",
            x: "",
            y: ""
        };
        var id = "";
        switch (type) {
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
        default:
            break;
        }
        return data;
    }

    /**
 * 引入图状
 * **/
    function setCreateUseEl(layerSnap, id, type, x, y) {
        createUseEl(layerSnap, {
            id: id,
            type: type
        },
        {
            x: x,
            y: y,
            scale: 1
        });
    }

    /**
 * 创建SVG文本
 * **/
    function createTextEl(layer, data, position) {
        position.rotate = position.rotate || 0;
        var g = layer.append("g").attr("id", data.id);
        var x = position.x;
        var y = position.y;
        var size = position.size || 14;
        var txtCls = position.txt || "fText";
        var anchor = position.anchor || "end";
        var tspan = data.tspan || false;
        if (tspan) {
            var txt = g.append('text').attr("text-anchor", anchor).attr("font-size", size).attr("stroke", "rgb(255,0,0)").attr("fill", "rgb(255,0,0)").html(data.title).attr("class", txtCls).attr("transform", "scale(" + position.scale + ") translate(0 0) rotate(" + position.rotate + " " + x + " " + y + ")");
        } else {
            var txt = g.append('text').attr("text-anchor", anchor).attr("font-size", size).attr("stroke", "rgb(255,0,0)").attr("fill", "rgb(255,0,0)").attr("x", x).attr("y", y).text(data.title).attr("class", txtCls).attr("transform", "scale(" + position.scale + ") translate(0 0) rotate(" + position.rotate + " " + x + " " + y + ")");
        }

    }

    /**
 * 创建引入图标
 * **/
    function createUseEl(layer, data, position) {
        var grid = 64;
        position.rotate = position.rotate || 0;
        data.id = data.id || "";
        var g = layer.append("g").attr("id", data.id);
        var symbol = getSymbolByType(data.type); //图标类型
        var x = position.x;
        var y = position.y;
        var transX = 0;
        var transY = 0;
        var rotate = position.rotate
        var rotateX = x + grid / 2;
        var rotateY = y + grid / 2;
        var useage = g.append('use').attr("width", grid).attr("height", grid).attr("transform", "scale(" + position.scale + ") translate(" + transX + " " + transY + ") rotate(" + position.rotate + " " + rotateX + " " + rotateY + ")").attr("xlink:href", "#" + symbol.id).attr("x", x).attr("y", y).attr("class", data.cls);
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
    function setSvgimg(height, width, srcPath, x, y, id, type) {
        var svgimg = document.createElementNS('http://www.w3.org/2000/svg', 'image');
        svgimg.setAttributeNS(null, "height", height);
        svgimg.setAttributeNS(null, "width", width);
        if (type != "M0002") {
            svgimg.setAttributeNS(null, "cursor", "pointer");
        }
        svgimg.setAttributeNS("http://www.w3.org/1999/xlink", "href", srcPath);
        svgimg.setAttributeNS(null, "x", x);
        svgimg.setAttributeNS(null, "y", y);
        svgimg.setAttributeNS(null, "id", id);
        svgimg.setAttributeNS(null, "visibility", "visible");
        return svgimg;
    }
    
    /**
     **获取下级节点信息
      *param：paramEpuType 类型
     *param：paramEpuParentId 父节点
     *param：data 数据集合
     ***/
    function getNextAmmeterId(paramEpuType,paramEpuParentId,data,arrayList){
    	for(var i= 0; i< data.length; i++){
    		var json = data[i];
    		var epuParentId = json["epuId"];
    		var epuType = json["epuType"];
    		if(epuType == paramEpuType ){
    			if(epuParentId == paramEpuParentId){
    				arrayList.push(json["rowId"]);
    			}
    		}
    	}
    	return arrayList;
    }

    return {
        drawSvg: drawSvg
    }
})();