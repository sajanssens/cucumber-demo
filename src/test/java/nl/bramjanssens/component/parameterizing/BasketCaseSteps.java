package nl.bramjanssens.component.parameterizing;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.bramjanssens.BasketCase;
import org.assertj.core.api.WithAssertions;

public class BasketCaseSteps implements WithAssertions {

    private BasketCase basketCase;

    @Given("I have a new empty basket")
    public void iHaveANewEmptyBasket() {
        this.basketCase = new BasketCase();
    }

    @When("I add a {string} to my basket")
    public void iAddATvToMyBasket(String name) {
        this.basketCase.add(name);
    }

    @And("I remove the {string} from my basket")
    public void iRemoveItFromMyBasket(String name) {
        this.basketCase.delete(name);
    }

    @Then("The basket is empty")
    public void theBasketIsEmpty() {
        assertThat(basketCase.size()).isEqualTo(0);
    }

    @Then("The basket contains {int} item(s)")
    public void theBasketContainsItem(int count) {
        assertThat(basketCase.size()).isEqualTo(count);
    }
}
