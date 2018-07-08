package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.GradDTO;
import poslovna.dto.TipPoslovnogPartneraDTO;
import poslovna.model.Grad;
import poslovna.model.TipPoslovnogPartnera;

@Component
public class TipPoslovnogPartneraToTipPoslovnogPartneraDTOConverter implements Converter<TipPoslovnogPartnera, TipPoslovnogPartneraDTO> {

	@Override
	public TipPoslovnogPartneraDTO convert(TipPoslovnogPartnera source) {
		if(source == null) {
			return null;
		}
		TipPoslovnogPartneraDTO ret = new TipPoslovnogPartneraDTO();
		ret.setId(source.getId());
		ret.setNaziv(source.getNaziv());
		return ret;
	}
	
	public List<TipPoslovnogPartneraDTO> convert(List<TipPoslovnogPartnera> source) {
		List<TipPoslovnogPartneraDTO> ret = new ArrayList<TipPoslovnogPartneraDTO>();
		for(TipPoslovnogPartnera grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
