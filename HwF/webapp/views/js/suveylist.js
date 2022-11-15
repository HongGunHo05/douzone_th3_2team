
function submitDelete(frm) {

	let msgConfirm = confirm("정말로 삭제하시겠습니까?");

	if (!msgConfirm) {
		alert("취소를 누르셨습니다.");
		return false;
	}
	else {
		alert("삭제가 완료되었습니다.");
		frm.action = "./Member?cmd=surveyDelete"
		frm.submit();
		return true;
	}
}

const change = (choice) => {
	const parentElem = document.getElementById("selectList");
	document.getElementById("con").style.display = "none";

	for (let i = 0; i < parentElem.childNodes.length; i++) {
		let childElem = parentElem.childNodes[i];

		if (childElem.id) {
			if ("s" + choice == childElem.id) childElem.style.display = "block";
			else childElem.style.display = "none";
		}
	}
};

window.onload = function() {
	document.getElementById("s1").style.display = "none";
	document.getElementById("s2").style.display = "none";
	document.getElementById("s3").style.display = "none";
	document.getElementById("s4").style.display = "none";
	document.getElementById("s7").style.display = "none";

};