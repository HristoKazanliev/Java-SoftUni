package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.enums.UserRoleEnum;
import bg.softuni.mobilelele.model.user.MobileleUserDetails;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MobileleUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MobileleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(MobileleUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
    }

//    private static UserDetails map(UserEntity userEntity) {
//        return User
//                .withUsername(userEntity.getEmail())
//                .password(userEntity.getPassword())
//                .authorities(List.of())
//                .disabled(false)
//                .build();
//    }

    private static UserDetails map(UserEntity userEntity) {
        return new MobileleUserDetails(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(r -> r.getRole()).map(MobileleUserDetailsService::map).toList(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }

    private static GrantedAuthority map(UserRoleEnum role) {
        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }
}
