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
@Table(name = "DEPENDENCIA", catalog = "", schema = "PLA_DEPENDENCIAS")
@Data
public class Dependencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "SIGLAS", nullable = false, length = 10)
	private String siglas;
	@Size(max = 30)
	@Column(name = "CODIGO_CIRCUITO_SUBCIRCUITO", length = 30)
	private String codigoCircuitoSubcircuito;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;
//	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDependencia", fetch = FetchType.LAZY)
//	    private List<VinculacionPersonalSubcircuito> vinculacionPersonalSubcircuitoList;
//	    @OneToMany(mappedBy = "codigoDependenciaPadre", fetch = FetchType.LAZY)
//	    private List<Dependencia> dependenciaList;
	@JoinColumn(name = "CODIGO_DEPENDENCIA_PADRE", referencedColumnName = "CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Dependencia dependenciaPadre;
	@JoinColumn(name = "CODIGO_JERARQUIA", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private JerarquiaDependencia jerarquia;

	public Dependencia() {
	}

	public Dependencia(Long codigo) {
		this.codigo = codigo;
	}

	public Dependencia(Long codigo, String nombre, String siglas, Character eliminado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.siglas = siglas;
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
		if (!(object instanceof Dependencia)) {
			return false;
		}
		Dependencia other = (Dependencia) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.Dependencia[ codigo=" + codigo + " ]";
	}

}
