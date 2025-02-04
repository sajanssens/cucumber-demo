package nl.bramjanssens.di;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import nl.bramjanssens.tabledemos.Stepdefs;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShoppingBasketDISteps {

    private final ShoppingBasket<Stepdefs.Product> basket;

    public ShoppingBasketDISteps(ShoppingBasket<Stepdefs.Product> sb) {
        this.basket = sb;
    }

    @Given("I have an empty di basket")
    public void iHaveAnEmptyDiBasket() {
        assertNotNull(this.basket);
    }

    @When("I add these products:")
    public void iAddTheseProducts(List<Stepdefs.Product> products) {
        this.basket.addAll(products);
    }
}
