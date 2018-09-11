package rui.coder.design.pattern.creater.builder.item.coldDrink;


/**
 * 可口可乐
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}