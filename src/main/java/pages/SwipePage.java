package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import core.DriverFactory;
import io.appium.java_client.TouchAction;

public class SwipePage {
	
	public void swipe(double start, double end) {
		Dimension size = DriverFactory.getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * start);
		int end_x = (int) (size.width * end);
		
		new TouchAction(DriverFactory.getDriver())
		.press(start_x, y)
		.waitAction(Duration.ofMillis(500))
		.moveTo(end_x, y)
		.release()
		.perform();
	}
	
	public void clickRight() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='›']")).click();
	}
	
	public String getText3Swipe() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Chegar até o fim!']")).getText();
	}
	
	public String getText2Swipe() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='você consegue']")).getText();
	}
	
	public String getText1Swipe() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='a esquerda']")).getText();
	}
}