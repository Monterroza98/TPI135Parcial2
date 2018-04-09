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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.OrdenTrabajoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.OrdenTrabajo;

/**
 *
 * @author joker
 */
public class OrdenTrabajoResource implements Serializable{
    
    @EJB
    private OrdenTrabajoFacadeLocal otfl;
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<OrdenTrabajo> findAll() {
        List lista = null;
        try {
            lista = otfl.findAll();
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
    public List<OrdenTrabajo> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("0") @QueryParam("pagesize") int pageSize
    ) {
        if (validarRangos(first, pageSize)) {
            List<OrdenTrabajo> salida = new ArrayList<>();
            salida.add(new OrdenTrabajo());
            return salida;
        }
        return Collections.EMPTY_LIST;
    }


    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Integer count() {
        try {
            if (otfl != null) {
                return otfl.count();
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
    public OrdenTrabajo create(OrdenTrabajo registro) {

        if (registro != null) {
            try {
                if (otfl != null) {
                    OrdenTrabajo m = otfl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new OrdenTrabajo();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public OrdenTrabajo edit(OrdenTrabajo registro) {

        if (registro != null && registro.getIdOrdenTrabajo()== null) {
            try {
                if (otfl != null) {
                    OrdenTrabajo m = otfl.editar(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new OrdenTrabajo();
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public OrdenTrabajo remove(OrdenTrabajo registro) {

        if (registro != null && registro.getIdOrdenTrabajo()== null) {
            try {
                if (otfl != null) {
                    OrdenTrabajo m = otfl.remover(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new OrdenTrabajo();
    }
    
}
