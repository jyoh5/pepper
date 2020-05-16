$(function(){
	
	$("#oldUserPW").blur(function(){
		var inputPW = $("#oldUserPW").val();
		
		if(inputPW != "") {
			
			var inputData = {userPW : inputPW};
			
			$.ajax({
				url : "/member/pwCheck",
				type : "post",
				data : inputData,
				success : function(data) {
					if(data == 0) {
						$("#oldPWCheckResult").text("비밀번호가 틀렸습니다.");
					} else {
						$("#oldPWCheckResult").text("올바른 비밀번호입니다.");
					}
					$("#oldPWCheckResult").css({"display": "block"});
				}
			});
		}
	});
	
	$("#userPWCheck").keyup(function(){
		var pw1 = $("#userPW").val();
		var pw2 = $("#userPWCheck").val();
		
		if(pw1 != "" && pw2 != "") {
			if(pw1 == pw2) {
				$("#pwCheckResult").text("비밀번호가 일치합니다.");
			} else {
				$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");
			}
			$("#pwCheckResult").css({"display": "block"});
		}
	});
	
	$("#submit").click(function(){
		
		if ($("#oldUserPW").val().length === 0){
			alert("현재 사용중인 비밀번호를 입력해 주세요.");
			$("#oldUserPW").focus();
			return false;
		} 
		else if($("#userPW").val().length === 0){
			alert("바꾸실 비밀번호를 입력해 주세요.");
			$("#userPW").focus();
			return false;
		} 
		else if($("#userPWCheck").val().length === 0){
			alert("바꾸실 비밀번호를 입력해 주세요.");
			$("#userPWCheck").focus();
			return false;
		}
		else if($("#oldPWCheckResult").text()==="비밀번호가 틀렸습니다."){
			alert("현재 사용중인 비밀번호를 다시 확인해 주세요.");
			$("#oldUserPW").val("");
			$("#oldUserPW").focus();
			return false;
		} 
		else if($("#pwCheckResult").text()==="비밀번호가 일치하지 않습니다."){
			alert("바꿀 비밀번호를 다시 확인해 주세요.")	
			$("#userPW").val("");
			$("#userPWCheck").val("");
			$("#userPW").focus();
			return false;
		} 
		else if($("#oldUserPW").val() === $("#userPW").val()) {
			alert("현재 비밀번호와 동일합니다.")
			$("#userPW").val("");
			$("#userPWCheck").val("");
			$("#userPW").focus();
			return false;
		}
		
		var userPWCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
		
		if(!userPWCheck.test($('#userPW').val())){
			alert("비밀번호 형식은 대문자+숫자+특수문자 8자 이상입니다.");
			$("#userPW").focus();
			return false;
		} 
		else if(!userPWCheck.test($('#userPWCheck').val())){
			alert("비밀번호 형식은 대문자+숫자+특수문자 8자 이상입니다.");
			$("#userPWCheck").focus();
			return false;
		} 
	});
});