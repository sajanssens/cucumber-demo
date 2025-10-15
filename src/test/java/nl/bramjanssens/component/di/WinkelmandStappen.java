package nl.bramjanssens.component.di;

import io.cucumber.java.nl.Als;
import io.cucumber.java.nl.Dan;
import io.cucumber.java.nl.En;
import io.cucumber.java.nl.Gegeven;
import nl.bramjanssens.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WinkelmandStappen {

    // Uses Weld, see: https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-jakarta-cdi

    // @Inject
    private ShoppingBasketDI basket;

    @Gegeven("Ik heb een lege mand.")
    public void ikHebEenLegeDIMand() {
        assertNotNull(this.basket);
    }

    @Als("ik deze producten toevoeg aan mijn mand:")
    public void ikDezeProductenToevoegAanMijnMand(List<Product> products) {
        this.basket.addAll(products);
    }

    @En("de producten zijn op voorraad")
    public void deProductenZijnOpVoorraad() {
    }

    @Dan("zouden er {int} producten in mijn mandje moeten zitten")
    public void zoudenErProductenInMijnMandjeMoetenZitten(int arg0) {
    }
}
