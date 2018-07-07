package poslovna.model;

import java.util.ArrayList;
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
public class Kompanija {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100)
	private String naziv;
	
	private Long PID;
	
	@Column(length = 60)
	private String adresa;
	
	@Column(length = 20)
	private String kontakt;
	
	@Column(length = 20)
	private String brojRacuna;
	
	@OneToMany(mappedBy = "nadredjena", cascade = CascadeType.REMOVE)
    protected List<PoslovniPartner> podredjene;  //one kojima je ona nadredjena
	
	@OneToMany(mappedBy = "podredjena", cascade = CascadeType.REMOVE)
    protected List<PoslovniPartner> nadredjene;  //one kojima je ona podredjena
	
	@OneToMany(mappedBy = "kompanija", cascade = CascadeType.REMOVE)
    protected List<FiskalnaGodina> fiskalneGodine;
	
	@OneToMany(mappedBy = "kompanija", cascade = CascadeType.REMOVE)
    protected List<Faktura> fakture;
	
	@OneToMany(mappedBy = "kompanija", cascade = CascadeType.REMOVE)
    protected List<ArtikalNaLageru> artikliNaLageru;
	
	@OneToMany(mappedBy = "kompanija", cascade = CascadeType.REMOVE)
    protected List<Radnik> radnici;
	
	@OneToMany(mappedBy = "kompanija", cascade = CascadeType.REMOVE)
    protected List<Cenovnik> cenovnici;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grada", nullable = false)
    private Grad grad;
	
	
	public Kompanija() {
		podredjene = new ArrayList<PoslovniPartner>();
		nadredjene = new ArrayList<PoslovniPartner>();
		fiskalneGodine = new ArrayList<FiskalnaGodina>();
		fakture = new ArrayList<Faktura>();
		artikliNaLageru = new ArrayList<ArtikalNaLageru>();
		radnici = new ArrayList<Radnik>();
		cenovnici = new ArrayList<Cenovnik>();
	}


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


	public Long getPID() {
		return PID;
	}


	public void setPID(Long pID) {
		PID = pID;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getKontakt() {
		return kontakt;
	}


	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}


	public String getBrojRacuna() {
		return brojRacuna;
	}


	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}


	public List<PoslovniPartner> getPodredjene() {
		return podredjene;
	}


	public void setPodredjene(List<PoslovniPartner> podredjene) {
		this.podredjene = podredjene;
	}


	public List<PoslovniPartner> getNadredjene() {
		return nadredjene;
	}


	public void setNadredjene(List<PoslovniPartner> nadredjene) {
		this.nadredjene = nadredjene;
	}


	public List<FiskalnaGodina> getFiskalneGodine() {
		return fiskalneGodine;
	}


	public void setFiskalneGodine(List<FiskalnaGodina> fiskalneGodine) {
		this.fiskalneGodine = fiskalneGodine;
	}


	public List<Faktura> getFakture() {
		return fakture;
	}


	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}


	public List<ArtikalNaLageru> getArtikliNaLageru() {
		return artikliNaLageru;
	}


	public void setArtikliNaLageru(List<ArtikalNaLageru> artikliNaLageru) {
		this.artikliNaLageru = artikliNaLageru;
	}


	public List<Radnik> getRadnici() {
		return radnici;
	}


	public void setRadnici(List<Radnik> radnici) {
		this.radnici = radnici;
	}


	public Grad getGrad() {
		return grad;
	}


	public void setGrad(Grad grad) {
		this.grad = grad;
	}


	public List<Cenovnik> getCenovnici() {
		return cenovnici;
	}


	public void setCenovnici(List<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}

}
