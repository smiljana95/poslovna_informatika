package poslovna.model;

import java.util.ArrayList;
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
public class Artikal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100)
	private String naziv;

	@Column(length = 100)
	private String opis;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_stavke", nullable = false)
    private StavkaUFakturi stavkaFakture;

	@OneToMany(mappedBy = "artikal", cascade = CascadeType.REMOVE)
    protected List<MagacinskaKartica> artikliNaLageru;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jedinice_mere", nullable = false)
    private JedinicaMere jedinicaMere;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grupe_artikala", nullable = false)
    private GrupaArtikala grupaArtikala;
	
	@OneToMany(mappedBy = "artikal", cascade = CascadeType.REMOVE)
    protected List<StavkaUCenovniku> stavkaUCenovniku;
	
	
	public GrupaArtikala getGrupaArtikala() {
		return grupaArtikala;
	}

	public void setGrupaArtikala(GrupaArtikala grupaArtikala) {
		this.grupaArtikala = grupaArtikala;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}


	public StavkaUFakturi getStavkaFakture() {
		return stavkaFakture;
	}

	public void setStavkaFakture(StavkaUFakturi stavkaFakture) {
		this.stavkaFakture = stavkaFakture;
	}

	public Artikal(String naziv, String opis, StavkaUFakturi stavkaFakture) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.stavkaFakture = stavkaFakture;
		artikliNaLageru = new ArrayList<MagacinskaKartica>();
		stavkaUCenovniku = new ArrayList<StavkaUCenovniku>();
	}

	public Artikal() {
		artikliNaLageru = new ArrayList<MagacinskaKartica>();
		stavkaUCenovniku = new ArrayList<StavkaUCenovniku>();
	}
	
	
	
}
