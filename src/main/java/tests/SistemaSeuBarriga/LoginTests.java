package tests.SistemaSeuBarriga;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.SistemaSeuBarriga.LoginPage;

public class LoginTests extends BaseTest {

	MenuPage menuPage = new MenuPage();
	LoginPage loginPage = new LoginPage();

	@Before
	public void setup() {
		menuPage.menuSeuBarrigaNativo();
	}

	@Test
	public void logInSucces() {
		loginPage.setName("wyll@wyll.com");
		loginPage.setPassword("012345");
		loginPage.clickEntrar();
		Assert.assertEquals("HOME", loginPage.getHomeScreen());
	}

	@Test
	public void logInEmailEmpty() {
		loginPage.setPassword("012345");
		loginPage.clickEntrar();
		Assert.assertEquals("Problemas com o login", loginPage.getMessageProblem());
	}

	@Test
	public void logInPasswordEmpty() {
		loginPage.setName("wyll@wyll.com");
		loginPage.clickEntrar();
		Assert.assertEquals("Usuário ou senha inválido", loginPage.getMessageInvalid());
	}

	@Test
	public void logInInvalid() {
		loginPage.setName("wyll@wyll.com");
		loginPage.setPassword("invalid");
		loginPage.clickEntrar();
		Assert.assertEquals("Usuário ou senha inválido", loginPage.getMessageInvalid());
	}
}