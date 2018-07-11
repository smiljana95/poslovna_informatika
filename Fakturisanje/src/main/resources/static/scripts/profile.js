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
        			url: "http://localhost:1234/poslovniPartner/getByKompanija/"+data.idKompanije,
        	        type: "GET",
        	        dataType: "json",
        	        success: function (data) {
        	        	var divDobavljaci = $("#tableDobavljaci");
        	        	var divKupci = $("#tableKupci");
        	        	var divKupDob = $("#tableKupciDobavljaci");
        	        	var ceoDivDob = $("#poslovniPartneriDob");
        	        	var ceoDivKup = $("#poslovniPartneriKup");
        	        	var ceoDivKupDob = $("#poslovniPartneriKupDob");
        	        	
        	        	for(i=0;i<data.length;i++){
        	        		if(data[i].tipPoslovnogPartneraDTO.naziv == 'dobavljac'){
        	        			divDobavljaci.append('<tr><td>'+data[i].naziv+'</td><td>'+data[i].gradDTO.naziv+'</td><td>'+data[i].adresa+'</td><td>'+data[i].kontaktTelefon+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"prikaziNarudzbenice('+data[i].id+')\">Prikazi narudzbenice</button></td></tr>');
        	        			ceoDivDob.append(divDobavljaci);
        	        		}else if(data[i].tipPoslovnogPartneraDTO.naziv == 'kupac'){
        	        			divKupci.append('<tr><td>'+data[i].naziv+'</td><td>'+data[i].gradDTO.naziv+'</td><td>'+data[i].adresa+'</td><td>'+data[i].kontaktTelefon+'</td><td ><button style=\"margin-left:15%;\" class=\"btn btn-default\" onclick=\"prikaziPrimljeneFakture('+data[i].id+')\">Prikazi fakture</button></td></tr>');
        	        			ceoDivKup.append(divKupci);
        	        		}else if(data[i].tipPoslovnogPartneraDTO.naziv == 'kupacdobavljac'){
        	        			divKupDob.append('<tr><td>'+data[i].naziv+'</td><td>'+data[i].gradDTO.naziv+'</td><td>'+data[i].adresa+'</td><td>'+data[i].kontaktTelefon+'</td><td><button style=\"margin-left:15%;\" class=\"btn btn-default\" onclick=\"prikaziNarudzbenice('+data[i].id+')\">Prikazi narudzbenice</button></td><td><button style=\"margin-left:3%;margin-right:15%;\" class=\"btn btn-default\" onclick=\"prikaziPrimljeneFakture('+data[i].id+')\">Prikazi fakture</button></td></tr>');
        	        			ceoDivKupDob.append(divKupDob);
        	        		}
        	        	}
        	        	
        	        },
        	        error: function (jqxhr, textStatus, errorThrown) {
        	        	top.location.href = "index.html";
        	            
        	        }
        		});
        	} else if(data.role=='ADMIN'){
        		var dugmePromeniAktivan = document.getElementById("promenaAktivnogCenovnika");
        		dugmePromeniAktivan.setAttribute("onclick","promeniAktivan('"+data.idKompanije+"')");
        		var postaviAktivanButton = document.getElementById("postaviAktivanButton");
        		postaviAktivanButton.setAttribute("onclick","postaviAktivan('"+data.idKompanije+"')");
	        	
        		$("#tabProfileName").text(data.name);
        		$.ajax({
        			async: false,
        			url: "http://localhost:1234/cenovnik/getByKompanija/"+data.idKompanije,
        	        type: "GET",
        	        dataType: "json",
        	        success: function (data) {
        	        	var paragrafAktivanCenovnik = $("#aktivanCenovnikP");
    	            	paragrafAktivanCenovnik.innerHTML = "";
        	        	var tableCenovnici = $("#tableCenovnici");
        	        	var selectAktivanCenovnik = $("#cenovniciSelect");
        	        	for(i=0;i<data.length;i++){
        	        		var brojStavki = data[i].stavkaCenovnikaDTO.length;
        	        		var aktivan;
        	        		
        	            	
        	        		if(data[i].aktivan){
        	        			paragrafAktivanCenovnik.innerHTML = "Trenutno aktivan cenovnik je cenovnik sa id-em: " + data[i].id + ".";
        	        			aktivan = "Da";
        	        		}else{
        	        			selectAktivanCenovnik.append('<option id=\"'+data[i].id+'\" value=\"'+data[i].id+'\">'+data[i].id+'</option>');
            	        		
        	        			aktivan = "Ne";
        	        		}
        	        		var rbr = data[i].id;
        	        		tableCenovnici.append('<tr><td>'+rbr+'</td><td>'+data[i].datumPocetkaVazenja+'</td><td>'+brojStavki+'</td><td>'+aktivan+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"prikaziCenovnikAdminu('+data[i].id+')\">Prikazi cenovnik</button><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"kopirajCenovnik('+data[i].id+')\">Kopiraj cenovnik</button></td></tr>');
        	        	}
        	        	
        	        },
        	        error: function (jqxhr, textStatus, errorThrown) {
        	        	top.location.href = "index.html";
        	            
        	        }
        		});
        	}else{
        		top.location.href = "index.html";
        	}
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	top.location.href = "index.html";
            
        }
    });
	
	
})


