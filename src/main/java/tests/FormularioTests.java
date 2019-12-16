package tests;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.FormularioPage;
import pages.MenuPage;

public class FormularioTests extends BaseTest {

	MenuPage menuPage = new MenuPage();
	FormularioPage formularioPage = new FormularioPage();

	@Before
	public void setup() {
		menuPage.menuFormulario();
	}

	@Test
	public void interactTextField() throws MalformedURLException {
		formularioPage.setName("Wyllaim Flores");
		Assert.assertEquals("Wyllaim Flores", formularioPage.getName());
	}

	@Test
	public void interactComboBox() throws MalformedURLException {
		formularioPage.selectComboBox();
		formularioPage.selectValueComboBox("PS4");
		Assert.assertEquals("PS4", formularioPage.getValueComboBox());
	}

	@Test
	public void interactSwitchAndCheckbox() throws MalformedURLException {
		// verificar status dos elementos
		MobileElement check = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("check"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		MobileElement sswitch = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(sswitch.getAttribute("checked").equals("true"));

		// clicar nos elementos
		formularioPage.clickCheck();
		formularioPage.clickSwitch();

		// verificar estados alterados
		Assert.assertTrue(check.getAttribute("checked").equals("true"));
		Assert.assertTrue(sswitch.getAttribute("checked").equals("false"));
	}

	@Test
	public void interactDatePicker() {
		formularioPage.clickDatePicker();
		formularioPage.selectDay("22");
		formularioPage.clickDatePickerOK();
		Assert.assertEquals("22/2/2000", formularioPage.getDate());
	}

	@Test
	public void interactTimePicker() {
		formularioPage.clickTimePicker();
		formularioPage.selectTimePickerHour();
		formularioPage.selectTimePickerMinute();
		formularioPage.clickTimePickerOK();
		Assert.assertEquals("16:50", formularioPage.getTime());
	}

	@Test
	public void interactSeekBar() {
		formularioPage.clickSliderkBar(0.40);
		formularioPage.clickSave();
		Assert.assertEquals("Slider: 40", formularioPage.getSliderRegister());
	}

	@Test
	public void formulario() throws MalformedURLException {
		formularioPage.setName("Wylliam");
		formularioPage.selectComboBox();
		formularioPage.selectValueComboBox("PS4");
		formularioPage.clickCheck();
		formularioPage.clickSwitch();
		formularioPage.clickSave();
		Assert.assertEquals("Nome: Wylliam", formularioPage.getNameRegister());
		Assert.assertEquals("Console: ps4", formularioPage.getComboBoxRegister());
		Assert.assertEquals("Switch: Off", formularioPage.getSwitchRegister());
		Assert.assertEquals("Checkbox: Marcado", formularioPage.getCheckboxRegister());
	}
}