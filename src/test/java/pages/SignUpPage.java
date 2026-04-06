package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SignUpPage {

    WebDriver driver;
    WaitUtils wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By email = By.id("email");
    By password = By.id("password");
    By createBtn = By.id("create");

    public void enterDetails() {
        wait.waitForVisibility(firstName).sendKeys("Test");
        wait.waitForVisibility(lastName).sendKeys("User");
        wait.waitForVisibility(email).sendKeys("test@test.com");
        wait.waitForVisibility(password).sendKeys("Test123");
    }

    public void clickCreate() {
        wait.waitForClickable(createBtn).click();
    }
}