
function obrisiFakturu(idFakture){
	$.ajax({
		async: false,
		url: "http://localhost:1234/faktura/obrisiFakturu/"+idFakture,
        type: "DELETE",
        success: function (data) {
        	top.location.href = "fakture.html";
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['error']('Nije moguce obrisati fakturu');
        } 
        });
}

function logout() {
    $.ajax({
    	url: "http://localhost:1234/radnik/logout",
        type: "POST",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
                top.location.href = "index.html";

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}


function eksportujFakturu(idFakture){
	$.ajax({
    	url: "http://localhost:1234/faktura/eksportujFakturu/"+idFakture,
        type: "GET",
        crossDomain: true,
        xhrFields: {
            withCredentials: true
         },
        success: function () {
                toastr['success']('Eksport uspesan');

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}