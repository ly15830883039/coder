package rui.coder.design.pattern.creater.builder.item.burger;

/**
 * 蔬菜堡
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}