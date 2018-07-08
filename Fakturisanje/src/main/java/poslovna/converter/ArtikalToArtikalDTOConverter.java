package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.ArtikalDTO;
import poslovna.dto.JedinicaMereDTO;
import poslovna.model.Artikal;
import poslovna.model.JedinicaMere;

@Component
public class ArtikalToArtikalDTOConverter implements Converter<Artikal, ArtikalDTO> {

	@Autowired
	private JedinicaMereToJedinicaMereDTOConverter converter;
	
	@Override
	public ArtikalDTO convert(Artikal source) {
		if(source == null){
			return null;
		}
		
		ArtikalDTO artikalDTO = new ArtikalDTO();
		artikalDTO.setId(source.getId());
		artikalDTO.setJedinicaMereDTO(converter.convert(source.getJedinicaMere()));
		artikalDTO.setNaziv(source.getNaziv());
		artikalDTO.setOpis(source.getOpis());
		return artikalDTO;
	}

	public List<ArtikalDTO> convert(List<Artikal> source) {
		List<ArtikalDTO> ret = new ArrayList<ArtikalDTO>();
		for(Artikal grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
