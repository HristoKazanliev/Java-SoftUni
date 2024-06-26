package com.bonappetit.service;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.dto.RecipeAddDTO;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.model.enums.CategoryEnum;
import com.bonappetit.repo.CategoryRepository;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.repo.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;
    private final CategoryRepository categoryRepository;

    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository, UserSession userSession, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.categoryRepository = categoryRepository;
    }

    public boolean addRecipe(RecipeAddDTO recipeAddDTO) {
        if (!userSession.isLoggedIn()) {
            return false;
        }

        Optional<User> userById = userRepository.findById(userSession.id());
        if (userById.isEmpty()) {
            return false;
        }

        Optional<Category> categoryByName = categoryRepository.findByName(recipeAddDTO.getCategory());
        if (categoryByName.isEmpty()) {
            return false;
        }

        Recipe recipe = new Recipe();
        recipe.setName(recipeAddDTO.getName());
        recipe.setCategory(categoryByName.get());
        recipe.setIngredients(recipeAddDTO.getIngredients());
        recipe.setAddedBy(userById.get());

        recipeRepository.save(recipe);

        return true;
    }

    public Map<CategoryEnum, List<Recipe>> getAllByCategory() {
        Map<CategoryEnum, List<Recipe>> result = new HashMap<>();
        List<Category> categories = categoryRepository.findAll();

        for (Category category : categories) {
            List<Recipe> recipes = recipeRepository.findByCategory(category);

            result.put(category.getName(), recipes);
        }

        return result;
    }

    @Transactional
    public void addToFavourites(Long userId, Long recipeId) {
        Optional<User> userById = userRepository.findById(userId);
        if (userById.isEmpty()) {
            return;
        }

        Optional<Recipe> recipeById = recipeRepository.findById(recipeId);
        if (recipeById.isEmpty()) {
            return;
        }

        userById.get().addFavourite(recipeById.get());

        userRepository.save(userById.get());
    }
}
