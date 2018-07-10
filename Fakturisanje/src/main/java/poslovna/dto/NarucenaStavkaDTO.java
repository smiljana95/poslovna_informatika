package poslovna.dto;

public class NarucenaStavkaDTO {
	
	private Long id;
	private int value;
	
	public NarucenaStavkaDTO() {
		// TODO Auto-generated constructor stub
	}

	public NarucenaStavkaDTO(Long id, int value) {
		this.id = id;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
