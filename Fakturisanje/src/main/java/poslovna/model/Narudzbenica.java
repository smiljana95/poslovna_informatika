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

@Entity
public class Narudzbenica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

private Date datumNarudzbenice; //datum kad je faktura kreirana
	
	private int brojNarudzbenice;
	
	
	@Column(name = "ukupan_pdv")
	private double ukupanPDV;
	
	@Column(name = "ukupna_cena_bezpdva")
	private double ukupnaCenaBezPDVa;
	
	@Column(length = 30)
	private String racunZaUplatu;
	
	@Column(length = 20)
	private String pozivNaBroj;
	
	private double ukupnaCena;
	
	private boolean poslata;
	
	private boolean odKupca;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nacina_placanja", nullable = false)
    private NacinPlacanja nacinPlacanja;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_fiskalne_godine", nullable = false)
    private FiskalnaGodina fiskalnaGodina;
	
	//ko narucuje
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanije", nullable = false)
    private Kompanija kompanija;

	//od koga je naruceno
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_PP", nullable = false)
    private PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy = "narudzbenica", cascade = CascadeType.REMOVE)
    protected List<StavkaUNarudzbenici> stavke;

	public Narudzbenica(Date datumNarudzbenica, int brojNarudzbenice, double ukupanPDV,
			double ukupnaCenaBezPDVa, String racunZaUplatu, String pozivNaBroj, double ukupnaCena, boolean placena,
			NacinPlacanja nacinPlacanja, FiskalnaGodina fiskalnaGodina, Kompanija kompanija,
			PoslovniPartner poslovniPartner) {
		this.stavke = new ArrayList<StavkaUNarudzbenici>();
		this.datumNarudzbenice = datumNarudzbenica;
		this.brojNarudzbenice = brojNarudzbenice;
		
		this.ukupanPDV = ukupanPDV;
		this.ukupnaCenaBezPDVa = ukupnaCenaBezPDVa;
		this.racunZaUplatu = racunZaUplatu;
		this.pozivNaBroj = pozivNaBroj;
		this.ukupnaCena = ukupnaCena;
		this.poslata = false;
		this.nacinPlacanja = nacinPlacanja;
		this.fiskalnaGodina = fiskalnaGodina;
		this.kompanija = kompanija;
		this.poslovniPartner = poslovniPartner;
	}

	public Narudzbenica() {
		this.stavke = new ArrayList<StavkaUNarudzbenici>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumNarudzbenica() {
		return datumNarudzbenice;
	}

	public int getBrojNarudzbenice() {
		return brojNarudzbenice;
	}

	public void setBrojNarudzbenice(int brojNarudzbenice) {
		this.brojNarudzbenice = brojNarudzbenice;
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

	public boolean isPoslata() {
		return poslata;
	}

	public void setPoslata(boolean poslata) {
		this.poslata = poslata;
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

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public List<StavkaUNarudzbenici> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaUNarudzbenici> stavke) {
		this.stavke = stavke;
	}

	public void setDatumNarudzbenica(Date datumNarudzbenica) {
		this.datumNarudzbenice = datumNarudzbenica;
	}

	public boolean isOdKupca() {
		return odKupca;
	}

	public void setOdKupca(boolean odKupca) {
		this.odKupca = odKupca;
	}
	
}
