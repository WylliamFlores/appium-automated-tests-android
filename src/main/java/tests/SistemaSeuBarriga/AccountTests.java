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
import pages.SistemaSeuBarriga.AccountPage;
import pages.SistemaSeuBarriga.LoginPage;
import pages.SistemaSeuBarriga.SBMenuPage;

public class AccountTests extends BaseTest {

	SBMenuPage sbMenuPage = new SBMenuPage();
	MenuPage menuPage = new MenuPage();
	AccountPage accountPage = new AccountPage();
	LoginPage loginPage = new LoginPage();

	@Before
	public void setup() {
		menuPage.menuSeuBarrigaNativo();
		loginPage.setName("wyll@wyll.com");
		loginPage.setPassword("012345");
		loginPage.clickEntrar();
		sbMenuPage.clicReset();
		sbMenuPage.clickAccount();
	}

	@Test
	public void createAccount() {
		accountPage.setAccountName("Conta do Wylliam");
		accountPage.clickSave();
		Assert.assertEquals("Conta adicionada com sucesso", accountPage.getMessageAccountSuccess());
	}

	@Test
	public void accountNameInUse() {
		accountPage.setAccountName("Conta com movimentacao");
		accountPage.clickSave();
		Assert.assertEquals("Problemas de comunicação", accountPage.getMessageError());
	}

	@Test
	public void editAccount() {
		accountPage.selectAccount("Conta para alterar");
		accountPage.setAccountName("Conta Alterada");
		accountPage.clickSave();
		Assert.assertEquals("Conta atualizada com sucesso", accountPage.getMessageAccountEditSuccess());
	}

	@Test
	public void deleteAccountWithMovement() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Conta com movimentacao']")));
		accountPage.selectAccount("Conta com movimentacao");
		accountPage.clickDelete();
		Assert.assertEquals("Conta em uso nas movimentações", accountPage.getMessageAccountWithMovement());
	}

	@Test
	public void deleteAccount() {
		accountPage.selectAccount("Conta mesmo nome");
		accountPage.clickDelete();
		Assert.assertEquals("Conta excluída com sucesso", accountPage.getMessageAccountDeleteSuccess());
	}
}