package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import utils.DriverManager;

import java.time.Duration;

public class SignUpStep {
	WebDriver driver = Hooks.getDriver();
    //WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user is on the signup page")
    public void openSignUpPage() {
        driver.get("https://www.saucedemo.com/"); // Replace with actual signup URL
    }

    @When("the user enters signup information")
    public void enterSignUpInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys("Ranajit");
        driver.findElement(By.id("last-name")).sendKeys("Chy");
        driver.findElement(By.id("email")).sendKeys("rbc@example.com");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("signup-button")).click();
    }

    @Then("the user should be registered successfully")
    public void verifySignUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome-message")));
    }
}