package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserProfileDto;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerData", new UserRegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerModel", bindingResult);

            return "register";
        }

        this.userService.registerUser(userRegisterDTO);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginData", new UserLoginDTO());

        return "login";
    }

    @GetMapping("/login-error")
    public ModelAndView loginError() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("showErrorMessage", true);
        modelAndView.addObject("loginData", new UserLoginDTO());

        return modelAndView;
    }

//    @PostMapping("/login")
//    public String login(UserLoginDTO loginData) {
//        this.userService.loginUser(loginData);
//
//        return "redirect:/";
//    }
//
//    @PostMapping("/logout")
//    public String logout() {
//        this.userService.logout();
//
//        return "redirect:/";
//    }

    @GetMapping("/profile")
    public String profile(Model model) {
       model.addAttribute("profileData", this.userService.getProfileDetails());

        return "/profile";
    }

//    @GetMapping("/profile/{id}")
//    private String profile(@PathVariable Long id, Model model){
//        model.addAttribute("user", modelMapper
//                        .map(this.userService.findById(id), UserProfileDto.class));
//
//        return "profile";
//    }
}
