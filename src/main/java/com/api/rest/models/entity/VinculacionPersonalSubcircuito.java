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
@Table(name = "VINCULACION_PERSONAL_SUBCIRCUITO", catalog = "", schema = "PLA_DEPENDENCIAS")
@Data
public class VinculacionPersonalSubcircuito implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    @GeneratedValue(generator = "GSQ_VINCULACION")
	@SequenceGenerator(name = "GSQ_VINCULACION", allocationSize = 1, sequenceName = "SEQ_VINCULACION")
    private Long codigo;
    @Basic(optional = false)
    @NotNull
    @JoinColumn(name = "CODIGO_PERSONAL_POLICIAL", referencedColumnName = "CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private PersonalPolicial personalPolicial;
    @JoinColumn(name = "CODIGO_DEPENDENCIA", referencedColumnName = "CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Dependencia dependencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIMINADO", nullable = false)
    private Character eliminado;
    

    public VinculacionPersonalSubcircuito() {
    }

    public VinculacionPersonalSubcircuito(Long codigo) {
        this.codigo = codigo;
    }

    public VinculacionPersonalSubcircuito(Long codigo, Character eliminado) {
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
        if (!(object instanceof VinculacionPersonalSubcircuito)) {
            return false;
        }
        VinculacionPersonalSubcircuito other = (VinculacionPersonalSubcircuito) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rest.models.entity.VinculacionPersonalSubcircuito[ codigo=" + codigo + " ]";
    }

}
