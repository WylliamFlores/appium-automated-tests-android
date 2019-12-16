package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriverFactory;

public class SplashPage {

	public String mesasgeSplash() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text = 'Splash!']")).getText();
	}

	public void waitSplashExit(){
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text = 'Splash!']")));
	}
}