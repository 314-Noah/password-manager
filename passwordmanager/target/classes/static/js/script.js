
function generate(path) {
	var url = "http://localhost:8080/operations/" + path + "/"
				+ document.getElementById('name').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('host').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('user').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('pass').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('topic').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('ID').innerHTML.replace("/", "@@@") 	+ "/"
				+ document.getElementById('color').style.backgroundColor 		+ "/";
	location = url;
}