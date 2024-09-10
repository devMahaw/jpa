package br.com.mdantas;

import br.com.mdantas.dao.*;
import br.com.mdantas.domain.Aluno;
import br.com.mdantas.domain.Computador;
import br.com.mdantas.domain.Curso;
import br.com.mdantas.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

/**
 * @author marcelo.dantas
 */
public class MatriculaTest {

    private IMatriculaDao matriculaDao;

    private ICursoDao cursoDao;

    private IAlunoDao alunoDao;

    private IComputadorDao computadorDao;

    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
        alunoDao = new AlunoDao();
        computadorDao = new ComputadorDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("A1");
        Aluno aluno = criarAluno("A1");

        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat.setAluno(aluno);

        aluno.setMatricula(mat);
        matriculaDao.cadastrar(mat);

        Assert.assertNotNull(mat);
        Assert.assertNotNull(mat.getId());

        Matricula matBD = matriculaDao.buscarPorCodigoCurso(mat.getCodigo());
        Assert.assertNotNull(matBD);
        Assert.assertEquals(mat.getId(), matBD.getId());

        Matricula matBDObj = matriculaDao.buscarPorCurso(curso);
        Assert.assertNotNull(matBDObj);
        Assert.assertEquals(mat.getId(), matBDObj.getId());
    }

    private Computador criarComputador(String codigo) {
        Computador comp = new Computador();
        comp.setCodigo(codigo);
        comp.setDescricao("Comp 1");
        return comp;
    }

    private Aluno criarAluno(String codigo) {
        Computador comp = criarComputador("A1");
        Computador comp2 = criarComputador("A2");
        Aluno aluno = new Aluno();
        aluno.setCodigo(codigo);
        aluno.setNome("Mahaw");
        aluno.add(comp);
        aluno.add(comp2);
        return alunoDao.cadastrar(aluno);
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        return cursoDao.cadastrar(curso);
    }

}
