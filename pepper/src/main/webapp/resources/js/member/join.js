$(function(){
	
	$("#userID").blur(function(){
		var inputID = $("#userID").val()
		
		if(inputID != "") {
					
			var inputData = {userID : inputID};
			
			$.ajax({
				url : "/member/idCheck",
				type : "post",
				data : inputData,
				success : function(data) {
					if(data == 1) {
						$("#idCheckResult").text("이미 사용중인 아이디입니다.");
					} else {
						$("#idCheckResult").text("사용 가능한 아이디입니다.");
					}
					$("#idCheckResult").css({"display": "block"});
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
				console.log(pw2);
				$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");				
			}
			$("#pwCheckResult").css({"display": "block"});
		}
	});
	
	$("#userName").blur(function(){
		var inputName = $("#userName").val()
		
		if(inputName != "") {
					
			var inputData = {userName : inputName};
			
			$.ajax({
				url : "/member/nameCheck",
				type : "post",
				data : inputData,
				success : function(data) {
					if(data == 1) {
						$("#nameCheckResult").text("이미 사용중인 닉네임입니다.");
					} else {
						$("#nameCheckResult").text("사용 가능한 닉네임입니다.");
					}
					$("#nameCheckResult").css({"display": "block"});
				}
			});
		}
	});
	
	$("#submit").click(function(){
		if ($("#userID").val().length === 0){
			alert("아이디를 입력해 주세요.");
			$("#userID").focus();
			return false;
		} 
		else if($("#userPW").val().length === 0){
			alert("비밀번호를 입력해 주세요.");
			$("#userPW").focus();
			return false;
		} 
		else if($("#userPWCheck").val().length === 0){
			alert("비밀번호를 입력해 주세요.");
			$("#userPWCheck").focus();
			return false;
		} 
		else if($("#userName").val().length === 0){
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
		else if($("#idCheckResult").text()==="이미 사용중인 아이디입니다."){
			alert("해당 아이디는 사용이 불가합니다.")
			return false;
		} 
		else if($("#idCheckResult").text()===""){
			alert("아이디 중복 확인을 해주세요.")
			return false;
		} 
		else if($("#pwCheckResult").text()==="비밀번호가 일치하지 않습니다."){
			alert("비밀번호를 다시 확인해 주세요.")
			return false;
		} 
		
		var userIDCheck = RegExp(/^[A-Za-z0-9_\-]{4,20}$/);
		var userPWCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
		var nameCheck = RegExp(/^[가-힣a-zA-Z0-9]{2,10}$/);
		var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
		var numberCheck = RegExp(/^[0-9]{10,12}$/);
		
		if(!userIDCheck.test($('#userID').val())){
			alert("아이디 형식은 영문 4자 이상입니다.");
			$("#userID").focus();
			return false;
		} 
		else if(!userPWCheck.test($('#userPW').val())){
			alert("비밀번호 형식은 대문자+숫자+특수문자 8자 이상입니다.");
			$("#userPW").focus();
			return false;
		} 
		else if(!userPWCheck.test($('#userPWCheck').val())){
			alert("비밀번호 형식은 대문자+숫자+특수문자 8자 이상입니다.");
			$("#userPWCheck").focus();
			return false;
		} 
		else if(!nameCheck.test($('#userName').val())){
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