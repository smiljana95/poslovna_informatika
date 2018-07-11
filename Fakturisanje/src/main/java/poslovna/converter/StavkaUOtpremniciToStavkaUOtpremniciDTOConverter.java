package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.StavkaUOtpremniciDTO;

import poslovna.model.StavkaUOtpremnici;

@Component
public class StavkaUOtpremniciToStavkaUOtpremniciDTOConverter implements Converter<StavkaUOtpremnici, StavkaUOtpremniciDTO> {

	@Autowired
	private ArtikalToArtikalDTOConverter converter;
	
	
	@Override
	public StavkaUOtpremniciDTO convert(StavkaUOtpremnici source) {
		if(source == null) {
			return null;
		}
		StavkaUOtpremniciDTO ret = new StavkaUOtpremniciDTO();
		ret.setId(source.getId());
		ret.setIznosPDVa(source.getIznosPDVa());
		ret.setJedinicnaCena(source.getJedinicnaCena());
		ret.setJedinicnaCenaSaPDV(source.getJedinicnaCenaSaPDVa());
		ret.setOsnovica(source.getOsnovica());
		ret.setPopust(source.getPopust());
		ret.setStopaPDVa(source.getStopaPDVa());
		ret.setUkupnaKolicina(source.getUkupnaKolicina());
		ret.setArtikalDTO(converter.convert(source.getArtikal()));
		return ret;
	}

	public List<StavkaUOtpremniciDTO> convert(List<StavkaUOtpremnici> source) {
		List<StavkaUOtpremniciDTO> ret = new ArrayList<StavkaUOtpremniciDTO>();
		for(StavkaUOtpremnici grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}
}
