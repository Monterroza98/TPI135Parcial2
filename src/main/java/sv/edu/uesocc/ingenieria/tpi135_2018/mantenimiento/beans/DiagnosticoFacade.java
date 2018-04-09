/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Diagnostico;

/**
 *
 * @author joker
 */
@Stateless
public class DiagnosticoFacade extends AbstractFacade<Diagnostico> implements DiagnosticoFacadeLocal {

    @PersistenceContext(unitName = "mantPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticoFacade() {
        super(Diagnostico.class);
    }

    @Override
    public List<Diagnostico> findByNombreLike(String name, Integer first, Integer pageSize) {
        Query query = em.createNamedQuery("Diagnostico.findByNombreLike");
        List<Diagnostico> lista= query.getResultList();
        return lista;
    }
 
}
