package nl.bramjanssens;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static nl.bramjanssens.DateChecker.isItFriday;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private String today;
    private String actualAnswer;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @Given("today is Friday")
    public void today_is_Friday() {
        today = "Friday";
    }

    @Given("today is {string}")
    public void todayIs(String arg0) {
        today = arg0;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
