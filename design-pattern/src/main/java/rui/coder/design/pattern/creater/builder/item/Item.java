package rui.coder.design.pattern.creater.builder.item;

import rui.coder.design.pattern.creater.builder.pack.Packing;

/**
 * 餐厅 食品的共有方法
 */
public interface Item {

    String name();

    Packing packing();

    float price();
}
