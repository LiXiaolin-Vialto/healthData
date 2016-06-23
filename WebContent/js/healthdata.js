// JavaScript Document
$(document).ready(function(e) {
	var table_name_code,//数据库中对应表格的名称
		data_name,//数据库中对应字段的名称
		attr_code,//字段的编号
		table_name,//字段所属表格的中文名称
		attr_Name,//字段的中文名称
		value_url = "http://localhost:8080/healthData/servlet/showValue",
		array_url = "http://localhost:8080/healthData/servlet/showArray",
		data_array;
	function getInformation(con_url){
		$.ajax({
			type:"get",
			url:con_url,
			data:{
					"table_name":table_name_code,
					"data_name":data_name,
					"type":type
					},
			success: function(data){
				var data_json = JSON.parse(data);
				if($.type(data_json.value)!="array"){
					$("#datarea").html(" ");
					$("#attr_value").val(data_json.value);
					$("#attr_code").val(attr_code);
					$("#table_Name").val(table_name);
					$("#attr_Name").val(attr_name);
					}
				else{
					data_array = data_json.value;
					$("#attr_code").val(attr_code);
					$("#table_Name").val(table_name);
					$("#attr_Name").val(attr_name);
					$("#attr_value").val(" ");
					require(
						[
							'echarts',
							'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
						],
						getCharts
					);
					}
				}
		});
		}
		
	function getCharts(ec){
		var myChart = ec.init(document.getElementById('datarea')); 
		var option = {
			title:{
				text:"过去三十天"+attr_name+"变化",
				},
			tooltip:{
				trigger:'items'
				},
			legend:{
				data:[attr_name]
				},
			caculable :true,
			xAxis:[{
				type:'category',
				boundaryGap:false,
				data:['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30']
				}],
			yAxis:[{
				type:'value',
				axisLabel:{
					formatter:'{value}'
					}
				}],
			series:[
			{
				name:'高压',
				type:'line',
				data:data_array,
				markPoint:{
					data:[{type:'max',name:'最高血压'}]
					},
				markLine:
				{
					data: [{type:'average',name:'平均值'}]
				}
			},
			]
			}
			myChart.setOption(option);
		}
		
	function bindEvents(){
		$("#browser").treeview();
		
		$(".file").hover(
			function(){
				$(this).addClass("hover");
				},
			function(){
					$(this).removeClass("hover");
					});
		
		
		$(".file").on('click',function(){
			
			table_name_code = $(this).parent().parent().prev("span").attr("name");
			data_name = $(this).attr("name");
			attr_code = $(this).text().split(" ")[0];
			table_name =  $(this).parent().parent().prev("span").text().split(" ")[1];
			attr_name = $(this).text().split(" ")[1]
			type = $(this).attr("type");
			if(type=="value"){
				getInformation(value_url);
				}
			else{
				getInformation(array_url);
				}
			});
		}
		
	function init(){
		require.config({
			paths:{
			echarts:'lib/js'}
		});
		bindEvents();
		};
		init();
});