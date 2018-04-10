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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.TipoMantenimiento;

/**
 *
 * @author joker
 */
@Stateless
public class TipoMantenimientoFacade extends AbstractFacade<TipoMantenimiento> implements TipoMantenimientoFacadeLocal {

    @PersistenceContext(unitName = "mantPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMantenimientoFacade() {
        super(TipoMantenimiento.class);
    }

    public List<TipoMantenimiento> findByNombreLike(String name) {
       if(name!= null && getEntityManager() !=null){
        Query query = em.createNamedQuery("TipoMantenimiento.findByNombreLike");
        query.setParameter("nombre", name.toLowerCase());
        List<TipoMantenimiento> lista= query.getResultList();
        return lista;
        }
        return new ArrayList<>();
        
    }

   
}
