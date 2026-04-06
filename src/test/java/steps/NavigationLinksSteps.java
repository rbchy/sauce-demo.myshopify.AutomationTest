package steps;

import hooks.Hooks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NavigationLinksSteps {

    WebDriver driver = Hooks.getDriver();
    // =======================
    // DECLARED LOCATORS
    // =======================

    // Left navigation links
    By catalogLink = By.xpath("//nav//a[contains(text(),'Catalog')]");
    By blogLink = By.xpath("//nav//a[contains(text(),'Blog')]");
    By leftAboutUsLink = By.xpath("//nav//a[contains(text(),'About Us')]");
    By cartLink = By.xpath("//a[contains(text(),'My Cart')]");

    // Footer links
    By footerSearchLink = By.xpath("//footer//a[contains(text(),'Search')]");
    By footerAboutUsLink = By.xpath("//footer//a[contains(text(),'About Us')]");

    // Destination page identifiers
    By collectionPageHeader = By.xpath("//h1[contains(text(),'Catalog') or contains(text(),'Products')]");
   
    By aboutPageHeader = By.xpath("//h1[contains(text(),'About')]");
    By emptyCartMessage = By.xpath("//p[@class='empty' and contains(text(),'Your cart is empty')]");
    By searchPageHeader = By.xpath("//h1[contains(text(),'Search')]");

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        driver.get("https://sauce-demo.myshopify.com/");
    }

    // ---- Catalog ----
    @When("user clicks the Catalog link")
    public void user_clicks_the_catalog_link() {
        driver.findElement(catalogLink).click();
    }

    @Then("collection page should load")
    public void collection_page_should_load() {
        Assert.assertTrue(driver.findElement(collectionPageHeader).isDisplayed());
    }

    // ---- Blog ----
    @When("user clicks the Blog link")
    public void user_clicks_the_blog_link() {
        driver.findElement(blogLink).click();
    }

    @Then("blog page should load")
    public void blog_page_should_load() {
    Assert.assertTrue(driver.getCurrentUrl().contains("/blogs/news"));
    	Assert.assertTrue(driver.findElements(By.xpath("//h2/a")).size() > 0,
    		    "No blog posts found on the Blog page"
    		); 

    }

    // ---- Left Navigation About Us ----
    @When("user clicks the left navigation About Us link")
    public void user_clicks_the_left_navigation_about_us_link() {
        driver.findElement(leftAboutUsLink).click();
    }

    @Then("about page should load")
    public void about_page_should_load() {
        Assert.assertTrue(driver.findElement(aboutPageHeader).isDisplayed());
    }

    // ---- Cart ----
    @When("user clicks the cart link")
    public void user_clicks_the_checkout_link() {
    	 driver.findElement(cartLink).click();
    }

    @Then("cart page should load")
    public void checkout_page_should_load() {
    	Assert.assertTrue(driver.findElement(emptyCartMessage).isDisplayed());
    }

    // ---- Footer Search ----
    @When("user clicks the footer Search link")
    public void user_clicks_the_footer_search_link() {
        driver.findElement(footerSearchLink).click();
    }

    @Then("search page should load")
    public void search_page_should_load() {
        Assert.assertTrue(driver.findElement(searchPageHeader).isDisplayed());
    }

    // ---- Footer About Us ----
    @When("user clicks the footer About Us link")
    public void user_clicks_the_footer_about_us_link() {
        driver.findElement(footerAboutUsLink).click();
    }
}