$(function(){
	
	$("#submit").click(function(){
		if ($("#userName").val().length === 0){
			alert("닉네임을 입력해 주세요.");
			$("#userName").focus();
			return false;
		} 
		else if($("#userEmail").val().length === 0){
			alert("이메일을 입력해 주세요.");
			$("#userEmail").focus();
			return false;
		} 
		else if($("#userNumber").val().length === 0){
			alert("연락처를 입력해 주세요.");
			$("#userNumber").focus();
			return false;
		}
		
		var nameCheck = RegExp(/^[가-힣a-zA-Z0-9]{2,10}$/);
		var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
		var numberCheck = RegExp(/^[0-9]{10,12}$/);
		
		if(!nameCheck.test($('#userName').val())){
			alert("닉네임 형식은 한글 또는 영어 2자 이상입니다.");
			$("#userName").focus();
			return false;
		} 
		else if(!emailCheck.test($('#userEmail').val())){
			alert("이메일 형식을 다시 확인해 주세요.");
			$("#userEmail").focus();
			return false;
		} 
		else if(!numberCheck.test($('#userNumber').val())){
			alert("연락처에 숫자만 입력해 주세요.");
			$("#userNumber").focus();
			return false;
		}
	});
});