/**
 * 
 */

document.querySelector("#open").onclick = function(){
	document.querySelector("#desc").style.display = "block";
	this.style.display = "none";
}
document.querySelector("#close").onclick = function(){
	document.querySelector("#desc").style.display = "none";
	document.querySelector("#open").style.display = "block";
}