package poslovna.model;

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
public class TipPDVa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100)
	private String naziv;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_stopePDVa", nullable = false)
    private StopaPDVa stopaPDVa;
	
	@OneToMany(mappedBy = "tipPDVa", cascade = CascadeType.REMOVE)
    protected List<GrupaArtikala> grupaArtikala;

	public TipPDVa(String naziv) {
		
		this.naziv = naziv;
	}
	
	

	public StopaPDVa getStopaPDVa() {
		return stopaPDVa;
	}



	public void setStopaPDVa(StopaPDVa stopaPDVa) {
		this.stopaPDVa = stopaPDVa;
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
	
	public TipPDVa(){}
	

}
