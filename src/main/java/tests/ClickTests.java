package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import pages.ClickPage;
import pages.MenuPage;

public class ClickTests extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ClickPage clickPage = new ClickPage();

	@Before
	public void setup() {
		menuPage.menuClick();
	}

	@Test
	public void interactLongClick() {
		clickPage.clickLong();
		Assert.assertEquals("Clique Longo", clickPage.getTextLongClick());
	}

	@Test
	public void interactDoubleClick() {
		clickPage.clickDouble();
		Assert.assertEquals("Duplo Clique", clickPage.getTextDoubleClick());
	}
}