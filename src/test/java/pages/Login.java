package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    private By usernameInput = By.xpath("//input[@placeholder='Username']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By submitButton = By.xpath("//button[@type='submit']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
