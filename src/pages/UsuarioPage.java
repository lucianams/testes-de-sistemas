package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsuarioPage {
	
	private WebDriver browser;
	
	public UsuarioPage(WebDriver browser){
		this.browser = browser;		
		browser.get("http://localhost:8080/apenas-teste/limpa");
	}
	
	public void acessaPagina(){
		browser.get("http://localhost:8080/usuarios");
	}

	public void novoUsuario(){
		browser.findElement(By.linkText("Novo Usuário")).click();
	}
		
	public boolean existeNalistagem(String nome, String email) {
		return browser.getPageSource().contains(nome) && browser.getPageSource().contains(email);
	}
	
	public void cadastra(String nome, String email){
		WebElement txtNome = browser.findElement(By.name("usuario.nome"));
		WebElement txtEmail = browser.findElement(By.name("usuario.email"));
		
		txtNome.sendKeys(nome);
		txtEmail.sendKeys(email);
		
		txtNome.submit();
	}
	
	public boolean nomeEmailNaoInformado(){
		WebElement txtNome = browser.findElement(By.name("usuario.nome"));
		WebElement txtEmail = browser.findElement(By.name("usuario.email"));

		txtNome.clear();
		txtEmail.clear();
		txtNome.submit();
		
		return browser.getPageSource().contains("Nome obrigatorio!");
	}

	public void excluirUsuario(String nome, String email) {
		WebElement btnExcluir = browser.findElement(By.tagName("button"));
		System.out.println(btnExcluir.getText());
		btnExcluir.submit();	
		
		//Alert alert = browser.switchTo().alert();
		//alert.accept();
	}
}
