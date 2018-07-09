package poslovna.dto;

import java.util.ArrayList;
import java.util.List;

public class NarudzbenicaDTO {
	
	private Long id;
	private String datumNarudzbenice;
	private int brojNarudzbenice;
	private double ukupanPDV;
	private double ukupnaCenaBezPDVa;
	private String racunZaUplatu;
	private String pozivNaBroj;
	private double ukupnaCena;
	private boolean poslata;
	private NacinPlacanjaDTO nacinPlacanjaDTO;
	private FiskalnaGodinaDTO fiskalnaGodinaDTO;
	private PoslovniPartnerDTO poslovniPartnerDTO;
	private List<StavkaUNarudzbeniciDTO> stavkeUNarudzbeniciDTO;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatumNarudzbenice() {
		return datumNarudzbenice;
	}
	public void setDatumNarudzbenice(String datumNarudzbenice) {
		this.datumNarudzbenice = datumNarudzbenice;
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
	public List<StavkaUNarudzbeniciDTO> getStavkeUNarudzbeniciDTO() {
		return stavkeUNarudzbeniciDTO;
	}
	public void setStavkeUNarudzbeniciDTO(List<StavkaUNarudzbeniciDTO> stavkeUNarudzbeniciDTO) {
		this.stavkeUNarudzbeniciDTO = stavkeUNarudzbeniciDTO;
	}
	public NarudzbenicaDTO(String datumNarudzbenice, int brojNarudzbenice, double ukupanPDV, double ukupnaCenaBezPDVa,
			String racunZaUplatu, String pozivNaBroj, double ukupnaCena, boolean poslata,
			NacinPlacanjaDTO nacinPlacanjaDTO, FiskalnaGodinaDTO fiskalnaGodinaDTO,
			PoslovniPartnerDTO poslovniPartnerDTO, List<StavkaUNarudzbeniciDTO> stavkeUNarudzbeniciDTO) {
		
		this.datumNarudzbenice = datumNarudzbenice;
		this.brojNarudzbenice = brojNarudzbenice;
		this.ukupanPDV = ukupanPDV;
		this.ukupnaCenaBezPDVa = ukupnaCenaBezPDVa;
		this.racunZaUplatu = racunZaUplatu;
		this.pozivNaBroj = pozivNaBroj;
		this.ukupnaCena = ukupnaCena;
		this.poslata = poslata;
		this.nacinPlacanjaDTO = nacinPlacanjaDTO;
		this.fiskalnaGodinaDTO = fiskalnaGodinaDTO;
		this.poslovniPartnerDTO = poslovniPartnerDTO;
		this.stavkeUNarudzbeniciDTO = stavkeUNarudzbeniciDTO;
	}
	public NarudzbenicaDTO() {
		this.stavkeUNarudzbeniciDTO = new ArrayList<StavkaUNarudzbeniciDTO>();
	}
	
	
	

}
