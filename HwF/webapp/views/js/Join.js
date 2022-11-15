String.prototype.trim=function(){

	var TRIM_PATTERN=/(^\s*)|(\s*$)/g; //  \s => 요게 공백. /(^\s*)|(\s*$)/g : 앞의 공백과 뒤의 공백을 제거하라

	return this.replace(TRIM_PATTERN,"");

}
function send(){
	var f=document.forms[1];
	var check = 0;
	
	// 이름
	if(! /^[\uac00-\ud7a3]*$/g.test(f.name.value)){ //g: 완전일치, ^앞 $뒤 *0개이상, uac00~ud7a3은 한글 코드값  , gi대소문자 구분없이 완전일치
		alert("이름을 한글로 입력하세요.");
		f.name.focus();
		check= 1;
		return;
	}

	//아이디 유효성검사
	if(! /^[a-z][a-z0-9_$@#]{4,9}$/i.test(f.userid.value)){ // ^ : 앞에만 검사, $ : 뒤에만 검사, i 대소문자 구분 안함(없으면 소문자만 가능하다)
		alert("아이디는 첫문자가 영문자이고, 5~10 글자수만 가능합니다.");
		f.userid.focus();
		check= 1;
		return;
	}

	//패스워드 유효성검사
	if(! /^(?=.*[a-z])(?=.*[_!@#$%^&*]|.*[0-9]).{4,9}$/i.test(f.passwd.value)){
		alert("비밀번호는 영문자와 1개이상의 숫자 및 특수문자를 포함해야 하며, 5~10 글자수만 가능합니다.");
		f.passwd.focus();
		check= 1;
		return;
	}	
	
	if (check === 0){
	return true; 
	}
	else{
		f.check="false";
		return;
	}
}

const change = (choice) => {
	const parentElem = document.getElementById("selectList");
	document.getElementById("con").style.display="none";
	
	for (let i = 0; i < parentElem.childNodes.length; i++) {
		let childElem = parentElem.childNodes[i];

		if (childElem.id) {
			if ("s" + choice == childElem.id) childElem.style.display = "block";
			else childElem.style.display = "none";
		}
	}
};

window.onload = function(){
	document.getElementById("s1").style.display = "none";
	document.getElementById("s2").style.display = "none";
	document.getElementById("s3").style.display = "none";
	document.getElementById("s4").style.display = "none";
	document.getElementById("s7").style.display = "none";
	
}
