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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.SubTipoMantenimiento;

/**
 *
 * @author joker
 */
@Stateless
public class SubTipoMantenimientoFacade extends AbstractFacade<SubTipoMantenimiento> implements SubTipoMantenimientoFacadeLocal {

    @PersistenceContext(unitName = "mantPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubTipoMantenimientoFacade() {
        super(SubTipoMantenimiento.class);
    }

    @Override
    public List<SubTipoMantenimiento> findByNombreLike(String nombre, Integer first, Integer pageSize) {
        if(nombre!= null){
        Query query = em.createNamedQuery("SubTipoMntenimiento.findByNombreLike");
        query.setParameter("nombre", nombre);
        List<SubTipoMantenimiento> lista= query.getResultList();
        return lista;
        }
        return new ArrayList<>();
    }

   
}
