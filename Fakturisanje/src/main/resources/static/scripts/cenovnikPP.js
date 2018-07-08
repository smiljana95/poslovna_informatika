$(document).ready(function () {
	var url_string = window.location.href;
	var url = new URL(url_string);
	var idPP = url.searchParams.get("idPP");
	$.ajax({
			async: false,
			url: "http://localhost:1234/cenovnik/getByPP/"+idPP,
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	        	var cenovnikPPDiv = $('#cenovnikPPDiv');
	        	var cenovnikPPTable = $('#cenovnikPPTable');
	        	for(i=0;i<data.stavkaCenovnikaDTO.length;i++){
	        		cenovnikPPTable.append('<tr><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.naziv+'</td><td>'+data.stavkaCenovnikaDTO[i].cena+'</td><td>'+data.stavkaCenovnikaDTO[i].artikalDTO.opis+'</td></tr>');
	        		cenovnikPPDiv.append(cenovnikPPTable);
	        	}
	        },
	        error: function (jqxhr, textStatus, errorThrown) {
	        	alert(textStatus);
	            
	        }
		});
})