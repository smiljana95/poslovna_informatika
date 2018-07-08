package poslovna.dto;

public class GradDTO {
	
	private Long id;
	private int PTT;
	private String naziv;
	
	public GradDTO() {
		// TODO Auto-generated constructor stub
	}

	public GradDTO(Long id, int pTT, String naziv) {
		this.id = id;
		PTT = pTT;
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPTT() {
		return PTT;
	}

	public void setPTT(int pTT) {
		PTT = pTT;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
