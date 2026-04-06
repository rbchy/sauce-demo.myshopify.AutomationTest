package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import hooks.Hooks;
import java.time.Duration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {
	

    WebDriver driver = Hooks.getDriver();
	@Given("user is on the Home page")
	public void user_is_on_the_home_page() {
	    driver.get("https://sauce-demo.myshopify.com/");
	}

	@When("user navigates to the cart page")
	public void user_navigates_to_the_cart_page() throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement cartIcon = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='toggle-drawer cart desktop ']")));

         cartIcon.click();  
		Thread.sleep(2000);
	}

	@Then("the empty cart message should be visible")
	public void the_empty_cart_message_should_be_visible() {
	    WebElement emptyMsg = driver.findElement(By.xpath("//p[@class='empty' and contains(text(),'Your cart is empty')]"));
	    Assert.assertTrue(emptyMsg.isDisplayed());
	    
	}
	 @When("user opens a product")
	    public void user_opens_a_product() {
	        // Click the first product on the homepage
	        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"product-1\"]/img"));
	        firstProduct.click();
	    }
	 @Then("the product title, price, and Add to Cart button should be visible")
	    public void product_details_should_be_visible() {

	        WebElement title = driver.findElement(By.xpath("//*[@id=\"product-form\"]/h1"));
	        WebElement price = driver.findElement(By.xpath("//*[@id=\"product-price\"]/span"));
	        WebElement addBtn = driver.findElement(By.id("add"));
	       
            Assert.assertTrue(title.isDisplayed());
	        Assert.assertTrue(price.isDisplayed());
	        Assert.assertTrue(addBtn.isDisplayed());
}
	
	 @And("user adds the product to the cart")
	    public void user_adds_the_product_to_the_cart() throws InterruptedException {
	        WebElement addBtn = driver.findElement(By.id("add"));
	        addBtn.click();
	        Thread.sleep(3000);
	    }
  
	 @And("the cart should show 1 item")
	 public void the_cart_should_show_1_item() throws InterruptedException {
		
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
	     WebElement cartCount = wait.until(
	    	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart-target-desktop\"]")));
	     Assert.assertEquals(cartCount.getText().trim(), "(1)"); 
  }
	
}
	 
	 

