function kreirajDirektnoFakturu() {
	
}


function kreirajFakturuIzNarudzbenice(idNarudzbenice){
	$.ajax({
		async: false,
		url: "http://localhost:1234/faktura/kreirajFakturuIzNarudzbenice/"+idNarudzbenice,
        type: "GET",
       
        success: function (data) {
        	top.location.href = "fakture.html";
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] ('Nije moguce kreirati narudzbenicu');
            
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