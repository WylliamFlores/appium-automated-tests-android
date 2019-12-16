package pages;

import org.openqa.selenium.By;

import core.DriverFactory;

public class AccordionPage {

	public void clickAccordion1() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Op��o 1']")).click();
	}

	public String getTextAccordion1() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Esta � a descri��o da op��o 1']")).getText();
	}
}