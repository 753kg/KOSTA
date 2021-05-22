
function solveM1(){
	document.getElementById("m_1").style.color = "red";
}

function solveM2(){
	var e = document.getElementById("m_2");
	e.setAttribute("class", "active");
}

function solveM3(){
	var imgs = document.querySelectorAll("#m_3 img");
	imgs.forEach(function(elt, i, array) {
		elt.setAttribute("src", "ch3.png");
	});
}

function solveM4(){
	var t = document.createTextNode("항목4");
	var e = document.createElement("p");
	m=document.getElementById("m_4");
	e.appendChild(t);
	m.appendChild(e);
	
	m.innerHTML += "<p>항목4</p>";
}

function solveM5(){
	var d = document.getElementById("m_5");
	var texts = document.querySelectorAll("#m_5 p");
	texts.forEach(function(elt) {
		//if(elt.innerText == "항목4") d.removeChild(elt);
		if(elt.innerHTML.indexOf("항목4") >= 0)		// 항목4가 존재하면
			d.removeChild(elt);
	});
}
		
function solveM6(){	
	var d = document.getElementById("m_6").parentNode;
	d.parentNode.removeChild(d);
	//document.querySelector("body").removeChild(d);
}