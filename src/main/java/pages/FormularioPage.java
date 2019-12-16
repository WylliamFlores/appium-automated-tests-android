package pages;

import org.openqa.selenium.By;

import core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class FormularioPage {

	public void setName(String name) {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("nome")).sendKeys(name);
	}

	public String getName() {
		return DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("nome")).getText();
	}

	public void selectComboBox() {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("console")).click();
	}

	public void selectValueComboBox(String texto) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public String getValueComboBox() {
		return DriverFactory.getDriver().findElement(By.xpath("//android.widget.Spinner/android.widget.TextView"))
				.getText();
	}

	public void clickCheck() {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("check")).click();
	}

	public void clickSwitch() {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("switch")).click();
	}

	public void clickSave() {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("save")).click();
	}

	public String getNameRegister() {
		return DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"))
				.getText();
	}

	public String getComboBoxRegister() {
		return DriverFactory.getDriver()
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")).getText();
	}

	public String getSwitchRegister() {
		return DriverFactory.getDriver()
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).getText();
	}

	public String getCheckboxRegister() {
		return DriverFactory.getDriver()
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).getText();
	}

	public String getSliderRegister() {
		return DriverFactory.getDriver()
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]")).getText();
	}

	public void clickDatePicker() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='01/01/2000']")).click();
	}

	public void selectDay(String texto) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public void clickDatePickerOK() {
		DriverFactory.getDriver().findElement(By.id("android:id/button1")).click();
	}

	public String getDate() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='22/2/2000']")).getText();
	}

	public void clickTimePicker() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='06:00']")).click();
	}

	public void selectTimePickerHour() {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("16")).click();
	}

	public void selectTimePickerMinute() {
		DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("50")).click();
	}

	public void clickTimePickerOK() {
		DriverFactory.getDriver().findElement(By.id("android:id/button1")).click();
	}

	public String getTime() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='16:50']")).getText();
	}

	public void tap(int x, int y) {
		new TouchAction(DriverFactory.getDriver()).tap(x, y).perform();
	}

	public void clickSliderkBar(double position) {
		MobileElement slider = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = slider.getLocation().y + (slider.getSize().height / 2);
		int x = (int) (slider.getLocation().x + (slider.getSize().width * position));
		tap(x, y);
	}
}