package poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Radnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50,nullable=false)
	private String email;
	
	@Column(length=50,nullable=false)
	private String ime;
	
	@Column(length=50,nullable=false)
	private String prezime;
	
	@Column(length=50,nullable=false)
	private String lozinka;
	
	@Column(length=20,nullable=false)
	private String kontaktTelefon;
	
	@Column(length=60,nullable=false)
	private String adresa;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grada", nullable = false)
    private Grad grad;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kompanije", nullable = false)
    private Kompanija kompanija;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Radnik(String email, String ime, String prezime, String lozinka, String kontaktTelefon, String adresa,
			Grad grad, Role role) {
		
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.lozinka = lozinka;
		this.kontaktTelefon = kontaktTelefon;
		this.adresa = adresa;
		this.grad = grad;
		this.role = role;
	}

	public Radnik() {
		
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
