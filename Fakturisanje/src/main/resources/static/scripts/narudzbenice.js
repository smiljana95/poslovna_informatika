function prikaziNarudzbenice(idPP){
	top.location.href = "narudzbenicePP.html?idPP="+idPP;
}

function dodajStavkuUNarudzbenicu() {
	idCenovnika = $('#idCenovnikaModal').val();
	idArtikla = $('#idArtiklaModal').val();
	idNarudzbenice = $('#idNarudzbeniceModal').val();
	idPP = $('#idPoslovnogPartneraModal').val();
	kolicina = $('#kolicinaInput').val();
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/stavkaUNarudzbenici/dodajStavku/" + idPP + "/" + idNarudzbenice + "/" + idArtikla + "/" + idCenovnika,
        type: "POST",
        contentType: "application/json",
        data: kolicina,
        success: function () {
        	top.location.href = "narudzbenicePP.html?idPP="+idPP;
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] (jqxhr.responseText);
            
        }
	})
}