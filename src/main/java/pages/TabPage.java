package pages;

import org.openqa.selenium.By;

import core.DriverFactory;

public class TabPage {

	public String getTextTab1() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Este é o conteúdo da Aba 1']")).getText();
	}

	public void clickTab2() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='ABA 2']")).click();
	}

	public String getTextTab2() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Este é o conteúdo da Aba 2']")).getText();
	}
}