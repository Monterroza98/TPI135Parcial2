/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joker
 */
@Entity
@Table(name = "tipo_parte", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoParte.findAll", query = "SELECT t FROM TipoParte t")
    , @NamedQuery(name = "TipoParte.findByIdTipoParte", query = "SELECT t FROM TipoParte t WHERE t.idTipoParte = :idTipoParte")
    , @NamedQuery(name = "TipoParte.findByNombre", query = "SELECT t FROM TipoParte t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoParte.findByNombreLike", query = "SELECT m FROM TipoParte m WHERE LOWER(m.nombre) LIKE CONCAT('%',LOWER(\"n\"),'%') ")
    , @NamedQuery(name = "TipoParte.findByDescripcion", query = "SELECT t FROM TipoParte t WHERE t.descripcion = :descripcion")})
public class TipoParte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_parte")
    private Integer idTipoParte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoParte")
    private Collection<Parte> parteCollection;

    public TipoParte() {
    }

    public TipoParte(Integer idTipoParte) {
        this.idTipoParte = idTipoParte;
    }

    public TipoParte(Integer idTipoParte, String nombre) {
        this.idTipoParte = idTipoParte;
        this.nombre = nombre;
    }

    public Integer getIdTipoParte() {
        return idTipoParte;
    }

    public void setIdTipoParte(Integer idTipoParte) {
        this.idTipoParte = idTipoParte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Parte> getParteCollection() {
        return parteCollection;
    }

    public void setParteCollection(Collection<Parte> parteCollection) {
        this.parteCollection = parteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoParte != null ? idTipoParte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoParte)) {
            return false;
        }
        TipoParte other = (TipoParte) object;
        if ((this.idTipoParte == null && other.idTipoParte != null) || (this.idTipoParte != null && !this.idTipoParte.equals(other.idTipoParte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.TipoParte[ idTipoParte=" + idTipoParte + " ]";
    }
    
}
