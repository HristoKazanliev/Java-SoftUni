package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.UserRepository;
import bg.softuni.pathfinder.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(AppUserDetailsService::mapToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }

    private static UserDetails mapToUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(List.of())
                .build();
    }
}
