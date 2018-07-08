package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.PoslovniPartnerDTO;
import poslovna.model.PoslovniPartner;

@Component
public class PoslovniPartnerToPoslovniPartnerDTOConverter implements Converter<PoslovniPartner, PoslovniPartnerDTO> {
	
	@Autowired
	private GradToGradDTOConverter gradToGradDTOConverter;
	
	@Autowired
	private TipPoslovnogPartneraToTipPoslovnogPartneraDTOConverter tipPoslovnogPartneraToTipPoslovnogPartneraDTOConverter;

	@Override
	public PoslovniPartnerDTO convert(PoslovniPartner source) {
		if(source == null) {
			return null;
		}
		PoslovniPartnerDTO ret = new PoslovniPartnerDTO();
		ret.setId(source.getId());
		ret.setAdresa(source.getAdresa());
		ret.setKontaktTelefon(source.getKontaktTelefon());
		ret.setNaziv(source.getNaziv());
		ret.setGradDTO(gradToGradDTOConverter.convert(source.getGrad()));
		ret.setTipPoslovnogPartneraDTO(tipPoslovnogPartneraToTipPoslovnogPartneraDTOConverter.convert(source.getTipPoslovnogPartnera()));
		return ret;
	}
	
	public List<PoslovniPartnerDTO> convert(List<PoslovniPartner> source) {
		List<PoslovniPartnerDTO> ret = new ArrayList<PoslovniPartnerDTO>();
		for(PoslovniPartner grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
