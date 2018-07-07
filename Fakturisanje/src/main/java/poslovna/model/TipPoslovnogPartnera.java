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
public class TipPoslovnogPartnera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100)
	private String naziv;
	
	@OneToMany(mappedBy = "tipPoslovnogPartnera", cascade = CascadeType.REMOVE)
    protected List<PoslovniPartner> poslovniPartneri;

	public TipPoslovnogPartnera(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
		poslovniPartneri = new ArrayList<PoslovniPartner>();
	}
	
	public TipPoslovnogPartnera() {
		poslovniPartneri = new ArrayList<PoslovniPartner>();
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

	public List<PoslovniPartner> getPoslovniPartneri() {
		return poslovniPartneri;
	}

	public void setPoslovniPartneri(List<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}
	
}
