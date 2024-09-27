package br.com.mdantas;

import br.com.mdantas.dao.IProdutoDao;
import br.com.mdantas.dao.ProdutoDao;
import br.com.mdantas.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author marcelo.dantas
 */
public class ProdutoTest {

    private IProdutoDao produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("PRODUTO TESTE");
        produto.setNome("Produto de Java Backend");
        produto = produtoDao.cadastrar(produto);

        Assert.assertNotNull(produto);
        Assert.assertNotNull(produto.getId());
    }
}
