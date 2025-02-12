package nl.bramjanssens.di;

import jakarta.enterprise.context.Dependent;
import nl.bramjanssens.Inventory;
import nl.bramjanssens.Product;

@Dependent
public class MockInventory implements Inventory {
    @Override
    public boolean inStock(Product product) {
        return true;
    }
}
