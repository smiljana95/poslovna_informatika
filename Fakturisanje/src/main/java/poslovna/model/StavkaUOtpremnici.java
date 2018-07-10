package poslovna.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StavkaUOtpremnici {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int ukupnaKolicina;
	
	private double jedinicnaCena;  // bez popustom, bez PDVom
	
	private double popust;
	
	private double osnovica; //kolicina * jedinična cena - popust
	
	private double iznosPDVa; // konkretan iznos - osnovica sa PDVom
	
	private double stopaPDVa; //npr 10%
	
	private double jedinicnaCenaBezPDVa;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_otpremnice", nullable = false)
    private Otpremnica otpremnica;
	
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

	public double getJedinicnaCenaBezPDVa() {
		return jedinicnaCenaBezPDVa;
	}

	public void setJedinicnaCenaBezPDVa(double jedinicnaCenaBezPDVa) {
		this.jedinicnaCenaBezPDVa = jedinicnaCenaBezPDVa;
	}

	public Otpremnica getOtpremnica() {
		return otpremnica;
	}

	public void setOtpremnica(Otpremnica otpremnica) {
		this.otpremnica = otpremnica;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public StavkaUOtpremnici() {
		
	}

	public StavkaUOtpremnici(int ukupnaKolicina, double jedinicnaCena, double popust, double osnovica, double iznosPDVa,
			double stopaPDVa, double jedinicnaCenaBezPDVa, Otpremnica otpremnica, Artikal artikal) {
		
		this.ukupnaKolicina = ukupnaKolicina;
		this.jedinicnaCena = jedinicnaCena;
		this.popust = popust;
		this.osnovica = osnovica;
		this.iznosPDVa = iznosPDVa;
		this.stopaPDVa = stopaPDVa;
		this.jedinicnaCenaBezPDVa = jedinicnaCenaBezPDVa;
		this.otpremnica = otpremnica;
		this.artikal = artikal;
	}
	
	
	
	
	
}
