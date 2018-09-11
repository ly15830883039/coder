package rui.coder.design.pattern.creater.builder;

import rui.coder.design.pattern.creater.builder.item.burger.ChickenBurger;
import rui.coder.design.pattern.creater.builder.item.burger.VegBurger;
import rui.coder.design.pattern.creater.builder.item.coldDrink.Coke;
import rui.coder.design.pattern.creater.builder.item.coldDrink.Pepsi;

public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}