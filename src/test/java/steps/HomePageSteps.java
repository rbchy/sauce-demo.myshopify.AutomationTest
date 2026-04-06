package steps;

import hooks.Hooks;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
    WebDriver driver = Hooks.getDriver();
    // ====== DECLARED LOCATORS ======
    By homePageUrl = By.xpath("https://sauce-demo.myshopify.com/");
    By leftNavPanel = By.xpath("//*[@id='sidebar']/nav");
    By featuredProductsSection = By.xpath("//section[contains(@class,'product-grid')]");
    By productCards = By.xpath("//section[contains(@class,'product-grid')]//div[contains(@class,'four')]");
    By cartLink = By.xpath("//a[contains(text(),'My Cart')]");
    By checkoutLink = By.xpath("//a[contains(text(),'Check Out')]");
    By footer = By.xpath("//footer");
    
  
    @Given("user navigates to the homepage")
    public void user_is_on_the_homepage() {
        driver.get("https://sauce-demo.myshopify.com/");
    }

    @Then("left navigation panel should be visible")
    public void left_navigation_panel_should_be_visible() {
        Assert.assertTrue(driver.findElement(leftNavPanel).isDisplayed());
    }

    @And("featured products section should be visible")
    public void featured_products_section_should_be_visible() {
        Assert.assertTrue(driver.findElement(featuredProductsSection).isDisplayed());
    }

    @And("each product card should be visible")
    public void each_product_card_should_be_visible() {
        List<WebElement> cards = driver.findElements(productCards);
        Assert.assertTrue(cards.size() > 0);
        for (WebElement card : cards) {
            Assert.assertTrue(card.isDisplayed());
        }
    }
    
    @And("product images should be visible")
    public void product_images_should_be_visible() {
        List<WebElement> images = driver.findElements(By.xpath("//section[contains(@class,'product-grid')]//img"));
        
       // Ensure at least one image exists
        Assert.assertTrue(images.size() > 0, "No product images found on homepage");

        // Verify each image is displayed
        for (WebElement img : images) {
            Assert.assertTrue(img.isDisplayed(), "A product image is not visible");
        }
    }
 
    @And("cart link should be visible")
    public void cart_link_should_be_visible() {
        Assert.assertTrue(driver.findElement(cartLink).isDisplayed());
    }

    @And("checkout link should be visible")
    public void checkout_link_should_be_visible() {
        Assert.assertTrue(driver.findElement(checkoutLink).isDisplayed());
    }

    @And("footer should be visible")
    public void footer_should_be_visible() {
        Assert.assertTrue(driver.findElement(footer).isDisplayed());
    }
}