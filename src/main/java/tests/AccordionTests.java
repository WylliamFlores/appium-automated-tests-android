package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccordionPage;
import pages.MenuPage;

public class AccordionTests extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private AccordionPage accordionPage = new AccordionPage();

	@Test
	public void interactAccordion() {
		menuPage.menuAccordion();
		accordionPage.clickAccordion1();
		Assert.assertEquals("Esta � a descri��o da op��o 1", accordionPage.getTextAccordion1());
	}
}