function prikaziNaseNarudzbenice(idPP){
	top.location.href = "naseNarudzbenice.html?idPP="+idPP;
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
        dataType: "json",
        data: kolicina,
        success: function (data) {
        	var tabelaStavke = $('#tabelaNarudzbenicaStavke' + idNarudzbenice);
        	tabelaStavke.empty();
        	var str = "";
        	str += "<tr><td colspan=\"10\">Stavke</td></tr>";
    		str += "<th class=\"stavkaTabele\">Naziv</th>";
    		str += "<th class=\"stavkaTabele\">Opis</th>";
    		str += "<th class=\"stavkaTabele\">Kolicina</th>";
    		str += "<th class=\"stavkaTabele\">Jedinica mere</th>";
    		str += "<th class=\"stavkaTabele\">Jedinicna cena</th>";
    		str += "<th class=\"stavkaTabele\">Popust(%)</th>";
    		str += "<th class=\"stavkaTabele\">Osnovica</th>";
    		str += "<th class=\"stavkaTabele\">Iznos PDV-a</th>";
    		str += "<th class=\"stavkaTabele\">Stopa PDV-a</th>";
    		str += "<th class=\"stavkaTabele\">Jedinicna cena sa PDV-om</th>";
        	for(j=0; j<data.stavkeUNarudzbeniciDTO.length; j++) {
	        	str += "<tr>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].artikalDTO.naziv + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].artikalDTO.opis + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].ukupnaKolicina + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].artikalDTO.jedinicaMereDTO.oznaka + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].jedinicnaCena + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].popust + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].osnovica + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].iznosPDVa + "</td>"
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].stopaPDVa + "</td>";
				str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].jedinicnaCenaSaPDV + "</td>";
				str += "</tr>";
        	}
			
			tabelaStavke.append(str);
			
			$('#ukupanpdvnarudzbenice' + idNarudzbenice).text(data.ukupanPDV);
        	$('#ukupnacenabezpdvnarudzbenice' + idNarudzbenice).text(data.ukupnaCenaBezPDVa);
        	$('#ukupnacenanarudzbenice' + idNarudzbenice).text(data.ukupnaCena);
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] (jqxhr.responseText);
            
        }
	})
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

