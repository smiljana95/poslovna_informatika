package poslovna.dto;

public class FiskalnaGodinaDTO {

	private Long id;
	private int brojGodine;
	private boolean aktivna;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBrojGodine() {
		return brojGodine;
	}
	public void setBrojGodine(int brojGodine) {
		this.brojGodine = brojGodine;
	}
	public boolean isAktivna() {
		return aktivna;
	}
	public void setAktivna(boolean aktivna) {
		this.aktivna = aktivna;
	}
	public FiskalnaGodinaDTO(Long id, int brojGodine, boolean aktivna) {
		
		this.id = id;
		this.brojGodine = brojGodine;
		this.aktivna = aktivna;
	}
	public FiskalnaGodinaDTO() {
		super();
	}
	
	
}
