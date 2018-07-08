function buttonLoginClick() {
	email = $('#formLogin-email').val();
	lozinka = $('#formLogin-password').val();
	
	if(!email || !lozinka) {
		toastr["error"]('Fill in all required entry fields!');
		return;
	}
	
	var data = JSON.stringify({
		"email": email,
		"lozinka": lozinka
	});
	$.ajax({
		async: false,
		url: "http://localhost:1234/radnik/login",
        type: "POST",
        contentType: "application/json",
        data: data,
        success: function () {
        	top.location.href = "home.html";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            toastr["error"](jqXHR.responseText);
        }
    });
}



