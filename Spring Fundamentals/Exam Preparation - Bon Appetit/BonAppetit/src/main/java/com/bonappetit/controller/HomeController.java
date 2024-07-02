package com.bonappetit.controller;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.RecipeInfoDTO;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.enums.CategoryEnum;
import com.bonappetit.service.RecipeService;
import com.bonappetit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private final UserSession userSession;
    private final RecipeService recipeService;
    private final UserService userService;

    public HomeController(UserSession userSession, RecipeService recipeService, UserService userService) {
        this.userSession = userSession;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String notLoggedHome() {
        if (userSession.isLoggedIn()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    @Transactional
    public String loggedHome(Model model) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        Map<CategoryEnum, List<Recipe>> allRecipes = recipeService.getAllByCategory();

        List<RecipeInfoDTO> desserts = allRecipes
                .get(CategoryEnum.DESSERT)
                .stream()
                .map(RecipeInfoDTO::new)
                .toList();

        List<RecipeInfoDTO> mainDishes = allRecipes
                .get(CategoryEnum.MAIN_DISH)
                .stream()
                .map(RecipeInfoDTO::new)
                .toList();

        List<RecipeInfoDTO> cocktails = allRecipes
                .get(CategoryEnum.COCKTAIL)
                .stream()
                .map(RecipeInfoDTO::new)
                .toList();

        List<RecipeInfoDTO> favourites = userService
                .findFavourites(userSession.id())
                .stream()
                .map(RecipeInfoDTO::new)
                .toList();


        model.addAttribute("dessertsData", desserts);
        model.addAttribute("mainDishesData", mainDishes);
        model.addAttribute("cocktailsData", cocktails);
        model.addAttribute("favouritesData", favourites);

        return "home";
    }
}
