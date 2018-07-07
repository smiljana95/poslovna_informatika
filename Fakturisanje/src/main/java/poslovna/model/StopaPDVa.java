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
public class StopaPDVa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String PDVuProcentima;
	
	@OneToMany(mappedBy = "stopaPDVa", cascade = CascadeType.REMOVE)
    protected List<TipPDVa> tipoviPDVa;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPDVuProcentima() {
		return PDVuProcentima;
	}


	public void setPDVuProcentima(String pDVuProcentima) {
		PDVuProcentima = pDVuProcentima;
	}


	public StopaPDVa(String pDVuProcentima) {
		tipoviPDVa = new ArrayList<TipPDVa>();
		PDVuProcentima = pDVuProcentima;
	}


	public StopaPDVa() {
		tipoviPDVa = new ArrayList<TipPDVa>();
	}
	
	

}