function kreirajDirektnoNarudzbenicuShowModal() {
	$.ajax({
    	url: "http://localhost:1234/nacinPlacanja/getAll",
        type: "GET",
        dataType:"json",
        success: function (data) {
        	for(i=0; i<data.length; i++) {
        		$('#selectNacinPlacanja').append("<option value=\"" + data[i].id + "\">" + data[i].nazivTipaPlacanja + "</option>")
        	}
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
	
	$('#modalKreirajNarudzbenicu').modal('toggle');
}

function kreirajDirektnoNarudzbenicu() {
	var url_string = window.location.href;
	var url = new URL(url_string);
	var idPP = url.searchParams.get("idPP");
	
	var idNacinaPlacanja = $('#selectNacinPlacanja').val();
	
	$.ajax({
    	url: "http://localhost:1234/narudzbenica/createNew/" + idPP + "/" + idNacinaPlacanja,
        type: "GET",
        dataType:"json",
        success: function (data) {
        	var div = $('#divSveNarudzbenice');
        	
        	var str = "";
        	
    		str += "<div class=\"okvir\"><h1>#" + data.brojNarudzbenice + "</h1>";
    		str += "<table id=\"tabelaNarudzbenica" + data.id + "\" width=\"400\">";
    		str += "<tr><td>Broj narudzbenice</td><td>" + data.brojNarudzbenice + "</td></tr>";
    		str += "<tr><td>Datum narudzbenice</td><td>" + data.datumNarudzbenice + "</td></tr>";
    		str += "<tr><td>Ukupan PDV</td><td id=\"ukupanpdvnarudzbenice" + data.id + "\">" + data.ukupanPDV + "</td></tr>";
    		str += "<tr><td>Ukupna cena bez PDV-a</td><td id=\"ukupnacenabezpdvnarudzbenice" + data.id + "\">" + data.ukupnaCenaBezPDVa + "</td></tr>";
    		str += "<tr><td>Ukupna cena</td><td id=\"ukupnacenanarudzbenice" + data.id + "\">" + data.ukupnaCena + "</td></tr>";
    		str += "<tr><td>Nacin placanja</td><td>" + data.nacinPlacanjaDTO.nazivTipaPlacanja + "</td></tr>";
    		if(data.nacinPlacanjaDTO.nazivTipaPlacanja === "racun") {
    			str += "<tr><td>Racun za uplatu</td><td>" + data.racunZaUplatu + "</td></tr>";
    			str += "<tr><td>Poziv na broj</td><td>" + data.pozivNaBroj + "</td></tr>";
    		}
    		str += "<tr><td>Fiskalna godina</td><td>" + data.fiskalnaGodinaDTO.brojGodine + "</td></tr>";
    		str += "<tr><td>Poslovni partner</td><td>" + data.poslovniPartnerDTO.naziv + "</td></tr>";
    		str += "<tr><td>Grad poslovnog partnera</td><td>" + data.poslovniPartnerDTO.gradDTO.naziv + " " + data.poslovniPartnerDTO.gradDTO.ptt + "</td></tr>";
    		str += "<tr><td>Adresa poslovnog partnera</td><td>" + data.poslovniPartnerDTO.adresa + "</td></tr>";
    		str += "<tr><td>Kontakt telefon poslovnog partnera</td><td>" + data.poslovniPartnerDTO.kontaktTelefon + "</td></tr>";
    		str += "</table></br>";
    		
    		str += "<table id=\"tabelaNarudzbenicaStavke" + data.id + "\" width=\"1000\">";
    		str += "<tr><td colspan=\"10\">Stavke</td></tr>";
    		str += "<th class=\"stavkaTabele\">Naziv</th>";
    		str += "<th class=\"stavkaTabele\">Opis</th>";
    		str += "<th class=\"stavkaTabele\">Kolicina</th>";
    		str += "<th class=\"stavkaTabele\">Jedinica mere</th>";
    		str += "<th class=\"stavkaTabele\">Jedinicna cena</th>";
    		str += "<th class=\"stavkaTabele\">Popust(%)</th>";
    		str += "<th class=\"stavkaTabele\">Osnovica</th>";
    		str += "<th class=\"stavkaTabele\">Iznos PDV-a</th>";
    		str += "<th class=\"stavkaTabele\">Stopa PDV-a</th>";
    		str += "<th class=\"stavkaTabele\">Jedinicna cena sa PDV-om</th>";
    		for(j=0; j<data.stavkeUNarudzbeniciDTO.length; j++) {
    			str += "<tr>";
    			
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].artikalDTO.naziv + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].artikalDTO.opis + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].ukupnaKolicina + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].artikalDTO.jedinicaMereDTO.oznaka + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].jedinicnaCena + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].popust + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].osnovica + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].iznosPDVa + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].stopaPDVa + "</td>";
    			str += "<td class=\"stavkaTabele\">" + data.stavkeUNarudzbeniciDTO[j].jedinicnaCenaSaPDV + "</td>";
    			
    			str += "</tr>";
    		}
    		str += "</table><br/><br/>";
    		str += "<div id=\"divCenovnik" + data.id + "\"></div>";
    		str += "<button onclick=\"prikaziCenovnik(" + data.poslovniPartnerDTO.id + "," + data.id + ")\" class=\"btn btn-success\">Dodaj stavku</button>";
    		str += "&nbsp&nbsp&nbsp<button onclick=\"kreirajFakturuIzNarudzbenice(" + data.id + ")\" class=\"btn btn-default\">Kreiraj fakturu</button>";
    		str += "&nbsp&nbsp&nbsp<button onclick=\"obrisiNarudzbenicu(" + data.id + ")\" class=\"btn btn-danger\" class=\"btn btn-danger\">Obrisi narudzbenicu</button>";
    		str += "</div><br/><br/>";
        	
        	
        	
        	div.append(str);
        	
        	
        	$("html, body").animate({ scrollTop: $(document).height() }, 2000);
        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
	
}

function obrisiNarudzbenicu(idNarudzbenice) {
	$.ajax({
    	url: "http://localhost:1234/narudzbenica/delete/" + idNarudzbenice,
        type: "DELETE",
        success: function () {
        	var url_string = window.location.href;
        	var url = new URL(url_string);
        	var idPP = url.searchParams.get("idPP");
        	top.location.href = "narudzbenicePP.html?idPP="+idPP;

        }, error: function (jqxhr, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}