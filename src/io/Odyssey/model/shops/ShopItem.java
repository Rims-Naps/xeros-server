package io.Odyssey.model.shops;

import io.Odyssey.model.items.GameItem;

public class ShopItem extends GameItem {

    private int price;

    public ShopItem(int id, int amount, int price) {
        super(id, amount);
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
