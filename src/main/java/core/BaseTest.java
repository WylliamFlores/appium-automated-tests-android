package core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();

	@AfterClass
	public static void end() {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
		ScreenShot();
		DriverFactory.getDriver().resetApp();
	}

	public void ScreenShot() {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File archive = ss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(archive, new File(
					"target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}