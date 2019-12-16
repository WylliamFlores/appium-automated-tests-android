package pages.SistemaSeuBarriga;

import org.openqa.selenium.By;

import core.DriverFactory;

public class LoginPage {

	public void setName(String name) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Nome']")).sendKeys(name);
	}

	public void setPassword(String password) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='Senha']")).sendKeys(password);
	}

	public void clickEntrar() {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='ENTRAR']")).click();
	}

	public String getHomeScreen() {
		return DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='HOME']")).getText();
	}

	public String getMessageProblem() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Problemas com o login']")).getText();
	}

	public String getMessageInvalid() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@text='Usuário ou senha inválido']")).getText();
	}
}