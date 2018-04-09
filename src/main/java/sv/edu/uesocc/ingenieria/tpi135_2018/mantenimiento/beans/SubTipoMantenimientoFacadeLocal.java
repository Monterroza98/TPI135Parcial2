/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.SubTipoMantenimiento;

/**
 *
 * @author joker
 */
@Local
public interface SubTipoMantenimientoFacadeLocal extends AbstractFacadeInterface<SubTipoMantenimiento>{
    
    public List<SubTipoMantenimiento> findByNombreLike(String name, Integer first, Integer pageSize);
      
    
}
