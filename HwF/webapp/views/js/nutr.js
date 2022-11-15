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

// 사는 방식 선택
const selectbuymethod = (choice) => {
	const parentElem = document.getElementById("selectbuymethod");

	for (let i = 0; i < parentElem.childNodes.length; i++) {
		let childElem = parentElem.childNodes[i];

		if (childElem.id) {
			if ("buy" + choice == childElem.id) childElem.style.display = "block";
			else childElem.style.display = "none";
		}
	}
};


// 일수 수량, 갯수 늘리는 함수
const countnum = (type) => {

	const takeoneElement = document.getElementById("takeone");

	const onetotalElement = document.getElementById("onetotal");

	const countoneElement = document.getElementById("countone");

	let takeone = parseInt(takeoneElement.innerText);
	let onetotal = parseInt(onetotalElement.value);
	let countone = parseInt(countoneElement.value);

	if (type === "plus") {
		onetotal += takeone;
		countone += 1;
	} else if (type === "minus") {
		if (onetotal >= takeone) {
			onetotal -= takeone;
			countone -= 1;
		}
	}

	$('input[name=onetotal]').attr('value', onetotal);
	$('input[name=countone]').attr('value', countone);
}



// 낱개 수량, 가격 늘리는 함수
const count = (type) => {

	const resultElemet = document.getElementById("result");

	const totalElement = document.getElementById("total");

	const countElement = document.getElementById("countnum");

	let number = resultElemet.innerText;
	let result = parseInt(totalElement.value);
	let countnum = parseInt(countElement.value);

	if (type === "plus") {
		result += parseInt(number);
		countnum += 1;
	} else if (type === "minus") {
		if (result >= parseInt(number)) {
			result -= parseInt(number);
			countnum -= 1;
		}
	}

	$('input[name=total]').attr('value', result);
	$('input[name=countnum]').attr('value', countnum);
}

// 시작시 한병 가격 나타나게 하기
window.onload = function() {
	const resultElemet = document.getElementById("result");
	const numperElement = document.getElementById("numperbottle");
	const oneElement = document.getElementById("takeone");

	let result = parseInt(resultElemet.innerText);
	let numper = parseInt(numperElement.innerText);

	oneElement.innerText = (result / numper).toFixed(0);

	document.getElementById("buy2").style.display = "none";

	/////////////////////////////////////////////////////////

	const nutrientsIDElement = document.getElementById("nutrientsID").innerText;

	$('input[name=hiddenid]').attr('value', nutrientsIDElement);

}


// 날짜 선택 
// 일 수 구매시 날짜
function selectnudate() {
	let result = new Date(document.getElementById("selectdate").value);
	// 입력 받은 날짜를 시간 형태로 저장

	const countday = document.getElementById("countone");

	let count = countday.value;

	let addDate = result.toISOString().substring(0, 10);

	let plusDate = new Date(addDate);
	plusDate.setDate(plusDate.getDate() + parseInt(count));
	plusDate = plusDate.toISOString().substring(0, 10);

	console.log(plusDate); // 더해진 날짜

	$('input[name=finishnutr]').attr('value', plusDate);


}

// 병당 구매시 날짜 선택
function selectnudate2() {
	let result = new Date(document.getElementById("selectdate2").value);

	const countday = document.getElementById("countnum");
	let count = countday.value;

	const numperday = document.getElementById("numperbottle");

	let numper = numperday.innerText;


	let addDate = result.toISOString().substring(0, 10);

	let plusDate = new Date(addDate);
	plusDate.setDate(plusDate.getDate() + (parseInt(count) * parseInt(numper)));
	plusDate = plusDate.toISOString().substring(0, 10);

	console.log(plusDate); // 더해진 날짜

	$('input[name=finishnutr2]').attr('value', plusDate);

}

