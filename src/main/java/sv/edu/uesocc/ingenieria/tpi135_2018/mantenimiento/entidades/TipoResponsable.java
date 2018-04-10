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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joker
 */
@Entity
@Table(name = "tipo_responsable", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoResponsable.findAll", query = "SELECT t FROM TipoResponsable t")
    , @NamedQuery(name = "TipoResponsable.findByIdTipoResponsable", query = "SELECT t FROM TipoResponsable t WHERE t.idTipoResponsable = :idTipoResponsable")
    , @NamedQuery(name = "TipoResponsable.findByNombre", query = "SELECT t FROM TipoResponsable t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoResponsable.findByNombreLike", query = "SELECT m FROM TipoResponsable m WHERE LOWER(m.nombre) LIKE CONCAT('%',LOWER(:nombre),'%') ")
    , @NamedQuery(name = "TipoResponsable.findByDescripciont", query = "SELECT t FROM TipoResponsable t WHERE t.descripciont = :descripciont")})
public class TipoResponsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_responsable")
    private Integer idTipoResponsable;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "descripciont")
    private String descripciont;
    @OneToMany(mappedBy = "idTipoResponsable")
    private Collection<Responsable> responsableCollection;

    public TipoResponsable() {
    }

    public TipoResponsable(Integer idTipoResponsable) {
        this.idTipoResponsable = idTipoResponsable;
    }

    public Integer getIdTipoResponsable() {
        return idTipoResponsable;
    }

    public void setIdTipoResponsable(Integer idTipoResponsable) {
        this.idTipoResponsable = idTipoResponsable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripciont() {
        return descripciont;
    }

    public void setDescripciont(String descripciont) {
        this.descripciont = descripciont;
    }

    @XmlTransient
    public Collection<Responsable> getResponsableCollection() {
        return responsableCollection;
    }

    public void setResponsableCollection(Collection<Responsable> responsableCollection) {
        this.responsableCollection = responsableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoResponsable != null ? idTipoResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoResponsable)) {
            return false;
        }
        TipoResponsable other = (TipoResponsable) object;
        if ((this.idTipoResponsable == null && other.idTipoResponsable != null) || (this.idTipoResponsable != null && !this.idTipoResponsable.equals(other.idTipoResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.entidades.TipoResponsable[ idTipoResponsable=" + idTipoResponsable + " ]";
    }
    
}
