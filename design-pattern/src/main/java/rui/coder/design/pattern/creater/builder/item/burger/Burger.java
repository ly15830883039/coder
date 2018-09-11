package rui.coder.design.pattern.creater.builder.item.burger;

import rui.coder.design.pattern.creater.builder.item.Item;
import rui.coder.design.pattern.creater.builder.pack.Packing;
import rui.coder.design.pattern.creater.builder.pack.Wrapper;

/**
 * 汉堡包，都是纸装
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}