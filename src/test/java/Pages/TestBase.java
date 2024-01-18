package Pages;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {

    public static WebDriver driver;
    public static ExtentReports er;
    public static ExtentTest et;

    @BeforeTest
    public void getBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @BeforeTest
    public void setupExtentReport(ITestContext context) {
        er = new ExtentReports();
        // Attach ExtentSparkReporter to the ExtentReports object
        ExtentSparkReporter sparkreporter = new ExtentSparkReporter("reportpom.html");
        er.attachReporter(sparkreporter);
        // Set system information
        er.setSystemInfo("OS", System.getProperty("os.name"));
        er.setSystemInfo("JAVA", System.getProperty("java.version"));
    }

    @BeforeTest
    public void createExtentTest(ITestContext context) {
        et = er.createTest(context.getName());
    }

    @AfterSuite
    public void generateReports() throws IOException {
        er.flush();
        Desktop.getDesktop().browse(new File("reportpom.html").toURI());
    }

    @AfterMethod
    public void generateTestStatus(Method m, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            et.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            et.pass(m.getName() + " is passed");
        }
    }
}
