// 메뉴 선택
const change = (choice) => {
	const parentElem = document.getElementById("selectList");
	document.getElementById("nutrientsListDiv").style.display = "none";

	for (let i = 0; i < parentElem.childNodes.length; i++) {
		let childElem = parentElem.childNodes[i];

		if (childElem.id) {
			if ("s" + choice == childElem.id) childElem.style.display = "block";
			else childElem.style.display = "none";
		}
	}
};

// 선택 아이디 전달

let serve = '';
function check_checkbox(event) {
	if (event.target.checked) {
		serve = serve + event.target.value + ',';
	} else {
		serve = serve.replace(event.target.value + ',', '');
	}
	$('input[name=hiddenid]').attr('value', serve);

	console.log(serve);
}

// 총 가격 출력
window.onload = function() {
	var price = document.getElementsByClassName("purchasePrice");
	let total = 0;
	for (var i = 0; i < price.length; i++) {
		total = parseInt(price[i].innerText) + total;
	}

	const purchaseElement = document.getElementById("purchasetotalprice");
	purchaseElement.innerText = total;
}

//구매시 호출 되는 함수 

function callpurchase() {
	serve = '';
	var value = document.getElementsByName("whatcheck");

	for (var i = 0; i < value.length; i++) {
		serve = serve + value[i].value + ',';
	}

	location.href = 'cart?cmd=purchase&id=' + serve;
}

function callcreditpurchase() {
	serve = '';
	var value = document.getElementsByName("whatcheck");

	for (var i = 0; i < value.length; i++) {
		serve = serve + value[i].value + ',';
	}

	location.href = 'cart?cmd=creditpurchase&id=' + serve;
}