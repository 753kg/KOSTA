/**
 * 공통자바스크립트
 */

var replyManager = ( function(){
	// 전부 조회
	var getAll = function(obj, callback){
		console.log("getAll()....");
		console.log(obj);
		// $.getJSON : AJAX의 한 방법
		// $.getJSON(url, success function)
		$.getJSON("/replies/board/" + obj, callback);
	};
	
	// 댓글 추가
	var add = function(obj, callback){
		console.log("add reply....");
		$.ajax({
			url: "/replies/" + obj["bno"],
			data: JSON.stringify(obj),
			dataType: "json",
			type: "post",			// insert --> post
			contentType: "application/json",
			success: callback
		});
	};
	
	// 수정
	var update = function(obj, callback){
		console.log("update reply....");
		$.ajax({
			url: "/replies/" + obj["bno"],
			data: JSON.stringify(obj),
			dataType: "json",
			type: "put",
			contentType: "application/json",
			success: callback
		});
	};
	
	// 삭제
	var remove = function(obj, callback){
		console.log("remove reply....");
		$.ajax({
			url: "/replies/" + obj["bno"] + "/" + obj["rno"],
			type: "delete",
			success: callback
		});
	};
	
	// JSON(JavaScript Object)
	return {"getAll":getAll, 
			"add": add,
			"update": update,
			"remove": remove
			};
})();	// 실행 --> 결과가 replyManager에 들어감