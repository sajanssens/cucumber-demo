package nl.bramjanssens.e2ebrowserautomation;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseHomepageSteps {
    private WebDriver driver = new ChromeDriver();

    @BeforeAll
    void setup() {
        // Pages use several methods to detect bots, such as checking for automation flags.
        // You can modify your ChromeOptions to avoid these detections:
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");  // Makes Selenium less detectable
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Removes 'Chrome is being controlled' banner
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        driver.get("https://quiz.bramjanssens.nl");
    }

    @When("I inspect the home page")
    public void iInspectTheHomePage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        } catch (TimeoutException e) {
            System.out.println("Header h1 did not appear.");
        }
    }

    @Then("the header should start with {string}")
    public void theHeaderShouldStartWith(String arg0) {
        assertTrue(driver.findElement(By.cssSelector("h1")).getText().startsWith(arg0));
    }
}
