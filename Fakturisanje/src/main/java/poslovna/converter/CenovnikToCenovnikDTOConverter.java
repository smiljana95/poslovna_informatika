package poslovna.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import poslovna.dto.ArtikalDTO;
import poslovna.dto.CenovnikDTO;
import poslovna.model.Artikal;
import poslovna.model.Cenovnik;

@Component
public class CenovnikToCenovnikDTOConverter implements Converter<Cenovnik, CenovnikDTO> {

	@Autowired
	private StavkaCenovnikaToStavkaCenovnikaDTOConverter converter;
	
	@Override
	public CenovnikDTO convert(Cenovnik source) {
		if(source==null){
			return null;
		}
		CenovnikDTO cenovnikDTO = new CenovnikDTO();
		cenovnikDTO.setId(source.getId());
		cenovnikDTO.setStavkaCenovnikaDTO(converter.convert(source.getStavkeUCenovniku()));
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		cenovnikDTO.setDatumPocetkaVazenja(df.format(source.getDatum_pocetka_vazenja()));
	return cenovnikDTO;
	}
	
	public List<CenovnikDTO> convert(List<Cenovnik> source) {
		List<CenovnikDTO> ret = new ArrayList<CenovnikDTO>();
		for(Cenovnik grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
