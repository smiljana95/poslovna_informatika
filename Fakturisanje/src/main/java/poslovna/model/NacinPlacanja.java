package poslovna.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class NacinPlacanja {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nazivTipaPlacanja;
	
	@OneToMany(mappedBy = "nacinPlacanja", cascade = CascadeType.REMOVE)
    protected List<Faktura> faktura;
	
	public NacinPlacanja() {
		faktura = new ArrayList<Faktura>();
	}

	public NacinPlacanja(Long id, String nazivTipaPlacanja, List<Faktura> faktura) {
		this.id = id;
		this.nazivTipaPlacanja = nazivTipaPlacanja;
		this.faktura = faktura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivTipaPlacanja() {
		return nazivTipaPlacanja;
	}

	public void setNazivTipaPlacanja(String nazivTipaPlacanja) {
		this.nazivTipaPlacanja = nazivTipaPlacanja;
	}

	public List<Faktura> getFaktura() {
		return faktura;
	}

	public void setFaktura(List<Faktura> faktura) {
		this.faktura = faktura;
	}
	
}
