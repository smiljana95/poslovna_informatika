package poslovna.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StavkaUNarudzbenici {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int ukupnaKolicina;
	
	private double jedinicnaCena;  // bez popustom, bez PDVom
	
	private double popust;
	
	private double osnovica; //kolicina * jedinična cena - popust
	
	private double iznosPDVa; // konkretan iznos - osnovica sa PDVom
	
	private double stopaPDVa; //npr 10%
	
	private double jedinicnaCenaSaPDV;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_narudzbenice", nullable = false)
    private Narudzbenica narudzbenica;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artikla", nullable = false)
    private Artikal artikal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUkupnaKolicina() {
		return ukupnaKolicina;
	}

	public void setUkupnaKolicina(int ukupnaKolicina) {
		this.ukupnaKolicina = ukupnaKolicina;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public double getPopust() {
		return popust;
	}

	public void setPopust(double popust) {
		this.popust = popust;
	}

	public double getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(double osnovica) {
		this.osnovica = osnovica;
	}

	public double getIznosPDVa() {
		return iznosPDVa;
	}

	public void setIznosPDVa(double iznosPDVa) {
		this.iznosPDVa = iznosPDVa;
	}

	public double getStopaPDVa() {
		return stopaPDVa;
	}

	public void setStopaPDVa(double stopaPDVa) {
		this.stopaPDVa = stopaPDVa;
	}

	public double getJedinicnaCenaSaPDV() {
		return jedinicnaCenaSaPDV;
	}

	public void setJedinicnaCenaSaPDV(double jedinicnaCenaBezPDVa) {
		this.jedinicnaCenaSaPDV = jedinicnaCenaBezPDVa;
	}

	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	public void setNarudzbenica(Narudzbenica narudzbenica) {
		this.narudzbenica = narudzbenica;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public StavkaUNarudzbenici(int ukupnaKolicina, double jedinicnaCena, double popust, double osnovica,
			double iznosPDVa, double stopaPDVa, double jedinicnaCenaBezPDVa, Narudzbenica narudzbenica,
			Artikal artikal) {
		
		this.ukupnaKolicina = ukupnaKolicina;
		this.jedinicnaCena = jedinicnaCena;
		this.popust = popust;
		this.osnovica = osnovica;
		this.iznosPDVa = iznosPDVa;
		this.stopaPDVa = stopaPDVa;
		this.jedinicnaCenaSaPDV = jedinicnaCenaBezPDVa;
		this.narudzbenica = narudzbenica;
		this.artikal = artikal;
	}

	public StavkaUNarudzbenici() {
		
	}


	
}
