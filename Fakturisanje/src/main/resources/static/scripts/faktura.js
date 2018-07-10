function kreirajDirektnoFakturu(idPP) {
	elements = $('.inputKolicina');
	$('#divKreirajFakturu').hide();
	var listOfObjects = [];
	for(i=0; i<elements.length; i++) {
		var singleObj = {}
	    singleObj['id'] = elements[i].id;
	    singleObj['value'] = elements[i].value;
	    listOfObjects.push(singleObj);
	}
	
	var data = JSON.stringify({ 
		"idPartnera" : idPP, 
		"stavke" : listOfObjects });
	alert(listOfObjects);
}

function kreirajDirektnoFakturuForma() {
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
        	str += "<br><table style=\"width:100%;\">";
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
        				'</td><td style=\"width:20%;color:black;\"><input class=\"inputKolicina\" id=\"' + data.stavkaCenovnikaDTO[i].id + '\" type=\"number\" value=\"0\" class=\"form-control\"/></td></tr>';
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