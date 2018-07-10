package poslovna.dto;

import java.util.List;

public class NovaFakturaDTO {

	private Long idPartnera;
	private Long idNacinaPlacanja;
	private List<NarucenaStavkaDTO> stavke;
	
	public NovaFakturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public NovaFakturaDTO(Long idPartnera, Long idNacinaPlacanja, List<NarucenaStavkaDTO> stavke) {
		this.idPartnera = idPartnera;
		this.idNacinaPlacanja = idNacinaPlacanja;
		this.stavke = stavke;
	}

	public Long getIdPartnera() {
		return idPartnera;
	}

	public void setIdPartnera(Long idPartnera) {
		this.idPartnera = idPartnera;
	}

	public List<NarucenaStavkaDTO> getStavke() {
		return stavke;
	}

	public void setStavke(List<NarucenaStavkaDTO> stavke) {
		this.stavke = stavke;
	}

	public Long getIdNacinaPlacanja() {
		return idNacinaPlacanja;
	}

	public void setIdNacinaPlacanja(Long idNacinaPlacanja) {
		this.idNacinaPlacanja = idNacinaPlacanja;
	}
	
}
