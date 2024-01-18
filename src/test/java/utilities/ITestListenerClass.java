package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Pages.TestBase;

public class ITestListenerClass extends TestBase implements ITestListener  {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		//File srcFile = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+sdf.format(d)+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("TestNG started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("TestNG finished");
	}

}
	

