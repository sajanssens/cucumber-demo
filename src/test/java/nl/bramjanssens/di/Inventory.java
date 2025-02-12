package nl.bramjanssens.di;

import nl.bramjanssens.tabledemos.Stepdefs;

public interface Inventory {
    boolean inStock(Stepdefs.Product product);
}
