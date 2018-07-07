package poslovna.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PoslovniPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nadredjene", nullable = false)
    private Kompanija nadredjena;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_podredjene", nullable = false)
    private Kompanija podredjena;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipa", nullable = false)
    private TipPoslovnogPartnera tipPoslovnogPartnera;
	
	public PoslovniPartner() {
		// TODO Auto-generated constructor stub
	}

	public PoslovniPartner(Long id, Kompanija nadredjena, Kompanija podredjena,
			TipPoslovnogPartnera tipPoslovnogPartnera) {
		this.id = id;
		this.nadredjena = nadredjena;
		this.podredjena = podredjena;
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Kompanija getNadredjena() {
		return nadredjena;
	}

	public void setNadredjena(Kompanija nadredjena) {
		this.nadredjena = nadredjena;
	}

	public Kompanija getPodredjena() {
		return podredjena;
	}

	public void setPodredjena(Kompanija podredjena) {
		this.podredjena = podredjena;
	}

	public TipPoslovnogPartnera getTipPoslovnogPartnera() {
		return tipPoslovnogPartnera;
	}

	public void setTipPoslovnogPartnera(TipPoslovnogPartnera tipPoslovnogPartnera) {
		this.tipPoslovnogPartnera = tipPoslovnogPartnera;
	}
	
}
