package poslovna.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FiskalnaGodina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int brojGodine;
	
	private boolean aktivna;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanije", nullable = false)
    private Kompanija kompanija;
	
	@OneToMany(mappedBy = "fiskalnaGodina", cascade = CascadeType.REMOVE)
    protected List<Faktura> fakture;
	
	public FiskalnaGodina() {
		fakture = new ArrayList<Faktura>();
	}

	public FiskalnaGodina(Long id, int brojGodine, boolean aktivna, Kompanija kompanija, List<Faktura> fakture) {
		this.id = id;
		this.brojGodine = brojGodine;
		this.aktivna = aktivna;
		this.kompanija = kompanija;
		this.fakture = fakture;
	}

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

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public List<Faktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<Faktura> fakture) {
		this.fakture = fakture;
	}
	
}
