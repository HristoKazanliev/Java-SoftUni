package com.bonappetit.service;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.UserLoginDTO;
import com.bonappetit.model.dto.UserRegisterDTO;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserSession userSession;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, UserSession userSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userSession = userSession;
    }

    public boolean register(UserRegisterDTO registerDTO) {
        Optional<User> existingUser = userRepository.findByUsernameOrEmail(registerDTO.getUsername(), registerDTO.getEmail());
        if (existingUser.isEmpty()) {
            return false;
        }

        User userMapped = modelMapper.map(registerDTO, User.class);
        userMapped.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(userMapped);
        return true;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> existingUser = userRepository.findByUsername(loginDTO.getUsername());
        if (existingUser.isEmpty()) {
            return false;
        }

        boolean matches = passwordEncoder.matches(loginDTO.getPassword(), existingUser.get().getPassword());
        if (!matches) {
            return false;
        }

        userSession.login(existingUser.get().getId(), loginDTO.getUsername());

        return true;
    }

    @Transactional
    public List<Recipe> findFavourites(Long id) {
        return userRepository
                .findById(id)
                .map(User::getFavouriteRecipes)
                .orElse(new ArrayList<>());
    }
}
