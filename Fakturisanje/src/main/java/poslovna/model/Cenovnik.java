package poslovna.model;

import java.util.ArrayList;
import java.util.Date;
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
public class Cenovnik {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date datum_pocetka_vazenja;
	
	@OneToMany(mappedBy = "cenovnik", cascade = CascadeType.REMOVE)
    protected List<StavkaUCenovniku> stavkeUCenovniku;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanije")
    private Kompanija kompanija;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_poslovnog_partnera")
    private PoslovniPartner poslovniPartner;
	
	private boolean aktivan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatum_pocetka_vazenja() {
		return datum_pocetka_vazenja;
	}

	public void setDatum_pocetka_vazenja(Date datum_pocetka_vazenja) {
		this.datum_pocetka_vazenja = datum_pocetka_vazenja;
	}
	
	public Cenovnik(Date datum_pocetka_vazenja, Date datum_isteka_vazenja) {
		
		this.datum_pocetka_vazenja = datum_pocetka_vazenja;
	}

	public Cenovnik() {
		stavkeUCenovniku = new ArrayList<StavkaUCenovniku>();
	}

	public List<StavkaUCenovniku> getStavkeUCenovniku() {
		return stavkeUCenovniku;
	}

	public void setStavkeUCenovniku(List<StavkaUCenovniku> stavkeUCenovniku) {
		this.stavkeUCenovniku = stavkeUCenovniku;
	}

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}
	
}
