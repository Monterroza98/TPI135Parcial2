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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Estado;

/**
 *
 * @author joker
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> implements EstadoFacadeLocal {

    @PersistenceContext(unitName = "mantPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    @Override    
     public List<Estado> findByNombreLike(String nombre, Integer first, Integer pageSize) {
        if(nombre!= null){
        Query query = em.createNamedQuery("Estado.findByNombreLike");
        query.setParameter("nombre", nombre);
        List<Estado> lista= query.getResultList();
        return lista;
        }
        return new ArrayList<>();
    

    }
    
}
