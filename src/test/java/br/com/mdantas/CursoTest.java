package br.com.mdantas;

import br.com.mdantas.dao.CursoDao;
import br.com.mdantas.dao.ICursoDao;
import br.com.mdantas.domain.Curso;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author marcelo.dantas
 */
public class CursoTest {

    private ICursoDao cursoDao;

    public CursoTest() {
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);

        Assert.assertNotNull(curso);
        Assert.assertNotNull(curso.getId());
    }
}