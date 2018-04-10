/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author joker
 */
public class EntityManagerProvider implements TestRule{
    
    private final EntityManager em;
    private EntityTransaction tx;
    
    private EntityManagerProvider(String unitName) {
        this.em = Persistence.createEntityManagerFactory(unitName).createEntityManager();
        
    }

    public final static EntityManagerProvider persistenceUnit(String unitName) {
        return new EntityManagerProvider(unitName);
    }

    public EntityManager em() {
        return this.em;
    }
    
    @After
    public void cleanup() {
        em.getTransaction().rollback();
    }
 
    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                base.evaluate();
                em.clear();
                em.close();
            }

        };
    }

}
