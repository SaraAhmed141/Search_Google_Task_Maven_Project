package Stepsdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
//import io.cucumber.java.en.*;

public class Steps {

    WebDriver driver;

    @Given("I am on the Google homepage")
    public void iAmOnGoogleHomepage() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @When("I enter {string} into the search bar")
    public void iEnterSearchText(String searchText){
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys(searchText);
    }

    @And("I click the search button")
    public void iClickSearchButton() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement searchButton = driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)"));
        searchButton.click();

    }

    @Then("I should see search results containing {string}")
    public void iSeeSearchResults(String expectedResult) {
        WebElement resultStats = driver.findElement(By.className("MjjYud"));
        String resultText = resultStats.getText();
        assert(resultText.contains(expectedResult));
        System.out.println(resultText.contains(expectedResult));

        driver.quit();
    }
}
