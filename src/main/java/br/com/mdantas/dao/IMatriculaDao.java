package br.com.mdantas.dao;

import br.com.mdantas.domain.Curso;
import br.com.mdantas.domain.Matricula;

/**
 * @author marcelo.dantas
 */
public interface IMatriculaDao {

    Matricula cadastrar(Matricula mat);
    Matricula buscarPorCodigoCurso(String codigoCurso);
    Matricula buscarPorCurso(Curso curso);
}
