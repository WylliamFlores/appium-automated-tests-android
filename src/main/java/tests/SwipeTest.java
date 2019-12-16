package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.SwipePage;

public class SwipeTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	SwipePage swipePage = new SwipePage();

	@Test
	public void interactSwipe() {
		menuPage.menuSwipe();
		Assert.assertEquals("a esquerda", swipePage.getText1Swipe());
		// swipe para direita
		swipePage.swipe(0.9, 0.1);
		// clicar botão direito
		swipePage.clickRight();
		// verificar mensagem
		Assert.assertEquals("Chegar até o fim!", swipePage.getText3Swipe());
		// swipe esquerdo
		swipePage.swipe(0.1, 0.9);
		// verificar mensagem
		Assert.assertEquals("você consegue", swipePage.getText2Swipe());
	}
}