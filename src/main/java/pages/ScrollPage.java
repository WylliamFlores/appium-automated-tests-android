package pages;

import org.openqa.selenium.By;

import core.DriverFactory;

public class ScrollPage {

	public String getTextAlertOpcaoEscondida() {
		return DriverFactory.getDriver().findElement(By.id("android:id/message")).getText();
	}
	
	public void clickAlertOk() {
		DriverFactory.getDriver().findElement(By.id("android:id/button1")).click();
	}
}