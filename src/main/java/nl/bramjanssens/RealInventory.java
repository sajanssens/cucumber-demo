package nl.bramjanssens;

import jakarta.enterprise.context.Dependent;

@Dependent
public class RealInventory implements Inventory {
    @Override
    public boolean inStock(Product product) {
        return false;
    }
}
