package poslovna.dto;

public class StavkaCenovnikaDTO {
		private ArtikalDTO artikalDTO;
		private Long id;
		private double cena;
		public ArtikalDTO getArtikalDTO() {
			return artikalDTO;
		}
		public void setArtikalDTO(ArtikalDTO artikalDTO) {
			this.artikalDTO = artikalDTO;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public double getCena() {
			return cena;
		}
		public void setCena(double cena) {
			this.cena = cena;
		}
		public StavkaCenovnikaDTO(ArtikalDTO artikalDTO, Long id, double cena) {
			
			this.artikalDTO = artikalDTO;
			this.id = id;
			this.cena = cena;
		}
		public StavkaCenovnikaDTO() {
			
		}
		
		
		
}
