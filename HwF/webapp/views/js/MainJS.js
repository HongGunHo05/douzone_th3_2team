const change = (choice) => {
	const parentElem = document.getElementById("selectList");

	for (let i = 0; i < parentElem.childNodes.length; i++) {
		let childElem = parentElem.childNodes[i];

		if (childElem.id) {
			if ("s" + choice == childElem.id) childElem.style.display = "block";
			else childElem.style.display = "none";
		}
	}
};

document.addEventListener("DOMContentLoaded", () => {
	change("1");
});