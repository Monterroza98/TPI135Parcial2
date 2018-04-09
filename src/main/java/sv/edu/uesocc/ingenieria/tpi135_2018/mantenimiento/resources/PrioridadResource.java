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
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.PrioridadFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Prioridad;

/**
 *
 * @author joker
 */
public class PrioridadResource implements Serializable{
    
    @EJB
    private PrioridadFacadeLocal pfl;
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Prioridad> findAll() {
        List lista = null;
        try {
            lista = pfl.findAll();
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
    public List<Prioridad> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("0") @QueryParam("pagesize") int pageSize
    ) {
        if (validarRangos(first, pageSize)) {
            List<Prioridad> salida = new ArrayList<>();
            salida.add(new Prioridad());
            return salida;
        }
        return Collections.EMPTY_LIST;
    }

    @GET
    @Path("nombre/{nombre}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByName(
            @PathParam("nombre") final String nombre,
            @QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("pageSize") @DefaultValue("50") int pageSize) {
        if (nombre != null && pfl != null) {
            List<Prioridad> salida = pfl.findByNombreLike(nombre, first, pageSize);
            if (salida != null && !salida.isEmpty()) {
                JsonArrayBuilder ab = Json.createArrayBuilder();
                for (Prioridad p : salida) {
                    ab.add(Json.createObjectBuilder()
                            .add("idPrioridad", p.getIdPrioridad())
                            .add("nombre", p.getNombre())
                            .add("activo", p.getActivo()));
                }
                return Response.ok(ab.build()).build();

            }

        }
        return (Response) Collections.EMPTY_LIST;

    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Integer count() {
        try {
            if (pfl != null) {
                return pfl.count();
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
    public Prioridad create(Prioridad registro) {

        if (registro != null) {
            try {
                if (pfl != null) {
                    Prioridad m = pfl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new Prioridad();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Prioridad edit(Prioridad registro) {

        if (registro != null && registro.getIdPrioridad() == null) {
            try {
                if (pfl != null) {
                    Prioridad m = pfl.editar(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new Prioridad();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Prioridad remove(Prioridad registro) {

        if (registro != null && registro.getIdPrioridad() == null) {
            try {
                if (pfl != null) {
                    Prioridad m = pfl.remover(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new Prioridad();
    }
    
}
