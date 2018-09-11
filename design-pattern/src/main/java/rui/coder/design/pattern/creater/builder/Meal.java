package rui.coder.design.pattern.creater.builder;

import rui.coder.design.pattern.creater.builder.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 点餐
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item: " + item.name());
            System.out.print(",Packing: " + item.packing().pack());
            System.out.println(",Price: " + item.price());
        }
    }
}