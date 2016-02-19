import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.UsuarioPage;
import static org.junit.Assert.assertTrue;

public class UsuarioTeste {
	
	private WebDriver browser;
	private UsuarioPage usuarios;
	
	@Before
	public void inicializa(){
		this.browser = new FirefoxDriver();
		this.usuarios = new UsuarioPage(browser);
		usuarios.acessaPagina();
		//browser.get("http://localhost:8080/usuarios");
		//WebElement novoUsuario = browser.findElement(By.linkText("Novo Usuário"));
		//novoUsuario.click();
	}

	@After
	public void finaliza(){
		browser.close();
	}

	//public static void main (String[] args){
	@Test
	public void deveAdicionarUsuario() {
		
		usuarios.novoUsuario();
		usuarios.cadastra("Luciana Magalhães", "lucianams@gmail.com");
		assertTrue(usuarios.existeNalistagem("Luciana Magalhães", "lucianams@gmail.com"));
		
		//WebElement nome = browser.findElement(By.name("usuario.nome"));
		//WebElement email = browser.findElement(By.name("usuario.email"));
		
		//nome.sendKeys("Luciana Magalhães");
		//email.sendKeys("lucianams@gmail.com");
		//email.submit();
		
		//boolean achouNome = browser.getPageSource().contains("Luciana Magalhães");
		//assertTrue(achouNome);
		
		//System.out.println("Funcionou!!");
	}
	
	@Test
	public void deveExibirMsgUsuarioSemNomeEmail() {
		
		usuarios.novoUsuario();
		assertTrue(usuarios.nomeEmailNaoInformado());
		
	}
	
	@Test
	public void deveExcluirUsuario() {
		
		assertTrue(usuarios.existeNalistagem("Luciana Magalhães", "lucianams@gmail.com"));
		usuarios.excluirUsuario("Luciana Magalhães", "lucianams@gmail.com");
		assertTrue(!(usuarios.existeNalistagem("Luciana Magalhães", "lucianams@gmail.com")));
		
	}
}
