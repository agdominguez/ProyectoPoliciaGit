package com.api.rest.models.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "TIPO_MANTENIMIENTO", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data
public class TipoMantenimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	@Size(max = 50)
	@Column(name = "NOMBRE", length = 50)
	private String nombre;
	@Size(max = 100)
	@Column(name = "DESCRIPCION", length = 100)
	private String descripcion;
	@JoinColumn(name = "CODIGO_TIPO_CONTRATO", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoContrato tipoContrato;
	@Column(name = "COSTO", precision = 18, scale = 2)
	private Long costo;
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;

	public TipoMantenimiento() {
	}

	public TipoMantenimiento(Long codigo) {
		this.codigo = codigo;
	}

	public TipoMantenimiento(Long codigo, Character eliminado) {
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
		if (!(object instanceof TipoMantenimiento)) {
			return false;
		}
		TipoMantenimiento other = (TipoMantenimiento) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.TipoMantenimiento[ codigo=" + codigo + " ]";
	}

}
