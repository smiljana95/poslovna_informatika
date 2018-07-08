package poslovna.dto;

public class ArtikalDTO {
	private JedinicaMereDTO jedinicaMereDTO;
	private Long id;
	private String opis;
	private String naziv;
	public JedinicaMereDTO getJedinicaMereDTO() {
		return jedinicaMereDTO;
	}
	public void setJedinicaMereDTO(JedinicaMereDTO jedinicaMereDTO) {
		this.jedinicaMereDTO = jedinicaMereDTO;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArtikalDTO(JedinicaMereDTO jedinicaMereDTO, Long id, String opis, String naziv) {
		
		this.jedinicaMereDTO = jedinicaMereDTO;
		this.id = id;
		this.opis = opis;
		this.naziv = naziv;
	}
	public ArtikalDTO() {
		
	}
	
	
}
