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
        	        	for(i=0; i<data.length; i++) {
        	        		div.append("<h1>#" + data[i].brojNarudzbenice + "</h1>")
        	        		div.append("<table width=\"200\">");
        	        		div.append("<tr><td>Broj narudzbenice</td><td>" + data[i].brojNarudzbenice + "</td></tr>")
        	        		div.append("<tr><td>Datum narudzbenice</td><td>" + data[i].datumNarudzbenice + "</td></tr>")
        	        		div.append("<tr><td>Ukupan PDV</td><td>" + data[i].ukupanPDV + "</td></tr>")
        	        		div.append("<tr><td>Ukupna cena bez PDV-a</td><td>" + data[i].ukupnaCenaBezPDVa + "</td></tr>")
        	        		div.append("<tr><td>Ukupna cena</td><td>" + data[i].ukupnaCena + "</td></tr>")
        	        		div.append("<tr><td>Nacin placanja</td><td>" + data[i].nacinPlacanjaDTO.nazivTipaPlacanja + "</td></tr>")
        	        		if(data[i].nacinPlacanjaDTO.nazivTipaPlacanja === "racun") {
        	        			div.append("<tr><td>Racun za uplatu</td><td>" + data[i].racunZaUplatu + "</td></tr>")
        	        			div.append("<tr><td>Poziv na broj</td><td>" + data[i].pozivNaBroj + "</td></tr>")
        	        		}
        	        		div.append("<tr><td>Fiskalna godina</td><td>" + data[i].fiskalnaGodinaDTO.brojGodine + "</td></tr>")
        	        		div.append("<tr><td>Poslovni partner</td><td>" + data[i].poslovniPartnerDTO.naziv + "</td></tr>")
        	        		div.append("<tr><td>Grad poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.gradDTO.naziv + " " + data[i].poslovniPartnerDTO.gradDTO.PTT + "</td></tr>")
        	        		div.append("<tr><td>Adresa poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.adresa + "</td></tr>")
        	        		div.append("<tr><td>Kontakt telefon poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.kontaktTelefon + "</td></tr>")
        	        		div.append("</table></br>");
        	        		
        	        		div.append("<table width=\"200\">");
        	        		div.append("<tr><td colspan=\"10\">Stavke</td></tr>")
        	        		div.append("<th class=\"stavkaTabele\">Naziv</th>")
        	        		div.append("<th class=\"stavkaTabele\">Opis</th>")
        	        		div.append("<th class=\"stavkaTabele\">Kolicina</th>")
        	        		div.append("<th class=\"stavkaTabele\">Jedinica mere</th>")
        	        		div.append("<th class=\"stavkaTabele\">Jedinicna cena</th>")
        	        		div.append("<th class=\"stavkaTabele\">Popust(%)</th>")
        	        		div.append("<th class=\"stavkaTabele\">Osnovica</th>")
        	        		div.append("<th class=\"stavkaTabele\">Iznos PDV-a</th>")
        	        		div.append("<th class=\"stavkaTabele\">Stopa PDV-a</th>")
        	        		div.append("<th class=\"stavkaTabele\">Jedinicna cena sa PDV-om</th>")
        	        		for(j=0; j<data[i].stavkeUNarudzbeniciDTO.length; j++) {
        	        			div.append("<tr>")
        	        			
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].artikalDTO.naziv + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].artikalDTO.opis + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].ukupnaKolicina + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].artikalDTO.jedinicaMereDTO.oznaka + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].jedinicnaCena + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].popust + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].osnovica + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].iznosPDVa + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].stopaPDVa + "</td>")
        	        			div.append("<td class=\"stavkaTabele\">" + data[i].stavkeUNarudzbeniciDTO[j].jedinicnaCenaSaPDV + "</td>")
        	        			
        	        			div.append("</tr>")
        	        		}
        	        		div.append("</table><br/><br/>");
        	        		div.append("<div id=\"divCenovnik" + data[i].id + "\"></div>")
        	        		div.append("<button onclick=\"prikaziCenovnik(" + data[i].poslovniPartnerDTO.id + "," + data[i].id + ")\" class=\"btn btn-success\">Dodaj stavku</button>")
        	        		div.append("&nbsp&nbsp&nbsp<button class=\"btn btn-default\">Kreiraj fakturu</button>")
        	        		div.append("&nbsp&nbsp&nbsp<button class=\"btn btn-danger\">Obrisi narudzbenicu</button>")
        	        		div.append("<div class=\"okvir\"></div><br/><br/>")
        	        	}
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