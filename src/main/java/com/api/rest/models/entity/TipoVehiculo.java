package com.api.rest.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "TIPO_VEHICULO", catalog = "", schema = "PLA_FLOTA_VEHICULAR")
@Data

public class TipoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false, precision = 0, scale = -127)
    private BigDecimal codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIPO", nullable = false, length = 25)
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIMINADO", nullable = false)
    private Character eliminado;
//    @OneToMany(mappedBy = "codigoTipoVehiculo")
//    private List<FlotaVehicular> flotaVehicularList;

    public TipoVehiculo() {
    }

    public TipoVehiculo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public TipoVehiculo(BigDecimal codigo, String tipo, String descripcion, Character eliminado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVehiculo)) {
            return false;
        }
        TipoVehiculo other = (TipoVehiculo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rest.models.entity.TipoVehiculo[ codigo=" + codigo + " ]";
    }
    
}
