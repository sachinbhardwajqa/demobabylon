import utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

import java.time.Duration;
import java.util.List;

public class BabylonDemoAutomation extends BaseClass {
    private Login loginPage;

    @Test(enabled = false)
    public void testLogin() {
        openURL("url");
        loginPage = new Login(driver);
        try {
            loginPage.setUsername(property.getProperty("username"));
            loginPage.setPassword(property.getProperty("password"));
            loginPage.clickSubmit();
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Leave']")).isDisplayed());
        } catch (Exception e) {
            Assert.fail("Login test failed: " + e.getMessage());
        }
    }

    @Test(enabled = false, priority = 2)
    public void assignLeave() {
        openURL("url");
        // Login to the application
        try {
            WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            username.sendKeys(property.getProperty("username"));
            password.sendKeys(property.getProperty("password"));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            boolean flag = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']")).isDisplayed();
            Assert.assertTrue(flag, "Able to successfully Login In App");
            Thread.sleep(5000); //Just to see before getting closed
        } catch (NoSuchElementException | InterruptedException noSuchElementException) {
            noSuchElementException.printStackTrace();
            Assert.fail("Unable to Login in App");
        }
        //Assign Leave
        try {
            driver.findElement(By.xpath("//span[normalize-space()='Leave']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Assign Leave']")).click();
            WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
            inputElement.clear();
            inputElement.sendKeys("a");
            Thread.sleep(2000);
            inputElement.sendKeys(Keys.ARROW_DOWN);
            inputElement.sendKeys(Keys.ARROW_DOWN);
            inputElement.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text']")).click();
            WebElement leaveType = driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]"));
            leaveType.click();
            Thread.sleep(2000);
            leaveType.sendKeys(Keys.ARROW_DOWN);
            leaveType.sendKeys(Keys.ARROW_DOWN);
            leaveType.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//label[normalize-space()='Leave Balance']/ancestor::div[2]/div[2]/p")).click();
            String todayDate = TestUtilities.getTodayDate("yyyy-MM-dd");
            List<WebElement> datePicker = driver.findElements(By.xpath("//input[@placeholder='yyyy-mm-dd']"));
            datePicker.get(0).sendKeys(todayDate);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text']")).click();
            String leaveBalance = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text']")).getText();
            float leaveBal = Float.parseFloat(leaveBalance.split(" ")[0]);
            System.out.println("Leave Balance is : " + leaveBal + " : " + leaveBalance.split(" ")[1]);
            if (leaveBal > 0) {
                System.out.println("Leave Balance is positive");
                driver.findElement(By.xpath("//button[@type='submit']")).click();
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(20))
                        .pollingEvery(Duration.ofSeconds(4))
                        .ignoring(NoSuchElementException.class);
                Boolean isToastDisplayed = wait.until(d -> d.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")).isDisplayed());
                Assert.assertTrue(isToastDisplayed, "Successfully assigned leave");

            } else {
                driver.findElement(By.xpath("//button[@type='submit']")).click();
                Thread.sleep(4000);
                boolean confirmPopUp = driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).isDisplayed();
                driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
                Assert.assertTrue(confirmPopUp, "Unable to assign Leave due to negative Balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to Assign Leave");
        }
    }

    @Test(enabled = false, priority = 1)
    public void addLeaveEntitlement() {
        openURL("url");
        // Login to the application
        try {
            WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            username.sendKeys(property.getProperty("username"));
            password.sendKeys(property.getProperty("password"));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            boolean flag = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']")).isDisplayed();
            Assert.assertTrue(flag, "Able to successfully Login In App");
            Thread.sleep(5000); //Just to see before getting closed
        } catch (NoSuchElementException | InterruptedException noSuchElementException) {
            noSuchElementException.printStackTrace();
            Assert.fail("Unable to Login in App");
        }

        // Add leave Entitlement
        try {
            driver.findElement(By.xpath("//span[normalize-space()='Leave']")).click();
            driver.findElement(By.xpath("//span[normalize-space()='Entitlements']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Add Entitlements']")).click();
            WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
            inputElement.clear();
            inputElement.sendKeys("a");
            Thread.sleep(2000);
            inputElement.sendKeys(Keys.ARROW_DOWN);
            inputElement.sendKeys(Keys.ARROW_DOWN);
            inputElement.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Bhanu  Prasad")));
//            List<WebElement> suggestions = driver.findElements(By.partialLinkText("Bhanu  Prasad"));
//            suggestions.get(0).click();
            driver.findElement(By.xpath("//label[normalize-space()='Entitlement']")).click();
            WebElement leaveType = driver.findElement(By.xpath("//div[contains(text(),'-- Select --')]"));
            leaveType.click();
            Thread.sleep(2000);
            leaveType.sendKeys(Keys.ARROW_DOWN);
            leaveType.sendKeys(Keys.ARROW_DOWN);
            leaveType.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
//            WebElement option = driver.findElement(By.xpath("//div[text()='CAN - FMLA']"));
//            option.click();
//            Select selectLeaveType = new Select(leaveType);
//            selectLeaveType.selectByVisibleText("CAN - FMLA");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//label[normalize-space()='Entitlement']")).click();
            WebElement entitlementText = driver.findElement(By.xpath("//label[normalize-space()='Entitlement']/ancestor::div[2]/descendant::input"));
            entitlementText.sendKeys("1");

            driver.findElement((By.xpath("//button[@type='submit']"))).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
            boolean flag = driver.findElement(By.xpath("//span[normalize-space()='(1) Record Found']")).isDisplayed();
            Assert.assertTrue(flag, "Able to successfully Add leave Entitlement");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Unable to add leave Entitlement");
        }
    }
}
