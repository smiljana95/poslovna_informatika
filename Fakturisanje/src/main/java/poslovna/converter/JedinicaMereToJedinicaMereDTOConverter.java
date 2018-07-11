package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.JedinicaMereDTO;
import poslovna.model.JedinicaMere;

@Component
public class JedinicaMereToJedinicaMereDTOConverter implements Converter<JedinicaMere, JedinicaMereDTO> {

	@Override
	public JedinicaMereDTO convert(JedinicaMere source) {
		if(source == null){
			return null;
		}
		
		JedinicaMereDTO jedinicaMereDTO = new JedinicaMereDTO();
		jedinicaMereDTO.setId(source.getId());
		jedinicaMereDTO.setNaziv(source.getNaziv());
		jedinicaMereDTO.setOznaka(source.getOznaka());
		return jedinicaMereDTO;
	}
	
	public List<JedinicaMereDTO> convert(List<JedinicaMere> source) {
		List<JedinicaMereDTO> ret = new ArrayList<JedinicaMereDTO>();
		for(JedinicaMere grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
