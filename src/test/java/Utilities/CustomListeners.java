package Utilities;

import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners extends BaseClass implements ITestListener {

    public void onTestStart(ITestResult result) {
        testLevelReport.get().log(Status.INFO, result.getMethod().getMethodName().toUpperCase() + " Execution Started");
    }


    public void onTestSuccess(ITestResult result) {
        testLevelReport.get().log(Status.INFO, result.getMethod().getMethodName().toUpperCase() + " Execution Ended");
        testLevelReport.get().log(Status.PASS, "PASSED");

        Reporter.log(getTestRunId().toUpperCase() + " : Passed");
    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        Reporter.log(getTestRunId().toUpperCase() + " : Failed");
        TestUtilities.captureScreenshot(result.getName());
        String exceptionMessage = result.getThrowable().getClass().toString();

        testLevelReport.get()
                .debug(exceptionMessage);
        testLevelReport.get().log(Status.INFO, result.getMethod().getMethodName().toUpperCase() + " Execution Ended");
        testLevelReport.get().log(Status.FAIL, "FAILED");

    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

        testLevelReport.get().debug(result.getMethod().getMethodName().toUpperCase() + " isSkipped");
        testLevelReport.get().log(Status.SKIP, "SKIPPED");

    }

}