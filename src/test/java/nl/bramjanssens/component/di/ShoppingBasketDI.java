package nl.bramjanssens.component.di;

// import jakarta.enterprise.context.Dependent;
// import jakarta.inject.Inject;

import nl.bramjanssens.Inventory;
import nl.bramjanssens.Product;

import java.util.LinkedList;
import java.util.List;

// @Dependent
public class ShoppingBasketDI {

    private List<Product> contents = new LinkedList<>();

    // @Inject
    private Inventory inventory;

    public void add(Product product) {
        if (inventory.inStock(product)) {
            contents.add(product);
        }
    }

    public void addAll(List<Product> products) {
        products.forEach(this::add);
    }

    public List<Product> getContents() {
        return contents;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
