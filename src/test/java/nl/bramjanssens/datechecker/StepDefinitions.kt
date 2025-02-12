package nl.bramjanssens.datechecker

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import nl.bramjanssens.datechecker.DateChecker.isItFriday
import org.junit.jupiter.api.Assertions

class StepDefinitions {
    private var today: String? = null
    private var actualAnswer: String? = null

    @Given("today is Sunday")
    fun today_is_Sunday() {
        today = "Sunday"
    }

    @Given("today is Friday")
    fun today_is_Friday() {
        today = "Friday"
    }

    @Given("today is {string}")
    fun todayIs(arg0: String?) {
        today = arg0
    }

    @When("I ask whether it's Friday yet") fun i_ask_whether_it_s_Friday_yet() {
        actualAnswer = isItFriday(today!!)
    }

    @Then("I should be told {string}") fun i_should_be_told(expectedAnswer: String?) {
        Assertions.assertEquals(expectedAnswer, actualAnswer)
    }
}
