package pages.SistemaSeuBarriga;

import org.openqa.selenium.By;

import core.DriverFactory;
import io.appium.java_client.TouchAction;

public class AccountPage {

	public void setAccountName(String name) {
		DriverFactory.getDriver().findElement(By.className("android.widget.EditText")).clear();
		DriverFactory.getDriver().findElement(By.className("android.widget.EditText")).sendKeys(name);
	}

	public void clickSave() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='SALVAR']")).click();
	}

	public void clickDelete() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='EXCLUIR']")).click();
	}

	public String getMessageAccountSuccess() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Conta adicionada com sucesso']")).getText();
	}

	public String getMessageError() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Problemas de comunicação']")).getText();
	}

	public String getMessageAccountWithMovement() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Conta em uso nas movimentações']")).getText();
	}

	public String getMessageAccountEditSuccess() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Conta atualizada com sucesso']")).getText();
	}

	public String getMessageAccountDeleteSuccess() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Conta excluída com sucesso']")).getText();
	}

	public void clickLong(By by) {
		new TouchAction(DriverFactory.getDriver()).longPress(DriverFactory.getDriver().findElement(by)).perform();
	}

	public void selectAccount(String conta) {
		clickLong(By.xpath("//*[@text='" + conta + "']"));
	}
}