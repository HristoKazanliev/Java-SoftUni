package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.UserLoginDTO;
import com.bonappetit.model.dto.UserRegisterDTO;
import com.bonappetit.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;
    private final UserSession userSession;

    public UserController(UserService userService, UserSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }

    @ModelAttribute("registerData")
    public UserRegisterDTO registerData() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("loginData")
    public UserLoginDTO loginData() {
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String register() {
        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);

            return "redirect:/register";
        }

        boolean success = userService.register(userRegisterDTO);
        if (!success) {
            return "redirect:/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginData", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData", bindingResult);

            return "redirect:/login";
        }

        boolean success = userService.login(userLoginDTO);
        if (!success) {
            redirectAttributes.addFlashAttribute("loginError", true);

            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        userSession.logout();

        return "redirect:/";
    }
}
