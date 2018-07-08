package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.GradDTO;
import poslovna.model.Grad;

@Component
public class GradToGradDTOConverter implements Converter<Grad, GradDTO> {

	@Override
	public GradDTO convert(Grad source) {
		if(source == null) {
			return null;
		}
		GradDTO ret = new GradDTO();
		ret.setId(source.getId());
		ret.setNaziv(source.getNaziv());
		ret.setPTT(source.getPTT());
		return ret;
	}
	
	public List<GradDTO> convert(List<Grad> source) {
		List<GradDTO> ret = new ArrayList<GradDTO>();
		for(Grad grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
