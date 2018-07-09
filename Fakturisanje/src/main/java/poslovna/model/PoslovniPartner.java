package poslovna.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PoslovniPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanija", nullable = false)
    private Kompanija kompanija;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipa", nullable = false)
    private TipPoslovnogPartnera tipPoslovnogPartnera;
	
	@Column(length = 100)
	private String naziv;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grada", nullable = false)
	private Grad grad;
	
	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.REMOVE)
    protected List<Cenovnik> cenovnici;
	
	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.REMOVE)
    protected List<MagacinskaKartica> artikliNaLageru;
	
	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.REMOVE)
    protected List<Narudzbenica> narudzbenice;
	
	@OneToMany(mappedBy = "poslovniPartner", cascade = CascadeType.REMOVE)
    protected List<Faktura> fakture;
	
	
	
	public List<Narudzbenica> getNarudzbenice() {
		return narudzbenice;
	}

	public void setNarudzbenice(List<Narudzbenica> narudzbenice) {
		this.narudzbenice = narudzbenice;
	}

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}

	private String adresa;
	
	private String kontaktTelefon;
	
	public PoslovniPartner() {
		// TODO Auto-generated constructor stub
	}

	public PoslovniPartner(Long id, Kompanija kompanija, TipPoslovnogPartnera tipPoslovnogPartnera, String naziv,
			Grad grad, String adresa, String kontaktTelefon) {
		this.id = id;
		this.kompanija = kompanija;
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
		this.naziv = naziv;
		this.grad = grad;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public TipPoslovnogPartnera getTipPoslovnogPartnera() {
		return tipPoslovnogPartnera;
	}

	public void setTipPoslovnogPartnera(TipPoslovnogPartnera tipPoslovnogPartnera) {
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
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

	public List<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(List<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}

	public List<MagacinskaKartica> getArtikliNaLageru() {
		return artikliNaLageru;
	}

	public void setArtikliNaLageru(List<MagacinskaKartica> artikliNaLageru) {
		this.artikliNaLageru = artikliNaLageru;
	}
	
	
	
}
