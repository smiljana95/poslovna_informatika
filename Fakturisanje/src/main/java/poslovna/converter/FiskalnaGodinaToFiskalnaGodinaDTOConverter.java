package poslovna.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.FiskalnaGodinaDTO;
import poslovna.model.FiskalnaGodina;

@Component
public class FiskalnaGodinaToFiskalnaGodinaDTOConverter implements Converter<FiskalnaGodina, FiskalnaGodinaDTO> {

	@Override
	public FiskalnaGodinaDTO convert(FiskalnaGodina source) {
		if(source == null) {
			return null;
		}
		FiskalnaGodinaDTO ret = new FiskalnaGodinaDTO();
		ret.setId(source.getId());
		ret.setBrojGodine(source.getBrojGodine());
		ret.setAktivna(source.isAktivna());
		return ret;
	}
	
	public List<FiskalnaGodinaDTO> convert(List<FiskalnaGodina> source) {
		List<FiskalnaGodinaDTO> ret = new ArrayList<FiskalnaGodinaDTO>();
		for(FiskalnaGodina grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
