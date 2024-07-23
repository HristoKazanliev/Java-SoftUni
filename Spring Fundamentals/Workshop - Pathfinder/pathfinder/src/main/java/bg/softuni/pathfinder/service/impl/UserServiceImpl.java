package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.data.UserRepository;
import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserProfileDto;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.enums.Level;
//import bg.softuni.pathfinder.service.CurrentUser;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserHelperService userHelperService;
    //private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserHelperService userHelperService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        //this.currentUser = currentUser;
        this.userHelperService = userHelperService;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = this.modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(this.passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setLevel(Level.BEGINNER);

        this.userRepository.save(user);
    }

    //Before spring security
//    @Override
//    public void loginUser(UserLoginDTO loginData) {
//        User user = this.userRepository
//                .findByUsername(loginData.getUsername())
//                .orElse(null);
//
//        if (user == null || loginData.getPassword() == null || user.getPassword() == null) {
//            throw new RuntimeException("Username not found");
//        }
//
//        if (this.passwordEncoder.matches(loginData.getPassword(), user.getPassword()) && !this.currentUser.isLoggedIn()) {
//            this.currentUser.setUser(user);
//        }
//    }

//    @Override
//    public void logout() {
//        this.currentUser.setUser(null);
//    }

    @Override
    public UserProfileDto getProfileDetails() {
        return this.modelMapper.map(userHelperService.getCurrentUser(), UserProfileDto.class);
    }
}
