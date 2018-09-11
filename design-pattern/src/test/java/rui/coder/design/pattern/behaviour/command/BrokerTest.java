package rui.coder.design.pattern.behaviour.command;

import org.junit.jupiter.api.Test;

class BrokerTest {

    @Test
    void placeOrders() {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}