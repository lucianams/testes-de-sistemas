package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeilaoPage {
	
	private final WebDriver browser;
	
	public LeilaoPage(WebDriver browser){
		this.browser = browser;
		browser.get("http://localhost:8080/apenas-teste/limpa");
	}
	
	public void acessaPagina(){
		browser.get("http://localhost:8080/leiloes");
	}

	public void novoLeilao() {
		browser.findElement(By.linkText("Novo Leilão")).click();	
		
		
	}

	public void cadastra(String nome, String valor, String usuario,	Boolean usado) {
		WebElement txtNome = browser.findElement(By.name("leilao.nome"));
		txtNome.sendKeys(nome);
		
		WebElement txtValor = browser.findElement(By.name("leilao.valorInicial"));
		txtValor.sendKeys(valor);
		
		Select cbUsuario = new Select(browser.findElement(By.name("leilao.usuario.id")));
		cbUsuario.selectByVisibleText(usuario);
		
		if (usado){
			WebElement ckUsado = browser.findElement(By.name("leilao.usado"));
			ckUsado.click();
		}
		
		WebElement btnSalvar = browser.findElement(By.tagName("button"));
		btnSalvar.click();
		
	}

	public boolean nomeValorNaoInformado(){
		WebElement txtNome = browser.findElement(By.name("leilao.nome"));
		WebElement txtValor = browser.findElement(By.name("leilao.valorInicial"));
		WebElement btnSalvar = browser.findElement(By.tagName("button"));
		
		txtNome.clear();
		txtValor.clear();
		btnSalvar.submit();
		
		return browser.getPageSource().contains("Nome obrigatorio!") &&
				browser.getPageSource().contains("Valor inicial deve ser maior que zero!");
		
	}
	
	public boolean existeNalistagem(String string) {
		return (browser.getPageSource().contains("Fogão Brastemp"));
	}

	public void exibir(String string) {
		WebElement lkExibir = browser.findElement(By.linkText("exibir"));
		lkExibir.click();
	}
	
	public boolean darLance(String usuario, String valor) {
		WebElement txtLance = browser.findElement(By.name("lance.valor"));
		txtLance.sendKeys(valor);
		WebElement btnDarLance = browser.findElement(By.tagName("button"));
		btnDarLance.click();	
		return browser.getPageSource().contains(valor);
	}

	public void excluir(String string, String string2, String string3, boolean b) {
		// TODO Auto-generated method stub
		
	}

}
