package poslovna.dto;
public class LoggedInUserDTO {
	
	private String name;
	private String role;
	private Long id;
	
	public LoggedInUserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public LoggedInUserDTO(String name, String role, Long id) {
		this.name = name;
		this.role = role;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}