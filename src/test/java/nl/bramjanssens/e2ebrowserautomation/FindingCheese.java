package nl.bramjanssens.e2ebrowserautomation;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static java.lang.String.valueOf;
import static java.time.Duration.ofMillis;

public class FindingCheese {

    private WebDriver driver = new ChromeDriver();

    @BeforeAll
    void setup() {
        // Google uses several methods to detect bots, such as checking for automation flags.
        // You can modify your ChromeOptions to avoid these detections:
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");  // Makes Selenium less detectable
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Removes 'Chrome is being controlled' banner
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
    }

    @Given("I am on the Google search page")
    public void I_visit_google() {
        driver.get("https://www.google.com");

        // Since we're opening an incognito page
        // wait and check if the accept button is present and click it
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb")));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("No consent popup appeared.");
        }
    }

    @When("I search for {string}")
    public void search_for(String query) {
        Random random = new Random();
        Actions actions = new Actions(driver);

        // Ensure the field is focused
        actions.moveToElement(driver.findElement(By.name("q"))).click().perform();

        // type the characters with a random delay between them
        query.chars().boxed()
                .forEach(c -> actions.sendKeys(valueOf(c))
                        .pause(ofMillis(200 + random.nextInt(300))));

        // Press Enter after typing
        actions.sendKeys(Keys.ENTER).pause(ofMillis(random.nextInt(1000))).perform();
    }

    @Then("the page title should start with {string}")
    public void checkTitle(String title) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver, Duration.ofSeconds(10L))
                .until(d -> d.getTitle().toLowerCase().startsWith(title));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}