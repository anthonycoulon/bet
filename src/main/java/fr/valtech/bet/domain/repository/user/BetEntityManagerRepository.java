package fr.valtech.bet.domain.repository.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

    public class BetEntityManagerRepository {

    @PersistenceContext(unitName = "betPersistenceUnit")
    private EntityManager entityManager;

    public EntityManager getEntityManager(){
        return this.entityManager;
    }
}
