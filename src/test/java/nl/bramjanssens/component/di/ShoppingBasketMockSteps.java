package nl.bramjanssens.component.di;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import nl.bramjanssens.Inventory;
import nl.bramjanssens.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingBasketMockSteps {

    private final ShoppingBasket basket;
    private final Inventory inventoryMock = mock(Inventory.class);

    public ShoppingBasketMockSteps(ShoppingBasket sb) {
        this.basket = sb;
        this.basket.setInventory(inventoryMock);
        when(inventoryMock.inStock(any())).thenReturn(true);
    }

    @Given("I have an empty mocked basket")
    public void iHaveAnEmptyDiBasket() {
        assertNotNull(this.basket);
    }

    @When("I add these products:")
    public void iAddTheseProducts(List<Product> products) {
        this.basket.addAll(products);
    }

    @And("the products are in stock")
    public void theProductsAreInStock() {
        boolean allInStock = this.basket.getContents().stream().allMatch(this.inventoryMock::inStock);
        assertTrue(allInStock);
    }
}
