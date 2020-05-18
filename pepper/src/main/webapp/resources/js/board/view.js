$(function(){
	
	$("#btnEdit").click(function(){
		location.href = "/board/edit?num="+num+"&bno="+bno+"&searchType="+searchType+"&keyword="+keyword;
	});
	
	
	$("#btnList").click(function(){
		location.href = "/board/list?num="+num+"&searchType="+searchType+"&keyword="+keyword;
	});
	
	
	$("#btnDelete").click(function(){
		$("#deleteArea").css("display", "block");
	});
	
	
	$("#btnDeleteOK").click(function(){
		var inputPW = $("#userPW").val()
		
		if(inputPW != "") {
					
			var inputData = {userPW : inputPW};

			$.ajax({
				url : "/member/pwCheck",
				type : "post",
				data : inputData,
				success : function(data) {
					
					if(data == 0) {
						$(".alertText").text("비밀번호가 틀렸습니다.");
					} else {
						location.href = "/board/delete?bno=" + bno;
					}
				}
			});
		}	
	});
	
	$("#userPW").keypress(function(event){
		if(event.which===13){
			$("#btnDeleteOK").click();
			return false;
		}
	});
	
	
	$("#btnDeleteCancel").click(function(){
		$("#userPW").val("");
		$("#deleteArea").css("display", "none");
	});
	
});