function promeniAktivan(idKompanije){
	$("#modalPromenaAktivnog").modal('toggle');
}
function postaviAktivan(idKompanije){

	var noviAktivanCenovnik = new Object();
	noviAktivanCenovnik.idKompanije = idKompanije;
	noviAktivanCenovnik.id = $("#cenovniciSelect").find(':selected').attr('id');
	//ajax
	$.ajax({
		async: false,
		url: "http://localhost:1234/cenovnik/promeniAktivan",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(noviAktivanCenovnik),
        dataType: "json",
        success: function (data) {
        	toastr["success"]("Uspesno promenjen aktivan cenovnik.");
        	//location.reload();
        	$("#cenovniciSelect").empty();
        	document.getElementById("cenovniciSelect").value = "";
        	var paragrafAktivanCenovnik = $("#aktivanCenovnikP");
        	paragrafAktivanCenovnik.innerHTML = "";
        	$("#modalPromenaAktivnog").modal('toggle');
        	$("#tableCenovnici").find("tr:gt(0)").remove();
        	$("#cenovniciSelect").empty();
        	document.getElementById("cenovniciSelect").value = "";
        	var paragrafAktivanCenovnik = $("#aktivanCenovnikP");
        	paragrafAktivanCenovnik.innerHTML = "";
        	
        	var tableCenovnici = $("#tableCenovnici");
        	var selectAktivanCenovnik = $("#cenovniciSelect");
        	for(i=0;i<data.length;i++){
        		var brojStavki = data[i].stavkaCenovnikaDTO.length;
        		var aktivan;
        		var paragrafAktivanCenovnik = $("#aktivanCenovnikP");
        		if(data[i].aktivan){
        			paragrafAktivanCenovnik.innerHTML = "Trenutno aktivan cenovnik je cenovnik sa id-em: " + data[i].id + ".";
        			aktivan = "Da";
        		}else{
        			selectAktivanCenovnik.append('<option id=\"'+data[i].id+'\" value=\"'+data[i].id+'\">'+data[i].id+'</option>');
	        		
        			aktivan = "Ne";
        		}
        		var rbr =data[i].id;
        		tableCenovnici.append('<tr><td>'+rbr+'</td><td>'+data[i].datumPocetkaVazenja+'</td><td>'+brojStavki+'</td><td>'+aktivan+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"prikaziCenovnikAdminu('+data[i].id+')\">Prikazi cenovnik</button><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"kopirajCenovnik('+data[i].id+')\">Kopiraj cenovnik</button></td></tr>');
          	  
        	}
        	
        },
        error: function (jqxhr, textStatus, errorThrown) {
        	top.location.href = "index.html";
            
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