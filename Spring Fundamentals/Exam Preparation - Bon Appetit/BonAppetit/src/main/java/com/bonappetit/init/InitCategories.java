package com.bonappetit.init;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.enums.CategoryEnum;
import com.bonappetit.repo.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class InitCategories implements CommandLineRunner {
    private final Map<CategoryEnum, String> descriptions = Map.of(
            CategoryEnum.MAIN_DISH, "Heart of the meal, substantial and satisfying; main dish delights taste buds.",
            CategoryEnum.DESSERT, "Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy.",
            CategoryEnum.COCKTAIL, "Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass."
    );

    private final CategoryRepository categoryRepository;

    public InitCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = this.categoryRepository.count();

        if (count > 0) {
            return;
        }

        for (CategoryEnum categoryEnum : descriptions.keySet()) {
            Category category = new Category(categoryEnum, descriptions.get(categoryEnum));

            this.categoryRepository.save(category);
        }

//        List<Category> categoriesToInsert = Arrays.stream(CategoryEnum.values())
//                .map(c -> new Category(c, descriptions.get(c)))
//                .toList();
//
//        this.categoryRepository.saveAll(categoriesToInsert);
    }
}
