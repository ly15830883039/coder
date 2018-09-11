package rui.coder.design.pattern.creater.builder.item.coldDrink;

/**
 * 百事可乐
 */
public class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
