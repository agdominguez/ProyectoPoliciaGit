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
@Table(name = "JERARQUIA_DEPENDENCIA", catalog = "", schema = "PLA_DEPENDENCIAS")
@Data
public class JerarquiaDependencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NOMBRE", nullable = false, length = 50)
	private String nombre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 5)
	@Column(name = "SIGLAS", nullable = false, length = 5)
	private String siglas;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ORDEN", nullable = false)
	private short orden;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;
//	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoJerarquia", fetch = FetchType.LAZY)
//	    private List<Dependencia> dependenciaList;

	public JerarquiaDependencia() {
	}

	public JerarquiaDependencia(Long codigo) {
		this.codigo = codigo;
	}

	public JerarquiaDependencia(Long codigo, String nombre, String siglas, short orden, Character eliminado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.siglas = siglas;
		this.orden = orden;
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
		if (!(object instanceof JerarquiaDependencia)) {
			return false;
		}
		JerarquiaDependencia other = (JerarquiaDependencia) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.JerarquiaDependencia[ codigo=" + codigo + " ]";
	}

}
