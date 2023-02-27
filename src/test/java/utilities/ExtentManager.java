package utilities;

import java.util.Date;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    private static String filePath = Paths.EXTENTREPORT_PATH + "extentReport.html";

    public static ExtentReports getExtent() {
        Date d = new Date();
        if (extent != null) {
            return extent;
        } else {
            extent = new ExtentReports();
            extent.attachReporter(getHtmlReporter());
            extent.setSystemInfo("Owner", "Sachin Bhardwaj (sachinb1750@gmail.com)");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Platform", "Web");
            extent.setSystemInfo("Run_Date", d.toString());

            extent.setAnalysisStrategy(AnalysisStrategy.TEST);
            return extent;
        }
    }


    public static ExtentHtmlReporter getHtmlReporter() {
        System.out.println(filePath);
        htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Sachin - Demo Project");
        htmlReporter.config().setReportName("Automation Execution Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.setAppendExisting(false);
        return htmlReporter;
    }

}