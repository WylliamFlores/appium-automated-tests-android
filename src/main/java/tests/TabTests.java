package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.TabPage;

public class TabTests extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private TabPage tabPage = new TabPage();

	@Test
	public void interactTabs() {
		menuPage.menuAbas();
		Assert.assertEquals("Este é o conteúdo da Aba 1", tabPage.getTextTab1());
		tabPage.clickTab2();
		Assert.assertEquals("Este é o conteúdo da Aba 2", tabPage.getTextTab2());
	}
}