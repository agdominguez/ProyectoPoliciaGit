package com.api.rest.models.entity;

import java.io.Serializable;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "ARMAMENTO", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data

public class Armamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_ARMAMENTO")
	@SequenceGenerator(name = "GSQ_ARMAMENTO", allocationSize = 1, sequenceName = "SEQ_ARMAMENTO")
    private Long codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_ARMA", nullable = false, length = 50)
    private String tipoArma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIMINADO", nullable = false)
    private Character eliminado;
    @JoinColumn(name = "CODIGO_DEPENDENCIA", referencedColumnName = "CODIGO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Dependencia dependencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODIGO_ARMA", nullable = false, length = 50)
    private String codigoArma;
    
//    @OneToMany(mappedBy = "codigoArmamento")
//    private List<AsignacionArmamento> asignacionArmamentoList;

    public Armamento() {
    }

    public Armamento(Long codigo) {
        this.codigo = codigo;
    }

    public Armamento(Long codigo, String tipoArma, String nombre, String descripcion, Character eliminado) {
        this.codigo = codigo;
        this.tipoArma = tipoArma;
        this.nombre = nombre;
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
        if (!(object instanceof Armamento)) {
            return false;
        }
        Armamento other = (Armamento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rest.models.entity.Armamento[ codigo=" + codigo + " ]";
    }
}
