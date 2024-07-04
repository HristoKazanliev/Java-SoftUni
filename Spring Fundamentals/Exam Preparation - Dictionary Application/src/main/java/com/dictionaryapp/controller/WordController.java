package com.dictionaryapp.controller;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController {
    private final WordService wordService;
    private final UserSession userSession;

    public WordController(WordService wordService, UserSession userSession) {
        this.wordService = wordService;
        this.userSession = userSession;
    }

    @ModelAttribute("wordData")
    public AddWordDTO addWordDTO() {
        return new AddWordDTO();
    }

    @GetMapping("/words/add")
    public String addWord() {
        if (!userSession.isUserLoggedIn()) {
            return "redirect:/";
        }

        return "word-add";
    }

    @PostMapping("/words/add")
    public String addWord(@Valid AddWordDTO wordDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (!userSession.isUserLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordData", wordDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.wordData", bindingResult);

            return "redirect:/words/add";
        }

        boolean success = this.wordService.addWord(wordDTO);
        if (!success) {
            redirectAttributes.addFlashAttribute("wordData", wordDTO);

            return "redirect:/words/add";
        }

        return "redirect:/home";
    }

    @GetMapping("/words/delete-word/{id}")
    public String deleteWord(@PathVariable long id) {
        if (!userSession.isUserLoggedIn()) {
            return "redirect:/";
        }

        wordService.delete(id);

        return "redirect:/home";
    }

    @GetMapping("/words/remove-all")
    public String removeAll() {
        if (!userSession.isUserLoggedIn()) {
            return "redirect:/";
        }

        wordService.deleteAll();

        return "redirect:/home";
    }
}
