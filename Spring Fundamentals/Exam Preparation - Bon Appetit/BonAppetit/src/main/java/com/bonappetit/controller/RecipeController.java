package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.RecipeAddDTO;
import com.bonappetit.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeController {
    private final UserSession userSession;
    private final RecipeService recipeService;

    public RecipeController(UserSession userSession, UserSession userSession1, RecipeService recipeService) {
        this.userSession = userSession1;
        this.recipeService = recipeService;
    }

    @ModelAttribute("recipeData")
    public RecipeAddDTO recipeData() {
        return new RecipeAddDTO();
    }

    @GetMapping("/add-recipe")
    public String addRecipe() {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        return "recipe-add";
    }

    @PostMapping("/add-recipe")
    public String addRecipe(@Valid RecipeAddDTO recipeAddDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("recipeData", recipeAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recipeData", bindingResult);

            return "redirect:/add-recipe";
        }

        boolean success = recipeService.addRecipe(recipeAddDTO);
        if (!success) {
            redirectAttributes.addFlashAttribute("recipeData", recipeAddDTO);

            return "redirect:/add-recipe";
        }

        return "redirect:/home";
    }

    @PostMapping("/add-to-favourites/{id}")
    public String addToFavourites(@PathVariable long id) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        recipeService.addToFavourites(userSession.id(), id);

        return "redirect:/home";
    }
}
