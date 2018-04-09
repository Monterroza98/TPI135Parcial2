/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Unidad;

/**
 *
 * @author joker
 */
@Local
public interface UnidadFacadeLocal extends AbstractFacadeInterface<Unidad>{

    public List<Unidad> findByNombreLike(String name, Integer first, Integer pageSize);
    
}
