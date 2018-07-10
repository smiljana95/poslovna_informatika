package poslovna.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.OtpremnicaDTO;

import poslovna.model.Otpremnica;

@Component
public class OtpremnicaToOtpremnicaDTOConverter implements Converter<Otpremnica, OtpremnicaDTO> {

	@Autowired
	private FiskalnaGodinaToFiskalnaGodinaDTOConverter fiskalnaGodinaConverter;
	
	@Autowired
	private NacinPlacanjaToNacinPlacanjaDTOConverter nacinPlacanjaConverter;
	
	@Autowired
	private PoslovniPartnerToPoslovniPartnerDTOConverter poslovniPartnerConverter;
	
	@Autowired
	private StavkaUOtpremniciToStavkaUOtpremniciDTOConverter stavkaConverter;
	
	@Override
	public OtpremnicaDTO convert(Otpremnica source) {
		if(source == null) {
			return null;
		}
		OtpremnicaDTO ret = new OtpremnicaDTO();
		ret.setBrojOtpremnice(source.getBrojOtpremnice());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		ret.setDatumOtpremnice((df.format(source.getDatumOtpremnice())));
		ret.setFiskalnaGodinaDTO(fiskalnaGodinaConverter.convert(source.getFiskalnaGodina()));
		ret.setId(source.getId());
		ret.setNacinPlacanjaDTO(nacinPlacanjaConverter.convert(source.getNacinPlacanja()));
		ret.setDatumValute(df.format(source.getDatumValute()));
		ret.setPoslovniPartnerDTO(poslovniPartnerConverter.convert(source.getPoslovniPartner()));
		ret.setPozivNaBroj(source.getPozivNaBroj());
		ret.setRacunZaUplatu(source.getRacunZaUplatu());
		ret.setStavkeUOtpremniciDTO(stavkaConverter.convert(source.getStavke()));
		ret.setUkupanPDV(source.getUkupanPDV());
		ret.setUkupnaCena(source.getUkupnaCena());
		
		ret.setUkupnaCenaBezPDVa(source.getUkupnaCenaBezPDVa());
		return ret;
	}
	
	public List<OtpremnicaDTO> convert(List<Otpremnica> source) {
		List<OtpremnicaDTO> ret = new ArrayList<OtpremnicaDTO>();
		for(Otpremnica grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
