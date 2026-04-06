package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class InventoryPage {

    WebDriver driver;
    WaitUtils wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    By menuBtn = By.id("react-burger-menu-btn");
    By logoutBtn = By.id("logout_sidebar_link");
    By inventoryContainer = By.id("inventory_container");

    public boolean isInventoryDisplayed() {
        return wait.waitForVisibility(inventoryContainer).isDisplayed();
    }

    public void logout() {
        wait.waitForClickable(menuBtn).click();   // ✅ open menu
        wait.waitForClickable(logoutBtn).click(); // ✅ now clickable
    }
}