package Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver dvr) {
		driver.set(dvr);
	}

	public static WebDriver getDriverInstance(String browser, int timePageLoad, int timeImplicitWait) {

		if (driver.get() == null) {
			if (browser.equalsIgnoreCase("CHROME")) {
				System.setProperty("webdriver.chrome.driver", Paths.WEB_DRIVER_CHROMEDRIVER);
				setDriver(new ChromeDriver());
			}
			else {
				System.out.println("Please Select a valid browser");
			}
		}
		setDriver(driver.get());
		setPageLoadTimeOut(timePageLoad);
		setImplicitWait(timeImplicitWait);
		return getDriver();
	}

	private static void setPageLoadTimeOut(int timePageLoad) {
		// TODO Auto-generated method stub

	}

	public static void killDriverInstance() {
		if (driver.get() != null) {
			driver.get().close();
			driver.get().quit();
			driver.set(null);
		}
	}

	public static void setImplicitWait(int time) {
		driver.get().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void setPageLoadTimeout(int time) {
		driver.get().manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
}