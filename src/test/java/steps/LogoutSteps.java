package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LogoutSteps {

    WebDriver driver = Hooks.getDriver();

    @And("the user clicks the Logout link")
    public void clickLogout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Step 1: Click the menu button
            WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
            menuBtn.click();

            // Step 2: Wait for logout button to be present in DOM
            WebElement logout = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));

            // Step 3: Scroll logout button into view (sometimes hidden)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logout);

            // Step 4: Click logout using JS executor to bypass animation delay
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);

            System.out.println("✅ Logout clicked successfully");

        } catch (TimeoutException e) {
            System.out.println("❌ Logout button not found or sidebar not opened: " + e.getMessage());
            throw e;
        }
    }

    @Then("the user should be redirected to the login page")
    public void verifyLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for login button visibility to ensure redirected
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        System.out.println("✅ User redirected to login page successfully");
    }
}