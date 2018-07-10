package poslovna.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="otpremnica")
@XmlAccessorType(XmlAccessType.FIELD)
public class OtpremnicaDTO {

	private Long id;
	private String datumOtpremnice;
	private String datumValute;
	private int brojOtpremnice;
	private double ukupanPDV;
	private double ukupnaCenaBezPDVa;
	private String racunZaUplatu;
	private String pozivNaBroj;
	private double ukupnaCena;
	private boolean poslata;
	private NacinPlacanjaDTO nacinPlacanjaDTO;
	private FiskalnaGodinaDTO fiskalnaGodinaDTO;
	private PoslovniPartnerDTO poslovniPartnerDTO;
	private List<StavkaUOtpremniciDTO> stavkeUOtpremniciDTO;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatumOtpremnice() {
		return datumOtpremnice;
	}
	public void setDatumOtpremnice(String datumOtpremnice) {
		this.datumOtpremnice = datumOtpremnice;
	}
	public String getDatumValute() {
		return datumValute;
	}
	public void setDatumValute(String datumValute) {
		this.datumValute = datumValute;
	}
	public int getBrojOtpremnice() {
		return brojOtpremnice;
	}
	public void setBrojOtpremnice(int brojOtpremnice) {
		this.brojOtpremnice = brojOtpremnice;
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
	public List<StavkaUOtpremniciDTO> getStavkeUOtpremniciDTO() {
		return stavkeUOtpremniciDTO;
	}
	public void setStavkeUOtpremniciDTO(List<StavkaUOtpremniciDTO> stavkeUOtpremniciDTO) {
		this.stavkeUOtpremniciDTO = stavkeUOtpremniciDTO;
	}
	public OtpremnicaDTO(String datumOtpremnice, String datumValute, int brojOtpremnice, double ukupanPDV,
			double ukupnaCenaBezPDVa, String racunZaUplatu, String pozivNaBroj, double ukupnaCena, boolean poslata,
			NacinPlacanjaDTO nacinPlacanjaDTO, FiskalnaGodinaDTO fiskalnaGodinaDTO,
			PoslovniPartnerDTO poslovniPartnerDTO, List<StavkaUOtpremniciDTO> stavkeUOtpremniciDTO) {
		
		this.datumOtpremnice = datumOtpremnice;
		this.datumValute = datumValute;
		this.brojOtpremnice = brojOtpremnice;
		this.ukupanPDV = ukupanPDV;
		this.ukupnaCenaBezPDVa = ukupnaCenaBezPDVa;
		this.racunZaUplatu = racunZaUplatu;
		this.pozivNaBroj = pozivNaBroj;
		this.ukupnaCena = ukupnaCena;
		this.poslata = poslata;
		this.nacinPlacanjaDTO = nacinPlacanjaDTO;
		this.fiskalnaGodinaDTO = fiskalnaGodinaDTO;
		this.poslovniPartnerDTO = poslovniPartnerDTO;
		this.stavkeUOtpremniciDTO = stavkeUOtpremniciDTO;
	}
	public OtpremnicaDTO() {
		this.stavkeUOtpremniciDTO  = new ArrayList<StavkaUOtpremniciDTO>();
	}
	
	
}
