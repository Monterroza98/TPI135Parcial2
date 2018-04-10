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
import javafx.scene.media.Media;
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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.TipoResponsableFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.TipoResponsable;

/**
 *
 * @author joker
 */
@Path("tiporesponsable")
public class TipoResponsableResorce implements  Serializable{
    
    @EJB
    private TipoResponsableFacadeLocal trfl;
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoResponsable> findAll() {
        List lista = null;
        try {
            lista = trfl.findAll();
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
    public List<TipoResponsable> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("5") @QueryParam("pagesize") int pageSize
    ) {
        if (validarRangos(first, pageSize)) {
            List<TipoResponsable> salida = trfl.findRange(first, pageSize);
            salida.add(new TipoResponsable());
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
        if (nombre != null && trfl != null) {
            List<TipoResponsable> salida = trfl.findByNombreLike(nombre, first, pageSize);
            if (salida != null && !salida.isEmpty()) {
                JsonArrayBuilder ab = Json.createArrayBuilder();
                for (TipoResponsable t : salida) {
                    ab.add(Json.createObjectBuilder()
                            .add("idTipoResponsable", t.getIdTipoResponsable())
                            .add("nombre", t.getNombre()));
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
            if (trfl != null) {
                return trfl.count();
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
    public TipoResponsable create(TipoResponsable registro) {

        if (registro != null) {
            try {
                if (trfl != null) {
                    TipoResponsable m = trfl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new TipoResponsable();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public TipoResponsable edit(TipoResponsable registro) {

        if (registro != null && registro.getIdTipoResponsable() == null) {
            try {
                if (trfl != null) {
                    TipoResponsable m = trfl.editar(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new TipoResponsable();
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public TipoResponsable remove(TipoResponsable registro) {

        if (registro != null && registro.getIdTipoResponsable() == null) {
            try {
                if (trfl != null) {
                    TipoResponsable m = trfl.remover(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new TipoResponsable();
    }

    
    
}
