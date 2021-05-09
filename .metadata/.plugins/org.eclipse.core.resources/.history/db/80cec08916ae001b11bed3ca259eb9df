<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#paging .pag {
		display: block;
		float: left;
		position: relative;
		margin-top: 100px;
		
	}
	#paging .pageBtn{
		position: relative;
		margin-top: 200px;
	}
	#paging button {
		padding: 0px;
		margin: 50px;
		width: 70px;
		height: 70px;
		border-radius: 100%;
		background: #FFDC68;
		border:none;
	}
#paging button:hover {
color:#FFDC68;
 background-color: black;
}
	}
#paging{
	top:150px;
	  position:relative; 
}
.typeBtn{
border-radius: 10px;
width:100px;
}
.typeBtn:hover{
color:pink;
 background-color: black;
}
#activity-div{
position:relative;
left:7%;}
</style>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<div id="activity-div">
		<div id="listType" style="position: absolute; left:570px;top:20px;">
			<button type="button" class="typeBtn" id="restaurants">식당</button>
			<button type="button" class="typeBtn" id="cafes">카페</button>
			<button type="button" class="typeBtn" id="activities">놀거리</button>
			<button type="button" class="typeBtn" id="safety">안심먹거리</button>
		</div>
    <div id="paging">
    	<div class="pag pageBtn"><button type="button" id="btn_prev"><i class="fas fa-chevron-left"></i></button></div>
    	<div class="pag viewPage" id="view"></div>
    	<div class="pag pageBtn"><button type="button" id="btn_next"><i class="fas fa-chevron-right"></i></button></div>
    </div>
    </div>
   
<script>

		
		$("#restaurants").click(function(){
			var currentPage = 1;
			var totalPage = ${r_total_page};
			var location_name = '${location_name}';
			showActivity(currentPage, totalPage, location_name, "r");
		});
		
		$("#cafes").click(function(){
			var currentPage = 1;
			var totalPage = ${c_total_page};
			var location_name = '${location_name}';
			showActivity(currentPage, totalPage, location_name, "c");
		});
		
		$("#activities").click(function(){
			var currentPage = 1;
			var totalPage = ${a_total_page};
			var location_name = '${location_name}';
			showActivity(currentPage, totalPage, location_name, "a");
		});
		
		$("#safety").click(function(){
			var currentPage = 1;
			var totalPage = ${s_total_page};
			var location_name = '${location_name}';
			showActivity(currentPage, totalPage, location_name, "s");
		});
		
		function showActivity(currentPage, totalPage, location_name, type){
			btnCheck(currentPage, totalPage);
			getNPage(location_name, currentPage, type);
		
			
			btn_next.onclick = function(){
				currentPage++;
				if(currentPage <= 1) currentPage = 0;
				btnCheck(currentPage, totalPage);
				getNPage(location_name, currentPage, type);
			};
			
			btn_prev.onclick = function(){
				currentPage--;
				if(currentPage >= totalPage) currentPage = totalPage;
				btnCheck(currentPage, totalPage);
				getNPage(location_name, currentPage, type);
			};
			
			function btnCheck(page, finalPage){
				$("#btn_prev").prop('disabled', false);
				if(page <= 1){
					$("#btn_prev").prop('disabled', true);
				}
				$("#btn_next").prop('disabled', false);
				if(page >= finalPage){
					$("#btn_next").prop('disabled', true);
				}
			}
			
			function getNPage(location_name, page, type){
				$.ajax({
	    			url : "../activityView/SelectNPage?type=" + type + "&location_name=" + location_name + "&page=" + page,
	    			type : "get",
	    			success : function(responsedata) {
	    				
	    				$("#view").html(responsedata);
	    			},
	    			error : function() {
	    				console.log("paginationTest >> ajax error")
	    			}
	    	});
			}
		}
		

		$("#restaurants").click();
</script>
</body>
</html>