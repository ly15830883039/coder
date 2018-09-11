package rui.coder.design.pattern.creater.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rui.coder.design.pattern.creater.builder.Meal;
import rui.coder.design.pattern.creater.builder.MealBuilder;

class MealBuilderTest {

    MealBuilder mealBuilder;
    @BeforeEach
    void setUp() {
        mealBuilder = new MealBuilder();
    }

    @Test
    void vegMeal() {
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());


    }
    @Test
    void nonVegMeal() {
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}