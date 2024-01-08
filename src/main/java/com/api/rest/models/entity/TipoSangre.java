package com.api.rest.models.entity;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "TIPO_SANGRE", catalog = "", schema = "PLA_PERSONAS")
@Data
public class TipoSangre implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "NOMBRE", nullable = false, length = 10)
	private String nombre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "DESCRIPCION", nullable = false, length = 30)
	private String descripcion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;

	public TipoSangre() {
	}

	public TipoSangre(Long codigo) {
		this.codigo = codigo;
	}

	public TipoSangre(Long codigo, String nombre, String descripcion, Character eliminado) {
		this.codigo = codigo;
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
		if (!(object instanceof TipoSangre)) {
			return false;
		}
		TipoSangre other = (TipoSangre) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.TipoSangre[ codigo=" + codigo + " ]";
	}

}
