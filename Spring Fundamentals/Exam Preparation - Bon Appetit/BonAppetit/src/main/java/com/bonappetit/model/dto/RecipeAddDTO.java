package com.bonappetit.model.dto;

import com.bonappetit.model.enums.CategoryEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RecipeAddDTO {
    @NotNull
    @Size(min = 2, max = 40)
    private String name;

    @NotNull
    @Size(min = 2, max = 150)
    private String ingredients;

    @NotNull
    private CategoryEnum category;

    public RecipeAddDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
