// 일수 수량, 갯수 늘리는 함수
const countnum = (type) => {

	const onetotalElement = document.getElementById("onetotal");
	const countoneElement = document.getElementById("countone");
	const resultElemet = document.getElementById("result");

	let onetotal = parseInt(onetotalElement.value);
	let countone = parseInt(countoneElement.value);
	let number = resultElemet.innerText;

	if (type === "plus") {
		onetotal += parseInt(number);
		countone += 1;
	} else if (type === "minus") {
	
		if (onetotal >= number) {
			onetotal -= parseInt(number);
			countone -= 1;
		}
	}

	$('input[name=onetotal]').attr('value', onetotal);
	$('input[name=countone]').attr('value', countone);
}