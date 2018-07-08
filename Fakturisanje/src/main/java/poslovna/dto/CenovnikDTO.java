package poslovna.dto;

import java.util.List;

public class CenovnikDTO {
	private Long id;
	private String datumPocetkaVazenja;
	private List<StavkaCenovnikaDTO> stavkaCenovnikaDTO;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatumPocetkaVazenja() {
		return datumPocetkaVazenja;
	}
	public void setDatumPocetkaVazenja(String datumPocetkaVazenja) {
		this.datumPocetkaVazenja = datumPocetkaVazenja;
	}
	public List<StavkaCenovnikaDTO> getStavkaCenovnikaDTO() {
		return stavkaCenovnikaDTO;
	}
	public void setStavkaCenovnikaDTO(List<StavkaCenovnikaDTO> stavkaCenovnikaDTO) {
		this.stavkaCenovnikaDTO = stavkaCenovnikaDTO;
	}
	public CenovnikDTO(Long id, String datumPocetkaVazenja, List<StavkaCenovnikaDTO> stavkaCenovnikaDTO) {
		
		this.id = id;
		this.datumPocetkaVazenja = datumPocetkaVazenja;
		this.stavkaCenovnikaDTO = stavkaCenovnikaDTO;
	}
	public CenovnikDTO() {
		super();
	}
	
	
	
}
