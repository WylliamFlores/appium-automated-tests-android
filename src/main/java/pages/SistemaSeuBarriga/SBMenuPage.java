package pages.SistemaSeuBarriga;

import org.openqa.selenium.By;

import core.DriverFactory;

public class SBMenuPage {

	public void clicReset() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='RESET']")).click();
	}

	public void clickAccount() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='CONTAS']")).click();
	}

	public void clickMovement() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='MOV...']")).click();
	}
}