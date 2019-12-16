package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.ScrollPage;

public class ScrollTests extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ScrollPage scrollPage = new ScrollPage();

	@Test
	public void interactScroll() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='About...']")));
		// scroll down
		menuPage.scroll(0.9, 0.1);

		// click menu
		menuPage.menuOpcaoEscondida();

		// verificar mensagem
		Assert.assertEquals("Você achou essa opção", scrollPage.getTextAlertOpcaoEscondida());

		// sair
		scrollPage.clickAlertOk();
	}
}