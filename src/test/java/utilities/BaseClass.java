package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Properties;


public class BaseClass {
    public static WebDriver driver;

    public static Properties property;
    private static String className;
    private static String testName;
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> classLevelReport = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testLevelReport = new ThreadLocal<ExtentTest>();
    private static String testRunId;

    @BeforeSuite
    public void setUpResources() {
        // Load Config Files
        property = TestUtilities.loadConfigProperties();
        //Instantiate Extent Reports for reporting the execution status
        extent = ExtentManager.getExtent();

    }

    @BeforeClass
    public void startClass() {
        //Creates a test Node at class level in the extent report
        ExtentTest parent = extent.createTest(getClass().getSimpleName());
        parent.assignCategory("Epic_Level_Report");
        classLevelReport.set(parent);

        //Creates a test Node at class level in the extent report
        className = this.getClass().getSimpleName().toString();

    }

    @BeforeMethod
    public void startMethod(Method m) {
        testName = m.getName();
        testRunId = m.getName();
        //Creates a test Node at class level in the extent report
        ExtentTest test = classLevelReport.get().createNode(m.getName().toUpperCase());
        test.assignCategory("Test_Level_Report");
        testLevelReport.set(test);
        //Invokes browser
        driver = DriverManager.getDriverInstance(property.getProperty("browser"), 30, 10);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void killMethod(Method m, ITestResult result) {
        extent.flush();
        DriverManager.killDriverInstance();
    }


    @AfterClass
    public void killClass() {
    }

    @AfterSuite
    public void killResources() {
        TestUtilities.archiveExtentReports();
    }

    public static String getTestRunId() {
        return testRunId;
    }

    public static String getClassName() {
        return className;
    }

    public static void loadPageWithRetry(String url) {
        int retryCount = 0;
        boolean pageLoaded = false;
        while (!pageLoaded && retryCount < 8) {
            try {
                driver.get(url);
                pageLoaded = true;
            } catch (Exception e) {
                retryCount++;
                try {
                    Thread.sleep(15000); // wait for 15 seconds
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (!pageLoaded) {
            System.out.println("Page could not be loaded after 8 attempts. Exiting the test.");
            if (driver != null) {
                driver.close();
                driver.quit();
            }
            System.exit(0);
        }
    }

    public static void openURL(String configProperty){
        loadPageWithRetry(property.getProperty(configProperty));
    }
}