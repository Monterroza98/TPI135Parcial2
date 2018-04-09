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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.TipoMantenimientoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.TipoMantenimiento;

/**
 *
 * @author joker
 */
@Path("tipoMantenimiento")
public class TipoMantenimientoResource implements Serializable{
    
    @EJB
    private TipoMantenimientoFacadeLocal tmfl;
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoMantenimiento> findAll() {
        List lista = null;
        try {
            lista = tmfl.findAll();
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
    public List<TipoMantenimiento> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("0") @QueryParam("pagesize") int pageSize
    ) {
        if (validarRangos(first, pageSize)) {
            List<TipoMantenimiento> salida = new ArrayList<>();
            salida.add(new TipoMantenimiento());
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
        if (nombre != null && tmfl != null) {
            List<TipoMantenimiento> salida = tmfl.findByNombreLike(nombre, first, pageSize);
            if (salida != null && !salida.isEmpty()) {
                JsonArrayBuilder ab = Json.createArrayBuilder();
                for (TipoMantenimiento t : salida) {
                    ab.add(Json.createObjectBuilder()
                            .add("idMarca", t.getIdTipoMantenimiento())
                            .add("nombre", t.getNombre())
                            .add("activo", t.getActivo()));
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
            if (tmfl != null) {
                return tmfl.count();
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
    public TipoMantenimiento create(TipoMantenimiento registro) {

        if (registro != null) {
            try {
                if (tmfl != null) {
                    TipoMantenimiento m = tmfl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new TipoMantenimiento();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public TipoMantenimiento edit(TipoMantenimiento registro) {

        if (registro != null) {
            try {
                if (tmfl != null) {
                    TipoMantenimiento m = tmfl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new TipoMantenimiento();
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public TipoMantenimiento remove(TipoMantenimiento registro) {

        if (registro != null && registro.getIdTipoMantenimiento() == null) {
            try {
                if (tmfl != null) {
                    TipoMantenimiento m = tmfl.remover(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new TipoMantenimiento();
    }
    
    
    
}
