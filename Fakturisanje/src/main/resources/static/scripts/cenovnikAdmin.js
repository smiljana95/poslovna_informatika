$(document).ready(function () {
	var url_string = window.location.href;
	var url = new URL(url_string);
	var idCenovnika = url.searchParams.get("idCenovnika");
	$.ajax({
			async: false,
			url: "http://localhost:1234/cenovnik/getCenovnikZaPrikaz/"+idCenovnika,
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	        	var cenovnikAdminTable = $('#cenovnikAdminTable');
	        	for(i=0;i<data.stavkaCenovnikaDTO.length;i++){
	        		cenovnikAdminTable.append('<tr><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.naziv+'</td><td>'+data.stavkaCenovnikaDTO[i].cena+'</td><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.opis+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-danger\" onclick=\"obrisiStavku('+data.id+',' + data.stavkaCenovnikaDTO[i].id + ')\">Obrisi stavku</button></td></tr>');
	        		
	        	}
	        	cenovnikAdminTable.append('<tr><td colspan=\"4\"> <button style=\"margin-left:40%\" class=\"btn btn-success\" onclick=\"dodajStavku('+data.id+')\">Nova stavka</button> </td></tr>')
	        },
	        error: function (jqxhr, textStatus, errorThrown) {
	        	alert(textStatus);
	            
	        }
		});
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/izlistajArtikle",
        type: "GET",
        dataType: "json",
        success: function (data) {
        	
        	var selectArtikli = $('#odaberiArtikalSelect');
        	for(i=0;i<data.length;i++){
        		selectArtikli.append('<option id=\"'+data[i].id+'\" value=\"'+data[i].id+'\">'+data[i].naziv+'</option>');
        		
        	}
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	alert(textStatus);
            
        }
	});
})

function obrisiStavku(idCenovnika, idStavke) {
	$("#cenovnikAdminTable").find("tr:gt(0)").remove();
	var stavkaZaBrisanje = new Object();
	stavkaZaBrisanje.id = idStavke;
	stavkaZaBrisanje.idCenovnika = idCenovnika;
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/obrisiStavku",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(stavkaZaBrisanje),
        dataType: "json",
        success: function (data) {
        	toastr["success"]("Stavka uspesno obrisana!");
        	
        	var cenovnikAdminTable = $('#cenovnikAdminTable');
        	for(i=0;i<data.stavkaCenovnikaDTO.length;i++){
        		cenovnikAdminTable.append('<tr><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.naziv+'</td><td>'+data.stavkaCenovnikaDTO[i].cena+'</td><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.opis+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-danger\" onclick=\"obrisiStavku('+data.id+',' + data.stavkaCenovnikaDTO[i].id + ')\">Obrisi stavku</button></td></tr>');
        		
        	}
        	cenovnikAdminTable.append('<tr><td colspan=\"4\"> <button style=\"margin-left:40%\" class=\"btn btn-success\" onclick=\"dodajStavku('+data.id+')\">Nova stavka</button> </td></tr>')
      	  
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	alert(textStatus);
            
        }
	});
}

function dodajStavku(idCenovnika) {
	$('#modalNovaStavka').modal('toggle');
	var btnDodaj = document.getElementById("dodajStavkuButton");
	btnDodaj.setAttribute('onclick','potvrdiDodavanjeStavke('+idCenovnika+')');
}

function potvrdiDodavanjeStavke(idCenovnika) {
	$('#modalNovaStavka').modal('toggle');
	$("#cenovnikAdminTable").find("tr:gt(0)").remove();
	var stavkaZaDodavanje = new Object();
	var cena = document.getElementById("cenaNoveStavke").value;
	if(cena.trim()=="" || isNaN(cena)){
		toastr["error"]("Unesite ispravnu brojcanu vrednost za cenu stavke.");
		return;
	}
	stavkaZaDodavanje.cena = document.getElementById("cenaNoveStavke").value;
	stavkaZaDodavanje.id = $("#odaberiArtikalSelect").find(':selected').attr('id');
	stavkaZaDodavanje.idCenovnika = idCenovnika;
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/dodajStavku",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(stavkaZaDodavanje),
        dataType: "json",
        success: function (data) {
        	toastr["success"]("Stavka uspesno dodata!");
        	
        	var cenovnikAdminTable = $('#cenovnikAdminTable');
        	for(i=0;i<data.stavkaCenovnikaDTO.length;i++){
        		cenovnikAdminTable.append('<tr><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.naziv+'</td><td>'+data.stavkaCenovnikaDTO[i].cena+'</td><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.opis+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-danger\" onclick=\"obrisiStavku('+data.id+',' + data.stavkaCenovnikaDTO[i].id + ')\">Obrisi stavku</button></td></tr>');
        		
        	}
        	cenovnikAdminTable.append('<tr><td colspan=\"4\"> <button style=\"margin-left:40%\" class=\"btn btn-success\" onclick=\"dodajStavku('+data.id+')\">Nova stavka</button> </td></tr>')
        	document.getElementById("cenaNoveStavke").value = "";
        	document.getElementById("odaberiArtikalSelect").value = "";
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	alert(textStatus);
            
        }
	});
}
