package poslovna.dto;

public class PoslovniPartnerDTO {

	private Long id;
	private TipPoslovnogPartneraDTO tipPoslovnogPartneraDTO;
	private String naziv;
	private GradDTO gradDTO;
	private String adresa;
	private String kontaktTelefon;
	
	public PoslovniPartnerDTO() {
		// TODO Auto-generated constructor stub
	}

	public PoslovniPartnerDTO(Long id, TipPoslovnogPartneraDTO tipPoslovnogPartneraDTO, String naziv, GradDTO gradDTO,
			String adresa, String kontaktTelefon) {
		this.id = id;
		this.tipPoslovnogPartneraDTO = tipPoslovnogPartneraDTO;
		this.naziv = naziv;
		this.gradDTO = gradDTO;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipPoslovnogPartneraDTO getTipPoslovnogPartneraDTO() {
		return tipPoslovnogPartneraDTO;
	}

	public void setTipPoslovnogPartneraDTO(TipPoslovnogPartneraDTO tipPoslovnogPartneraDTO) {
		this.tipPoslovnogPartneraDTO = tipPoslovnogPartneraDTO;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public GradDTO getGradDTO() {
		return gradDTO;
	}

	public void setGradDTO(GradDTO gradDTO) {
		this.gradDTO = gradDTO;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	
}
