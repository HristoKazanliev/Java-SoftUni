package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.UserLoginDTO;
import bg.softuni.mobilelele.model.dto.UserRegistrationDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.repository.UserRepository;
//import bg.softuni.mobilelele.service.CurrentUser;
import bg.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    //private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        //this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

//  Before springframework.security
//    @Override
//    public boolean login(UserLoginDTO userLoginDTO) {
//        UserEntity userToFind = userRepository
//                        .findByEmail(userLoginDTO
//                        .email()).orElse(null);
//
//        if (userLoginDTO.password() == null || userToFind == null || userToFind.getPassword() == null) return false;
//
//        boolean successfulLogin = passwordEncoder.matches(userLoginDTO.password(), userToFind.getPassword());
//
//        if (successfulLogin) {
//            currentUser.setLoggedIn(true);
//            currentUser.setFullName(userToFind.getFirstName() + " " + userToFind.getLastName());
//        } else {
//            currentUser.clean();
//        }
//
//        return false;
//    }

//    @Override
//    public void logout() {
//        currentUser.clean();
//    }

    private UserEntity map (UserRegistrationDTO dto) {
        UserEntity mappedUser = modelMapper.map(dto, UserEntity.class);

        mappedUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        return mappedUser;
    }
}
