package com.dictionaryapp.controller;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.InfoWordDTO;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageEnum;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private final UserSession userSession;
    private final WordService wordService;

    public HomeController(UserSession userSession, WordService wordService) {
        this.userSession = userSession;
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String notLoggedHome() {
        if (userSession.isUserLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String loggedHome(Model model) {
        if (!userSession.isUserLoggedIn()) {
            return "redirect:/";
        }

        Map<LanguageEnum, List<Word>> allWords = wordService.getAllWords();

        List<InfoWordDTO> germanWords = allWords
                .get(LanguageEnum.GERMAN)
                .stream()
                .map(InfoWordDTO::new)
                .toList();

        List<InfoWordDTO> spanishWords = allWords
                .get(LanguageEnum.SPANISH)
                .stream()
                .map(InfoWordDTO::new)
                .toList();

        List<InfoWordDTO> frenchWords = allWords
                .get(LanguageEnum.FRENCH)
                .stream()
                .map(InfoWordDTO::new)
                .toList();

        List<InfoWordDTO> italianWords = allWords
                .get(LanguageEnum.ITALIAN)
                .stream()
                .map(InfoWordDTO::new)
                .toList();

        model.addAttribute("germanData", germanWords);
        model.addAttribute("spanishData", spanishWords);
        model.addAttribute("frenchData", frenchWords);
        model.addAttribute("italianData", italianWords);

        return "home";
    }

}
