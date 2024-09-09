package br.com.mdantas.dao;

import br.com.mdantas.domain.Curso;
import br.com.mdantas.domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author marcelo.dantas
 */
public class MatriculaDao implements IMatriculaDao {


    @Override
    public Matricula cadastrar(Matricula mat) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(mat);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return mat;
    }
}
