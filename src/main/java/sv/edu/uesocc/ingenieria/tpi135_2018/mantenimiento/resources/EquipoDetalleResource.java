/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.EquipoDetalleFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.EquipoDetalle;

/**
 *
 * @author joker
 */
public class EquipoDetalleResource implements Serializable{
    
    @EJB
    private EquipoDetalleFacadeLocal edfl;
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EquipoDetalle> findAll() {
        List lista = null;
        try {
            lista = edfl.findAll();
            if (lista != null) {
                return lista;
            }
        } catch (Exception e) {
        } finally {
            lista = new ArrayList();
        }

        return lista;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<EquipoDetalle> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("0") @QueryParam("pagesize") int pageSize
    ) {
        if (validarRangos(first, pageSize)) {
            List<EquipoDetalle> salida = new ArrayList<>();
            salida.add(new EquipoDetalle());
            return salida;
        }
        return Collections.EMPTY_LIST;
    }


    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Integer count() {
        try {
            if (edfl != null) {
                return edfl.count();
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public boolean validarRangos(int first, int pageSize) {
        return first >= 0 && pageSize >= 0;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public EquipoDetalle create(EquipoDetalle registro) {

        if (registro != null) {
            try {
                if (edfl != null) {
                    EquipoDetalle m = edfl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new EquipoDetalle();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public EquipoDetalle edit(EquipoDetalle registro) {

        if (registro != null && registro.getIdEquipoDetalle()== null) {
            try {
                if (edfl != null) {
                    EquipoDetalle m = edfl.editar(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new EquipoDetalle();
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public EquipoDetalle remove(EquipoDetalle registro) {

        if (registro != null && registro.getIdEquipoDetalle()== null) {
            try {
                if (edfl != null) {
                    EquipoDetalle m = edfl.remover(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new EquipoDetalle();
    }
    
}
