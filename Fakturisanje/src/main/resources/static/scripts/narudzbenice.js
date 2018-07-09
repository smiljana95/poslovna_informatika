function prikaziNarudzbenice(idPP){
	top.location.href = "narudzbenicePP.html?idPP="+idPP;
}

function dodajStavkuUNarudzbenicu() {
	idCenovnika = $('#idCenovnikaModal').val();
	idArtikla = $('#idArtiklaModal').val();
	idNarudzbenice = $('#idNarudzbeniceModal').val();
	idPP = $('#idPoslovnogPartneraModal').val();
}