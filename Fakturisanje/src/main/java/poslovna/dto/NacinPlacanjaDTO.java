package poslovna.dto;

public class NacinPlacanjaDTO {

	private Long id;
	private String nazivTipaPlacanja;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazivTipaPlacanja() {
		return nazivTipaPlacanja;
	}
	public void setNazivTipaPlacanja(String nazivTipaPlacanja) {
		this.nazivTipaPlacanja = nazivTipaPlacanja;
	}
	public NacinPlacanjaDTO(Long id, String nazivTipaPlacanja) {
		
		this.id = id;
		this.nazivTipaPlacanja = nazivTipaPlacanja;
	}
	public NacinPlacanjaDTO() {
		
	}
	
	
}
