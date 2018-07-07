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
import javax.validation.constraints.Size;

@Entity
public class JedinicaMere {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100)
	private String naziv;
	
	
	@Size(min=3,max=3)
	private String oznaka;

	
	@OneToMany(mappedBy = "jedinicaMere", cascade = CascadeType.REMOVE)
    protected List<Artikal> artikli;
	


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


	public String getOznaka() {
		return oznaka;
	}


	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}


	public JedinicaMere(String naziv, String oznaka) {
		super();
		this.naziv = naziv;
		this.oznaka = oznaka;
		artikli = new ArrayList<Artikal>();
	}


	public JedinicaMere() {
		artikli = new ArrayList<Artikal>();
	}
	
	
	
	
	
}
