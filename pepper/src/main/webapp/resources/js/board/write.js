$(function(){
	
	$("#btnSubmit").click(function(){
		
		var title = $("#title").val();
		var content = $("#content").val();
		
		if (title.length === 0){
			alert("제목을 입력해 주세요.");
			$("#title").focus();
			return false;
		} else if (content.length === 0) {
			alert("내용을 입력해 주세요.");
			$("#content").focus();
			return false;
		}
	});
	
	
	$("#btnCancel").click(function(){
		location.href = "/board/list?num=" + num + "&searchType=" + searchType + "&keyword=" + keyword;
	});
	
	
	
});