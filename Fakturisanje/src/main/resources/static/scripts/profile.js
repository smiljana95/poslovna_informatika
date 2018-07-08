$(document).ready(function () {
	$.ajax({
		async: false,
		url: "http://localhost:1234/radnik/getLoggedIn",
        type: "GET",
        dataType: "json",
        success: function (data) {
        	if(data.role === "REGISTERED") {
        		$("#tabProfileName").text(data.name);
        	} else {
        		top.location.href = "index.html";
        	}
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	top.location.href = "index.html";
            
        }
    });
})