package nl.bramjanssens.di;

import java.util.LinkedList;
import java.util.List;

public class ShoppingBasket<T> {

    private List<T> contents = new LinkedList<>();
    private Inventory inventory;

    public void addAll(List<T> products) {
        this.contents.addAll(products);
    }

    public List<T> getContents() {
        return contents;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
