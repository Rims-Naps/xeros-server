package io.Odyssey.model;

import io.Odyssey.model.definitions.ItemDef;
import io.Odyssey.model.items.GameItem;
import io.Odyssey.model.items.ItemInterface;
import io.Odyssey.util.Misc;

public class SlottedItem implements ItemInterface {

    private final int id;
    private final int amount;
    private final int slot;

    public SlottedItem(int id, int amount, int slot) {
        this.id = id;
        this.amount = amount;
        this.slot = slot;
    }

    public GameItem toGameItem() {
        return new GameItem(id, amount);
    }

    @Override
    public String toString() {
        ItemDef definition = ItemDef.forId(id);
        String name = definition == null ? "null" : definition.getName();
        return "SlottedItem{" +
                "name=" + name +
                ", id=" + id +
                ", amount=" + Misc.insertCommas(String.valueOf(amount)) +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    public int getSlot() {
        return slot;
    }
}
