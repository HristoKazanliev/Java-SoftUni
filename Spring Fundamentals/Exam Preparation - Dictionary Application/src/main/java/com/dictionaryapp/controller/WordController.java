package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.AddWordDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController {

    @ModelAttribute("wordData")
    public AddWordDTO addWordDTO() {
        return new AddWordDTO();
    }

    @GetMapping("/words")
    public String addWord() {
        return "word-add";
    }

    @PostMapping("/words")
    public String addWord(@Valid AddWordDTO wordDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordData", wordDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.wordData", bindingResult);

            return "redirect:/words";
        }



        return "redirect:/word-add";
    }
}
