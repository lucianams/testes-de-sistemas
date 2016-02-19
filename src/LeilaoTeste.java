import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.LeilaoPage;
import pages.UsuarioPage;

public class LeilaoTeste {
	
	private WebDriver browser;
	private LeilaoPage leilao;
	
	@Before
	public void inicializa(){
		this.browser = new FirefoxDriver();
		this.leilao = new LeilaoPage(browser);
		
		UsuarioPage usuario = new UsuarioPage(browser);
		usuario.acessaPagina();
		usuario.novoUsuario();
		usuario.cadastra("Luciana Magalhães", "lucianams@gmail.com");
				
		leilao.acessaPagina();
	}

	@After
	public void finaliza(){
		browser.close();
	}

	@Test
	public void deveAdicionarLeilao() {
		leilao.novoLeilao();
		leilao.cadastra("Fogão Brastemp", "100", "Luciana Magalhães", true);
		assertTrue(leilao.existeNalistagem("Fogão Brastemp"));
	}
	
	@Test
	public void deveExibirMsgUsuarioValorNaoInformado() {
		leilao.novoLeilao();
		assertTrue(leilao.nomeValorNaoInformado());
	}
	
	@Test
	public void deveDarLanceLeilao() {
		assertTrue(leilao.existeNalistagem("Fogão Brastemp"));
		leilao.exibir("Fogão Brastemp");
		assertTrue(leilao.darLance("Luciana Magalhães", "100"));
	}
	
	@Test
	public void deveExcluirLeilao() {
		do {
			leilao.excluir("Fogão Brastemp", "100", "Luciana Magalhães", true);
		} while (leilao.existeNalistagem("Fogão Brastemp"));
	}
}
