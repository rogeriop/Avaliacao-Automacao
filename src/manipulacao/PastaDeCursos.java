package manipulacao;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastaDeCursos {
	
	public static void main(String[] args) throws UnsupportedFlavorException, IOException {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		driver.get("http://arpinheiro.ddns.net:8080/share/page/site/07-carreira-profissional/documentlibrary#filter=path%7C%2F01%2520CURSOS%2F2014-12-19%2520ALURA%2F27%2520Wordpress%253B%2520primeiros%2520passos&page=1");
		driver.manage().window().maximize();
		
		
		String[] linhas = new ClipBoard().obtem().split("\n");
		int contadorDeLinhas = 0;
		
		for (String s: linhas) {
		
			contadorDeLinhas++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("template_x002e_toolbar_x002e_documentlibrary_x0023_default-newFolder-button-button")));
			driver.findElement(By.id("template_x002e_toolbar_x002e_documentlibrary_x0023_default-newFolder-button-button")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("prop_cm_name")));
			driver.findElement(By.name("prop_cm_name")).sendKeys(((contadorDeLinhas < 10) ? "0" : "")
					+ contadorDeLinhas + " " + s);
			driver.findElement(By.id("template_x002e_toolbar_x002e_documentlibrary_x0023_default-createFolder-form-submit-button")).click();
		
		}
		
	}

}
