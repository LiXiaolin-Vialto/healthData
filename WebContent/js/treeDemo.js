// JavaScript Document
$(document).ready(function(e) {
    $("#browser").treeview();
	
	$.ajax({
			type:"get",
			url:"http://localhost:8080/testWeb/index.jsp",
			success: function(data){
				console.log(data);
				}
		});
});