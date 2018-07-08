package poslovna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poslovna.dto.LoggedInUserDTO;
import poslovna.dto.LoginDTO;
import poslovna.model.Radnik;
import poslovna.model.Role;
import poslovna.service.RadnikService;

@RestController
@RequestMapping(value = "/radnik")
public class RadnikController {
	
	@Autowired
	private RadnikService radnikService;
	
	@RequestMapping(
			value = "/login",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
		Radnik radnik = radnikService.findByEmail(loginDTO.getEmail());
		if(radnik == null) {
			return new ResponseEntity<>("Incorrect email or password!", HttpStatus.BAD_REQUEST);
		}
		if(!radnik.getLozinka().equals(loginDTO.getLozinka())) {
			return new ResponseEntity<>("Incorrect email or password!", HttpStatus.BAD_REQUEST);
		}
		radnikService.setCurrentUser(radnik);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated()")
    @RequestMapping(
            value = "/getLoggedIn",
            method = RequestMethod.GET)
    public ResponseEntity<?> getLoggedIn() {
		Radnik loggedIn = radnikService.getCurrentUser();
		if(loggedIn == null) {
			return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		}
		String role = "";
		if(loggedIn.getRole().equals(Role.ADMIN)) {
			role = "ADMIN";
		} else if(loggedIn.getRole().equals(Role.REGISTERED)) {
			role = "REGISTERED";
		}
        return new ResponseEntity<>(new LoggedInUserDTO(loggedIn.getIme(), role, loggedIn.getId()), HttpStatus.OK);
    }
	
	@PreAuthorize("isAuthenticated()")
    @RequestMapping(
            value = "/logout",
            method = RequestMethod.POST)
    public ResponseEntity<?> signout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
