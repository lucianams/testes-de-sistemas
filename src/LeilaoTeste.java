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
		usuario.cadastra("Luciana Magalh�es", "lucianams@gmail.com");
				
		leilao.acessaPagina();
	}

	@After
	public void finaliza(){
		browser.close();
	}

	@Test
	public void deveAdicionarLeilao() {
		leilao.novoLeilao();
		leilao.cadastra("Fog�o Brastemp", "100", "Luciana Magalh�es", true);
		assertTrue(leilao.existeNalistagem("Fog�o Brastemp"));
	}
	
	@Test
	public void deveExibirMsgUsuarioValorNaoInformado() {
		leilao.novoLeilao();
		assertTrue(leilao.nomeValorNaoInformado());
	}
	
	@Test
	public void deveDarLanceLeilao() {
		assertTrue(leilao.existeNalistagem("Fog�o Brastemp"));
		leilao.exibir("Fog�o Brastemp");
		assertTrue(leilao.darLance("Luciana Magalh�es", "100"));
	}
	
	@Test
	public void deveExcluirLeilao() {
		do {
			leilao.excluir("Fog�o Brastemp", "100", "Luciana Magalh�es", true);
		} while (leilao.existeNalistagem("Fog�o Brastemp"));
	}
}
