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
public class GrupaArtikala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "grupaArtikala", cascade = CascadeType.REMOVE)
    protected List<Artikal> artikli;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipaPDVa", nullable = false)
    private TipPDVa tipPDVa;
	
	private String naziv;
	
	public GrupaArtikala() {
		artikli = new ArrayList<Artikal>();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}

	public GrupaArtikala(List<Artikal> artikli) {
		this.artikli = artikli;
	}

	public TipPDVa getTipPDVa() {
		return tipPDVa;
	}

	public void setTipPDVa(TipPDVa tipPDVa) {
		this.tipPDVa = tipPDVa;
	}
	
	

}
