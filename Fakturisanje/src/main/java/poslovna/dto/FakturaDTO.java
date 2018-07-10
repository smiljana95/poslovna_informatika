package poslovna.dto;

import java.util.List;

public class FakturaDTO {

	private Long id;
	private String datumFakture;
	private String datumValute;
	private int brojFakture;
	private double ukupanPDV;
	private double ukupnaCenaBezPDVa;
	private String racunZaUplatu;
	private String pozivNaBroj;
	private double ukupnaCena;
	private boolean poslata;
	private NacinPlacanjaDTO nacinPlacanjaDTO;
	private FiskalnaGodinaDTO fiskalnaGodinaDTO;
	private PoslovniPartnerDTO poslovniPartnerDTO;
	private List<StavkaUFakturiDTO> stavkeUFakturiDTO;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatumFakture() {
		return datumFakture;
	}
	public void setDatumFakture(String datumFakture) {
		this.datumFakture = datumFakture;
	}
	public String getDatumValute() {
		return datumValute;
	}
	public void setDatumValute(String datumValute) {
		this.datumValute = datumValute;
	}
	public int getBrojFakture() {
		return brojFakture;
	}
	public void setBrojFakture(int brojFakture) {
		this.brojFakture = brojFakture;
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
	public NacinPlacanjaDTO getNacinPlacanjaDTO() {
		return nacinPlacanjaDTO;
	}
	public void setNacinPlacanjaDTO(NacinPlacanjaDTO nacinPlacanjaDTO) {
		this.nacinPlacanjaDTO = nacinPlacanjaDTO;
	}
	public FiskalnaGodinaDTO getFiskalnaGodinaDTO() {
		return fiskalnaGodinaDTO;
	}
	public void setFiskalnaGodinaDTO(FiskalnaGodinaDTO fiskalnaGodinaDTO) {
		this.fiskalnaGodinaDTO = fiskalnaGodinaDTO;
	}
	public PoslovniPartnerDTO getPoslovniPartnerDTO() {
		return poslovniPartnerDTO;
	}
	public void setPoslovniPartnerDTO(PoslovniPartnerDTO poslovniPartnerDTO) {
		this.poslovniPartnerDTO = poslovniPartnerDTO;
	}
	public List<StavkaUFakturiDTO> getStavkeUFakturiDTO() {
		return stavkeUFakturiDTO;
	}
	public void setStavkeUFakturiDTO(List<StavkaUFakturiDTO> stavkeUFakturiDTO) {
		this.stavkeUFakturiDTO = stavkeUFakturiDTO;
	}
	public FakturaDTO(String datumFakture, String datumValute, int brojFakture, double ukupanPDV,
			double ukupnaCenaBezPDVa, String racunZaUplatu, String pozivNaBroj, double ukupnaCena, boolean poslata,
			NacinPlacanjaDTO nacinPlacanjaDTO, FiskalnaGodinaDTO fiskalnaGodinaDTO,
			PoslovniPartnerDTO poslovniPartnerDTO, List<StavkaUFakturiDTO> stavkeUFakturiDTO) {
		
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.brojFakture = brojFakture;
		this.ukupanPDV = ukupanPDV;
		this.ukupnaCenaBezPDVa = ukupnaCenaBezPDVa;
		this.racunZaUplatu = racunZaUplatu;
		this.pozivNaBroj = pozivNaBroj;
		this.ukupnaCena = ukupnaCena;
		this.poslata = poslata;
		this.nacinPlacanjaDTO = nacinPlacanjaDTO;
		this.fiskalnaGodinaDTO = fiskalnaGodinaDTO;
		this.poslovniPartnerDTO = poslovniPartnerDTO;
		this.stavkeUFakturiDTO = stavkeUFakturiDTO;
	}
	
	public FakturaDTO() {
		
	}
	
	
	
}
