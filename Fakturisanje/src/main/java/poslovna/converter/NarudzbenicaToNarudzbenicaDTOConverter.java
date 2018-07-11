package poslovna.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.NarudzbenicaDTO;
import poslovna.model.Narudzbenica;

@Component
public class NarudzbenicaToNarudzbenicaDTOConverter implements Converter<Narudzbenica, NarudzbenicaDTO> {

	@Autowired
	private FiskalnaGodinaToFiskalnaGodinaDTOConverter fiskalnaGodinaConverter;
	
	@Autowired
	private NacinPlacanjaToNacinPlacanjaDTOConverter nacinPlacanjaConverter;
	
	@Autowired
	private PoslovniPartnerToPoslovniPartnerDTOConverter poslovniPartnerConverter;
	
	@Autowired
	private StavkaUNarudzbeniciToStavkaUNarudzbeniciDTOConverter stavkaConverter;
	
	@Override
	public NarudzbenicaDTO convert(Narudzbenica source) {
		if(source == null) {
			return null;
		}
		NarudzbenicaDTO ret = new NarudzbenicaDTO();
		ret.setBrojNarudzbenice(source.getBrojNarudzbenice());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		ret.setDatumNarudzbenice(df.format(source.getDatumNarudzbenica()));
		ret.setFiskalnaGodinaDTO(fiskalnaGodinaConverter.convert(source.getFiskalnaGodina()));
		ret.setId(source.getId());
		ret.setNacinPlacanjaDTO(nacinPlacanjaConverter.convert(source.getNacinPlacanja()));
		ret.setPoslata(source.isPoslata());
		ret.setPoslovniPartnerDTO(poslovniPartnerConverter.convert(source.getPoslovniPartner()));
		ret.setPozivNaBroj(source.getPozivNaBroj());
		ret.setRacunZaUplatu(source.getRacunZaUplatu());
		ret.setStavkeUNarudzbeniciDTO(stavkaConverter.convert(source.getStavke()));
		ret.setUkupanPDV(source.getUkupanPDV());
		ret.setUkupnaCena(source.getUkupnaCena());
		ret.setUkupnaCenaBezPDVa(source.getUkupnaCenaBezPDVa());
		return ret;
	}
	
	public List<NarudzbenicaDTO> convert(List<Narudzbenica> source) {
		List<NarudzbenicaDTO> ret = new ArrayList<NarudzbenicaDTO>();
		for(Narudzbenica grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

	
}
