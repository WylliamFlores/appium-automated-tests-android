package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTest;
import core.DriverFactory;
import pages.AlertPage;
import pages.MenuPage;

public class AlertTests extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private AlertPage alertPage = new AlertPage();

	@Test
	public void interactAlertConfirm() {
		menuPage.menuAlertas();
		alertPage.clickAlertConfirm();
		Assert.assertEquals("Confirma a operação?", alertPage.getTextConfirm());
		alertPage.clickConfirm();
		Assert.assertEquals("Confirmado", alertPage.getTextConfirm());
		alertPage.clickExit();
	}

	@Test
	public void interactAlertSimple() {
		menuPage.menuAlertas();
		alertPage.clickAlertSimple();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Pode clicar no OK ou fora da caixa para sair']")));
		alertPage.clickOutBox(550, 450);
		Assert.assertFalse(alertPage.existElementByText("Pode clicar no OK ou fora da caixa para sair"));
	}
}