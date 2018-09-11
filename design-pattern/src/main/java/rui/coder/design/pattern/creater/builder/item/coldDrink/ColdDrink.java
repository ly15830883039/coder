package rui.coder.design.pattern.creater.builder.item.coldDrink;

import rui.coder.design.pattern.creater.builder.item.Item;
import rui.coder.design.pattern.creater.builder.pack.Bottle;
import rui.coder.design.pattern.creater.builder.pack.Packing;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}