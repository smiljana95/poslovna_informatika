package poslovna.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MagacinskaKartica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int kolicna;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanije")
    private Kompanija kompanija;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_poslovnog_partnera")
    private PoslovniPartner poslovniPartner;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artikla", nullable = false)
    private Artikal artikal;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKolicna() {
		return kolicna;
	}

	public void setKolicna(int kolicna) {
		this.kolicna = kolicna;
	}

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public MagacinskaKartica(int kolicna, Kompanija kompanija, Artikal artikal) {
		super();
		this.kolicna = kolicna;
		this.kompanija = kompanija;
		this.artikal = artikal;
	}

	public MagacinskaKartica() {
		
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}
	
	

}
