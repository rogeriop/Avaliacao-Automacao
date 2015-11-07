package manipulacao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovaSimulacao {

	@Test
	public void test() {
		FirefoxDriver driver = new FirefoxDriver();
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("http://eliasnogueira.com/uninassau/financiamento/index.html");
		driver.findElementById("residencial").click();
		driver.findElementById("valor_imovel").sendKeys("8000000");
		driver.findElementById("valor_entrada").sendKeys("2500000");
		driver.findElementByName("prazo").sendKeys("121");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		assertEquals("O prazo deve ser de de 12 a 120 meses", driver.findElement(By.cssSelector(".alert.alert-danger.meses")).getText());

	}
}
