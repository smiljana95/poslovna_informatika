package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.StavkaUFakturiDTO;
import poslovna.dto.StavkaUNarudzbeniciDTO;
import poslovna.model.StavkaUFakturi;
import poslovna.model.StavkaUNarudzbenici;

@Component
public class StavkaUFakturiToStavkaUFakturiDTOConverter implements Converter<StavkaUFakturi, StavkaUFakturiDTO> {

	@Autowired
	private ArtikalToArtikalDTOConverter converter;
	
	@Override
	public StavkaUFakturiDTO convert(StavkaUFakturi source) {
		
		if(source == null) {
			return null;
		}
		StavkaUFakturiDTO ret = new StavkaUFakturiDTO();
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
	
	public List<StavkaUFakturiDTO> convert(List<StavkaUFakturi> source) {
		List<StavkaUFakturiDTO> ret = new ArrayList<StavkaUFakturiDTO>();
		for(StavkaUFakturi grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
