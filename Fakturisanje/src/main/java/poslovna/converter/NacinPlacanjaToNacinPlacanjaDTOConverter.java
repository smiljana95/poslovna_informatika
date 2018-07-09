package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.GradDTO;
import poslovna.dto.NacinPlacanjaDTO;
import poslovna.model.Grad;
import poslovna.model.NacinPlacanja;

@Component
public class NacinPlacanjaToNacinPlacanjaDTOConverter implements Converter<NacinPlacanja, NacinPlacanjaDTO> {

	@Override
	public NacinPlacanjaDTO convert(NacinPlacanja source) {
		if(source == null) {
			return null;
		}
		NacinPlacanjaDTO ret = new NacinPlacanjaDTO();
		ret.setId(source.getId());
		ret.setNazivTipaPlacanja(source.getNazivTipaPlacanja());
		return ret;
	}
	
	public List<NacinPlacanjaDTO> convert(List<NacinPlacanja> source) {
		List<NacinPlacanjaDTO> ret = new ArrayList<NacinPlacanjaDTO>();
		for(NacinPlacanja grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
