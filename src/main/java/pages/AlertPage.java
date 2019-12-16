package pages;

import java.util.List;

import org.openqa.selenium.By;

import core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class AlertPage {

	public void clickAlertConfirm() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='ALERTA CONFIRM']")).click();
	}

	public String getTextConfirm() {
		return DriverFactory.getDriver().findElement(By.id("android:id/message")).getText();
	}

	public void clickConfirm() {
		DriverFactory.getDriver().findElement(By.id("android:id/button2")).click();
	}

	public void clickExit() {
		DriverFactory.getDriver().findElement(By.id("android:id/button1")).click();
	}

	public void clickAlertSimple() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='ALERTA SIMPLES']")).click();
	}

	public void tap(int x, int y) {
		new TouchAction(DriverFactory.getDriver()).tap(x, y).perform();
	}

	public void clickOutBox(int x, int y) {
		tap(x, y);
	}

	public boolean existElementByText(String texto) {
		List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}
}