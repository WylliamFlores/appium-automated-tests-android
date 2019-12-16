package tests.SistemaSeuBarriga;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTest;
import core.DriverFactory;
import pages.MenuPage;
import pages.SistemaSeuBarriga.LoginPage;
import pages.SistemaSeuBarriga.MovementPage;
import pages.SistemaSeuBarriga.SBMenuPage;

public class MovementTest extends BaseTest {

	SBMenuPage sbMenuPage = new SBMenuPage();
	MenuPage menuPage = new MenuPage();
	LoginPage loginPage = new LoginPage();
	MovementPage movementPage = new MovementPage();

	@Before
	public void setup() {
		menuPage.menuSeuBarrigaNativo();
		loginPage.setName("wyll@wyll.com");
		loginPage.setPassword("012345");
		loginPage.clickEntrar();
		sbMenuPage.clicReset();
		sbMenuPage.clickMovement();
	}

	@Test
	public void createMovement() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Receita']")));
		movementPage.selectComboBoxType();
		movementPage.selectValueMoviment("Despesa");
		movementPage.clickSwitchActive();
		movementPage.setDescription("Pagamento Fatura");
		movementPage.setInterested("Vivo");
		movementPage.setValue("33,66");
		movementPage.selectComboBoxAccount();
		movementPage.selectAccountMoviment("Conta para extrato");
		movementPage.clickSave();
		Assert.assertEquals("Movimenta��o cadastrada com sucesso", movementPage.getMessageSuccess());
	}

	@Test
	public void movementRequiredFields() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Receita']")));
		movementPage.clickSave();
		Assert.assertTrue(movementPage.containsMessage("Descri��o � um campo obrigat�rio"));
		movementPage.setDescription("Pagamento Luz");
		movementPage.clickSave();
		Assert.assertTrue(movementPage.containsMessage("Interessado � um campo obrigat�rio"));
		movementPage.setInterested("ceee");
		movementPage.clickSave();
		Assert.assertTrue(movementPage.containsMessage("Valor � um campo obrigat�rio"));
		movementPage.setValue("55,11");
		movementPage.clickSave();
		Assert.assertTrue(movementPage.containsMessage("Conta � um campo obrigat�rio"));
		movementPage.selectComboBoxAccount();
		movementPage.selectAccountMoviment("Conta para extrato");
		movementPage.clickSave();
		Assert.assertEquals("Movimenta��o cadastrada com sucesso", movementPage.getMessageSuccess());
	}
}