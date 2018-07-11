function kreirajDirektnoFakturu(idPP) {
	idNacinaPlacanja = $('#selectDodajFakturuNacinPlacanja').val();
	elements = $('.inputKolicina');
	
	var listOfObjects = [];
	for(i=0; i<elements.length; i++) {
		var singleObj = {}
	    singleObj['id'] = elements[i].id;
	    singleObj['value'] = elements[i].value;
	    listOfObjects.push(singleObj);
	}
	
	var data = JSON.stringify({ 
		"idPartnera" : idPP, 
		"stavke" : listOfObjects,
		"idNacinaPlacanja" : idNacinaPlacanja
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/faktura/kreairajDirektno",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: data,
        success: function (data) {
        	
        	var div = $('#divSveFakture');
        	var str="";
        	
        	str +="<div class=\"okvir\"><h1>#" + data.brojFakture + "</h1>";
    		str +="<table width=\"400\">";
    		str +="<tr><td>Broj fakture</td><td>" + data.brojFakture + "</td></tr>";
    		str +="<tr><td>Datum fakture</td><td>" + data.datumFakture + "</td></tr>";
    		str +="<tr><td>Ukupan PDV</td><td>" + data.ukupanPDV + "</td></tr>";
    		str +="<tr><td>Ukupna cena bez PDV-a</td><td>" + data.ukupnaCenaBezPDVa + "</td></tr>";
    		str +="<tr><td>Ukupna cena</td><td>" + data.ukupnaCena + "</td></tr>";
    		str +="<tr><td>Nacin placanja</td><td>" + data.nacinPlacanjaDTO.nazivTipaPlacanja + "</td></tr>";
    		if(data.nacinPlacanjaDTO.nazivTipaPlacanja === "racun") {
    			str +="<tr><td>Racun za uplatu</td><td>" + data.racunZaUplatu + "</td></tr>";
    			str +="<tr><td>Poziv na broj</td><td>" + data.pozivNaBroj + "</td></tr>";
    		}
    		str +="<tr><td>Fiskalna godina</td><td>" + data.fiskalnaGodinaDTO.brojGodine + "</td></tr>";
    		str +="<tr><td>Poslovni partner</td><td>" + data.poslovniPartnerDTO.naziv + "</td></tr>";
    		str +="<tr><td>Grad poslovnog partnera</td><td>" + data.poslovniPartnerDTO.gradDTO.naziv + " " + data.poslovniPartnerDTO.gradDTO.ptt + "</td></tr>";
    		str +="<tr><td>Adresa poslovnog partnera</td><td>" + data.poslovniPartnerDTO.adresa + "</td></tr>";
    		str +="<tr><td>Kontakt telefon poslovnog partnera</td><td>" + data.poslovniPartnerDTO.kontaktTelefon + "</td></tr>";
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
    		for(j=0; j<data.stavkeUFakturiDTO.length; j++) {
    			str +="<tr>";
    			
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].artikalDTO.naziv + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].artikalDTO.opis + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].ukupnaKolicina + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].artikalDTO.jedinicaMereDTO.oznaka + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].jedinicnaCena + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].popust + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].osnovica + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].iznosPDVa + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].stopaPDVa + "</td>";
    			str +="<td class=\"stavkaTabele\">" + data.stavkeUFakturiDTO[j].jedinicnaCenaSaPDV + "</td>";
    			
    			str +="</tr>";
    		}
    		str +="</table><br/><br/>";
    		str +="<div id=\"divCenovnik" + data.id + "\"></div>";
    		
    		str +="<button onclick=\"eksportujFakturu("+data.id+")\"  class=\"btn btn-default\">Eksportuj fakturu</button>";
    		str +="&nbsp&nbsp&nbsp<button onclick=\"obrisiFakturu("+data.id+")\" class=\"btn btn-danger\">Obrisi fakturu</button>";
    		str +="</div><br/><br/>";
        	
        	div.append(str);
        	$('#divKreirajFakturu').hide();
        	$("html, body").animate({ scrollTop: $(document).height() }, 2000);
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] (jqxhr.responseText);
            
        }
	});
}

function kreirajDirektnoFakturuForma() {
	
	$('#divCenovnikPoslovnogPartnera').empty();
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/poslovniPartner/getByUlogovani",
        type: "GET",
       
        success: function (data) {
        	var select = $('#selectDodajFakturuPP');
        	select.empty();
        	var str="";
        	str += "<option value=\"\" selected disabled hidden>Selektovati poslovnog partnera</option>";
        	for(i=0; i<data.length; i++) {
        		str += "<option value=\"" + data[i].id + "\">" + data[i].naziv + "</option>";
        	}
        	select.append(str);
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] (errorThrown);
            
        }
	});
	
	$.ajax({
		async: false,
		url: "http://localhost:1234/nacinPlacanja/getAll",
        type: "GET",
       
        success: function (data) {
        	var selectPlacanje = $('#selectDodajFakturuNacinPlacanja');
        	selectPlacanje.empty();
        	var str="";
        	str += "<option value=\"\" selected disabled hidden>Selektovati nacin placanja</option>";
        	for(i=0; i<data.length; i++) {
        		str += "<option value=\"" + data[i].id + "\">" + data[i].nazivTipaPlacanja + "</option>";
        	}
        	selectPlacanje.append(str);
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] (errorThrown);
            
        }
	});
	
	$('#divKreirajFakturu').show();
}

function prikaziCenovnikIzabranogDobavljaca() {
	var idPP = $('#selectDodajFakturuPP').val();
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/getByPP/"+idPP,
        type: "GET",
        dataType: "json",
        success: function (data) {
        	var cenovnikPPDiv = $('#divCenovnikPoslovnogPartnera');
        	cenovnikPPDiv.empty();
        	var str = "";
        	str += "<table style=\"width:100%;\">";
        	str += "<tr>";
        	str += "<th>Naziv</th>";
        	str += "<th>Cena</th>";
        	str += "<th>Opis</th>";
        	str += "</tr>";
        	for(i=0;i<data.stavkaCenovnikaDTO.length;i++){
        		if(data !=null){
        			str += '<tr><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.naziv+
        				'</td><td>'+data.stavkaCenovnikaDTO[i].cena+'</td><td>'+
        				data.stavkaCenovnikaDTO[i].artikalDTO.opis+
        				'</td><td style=\"width:5%;color:black;\"><input class=\"inputKolicina\" id=\"' + data.stavkaCenovnikaDTO[i].id + '\" type=\"number\" value=\"0\" class=\"form-control\"/></td></tr>';
	        	}
        	}
        	str += "</table></br>";
        	cenovnikPPDiv.append(str);
        	$("#btnKreirajFakturu").attr( "onClick", "kreirajDirektnoFakturu(" + idPP + ")" );
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	toastr['warning'] ('Poslovni partner nema cenovnik');
            
        }
	});
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