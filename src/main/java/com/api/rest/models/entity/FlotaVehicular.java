package com.api.rest.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
*
* @author Alex
*/
@Entity
@Table(name = "FLOTA_VEHICULAR", catalog = "", schema = "PLA_FLOTA_VEHICULAR")
@Data

public class FlotaVehicular implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_FLOTA_VEHICULAR")
	@SequenceGenerator(name = "GSQ_FLOTA_VEHICULAR", allocationSize = 1, sequenceName = "SEQ_FLOTA_VEHICULAR")
    private Long codigo;
    @Size(max = 10)
    @Column(name = "PLACA", length = 10)
    private String placa;
    @Size(max = 30)
    @Column(name = "CHASIS", length = 30)
    private String chasis;
    @Size(max = 25)
    @Column(name = "MARCA", length = 25)
    private String marca;
    @Size(max = 25)
    @Column(name = "MODELO", length = 25)
    private String modelo;
    @Size(max = 30)
    @Column(name = "MOTOR", length = 30)
    private String motor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KILOMETRAJE", precision = 18, scale = 2)
    private BigDecimal kilometraje;
    @Column(name = "CILINDRAJE", precision = 18, scale = 2)
    private BigDecimal cilindraje;
    @Column(name = "CAPACIDAD_CARGA", precision = 18, scale = 2)
    private BigDecimal capacidadCarga;
    @Column(name = "CAPACIDAD_PASAJEROS", precision = 18, scale = 2)
    private BigDecimal capacidadPasajeros;
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "ELIMINADO")
    private Character eliminado;
    @JoinColumn(name = "CODIGO_TIPO_VEHICULO", referencedColumnName = "CODIGO")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private TipoVehiculo tipoVehiculo;
//    @OneToMany(mappedBy = "codigoFlotaVehicular")
//    private List<VinculacionFlotaSubcircuito> vinculacionFlotaSubcircuitoList;

    public FlotaVehicular() {
    }

    public FlotaVehicular(Long codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof FlotaVehicular)) {
            return false;
        }
        FlotaVehicular other = (FlotaVehicular) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rest.models.entity.FlotaVehicular[ codigo=" + codigo + " ]";
    }
}
