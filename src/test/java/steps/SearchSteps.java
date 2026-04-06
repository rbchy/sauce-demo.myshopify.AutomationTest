package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.Hooks;

import java.time.Duration;

public class SearchSteps {

    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By searchBar = By.id("search-field");
    By searchButton = By.id("search-submit");
    By productCards = By.xpath("//section[@class='product-grid']//div[contains(@class,'four')]");
    By noResultsMessage = By.xpath("//*[@id=\"keyword\"]");
    By productTitle = By.xpath("//*[@id=\"product-form\"]/h1");
    By addToCartButton = By.xpath("//button[contains(@class,'product-form__submit')]");

    
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        driver.get("https://sauce-demo.myshopify.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
    }

    @Then("the search bar should be visible")
    public void the_search_bar_should_be_visible() {
        Assert.assertTrue(driver.findElement(searchBar).isDisplayed());
    }

    @When("I type into the search bar")
    public void i_type_into_the_search_bar() {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys("test");
    }

    @Then("the search input should contain the typed value")
    public void the_search_input_should_contain_the_typed_value() {
        String value = driver.findElement(searchBar).getAttribute("value");
        Assert.assertEquals(value, "test");
    }

    // -------------------------
    // VALID SEARCH (PARAMETER)
    // -------------------------

    @When("I search for {string}")
    public void i_search_for(String keyword) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));
        Assert.assertTrue(driver.findElements(productCards).size() > 0);
    }

    @And("at least one product should be visible")
    public void at_least_one_product_should_be_visible() {
        Assert.assertTrue(driver.findElements(productCards).size() > 0);
    }

    // -------------------------
    // INVALID SEARCH
    // -------------------------

    @Then("a no results message should be displayed")
    public void a_no_results_message_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
        Assert.assertTrue(driver.findElement(noResultsMessage).isDisplayed());
    }

    @And("no products should be visible")
    public void no_products_should_be_visible() {
        Assert.assertEquals(driver.findElements(productCards).size(), 0);
    }

    // -------------------------
    // CLICK FIRST PRODUCT
    // -------------------------

    @And("I click the first product in search results")
    public void i_click_the_first_product_in_search_results() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));
        driver.findElements(productCards).get(0).click();
        Thread.sleep(2000);    }

    @Then("the product details page should be displayed")
    public void the_product_details_page_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        Assert.assertTrue(driver.findElement(productTitle).isDisplayed());
    }

 }