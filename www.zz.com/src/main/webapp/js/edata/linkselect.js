//用来获得option元素中selected属性为true的元素的id
function Get_Selected_Id(place) {
	var pro = document.getElementById(place);
	var Selected_Id = pro.options[pro.selectedIndex].id;
	return Selected_Id; //返回selected属性为true的元素的id
}
//改变下一个级联的option元素的内容，即加载市或县
function Get_Next_Place(This_Place_ID, Action) {
	var Selected_Id = Get_Selected_Id(This_Place_ID); //Selected_Id用来记录当前被选中的省或市的ID
	if (Action == 'Get_city') //从而可以在下一个级联中加载相应的市或县
		Add_city(Selected_Id);
	else if (Action == 'Get_country')
		Add_country(Selected_Id);
}
//用来存储省市区的数据结构
var Place_dict = {
	"GuangDong": {
		"GuangZhou": ["PanYu", "HuangPu", "TianHe"],
		"QingYuan": ["QingCheng", "YingDe", "LianShan"],
		"FoShan": ["NanHai", "ShunDe", "SanShui"]
	},
	"ShanDong": {
		"JiNan": ["LiXia", "ShiZhong", "TianQiao"],
		"QingDao": ["ShiNan", "HuangDao", "JiaoZhou"]
	},
	"HuNan": {
		"ChangSha": ["KaiFu", "YuHua", "WangCheng"],
		"ChenZhou": ["BeiHu", "SuXian", "YongXian"]
	}
};
//加载城市选项
function Add_city(Province_Selected_Id) {
	$("#city").empty();
	$("#city").append("<option>City</option>");
	$("#country").empty();
	$("#country").append("<option>Country</option>");
	//上面的两次清空与两次添加是为了保持级联的一致性
	var province_dict = Place_dict[Province_Selected_Id]; //获得一个省的字典
	for (city in province_dict) { //取得省的字典中的城市
		//添加内容的同时在option标签中添加对应的城市ID
		var text = "<option" + " id='" + city + "'>" + city + "</option>";
		$("#city").append(text);
		console.log(text); //用来观察生成的text数据
	}
}
//加载县区选项
function Add_country(City_Selected_Id) {
	$("#country").empty();
	$("#country").append("<option>Country</option>");
	//上面的清空与添加是为了保持级联的一致性
	var Province_Selected_ID = Get_Selected_Id("province"); //获得被选中省的ID，从而方便在字典中加载数据
	var country_list = Place_dict[Province_Selected_ID][City_Selected_Id]; //获得城市列表
	for (index in country_list) {
		////添加内容的同时在option标签中添加对应的县区ID
		var text = "<option" + " id=\'" + country_list[index] + "\'>" + country_list[index] + "</option>";
		$("#country").append(text);
		console.log(text); //用来观察生成的text数据
	}
}