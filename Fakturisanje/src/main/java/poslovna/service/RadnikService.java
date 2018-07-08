package poslovna.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import poslovna.model.Radnik;
import poslovna.repository.RadnikRepository;

@Service
public class RadnikService {
	
	@Autowired
	private RadnikRepository radnikRepository;
	
	public Radnik findByEmail(String email) {
		return radnikRepository.findByEmailIgnoreCase(email);
	}
	
	public void setCurrentUser(Radnik user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        Authentication authentication = new PreAuthenticatedAuthenticationToken(user.getId(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public Radnik getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            Long id = Long.parseLong(auth.getName());
            return radnikRepository.findOne(id);
        } catch (Exception e) {
            return null;
        }
    }

}
