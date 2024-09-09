package br.com.mdantas;

import br.com.mdantas.dao.IMatriculaDao;
import br.com.mdantas.dao.MatriculaDao;
import br.com.mdantas.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

/**
 * @author marcelo.dantas
 */
public class MatriculaTest {

    private IMatriculaDao matriculaDao;

    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
    }

    @Test
    public void cadastrar() {
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        matriculaDao.cadastrar(mat);

        Assert.assertNotNull(mat);
        Assert.assertNotNull(mat.getId());
    }
}
