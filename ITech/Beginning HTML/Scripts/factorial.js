var fact = 1;
var text = "";
for (var i = 1; i < 10; i++) {
	fact *= i;
	text += (i + " ! = " + fact + "<br />");
}
document.getElementById("demo").innerHTML = text;