import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteAutomatizado {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver","env/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","env/chromedriver.exe");
		
		//WebDriver browser = new FirefoxDriver();
		WebDriver browser = new ChromeDriver();
		browser.get("http://www.bing.com");
		
		WebElement campo = browser.findElement(By.name("q"));
		campo.sendKeys("Caelum");
		campo.submit();
	}
}
