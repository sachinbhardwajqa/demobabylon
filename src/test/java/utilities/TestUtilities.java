package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtilities {
	
	public static void archiveExtentReports() {
		Date d = new Date();
		String reportName = "ExtenReport_" + d.toString().replaceAll("[ :]", "_") + ".html";
		String absoluteExtentReportPath = Paths.EXTENTREPORT_PATH + "extentReport.html";
		
		try {
			File scrFile = new File(absoluteExtentReportPath);
			FileUtils.copyFile(scrFile, new File(Paths.ARCHIVED_EXTENTREPORT_PATH + reportName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void captureScreenshot(String testName) {

		
			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			Date d = new Date();
			String screenshotName = testName + "_" + d.toString().replaceAll("[ :]", "_") + ".png";
			String absoluteScreenshotPath = Paths.SCREENSHOT_PATH + "failed_screen.png";

			try {
				FileUtils.copyFile(scrFile, new File(absoluteScreenshotPath));
				FileUtils.copyFile(scrFile, new File(Paths.ARCHIVED_EXTENTREPORT_PATH + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

	public static Properties loadConfigProperties() {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					new File(Paths.CONFIGURATION_PROPERTIES));
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static String getTodayDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}

}