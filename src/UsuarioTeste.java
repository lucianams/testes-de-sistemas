import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class UsuarioTeste {
	
	WebDriver browser = new FirefoxDriver();
	
	@Before
	public void inicializa(){
		browser.get("http://localhost:8080/usuarios");
		WebElement novoUsuario = browser.findElement(By.linkText("Novo Usuário"));
		novoUsuario.click();
	}

	@After
	public void finaliza(){
		browser.close();
	}

	//public static void main (String[] args){
	@Test
	public void deveAdicionarUsuario() {
		WebElement nome = browser.findElement(By.name("usuario.nome"));
		WebElement email = browser.findElement(By.name("usuario.email"));
		
		nome.sendKeys("Luciana Magalhães");
		email.sendKeys("lucianams@gmail.com");
		email.submit();
		
		boolean achouNome = browser.getPageSource().contains("Luciana Magalhães");
		assertTrue(achouNome);
		
		//System.out.println("Funcionou!!");
	}
	
	@Test
	public void deveExibirMsgUsuarioSemNomeEmail() {
		WebElement nome = browser.findElement(By.name("usuario.nome"));
		WebElement email = browser.findElement(By.name("usuario.email"));

		nome.clear();
		email.clear();
		email.submit();
		
		boolean achouMensagem = browser.getPageSource().contains("Nome obrigatorio!");
		assertTrue(achouMensagem);

	}
}
