$(function(){
	$("#submit").click(function(){
		if ($("#userID").val().length === 0){
			alert("아이디를 입력해 주세요.");
			$("#userID").focus();
			return false;
		} else if($("#userPW").val().length === 0){
			alert("비밀번호를 입력해 주세요.");
			$("#userPW").focus();
			return false;
		}
	});
});