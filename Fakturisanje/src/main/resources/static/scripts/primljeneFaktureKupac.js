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
        			url: "http://localhost:1234/faktura/getPrimljeneFakture/"+idPP,
        	        type: "GET",
        	        dataType: "json",
        	        success: function (data) {
        	        	var div = $('#divSvePrimljeneFakture');
        	        	div.empty();
        	        	var str = "";
        	        	for(i=0; i<data.length; i++) {
        	        		str +="<div class=\"okvir\"><h1>#" + data[i].brojFakture + "</h1>";
        	        		str +="<table width=\"400\">";
        	        		str +="<tr><td>Broj fakture</td><td>" + data[i].brojFakture + "</td></tr>";
        	        		str +="<tr><td>Datum fakture</td><td>" + data[i].datumFakture + "</td></tr>";
        	        		str +="<tr><td>Ukupan PDV</td><td>" + data[i].ukupanPDV + "</td></tr>";
        	        		str +="<tr><td>Ukupna cena bez PDV-a</td><td>" + data[i].ukupnaCenaBezPDVa + "</td></tr>";
        	        		str +="<tr><td>Ukupna cena</td><td>" + data[i].ukupnaCena + "</td></tr>";
        	        		str +="<tr><td>Nacin placanja</td><td>" + data[i].nacinPlacanjaDTO.nazivTipaPlacanja + "</td></tr>";
        	        		if(data[i].nacinPlacanjaDTO.nazivTipaPlacanja === "racun") {
        	        			str +="<tr><td>Racun za uplatu</td><td>" + data[i].racunZaUplatu + "</td></tr>";
        	        			str +="<tr><td>Poziv na broj</td><td>" + data[i].pozivNaBroj + "</td></tr>";
        	        		}
        	        		str +="<tr><td>Fiskalna godina</td><td>" + data[i].fiskalnaGodinaDTO.brojGodine + "</td></tr>";
        	        		str +="<tr><td>Poslovni partner</td><td>" + data[i].poslovniPartnerDTO.naziv + "</td></tr>";
        	        		str +="<tr><td>Grad poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.gradDTO.naziv + " " + data[i].poslovniPartnerDTO.gradDTO.ptt + "</td></tr>";
        	        		str +="<tr><td>Adresa poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.adresa + "</td></tr>";
        	        		str +="<tr><td>Kontakt telefon poslovnog partnera</td><td>" + data[i].poslovniPartnerDTO.kontaktTelefon + "</td></tr>";
        	        		str +="</table></br>";
        	        		
        	        		str +="<table width=\"1000\">";
        	        		str +="<tr><td colspan=\"10\">Stavke</td></tr>";
        	        		str +="<th class=\"stavkaTabele\">Naziv</th>";
        	        		str +="<th class=\"stavkaTabele\">Opis</th>";
        	        		str +="<th class=\"stavkaTabele\">Kolicina</th>";
        	        		str +="<th class=\"stavkaTabele\">Jedinica mere</th>";
        	        		str +="<th class=\"stavkaTabele\">Jedinicna cena</th>";
        	        		str +="<th class=\"stavkaTabele\">Popust(%)</th>";
        	        		str +="<th class=\"stavkaTabele\">Osnovica</th>";
        	        		str +="<th class=\"stavkaTabele\">Iznos PDV-a</th>";
        	        		str +="<th class=\"stavkaTabele\">Stopa PDV-a</th>";
        	        		str +="<th class=\"stavkaTabele\">Jedinicna cena sa PDV-om</th>";
        	        		for(j=0; j<data[i].stavkeUFakturiDTO.length; j++) {
        	        			str +="<tr>";
        	        			
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].artikalDTO.naziv + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].artikalDTO.opis + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].ukupnaKolicina + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].artikalDTO.jedinicaMereDTO.oznaka + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].jedinicnaCena + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].popust + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].osnovica + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].iznosPDVa + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].stopaPDVa + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUFakturiDTO[j].jedinicnaCenaSaPDV + "</td>";
        	        			
        	        			str +="</tr>";
        	        		}
        	        		str +="</table><br/><br/>";
        	        		str +="<div id=\"divCenovnik" + data[i].id + "\"></div>";
        	        		//str +="<button onclick=\"prikaziCenovnik(" + data[i].poslovniPartnerDTO.id + "," + data[i].id + ")\" class=\"btn btn-success\">Dodaj stavku</button>")
        	        		str +="<button onclick=\"otpremiFakturu("+data[i].id+")\"  class=\"btn btn-default\">Otpremi fakturu</button>";
        	        		str +="&nbsp&nbsp&nbsp<button onclick=\"obrisiFakturu("+data[i].id+")\" class=\"btn btn-danger\">Obrisi fakturu</button>";
        	        		str +="</div><br/><br/>";
        	        	}
        	        	div.append(str);
        	        },
        	        error: function (jqxhr, textStatus, errorThrown) {
        	        	toastr['warning'] ('Nema faktura');
        	            
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


function otpremiFakturu(idFakture){
	$.ajax({
		async: false,
		url: "http://localhost:1234/otpremnica/kreirajOtpremnicu/"+idFakture,
        type: "GET",
        success: function (data) {
        	top.location.href ="otpremnice.html";
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['error']('Nije moguce otpremiti fakturu');
        } 
	 });
}

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