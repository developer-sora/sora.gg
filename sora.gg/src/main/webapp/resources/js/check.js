function logincheck(){
	
	let emailInput = document.f.u_email;
	let pwInput = document.f.u_password;
	

	if(isEmpty(emailInput)){
		alert('Email을 입력하세요.');
		emailInput.value="";
		emailInput.focus();
	
		return false;
	}
	
	if(isEmpty(pwInput)){
		alert('Password를 입력하세요.');
		pwInput.value="";
		pwInput.focus();
	
		return false;
	}
	
	return true;
	
	
}

function joincheck(){
	
	let emailInput = document.j.u_email;
	let nameInput = document.j.u_nickname;
	let pwInput = document.j.u_password;
	let pwCheckInput = document.j.passwordCheck;

	if(isEmpty(emailInput)){
		alert('Email을 입력하세요.');
		emailInput.value="";
		emailInput.focus();
	
		return false;
	}
	
	if(isEmpty(nameInput)){
		alert('Nickname을 입력하세요.');
		nameInput.value="";
		nameInput.focus();
	
		return false;
	}
	
		if(isEmpty(nameInput)){
		alert('Nickname을 입력하세요.');
		nameInput.value="";
		nameInput.focus();
	
		return false;
	}
	
	if(isEmpty(pwInput)){
		alert('Password를 입력하세요.');
		pwInput.value="";
		pwInput.focus();
	
		return false;
	}
	
		if(isEmpty(pwCheckInput)){
		alert('Password Check를 입력하세요.');
		pwCheckInput.value="";
		pwCheckInput.focus();
	
		return false;
	}
	
	if(pwCheck(pwInput,pwCheckInput)){
		alert('Password가 다릅니다');
		pwInput.value="";
		pwCheckInput.value="";
		pwInput.focus();
			
		return false;
	}
	
	if(! emailCheck(emailInput)){
		
		alert('올바른 Email 형식이 아닙니다.');
		emailInput.value="";
		emailInput.focus();
	
		return false;
		
	}
	
	
	return true;
	
	
}
	
	
/*	
	if(containKR(idInput)){
		alert('올바른 문자를 입력하세요');
		idInput.value="";
		idInput.focus();
		
		return false;
	}
	
	if(isEmpty(lenInput)||lessThan(lenInput, 3)){
		alert('id 입력 오류');
		lenInput.value="";
		lenInput.focus();
	
		return false;
	}
	
		if(isEmpty(pwInput)
		||lessThan(pwInput,5)
		||notContains(pwInput,"QWERTYUIOPASDFGHJKLZXCVBNM")
		||notContains(pwInput,"1234567890")
		){
		alert('비밀번호 입력 오류');
		pwInput.value="";
		pwInput.focus();
	
		return false;
	}
	
	if(pwCheck(pwInput,pwCheckInput)){
		alert('비밀번호 확인 오류');
		pwInput.value="";
		pwCheckInput.value="";
		pwInput.focus();
			
		return false;
	}
*/	

/*
	if(isEmpty(numInput)||
		isNotNum(numInput)){
		alert('숫자만 입력하세요');
		numInput.value="";
		numInput.focus();
		return false;
	}
	
/*	if(lessThan(idInput, 3)){
		alert('글자수 부족');
		lenInput.value="";
		lenInput.focus();
	
		return false;
	*/	
	
	/*	if(lessThan(lenInput, 3)){
		alert('글자수 에러');
		lenInput.value="";
		lenInput.focus();
	
		return false;}
	*/
	
	
	
	
	
	