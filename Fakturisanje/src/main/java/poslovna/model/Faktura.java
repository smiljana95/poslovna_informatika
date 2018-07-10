package poslovna.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Faktura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date datumFakture; //datum kad je faktura kreirana
	
	private int brojFakture;
	
	private Date datumValute; //datum do kad mora da se plati
	
	private double ukupanPDV;
	
	private double ukupnaCenaBezPDVa;
	
	@Column(length = 30,nullable=true)
	private String racunZaUplatu;
	
	@Column(length = 20,nullable=true)
	private String pozivNaBroj;
	
	private double ukupnaCena;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nacina_placanja", nullable = false)
    private NacinPlacanja nacinPlacanja;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_fiskalne_godine", nullable = false)
    private FiskalnaGodina fiskalnaGodina;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanije", nullable = false)
    private Kompanija kompanija;
	
	//od koga je naruceno
		@ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_PP", nullable = false)
	    private PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy = "faktura", cascade = CascadeType.REMOVE)
    protected List<StavkaUFakturi> stavke;

	
	
	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumFakture() {
		return datumFakture;
	}

	public void setDatumFakture(Date datumFakture) {
		this.datumFakture = datumFakture;
	}

	public int getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(int brojFakture) {
		this.brojFakture = brojFakture;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public double getUkupanPDV() {
		return ukupanPDV;
	}

	public void setUkupanPDV(double ukupanPDV) {
		this.ukupanPDV = ukupanPDV;
	}

	public double getUkupnaCenaBezPDVa() {
		return ukupnaCenaBezPDVa;
	}

	public void setUkupnaCenaBezPDVa(double ukupnaCenaBezPDVa) {
		this.ukupnaCenaBezPDVa = ukupnaCenaBezPDVa;
	}

	public String getRacunZaUplatu() {
		return racunZaUplatu;
	}

	public void setRacunZaUplatu(String racunZaUplatu) {
		this.racunZaUplatu = racunZaUplatu;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}



	public NacinPlacanja getNacinPlacanja() {
		return nacinPlacanja;
	}

	public void setNacinPlacanja(NacinPlacanja nacinPlacanja) {
		this.nacinPlacanja = nacinPlacanja;
	}

	public FiskalnaGodina getFiskalnaGodina() {
		return fiskalnaGodina;
	}

	public void setFiskalnaGodina(FiskalnaGodina fiskalnaGodina) {
		this.fiskalnaGodina = fiskalnaGodina;
	}

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public List<StavkaUFakturi> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaUFakturi> stavke) {
		this.stavke = stavke;
	}

	public Faktura(Date datumFakture, int brojFakture, Date datumValute, double ukupanPDV, double ukupnaCenaBezPDVa,
			String racunZaUplatu, String pozivNaBroj, double ukupnaCena, NacinPlacanja nacinPlacanja,
			FiskalnaGodina fiskalnaGodina, Kompanija kompanija, List<StavkaUFakturi> stavke) {
		super();
		this.datumFakture = datumFakture;
		this.brojFakture = brojFakture;
		this.datumValute = datumValute;
		this.ukupanPDV = ukupanPDV;
		this.ukupnaCenaBezPDVa = ukupnaCenaBezPDVa;
		this.racunZaUplatu = racunZaUplatu;
		this.pozivNaBroj = pozivNaBroj;
		this.ukupnaCena = ukupnaCena;
		
		this.nacinPlacanja = nacinPlacanja;
		this.fiskalnaGodina = fiskalnaGodina;
		this.kompanija = kompanija;
		this.stavke = stavke;
	}
	
	public Faktura(){
		stavke = new ArrayList<StavkaUFakturi>();
	}

}
