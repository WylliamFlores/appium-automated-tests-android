package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class MenuPage {

	public void scroll(double start, double end) {
		Dimension size = DriverFactory.getDriver().manage().window().getSize();
		int x = size.width / 2;
		int start_y = (int) (size.height * start);
		int end_y = (int) (size.height * end);
		new TouchAction(DriverFactory.getDriver())
		.press(x, start_y).waitAction(Duration.ofMillis(500))
		.moveTo(x, end_y)
		.release().perform();
	}
	
	public void menuSeuBarrigaNativo() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='SeuBarriga Nativo']")).click();
	}

	public void menuFormulario() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}

	public void menuSplash() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Splash']")).click();
	}

	public boolean visibleMenuPrincipal(String texto) {
		List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	public void menuAlertas() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Alertas']")).click();
	}

	public void menuAbas() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Abas']")).click();
	}

	public void menuAccordion() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Accordion']")).click();
	}
	
	public void menuSwipe() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Swipe']")).click();
	}

	public void menuClick() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Cliques']")).click();
	}

	public void menuOpcaoEscondida() {
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Opção bem escondida']"))
				.click();
	}
}