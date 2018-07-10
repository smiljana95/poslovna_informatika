$(document).ready(function () {
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/radnik/getLoggedIn",
        type: "GET",
        dataType: "json",
        success: function (data) {
        	if(data.role === "REGISTERED") {
        		$("#tabProfileName").prepend(data.name);
        		var url_string = window.location.href;
        		var url = new URL(url_string);
        		var idPP = url.searchParams.get("idPP");
        		$.ajax({
        			async: false,
        			url: "http://localhost:1234/narudzbenica/getAllByPP/"+idPP,
        	        type: "GET",
        	        dataType: "json",
        	        success: function (data) {
        	        	var div = $('#divSveNarudzbenice');
        	        	div.empty();
        	        	var str="";
        	        	for(i=0; i<data.length; i++) {
	        	        	if(!data[i].poslata) {
	        	        		str += "<h1>#" + data[i].brojNarudzbenice + "</h1>";
	        	        		str += "<table id=\"tabelaNarudzbenica" + data[i].id + "\" width=\"400\">";
	        	        		str += "<tr><td>Broj narudzbenice</td><td>" + data[i].brojNarudzbenice + "</td></tr>";
	        	        		str += "<tr><td>Datum narudzbenice</td><td>" + data[i].datumNarudzbenice + "</td></tr>";
	        	        		str += "<tr><td>Ukupan PDV</td><td id=\"ukupanpdvnarudzbenice" + data[i].id + "\">" + data[i].ukupanPDV + "</td></tr>";
	        	        		str += "<tr><td>Ukupna cena bez PDV-a</td><td id=\"ukupnacenabezpdvnarudzbenice" + data[i].id + "\">" + data[i].ukupnaCenaBezPDVa + "</td></tr>";
	        	        		str += "<tr><td>Ukupna cena</td><td id=\"ukupnacenanarudzbenice" + data[i].id + "\">" + data[i].ukupnaCena + "</td></tr>";
	        	        		str += "<tr><td>Nacin placanja</td><td>" + data[i].nacinPlacanjaDTO.nazivTipaPlacanja + "</td></tr>";
	        	        		if(data[i].nacinPlacanjaDTO.nazivTipaPlacanja === "racun") {
	        	        			str += "<tr><td>Racun za uplatu</td><td>" + data[i].racunZaUplatu + "</td></tr>";
	        	        			str += "<tr><td>Poziv na broj</td><td>" + data[i].pozivNaBroj + "</td></tr>";
	        	        		}
	        	        		str += "<tr><td>Fiskalna godina</td><td>" + data[i].fiskalnaGodinaDTO.brojGodine + "</td></tr>";
	        	        		str += "<tr><td>Poslovni partner</td><td>" + data[i].poslovniPartnerDTO.naziv + "</td></tr>";
	        	        		str += "<tr><td>Grad poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.gradDTO.naziv + " " + data[i].poslovniPartnerDTO.gradDTO.ptt + "</td></tr>";
	        	        		str += "<tr><td>Adresa poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.adresa + "</td></tr>";
	        	        		str += "<tr><td>Kontakt telefon poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.kontaktTelefon + "</td></tr>";
	        	        		str += "</table></br>";
	        	        		
	        	        		str += "<table id=\"tabelaNarudzbenicaStavke" + data[i].id + "\" width=\"1000\">";
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
	        	        		for(j=0; j<data[i].stavkeUNarudzbeniciDTO.length; j++) {
	        	        			str += "<tr>";
	        	        			
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].artikalDTO.naziv + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].artikalDTO.opis + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].ukupnaKolicina + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].artikalDTO.jedinicaMereDTO.oznaka + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].jedinicnaCena + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].popust + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].osnovica + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].iznosPDVa + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].stopaPDVa + "</td>";
	        	        			str += "<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].jedinicnaCenaSaPDV + "</td>";
	        	        			
	        	        			str += "</tr>";
	        	        		}
	        	        		str += "</table><br/><br/>";
	        	        		str += "<div id=\"divCenovnik" + data[i].id + "\"></div>";
	        	        		str += "<button onclick=\"prikaziCenovnik(" + data[i].poslovniPartnerDTO.id + "," + data[i].id + ")\" class=\"btn btn-success\">Dodaj stavku</button>";
	        	        		str += "&nbsp&nbsp&nbsp<button class=\"btn btn-default\">Kreiraj fakturu</button>";
	        	        		str += "&nbsp&nbsp&nbsp<button class=\"btn btn-danger\">Obrisi narudzbenicu</button>";
	        	        		str += "<div class=\"okvir\"></div><br/><br/>";
	        	        	}
        	        	}
        	        	div.append(str);
        	        },
        	        error: function (jqxhr, textStatus, errorThrown) {
        	        	toastr['warning'] ('Nema narudzbnia');
        	            
        	        }
        		});
        	} else {
        		top.location.href = "index.html";
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	top.location.href = "index.html";
            
        }
	});
	
	

})