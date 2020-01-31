
function generate(path) {
	var url = "https://my-password-manager.herokuapp.com/operations/" + path + "/"
				+ document.getElementById('name').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('host').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('user').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('pass').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('topic').	value.replace("/", "@@@") 	+ "/"
				+ document.getElementById('ID').innerHTML.replace("/", "@@@") 	+ "/"
				+ document.getElementById('color').style.backgroundColor 		+ "/";
	location = url;
}
