/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author joker
 */
@javax.ws.rs.ApplicationPath("ws")

public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourcesClasses(resources);
        return resources;
    }

    private void addRestResourcesClasses(Set<Class<?>> resources) {
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.DiagnosticoParteResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.DiagnosticoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.EquipoDetalleResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.EquipoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.EstadoMantenimientoDetalleResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.EstadoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.MantenimientoDetalleResources.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.MarcaResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.ModeloResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.OrdenTrabajoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.ParteResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.PasoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.PrioridadResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.ProcedimientoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.ResponsableResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.SolicitudResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.SubTipoMantenimientoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.TipoMantenimientoResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.TipoParteResource.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.TipoResponsableResorce.class);
       resources.add(sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources.UnidadResource.class);
       

              
       
       
       
       
    }
}
