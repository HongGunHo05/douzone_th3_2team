function submitDelete(frm)  {
 
 	let msgConfirm = confirm("정말로 삭제하시겠습니까?");
 
 	if (!msgConfirm) {
  		alert("취소를 누르셨습니다.");
  		return false;
  	} 
	else { 
	  	alert("삭제가 완료되었습니다.");
	  	 frm.action="./admin?cmd=AdminNutrientsDelete"
   		 frm.submit(); 
   		 return true; 
	}
}