package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.DriverFactory;
import io.appium.java_client.TouchAction;

public class ClickPage {

	public void clickLong() {
		new TouchAction(DriverFactory.getDriver())
				.longPress(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
	}

	public void clickDouble() {
		WebElement element = DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique duplo']"));
		TouchAction action = new TouchAction(DriverFactory.getDriver());
		action.press(element).waitAction(Duration.ofMillis(50)).release().press(element)
				.waitAction(Duration.ofMillis(50)).release().perform();
	}

	public String getTextLongClick() {
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}

	public String getTextDoubleClick() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Duplo Clique']")).getText();
	}
}