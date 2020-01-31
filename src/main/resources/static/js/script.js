
function generate(path) {
	var url = "https://my-password-manager.herokuapp.com/operations/" + path + "/"
				+ encodeURIComponent(document.getElementById('name').	value.replace("/", "@@@"))	+ "/"
				+ encodeURIComponent(document.getElementById('host').	value.replace("/", "@@@"))	+ "/"
				+ encodeURIComponent(document.getElementById('user').	value.replace("/", "@@@")) 	+ "/"
				+ encodeURIComponent(document.getElementById('pass').	value.replace("/", "@@@"))	+ "/"
				+ encodeURIComponent(document.getElementById('topic').	value.replace("/", "@@@")) 	+ "/"
				+ encodeURIComponent(document.getElementById('ID').innerHTML.replace("/", "@@@")) 	+ "/"
				+ encodeURIComponent(document.getElementById('color').style.backgroundColor)		+ "/";
	location = url;
}
