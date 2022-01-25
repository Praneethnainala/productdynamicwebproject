function validateform() {
	var username = document.form.username.value;
	var password = document.form.password.value;

	if (username == null || username == "") {
		alert("insert vaild username");
		return false;
	} else if (password.length < 6) {
		alert("Password must be at least 6 characters long.");
		alert("insert password");
		return false;
	}
}
