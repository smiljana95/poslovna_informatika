package poslovna.dto;

public class StavkaUNarudzbeniciDTO {
	
	private Long id;
	private int ukupnaKolicina;
	private double jedinicnaCena;
	private double popust;
	private double osnovica;
	private double iznosPDVa;
	private double stopaPDVa;
	private double jedinicnaCenaSaPDV;
	private ArtikalDTO artikalDTO;
	
	public StavkaUNarudzbeniciDTO(Long id, int ukupnaKolicina, double jedinicnaCena, double popust, double osnovica,
			double iznosPDVa, double stopaPDVa, double jedinicnaCenaBezPDVa) {
		
		this.id = id;
		this.ukupnaKolicina = ukupnaKolicina;
		this.jedinicnaCena = jedinicnaCena;
		this.popust = popust;
		this.osnovica = osnovica;
		this.iznosPDVa = iznosPDVa;
		this.stopaPDVa = stopaPDVa;
		this.jedinicnaCenaSaPDV = jedinicnaCenaBezPDVa;
	}
	
	

	public StavkaUNarudzbeniciDTO() {
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUkupnaKolicina() {
		return ukupnaKolicina;
	}

	public void setUkupnaKolicina(int ukupnaKolicina) {
		this.ukupnaKolicina = ukupnaKolicina;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}

	public double getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(double osnovica) {
		this.osnovica = osnovica;
	}

	public double getIznosPDVa() {
		return iznosPDVa;
	}

	public void setIznosPDVa(double iznosPDVa) {
		this.iznosPDVa = iznosPDVa;
	}

	public double getStopaPDVa() {
		return stopaPDVa;
	}

	public void setStopaPDVa(double stopaPDVa) {
		this.stopaPDVa = stopaPDVa;
	}

	public double getJedinicnaCenaSaPDV() {
		return jedinicnaCenaSaPDV;
	}

	public void setJedinicnaCenaSaPDV(double jedinicnaCenaBezPDVa) {
		this.jedinicnaCenaSaPDV = jedinicnaCenaBezPDVa;
	}

	public ArtikalDTO getArtikalDTO() {
		return artikalDTO;
	}

	public void setArtikalDTO(ArtikalDTO artikalDTO) {
		this.artikalDTO = artikalDTO;
	}
	
	
	
	
	
	

}
