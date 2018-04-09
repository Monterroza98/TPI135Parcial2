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
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.beans.EquipoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.DiagnosticoParte;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.Equipo;

/**
 *
 * @author joker
 */
public class EquipoResource implements Serializable{
    
    @EJB
    private EquipoFacadeLocal efl;
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Equipo> findAll() {
        List lista = null;
        try {
            lista = efl.findAll();
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
    public List<Equipo> findRange(
            @DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("0") @QueryParam("pagesize") int pageSize
    ) {
        if (validarRangos(first, pageSize)) {
            List<Equipo> salida = new ArrayList<>();
            salida.add(new Equipo());
            return salida;
        }
        return Collections.EMPTY_LIST;
    }


    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Integer count() {
        try {
            if (efl != null) {
                return efl.count();
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
    public Equipo create(Equipo registro) {

        if (registro != null) {
            try {
                if (efl != null) {
                    Equipo m = efl.crear(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new Equipo();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Equipo edit(Equipo registro) {

        if (registro != null && registro.getIdEquipo()== null) {
            try {
                if (efl != null) {
                    Equipo m = efl.editar(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new Equipo();
    }


    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public Equipo remove(Equipo registro) {

        if (registro != null && registro.getIdEquipo() == null) {
            try {
                if (efl != null) {
                    Equipo m = efl.remover(registro);
                    if (m != null) {
                        return m;
                    }
                }
            } catch (Exception e) {
            }
        }
        return new Equipo();
    }

    
}
