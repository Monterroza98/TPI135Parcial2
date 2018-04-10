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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Modelo;

/**
 *
 * @author joker
 */
@Stateless
public class ModeloFacade extends AbstractFacade<Modelo> implements ModeloFacadeLocal {

    @PersistenceContext(unitName = "mantPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloFacade() {
        super(Modelo.class);
    }

   @Override
    public List<Modelo> findByNombreLike(String nombre, Integer first, Integer pageSize) {
        if(nombre!= null){
        Query query = em.createNamedQuery("Unidad.findByNombreLike");
        query.setParameter("nombre", nombre);
        List<Modelo> lista= query.getResultList();
        return lista;
        }
        return new ArrayList<>();
    

    }
    
}
