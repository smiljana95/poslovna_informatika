$(document).ready(function () {
	$.ajax({
		async: false,
		url: "http://localhost:1234/radnik/getLoggedIn",
        type: "GET",
        dataType: "json",
        success: function (data) {
        	if(data.role === "REGISTERED") {
        		$("#tabProfileName").text(data.name);
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
        	        			divDobavljaci.append('<tr><td>'+data[i].naziv+'</td><td>'+data[i].gradDTO.naziv+'</td><td>'+data[i].adresa+'</td><td>'+data[i].kontaktTelefon+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"prikaziCenovnik('+data[i].id+')\">Prikazi cenovnik</button></td></tr>');
        	        			ceoDivDob.append(divDobavljaci);
        	        		}else if(data[i].tipPoslovnogPartneraDTO.naziv == 'kupac'){
        	        			divKupci.append('<tr><td>'+data[i].naziv+'</td><td>'+data[i].gradDTO.naziv+'</td><td>'+data[i].adresa+'</td><td>'+data[i].kontaktTelefon+'</td></tr>');
        	        			ceoDivKup.append(divKupci);
        	        		}else if(data[i].tipPoslovnogPartneraDTO.naziv == 'kupacdobavljac'){
        	        			divKupDob.append('<tr><td>'+data[i].naziv+'</td><td>'+data[i].gradDTO.naziv+'</td><td>'+data[i].adresa+'</td><td>'+data[i].kontaktTelefon+'</td><td><button style=\"margin-left:15%\" class=\"btn btn-default\" onclick=\"prikaziCenovnik('+data[i].id+')\">Prikazi cenovnik</button></td></tr>');
        	        			ceoDivKupDob.append(divKupDob);
        	        		}
        	        	}
        	        	
        	        },
        	        error: function (jqxhr, textStatus, errorThrown) {
        	        	top.location.href = "index.html";
        	            
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