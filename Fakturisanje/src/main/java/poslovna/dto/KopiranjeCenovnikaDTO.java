package poslovna.dto;

public class KopiranjeCenovnikaDTO {
	
	private Long idCenovnika;
	private double procenat;
	
	public KopiranjeCenovnikaDTO(Long idCenovnika, double procenat) {
		super();
		this.idCenovnika = idCenovnika;
		this.procenat = procenat;
	}
	
	public KopiranjeCenovnikaDTO(){
		
	}

	public Long getIdCenovnika() {
		return idCenovnika;
	}

	public void setIdCenovnika(Long idCenovnika) {
		this.idCenovnika = idCenovnika;
	}

	public double getProcenat() {
		return procenat;
	}

	public void setProcenat(double procenat) {
		this.procenat = procenat;
	}
	
	
	
}
