package com.dictionaryapp.config;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionMapping {

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFound(Model model) {

        return "redirect:/error";
    }
}
