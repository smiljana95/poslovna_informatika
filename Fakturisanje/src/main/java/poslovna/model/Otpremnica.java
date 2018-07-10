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

import poslovna.dto.StavkaUOtpremniciDTO;

@Entity
public class Otpremnica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date datumOtpremnice; //datum kad je faktura kreirana
	
	private int brojOtpremnice;
	
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
	
	//od koga je naruceno
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanije", nullable = false)
    private Kompanija kompanija;
	
	//ko je narucio
		@ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_PP", nullable = false)
	    private PoslovniPartner poslovniPartner;
	
	@OneToMany(mappedBy = "otpremnica", cascade = CascadeType.REMOVE)
    protected List<StavkaUOtpremnici> stavke;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumOtpremnice() {
		return datumOtpremnice;
	}

	public void setDatumOtpremnice(Date datumOtpremnice) {
		this.datumOtpremnice = datumOtpremnice;
	}

	public int getBrojOtpremnice() {
		return brojOtpremnice;
	}

	public void setBrojOtpremnice(int brojOtpremnice) {
		this.brojOtpremnice = brojOtpremnice;
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

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public List<StavkaUOtpremnici> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaUOtpremnici> stavke) {
		this.stavke = stavke;
	}

	public Otpremnica(Date datumOtpremnice, int brojOtpremnice, Date datumValute, double ukupanPDV, double ukupnaCenaBezPDVa,
			String racunZaUplatu, String pozivNaBroj, double ukupnaCena, NacinPlacanja nacinPlacanja,
			FiskalnaGodina fiskalnaGodina, Kompanija kompanija, PoslovniPartner poslovniPartner,
			List<StavkaUOtpremnici> stavke) {
		
		this.datumOtpremnice = datumOtpremnice;
		this.brojOtpremnice = brojOtpremnice;
		this.datumValute = datumValute;
		this.ukupanPDV = ukupanPDV;
		this.ukupnaCenaBezPDVa = ukupnaCenaBezPDVa;
		this.racunZaUplatu = racunZaUplatu;
		this.pozivNaBroj = pozivNaBroj;
		this.ukupnaCena = ukupnaCena;
		this.nacinPlacanja = nacinPlacanja;
		this.fiskalnaGodina = fiskalnaGodina;
		this.kompanija = kompanija;
		this.poslovniPartner = poslovniPartner;
		this.stavke = stavke;
	}

	public Otpremnica() {
		this.stavke  = new ArrayList<StavkaUOtpremnici>();
	}


	
	

}
