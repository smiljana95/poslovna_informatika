package poslovna.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.FakturaDTO;
import poslovna.dto.NarudzbenicaDTO;
import poslovna.model.Faktura;
import poslovna.model.Narudzbenica;

@Component
public class FakturaToFakturaDTOConverter implements Converter<Faktura, FakturaDTO>{
	
	@Autowired
	private FiskalnaGodinaToFiskalnaGodinaDTOConverter fiskalnaGodinaConverter;
	
	@Autowired
	private NacinPlacanjaToNacinPlacanjaDTOConverter nacinPlacanjaConverter;
	
	@Autowired
	private PoslovniPartnerToPoslovniPartnerDTOConverter poslovniPartnerConverter;
	
	@Autowired
	private StavkaUFakturiToStavkaUFakturiDTOConverter stavkaConverter;

	@Override
	public FakturaDTO convert(Faktura source) {
		if(source == null) {
			return null;
		}
		FakturaDTO ret = new FakturaDTO();
		ret.setBrojFakture(source.getBrojFakture());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		ret.setDatumFakture(df.format(source.getDatumFakture()));
		ret.setFiskalnaGodinaDTO(fiskalnaGodinaConverter.convert(source.getFiskalnaGodina()));
		ret.setId(source.getId());
		ret.setNacinPlacanjaDTO(nacinPlacanjaConverter.convert(source.getNacinPlacanja()));
		ret.setDatumValute(df.format(source.getDatumValute()));
		ret.setPoslovniPartnerDTO(poslovniPartnerConverter.convert(source.getPoslovniPartner()));
		ret.setPozivNaBroj(source.getPozivNaBroj());
		ret.setRacunZaUplatu(source.getRacunZaUplatu());
		ret.setStavkeUFakturiDTO(stavkaConverter.convert(source.getStavke()));
		ret.setUkupanPDV(source.getUkupanPDV());
		ret.setUkupnaCena(source.getUkupnaCena());
		ret.setUkupnaCenaBezPDVa(source.getUkupnaCenaBezPDVa());
		return ret;
	}
	
	public List<FakturaDTO> convert(List<Faktura> source) {
		List<FakturaDTO> ret = new ArrayList<FakturaDTO>();
		for(Faktura grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
