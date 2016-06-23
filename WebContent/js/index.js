;(function(){
	var template = "{{#settings}}<h3 class='title'>{{title}}</h3>"+
					"<ul>{{#items}}<li>{{.}}</li>{{/items}}"+
					"{{^items}}<li>您还没选任何条目</li>{{/items}}</ul>{{/settings}}";
	var person_settings = {};

	var type = ["身体基本信息","就诊信息","疾病信息","生产信息"];

	function getCheckedItem(){
		person_settings["settings"] = [];

		$.each(type,function(k,v){
			var data = getSelectedByType(v);
			person_settings["settings"].push(data);
		});
		return person_settings;
	}

	function getSelectedByType(name){
		var selectedList = [];
		var data = {};

		$("input[name='"+name+"']:checked").each(function(k,v){
			selectedList.push($(this).val());
		});
		data["title"] = name ;
		data["items"] = selectedList;

		return data;
	}

	function bindEvent(){
		$("#personal_settings").accordion(
			{
				collapsible:true,
				heightStyle: "content",
				header:"h3"
			});

		$("#save").on("click",function(){
			$("#personal_info_panel").modal("hide");

			var data = getCheckedItem();
			renderList(data);
			$("#personal_settings").accordion("refresh");

		});

	}

	function getList() {
		$.ajax({
			url:"data/settings.json",
			type:"GET",
			success:function(data){
				renderList(JSON.parse(data));
			}
		});
	}

	function renderList(data){
		var out = Mustache.render(template,data);
		$("#personal_settings").html(out);
		bindEvent();
	}

	function init(){
		getList();
	}
	init();
}(jQuery));