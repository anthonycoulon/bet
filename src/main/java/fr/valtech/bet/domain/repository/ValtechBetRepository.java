package fr.valtech.bet.domain.repository;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

    public class ValtechBetRepository {

    @PersistenceContext(unitName = "betPersistenceUnit")
    private EntityManager entityManager;

    public EntityManager getEntityManager(){
        return this.entityManager;
    }

    public Session getSession(){
        return (Session) this.entityManager.getDelegate();
    }
}
