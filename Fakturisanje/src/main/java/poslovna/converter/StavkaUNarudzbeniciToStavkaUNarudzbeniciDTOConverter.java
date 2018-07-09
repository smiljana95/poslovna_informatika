package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.GradDTO;
import poslovna.dto.StavkaUNarudzbeniciDTO;
import poslovna.model.Grad;
import poslovna.model.StavkaUNarudzbenici;

@Component
public class StavkaUNarudzbeniciToStavkaUNarudzbeniciDTOConverter implements Converter<StavkaUNarudzbenici, StavkaUNarudzbeniciDTO> {

	@Autowired
	private ArtikalToArtikalDTOConverter converter;
	
	@Override
	public StavkaUNarudzbeniciDTO convert(StavkaUNarudzbenici source) {
		if(source == null) {
			return null;
		}
		StavkaUNarudzbeniciDTO ret = new StavkaUNarudzbeniciDTO();
		ret.setId(source.getId());
		ret.setIznosPDVa(source.getIznosPDVa());
		ret.setJedinicnaCena(source.getJedinicnaCena());
		ret.setJedinicnaCenaSaPDV(source.getJedinicnaCenaSaPDV());
		ret.setOsnovica(source.getOsnovica());
		ret.setPopust(source.getPopust());
		ret.setStopaPDVa(source.getStopaPDVa());
		ret.setUkupnaKolicina(source.getUkupnaKolicina());
		ret.setArtikalDTO(converter.convert(source.getArtikal()));
		return ret;
	}
	
	public List<StavkaUNarudzbeniciDTO> convert(List<StavkaUNarudzbenici> source) {
		List<StavkaUNarudzbeniciDTO> ret = new ArrayList<StavkaUNarudzbeniciDTO>();
		for(StavkaUNarudzbenici grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
