package poslovna.converter;

import org.springframework.stereotype.Component;

import poslovna.dto.JedinicaMereDTO;
import poslovna.dto.PoslovniPartnerDTO;
import poslovna.model.JedinicaMere;
import poslovna.model.PoslovniPartner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

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
