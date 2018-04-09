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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.SubTipoMantenimientoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.SubTipoMantenimiento;

/**
 *
 * @author joker
 */
@Path("subTipoMantenimiento")
public class SubTipoMantenimientoResource implements Serializable{
    
    @EJB
    private SubTipoMantenimientoFacadeLocal stmfl;
    
     @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<SubTipoMantenimiento> findAll() {
        List lista = null;
        try {
            lista = stmfl.findAll();
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
    public List<SubTipoMantenimiento> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("0") @QueryParam("pagesize") int pageSize
    ) {
        if (validarRangos(first, pageSize)) {
            List<SubTipoMantenimiento> salida = new ArrayList<>();
            salida.add(new SubTipoMantenimiento());
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
        if (nombre != null && stmfl != null) {
            List<SubTipoMantenimiento> salida = stmfl.findByNombreLike(nombre, first, pageSize);
            if (salida != null && !salida.isEmpty()) {
                JsonArrayBuilder ab = Json.createArrayBuilder();
                for (SubTipoMantenimiento s : salida) {
                    ab.add(Json.createObjectBuilder()
                            .add("idSubTipoMantenimiento", s.getIdSubTipoMantenimiento())
                            .add("nombre", s.getNombre()));
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
            if (stmfl != null) {
                return stmfl.count();
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
    public SubTipoMantenimiento create(SubTipoMantenimiento registro) {

        if (registro != null) {
            try {
                if (stmfl != null) {
                    SubTipoMantenimiento m = stmfl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new SubTipoMantenimiento();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public SubTipoMantenimiento edit(SubTipoMantenimiento registro) {

        if (registro != null && registro.getIdSubTipoMantenimiento() == null) {
            try {
                if (stmfl != null) {
                    SubTipoMantenimiento m = stmfl.editar(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new SubTipoMantenimiento();
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public SubTipoMantenimiento remove(SubTipoMantenimiento registro) {

        if (registro != null && registro.getIdSubTipoMantenimiento() == null) {
            try {
                if (stmfl != null) {
                    SubTipoMantenimiento m = stmfl.remover(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new SubTipoMantenimiento();
    }
    
}
