function isEmpty(input){
	return !input.value; // 값이 없다
	
}

function pwCheck(input,input2){
		return input.value != input2.value
		
	}
	
	
function emailCheck(input) { 
	var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; 
	return (email != '' && email != 'undefined' && regex.test(email)); }

function lessThan(input,length){
		return input.value.length < length;
		
	}



