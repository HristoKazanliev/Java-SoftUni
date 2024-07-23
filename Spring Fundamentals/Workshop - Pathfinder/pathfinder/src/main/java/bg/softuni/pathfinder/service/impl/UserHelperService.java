package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.UserRepository;
import bg.softuni.pathfinder.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHelperService {
    private static final String ROLE_PREFIX = "ROLE_";
    private final UserRepository userRepository;

    public User getCurrentUser() {
        return userRepository.findByUsername(getUserDetails().getUsername()).orElse(null);
    }

    public boolean hasRole(String role) {
        return getAuthentication().getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(ROLE_PREFIX + role));
    }

    public boolean isAuthenticated() {
        //default is ANONYMOUS when no user is authenticated
        return !hasRole("ANONYMOUS");
    }

    public UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
    }

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
