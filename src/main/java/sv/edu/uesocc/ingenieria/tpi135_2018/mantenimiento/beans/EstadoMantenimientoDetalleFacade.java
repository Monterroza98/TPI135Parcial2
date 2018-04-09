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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.EstadoMantenimientoDetalle;

/**
 *
 * @author joker
 */
@Stateless
public class EstadoMantenimientoDetalleFacade extends AbstractFacade<EstadoMantenimientoDetalle> implements EstadoMantenimientoDetalleFacadeLocal {

    @PersistenceContext(unitName = "mantPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoMantenimientoDetalleFacade() {
        super(EstadoMantenimientoDetalle.class);
    }

}
