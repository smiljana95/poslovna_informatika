package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import poslovna.dto.StavkaCenovnikaDTO;

import poslovna.model.StavkaUCenovniku;

@Component
public class StavkaCenovnikaToStavkaCenovnikaDTOConverter implements Converter<StavkaUCenovniku, StavkaCenovnikaDTO> {

	@Autowired
	private ArtikalToArtikalDTOConverter converter;
	
	@Override
	public StavkaCenovnikaDTO convert(StavkaUCenovniku source) {
		if(source==null){
			return null;
		}
		StavkaCenovnikaDTO stavkaCenovnikaDTO = new StavkaCenovnikaDTO();
		stavkaCenovnikaDTO.setArtikalDTO(converter.convert(source.getArtikal()));
		stavkaCenovnikaDTO.setCena(source.getCena());
		stavkaCenovnikaDTO.setId(source.getId());
		
		return stavkaCenovnikaDTO;
	}
	
	public List<StavkaCenovnikaDTO> convert(List<StavkaUCenovniku> source) {
		List<StavkaCenovnikaDTO> ret = new ArrayList<StavkaCenovnikaDTO>();
		for(StavkaUCenovniku grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
