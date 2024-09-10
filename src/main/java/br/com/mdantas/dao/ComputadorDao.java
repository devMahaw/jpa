package br.com.mdantas.dao;

import br.com.mdantas.domain.Computador;
import br.com.mdantas.domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author marcelo.dantas
 */
public class ComputadorDao implements IComputadorDao {
    @Override
    public Computador cadastrar(Computador computador) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(computador);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return computador;
    }
}
