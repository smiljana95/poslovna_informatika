function prikaziIzlazneFakture(idPP) {
	top.location.href = "izlazneFakture.html?idPP=" + idPP;
}

function otpremiFakturu(idFakture) {
	$.ajax({
		async: false,
		url: "http://localhost:1234/otpremnica/kreirajOtpremnicu/"+idFakture,
        type: "GET",
       
        success: function (data) {
        	top.location.href = "otpremnice.html";
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] ('Nije moguce otpremiti fakturu.');
            
        }
	});
}
