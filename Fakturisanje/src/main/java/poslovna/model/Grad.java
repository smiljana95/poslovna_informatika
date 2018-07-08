package poslovna.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 5)
	private int ptt;
	
	@Column(length = 100)
	private String naziv;
	
	@OneToMany(mappedBy = "grad", cascade = CascadeType.REMOVE)
    protected List<Radnik> korisnici;
	
	@OneToMany(mappedBy = "grad", cascade = CascadeType.REMOVE)
    protected List<Kompanija> kompanije;
	
	@OneToMany(mappedBy = "grad", cascade = CascadeType.REMOVE)
    protected List<PoslovniPartner> poslovniPartneri;

	public Grad(Long id, int pTT, String naziv) {
		this.id = id;
		ptt = pTT;
		this.naziv = naziv;
		korisnici = new ArrayList<Radnik>();
		kompanije = new ArrayList<Kompanija>();
		poslovniPartneri = new ArrayList<PoslovniPartner>();
	}
	
	public Grad() {
		korisnici = new ArrayList<Radnik>();
		kompanije = new ArrayList<Kompanija>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPTT() {
		return ptt;
	}

	public void setPTT(int pTT) {
		ptt = pTT;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Radnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(List<Radnik> korisnici) {
		this.korisnici = korisnici;
	}

	public List<Kompanija> getKompanije() {
		return kompanije;
	}

	public void setKompanije(List<Kompanija> kompanije) {
		this.kompanije = kompanije;
	}

	public List<PoslovniPartner> getPoslovniPartneri() {
		return poslovniPartneri;
	}

	public void setPoslovniPartneri(List<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}
	
}
