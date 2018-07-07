package poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StavkaUCenovniku {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artikla", nullable = false)
    private Artikal artikal;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cenovnika", nullable = false)
    private Cenovnik cenovnik;
	
	@Column(precision = 10, scale = 2)
	private double cena;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public Cenovnik getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public StavkaUCenovniku(Artikal artikal, Cenovnik cenovnik, double cena) {
		
		this.artikal = artikal;
		this.cenovnik = cenovnik;
		this.cena = cena;
	}

	public StavkaUCenovniku() {
		
	}
	
	
	

}
