$(document).ready(function () {
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/radnik/getLoggedIn",
        type: "GET",
        dataType: "json",
        success: function (data) {
        	if(data.role === "REGISTERED") {
        		$("#tabProfileName").prepend(data.name);
        		
        		$.ajax({
        			async: false,
        			url: "http://localhost:1234/otpremnica/getAllOtpremnice",
        	        type: "GET",
        	        dataType: "json",
        	        success: function (data) {
        	        	var div = $('#divSveOtpremnice');
        	        	div.empty();
        	        	var str = "";
        	        	for(i=0; i<data.length; i++) {
        	        		str +="<h1>#" + data[i].brojOtpremnice + "</h1>";
        	        		str +="<table width=\"400\">";
        	        		str +="<tr><td>Broj otpremnice</td><td>" + data[i].brojOtpremnice + "</td></tr>";
        	        		str +="<tr><td>Datum otpremnice</td><td>" + data[i].datumOtpremnice + "</td></tr>";
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
        	        		for(j=0; j<data[i].stavkeUOtpremniciDTO.length; j++) {
        	        			str +="<tr>";
        	        			
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].artikalDTO.naziv + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].artikalDTO.opis + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].ukupnaKolicina + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].artikalDTO.jedinicaMereDTO.oznaka + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].jedinicnaCena + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].popust + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].osnovica + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].iznosPDVa + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].stopaPDVa + "</td>";
        	        			str +="<td class=\"stavkaTabele\">" + data[i].stavkeUOtpremniciDTO[j].jedinicnaCenaSaPDV + "</td>";
        	        			
        	        			str +="</tr>";
        	        		}
        	        		str +="</table><br/><br/>";
        	        		str +="<div id=\"divCenovnik" + data[i].id + "\"></div>";
        	        		//str +="<button onclick=\"prikaziCenovnik(" + data[i].poslovniPartnerDTO.id + "," + data[i].id + ")\" class=\"btn btn-success\">Dodaj stavku</button>")
        	        		str +="<button onclick=\"eksportujOtpremnicu("+data[i].id+")\"  class=\"btn btn-default\">Eksportuj otpremnicu</button>";
        	        		str +="&nbsp&nbsp&nbsp<button onclick=\"obrisiOtpremnicu("+data[i].id+")\" class=\"btn btn-danger\">Obrisi otpremnicu</button>";
        	        		str +="<div class=\"okvir\"></div><br/><br/>";
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

function obrisiOtpremnicu(idOtpremnice){
	$.ajax({
		async: false,
		url: "http://localhost:1234/otpremnica/obrisiOtpremnicu/"+idOtpremnice,
        type: "DELETE",
        success: function (data) {
        	top.location.href = "otpremnice.html";
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['error']('Nije moguce obrisati otpremnicu');
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


function eksportujOtpremnicu(idOtpremnice){
	$.ajax({
    	url: "http://localhost:1234/otpremnica/eksportujOtpremnicu/"+idOtpremnice,
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