/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Responsable;

/**
 *
 * @author joker
 */
@Stateless
public class ResponsableFacade extends AbstractFacade<Responsable> implements ResponsableFacadeLocal {

    @PersistenceContext(unitName = "mantPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsableFacade() {
        super(Responsable.class);
    }

    @Override
    public List<Responsable> findByNombreLike(String name) {
        if(name!= null && getEntityManager() !=null){
        Query query = em.createNamedQuery("Responsable.findByNombreLike");
        query.setParameter("nombre", name.toLowerCase());
        List<Responsable> lista= query.getResultList();
        return lista;
        }
        return new ArrayList<>();
    }
  
}
