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
	private int PTT;
	
	@Column(length = 100)
	private String naziv;
	
	@OneToMany(mappedBy = "grad", cascade = CascadeType.REMOVE)
    protected List<Radnik> korisnici;
	
	@OneToMany(mappedBy = "grad", cascade = CascadeType.REMOVE)
    protected List<Kompanija> kompanije;

	public Grad(Long id, int pTT, String naziv) {
		this.id = id;
		PTT = pTT;
		this.naziv = naziv;
		korisnici = new ArrayList<Radnik>();
		kompanije = new ArrayList<Kompanija>();
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
