package pages;

import org.openqa.selenium.By;

import core.DriverFactory;

public class AccordionPage {

	public void clickAccordion1() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Opção 1']")).click();
	}

	public String getTextAccordion1() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Esta é a descrição da opção 1']")).getText();
	}
}