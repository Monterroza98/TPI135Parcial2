/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Prioridad;

/**
 *
 * @author joker
 */
@Local
public interface PrioridadFacadeLocal extends AbstractFacadeInterface<Prioridad>{

    public List<Prioridad> findByNombreLike(String name, Integer first, Integer pageSize);
    
}
