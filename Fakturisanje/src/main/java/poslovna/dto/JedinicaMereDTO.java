package poslovna.dto;

public class JedinicaMereDTO {
	private Long id;
	private String naziv;
	private String oznaka;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public JedinicaMereDTO(Long id, String naziv, String oznaka) {
		
		this.id = id;
		this.naziv = naziv;
		this.oznaka = oznaka;
	}
	public JedinicaMereDTO() {
		
	}
	
	
}
