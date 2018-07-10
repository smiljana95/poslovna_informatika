function prikaziCenovnik(idPP, idNarudzbenice) {
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/getByPP/"+idPP,
        type: "GET",
        dataType: "json",
        success: function (data) {
        	var cenovnikPPDiv = $('#divCenovnik'+idNarudzbenice);
        	cenovnikPPDiv.append("<table>");
        	cenovnikPPDiv.append("<tr>")
        	cenovnikPPDiv.append("<th>Naziv</th>")
        	cenovnikPPDiv.append("<th>Cena</th>")
        	cenovnikPPDiv.append("<th>Opis</th>")
        	cenovnikPPDiv.append("<th><a onclick=\"return zatvoriCenovnik(" + idNarudzbenice + ")\"><span style=\"float:right;\" class=\"glyphicon glyphicon-remove\"></span></a></th>")
        	cenovnikPPDiv.append("</tr>")
        	for(i=0;i<data.stavkaCenovnikaDTO.length;i++){
        		if(data !=null){
        			cenovnikPPDiv.append('<tr><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.naziv+'</td><td>'+data.stavkaCenovnikaDTO[i].cena+'</td><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.opis+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"naruci('+data.id+',' + data.stavkaCenovnikaDTO[i].artikalDTO.id + ',' + idNarudzbenice + ',' + idPP + ')\">Naruci</button></td></tr>');
	        	}
        	}
        	cenovnikPPDiv.append("</table></br>");
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] ('Poslovni partner nema cenovnik');
            
        }
	});
}

function zatvoriCenovnik(idNarudzbenice) {
	$('#divCenovnik'+idNarudzbenice).empty();
}

function naruci(idCenovnika, idArtikla, idNarudzbenice, idPP) {
	$('#idCenovnikaModal').val(idCenovnika);
	$('#idArtiklaModal').val(idArtikla);
	$('#idNarudzbeniceModal').val(idNarudzbenice);
	$('#idPoslovnogPartneraModal').val(idPP);
	
	$('#kolicinaInput').val('');
	
	$('#modalNaruci').modal('toggle');
}

function prikaziCenovnikAdminu(idCenovnika) {
	//top.location.href = "cenovnikPP.html?idPP="+idPP;
	top.location.href = "cenovnikAdmin.html?idCenovnika="+idCenovnika;
	
}

function kopirajCenovnik(idCenovnika) {
	
	var button = document.getElementById("kopirajKatalogButton");
	button.setAttribute("onclick","return potvrdiKopiranjeCenovnika('"+idCenovnika +"')");
	
	$("#myModal").modal('show');
}

function potvrdiKopiranjeCenovnika(idCenovnika) {
	
	var procenat = document.getElementById("procenatInput").value;
	if(procenat.trim()=="" || isNaN(procenat)){
		toastr["error"]("Unesite ispravnu brojcanu vrednost za procenat.");
		return;
	}
	var data = JSON.stringify({
		"idCenovnika": idCenovnika,
		"procenat": procenat
	});
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/kopiranjeCenovnika",
        type: "POST",
        contentType: "application/json",
        data: data,
        success: function (data) {
        	location.reload();
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] ('Poslovni partner nema cenovnik');
            
        }
	});
}
