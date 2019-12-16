package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.SplashPage;

public class SplashTests extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private SplashPage splashPage = new SplashPage();

	@Test
	public void interactSplash() {
		menuPage.menuSplash();

		// verificar splash/mensagem esta sendo exibida
		Assert.assertEquals("Splash!", splashPage.mesasgeSplash());

		// aguardar saida do splash
		splashPage.waitSplashExit();

		// splash saiu e retornou para o menu principal
		Assert.assertTrue(menuPage.visibleMenuPrincipal("About..."));
	}
}