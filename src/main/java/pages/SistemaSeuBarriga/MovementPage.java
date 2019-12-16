package pages.SistemaSeuBarriga;

import java.util.List;

import org.openqa.selenium.By;

import core.DriverFactory;
import io.appium.java_client.MobileElement;

public class MovementPage {

	public void selectComboBoxType() {
		DriverFactory.getDriver().findElement(By.id("android:id/text1")).click();
	}

	public void selectValueMoviment(String texto) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public void clickSwitchActive() {
		DriverFactory.getDriver().findElement(By.className("android.widget.Switch")).click();
	}

	public void setDescription(String name) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Descrição']")).sendKeys(name);
	}

	public void setInterested(String name) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Interessado']")).sendKeys(name);
	}

	public void setValue(String name) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Valor']")).sendKeys(name);
	}

	public void selectComboBoxAccount() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Selecione uma conta...']")).click();
	}

	public void selectAccountMoviment(String texto) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public void clickSave() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='SALVAR']")).click();
	}

	public String getMessageSuccess() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Movimentação cadastrada com sucesso']"))
				.getText();
	}

	public boolean containsMessage(String texto) {
		List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}
}