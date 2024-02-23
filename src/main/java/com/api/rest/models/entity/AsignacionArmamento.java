package com.api.rest.models.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "ASIGNACION_ARMAMENTO", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data
public class AsignacionArmamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_ASIG_ARMAMENTO")
	@SequenceGenerator(name = "GSQ_ASIG_ARMAMENTO", allocationSize = 1, sequenceName = "SEQ_ASIG_ARMAMENTO")
    private Long codigo;
    
    @JoinColumn(name = "CODIGO_VINCULACION_PERSONAL", referencedColumnName = "CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private VinculacionPersonalSubcircuito vinculacionPersonal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ASIGNACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIMINADO", nullable = false)
    private Character eliminado;
    
    @JoinColumn(name = "CODIGO_ARMAMENTO", referencedColumnName = "CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Armamento armamento;

    public AsignacionArmamento() {
    }

    public AsignacionArmamento(Long codigo) {
        this.codigo = codigo;
    }

    public AsignacionArmamento(Long codigo, Date fechaAsignacion, Character eliminado) {
        this.codigo = codigo;
        this.fechaAsignacion = fechaAsignacion;
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
        if (!(object instanceof AsignacionArmamento)) {
            return false;
        }
        AsignacionArmamento other = (AsignacionArmamento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rest.models.entity.AsignacionArmamento[ codigo=" + codigo + " ]";
    }

}
