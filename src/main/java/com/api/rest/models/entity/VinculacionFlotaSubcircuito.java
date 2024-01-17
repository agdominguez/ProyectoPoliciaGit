package com.api.rest.models.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "VINCULACION_FLOTA_SUBCIRCUITO", catalog = "", schema = "PLA_FLOTA_VEHICULAR")
@Data
public class VinculacionFlotaSubcircuito implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "CODIGO", nullable = false)
	    @GeneratedValue(generator = "GSQ_VINCULACION")
		@SequenceGenerator(name = "GSQ_VINCULACION", allocationSize = 1, sequenceName = "SEQ_VINCULACION")
	    private Long codigo;
	    @JoinColumn(name = "CODIGO_DEPENDENCIA", referencedColumnName = "CODIGO", nullable = false)
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	    private Dependencia dependencia;
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "ELIMINADO", nullable = false)
	    private Character eliminado;
	    @JoinColumn(name = "CODIGO_FLOTA_VEHICULAR", referencedColumnName = "CODIGO", nullable = false)
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	    private FlotaVehicular flotaVehicular;

	    public VinculacionFlotaSubcircuito() {
	    }

	    public VinculacionFlotaSubcircuito(Long codigo) {
	        this.codigo = codigo;
	    }

	    public VinculacionFlotaSubcircuito(Long codigo, Character eliminado) {
	        this.codigo = codigo;
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
	        if (!(object instanceof VinculacionFlotaSubcircuito)) {
	            return false;
	        }
	        VinculacionFlotaSubcircuito other = (VinculacionFlotaSubcircuito) object;
	        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.api.rest.models.entity.VinculacionFlotaSubcircuito[ codigo=" + codigo + " ]";
	    }

}
