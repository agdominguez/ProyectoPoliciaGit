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
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "SUGERENCIA", catalog = "", schema = "PLA_PERSONAS")
@Data
public class Sugerencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_SUGERENCIA")
	@SequenceGenerator(name = "GSQ_SUGERENCIA", allocationSize = 1, sequenceName = "SEQ_SUGERENCIA")
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	@JoinColumn(name = "CODIGO_DEPENDENCIA", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Dependencia dependencia;
	@Size(max = 200)
	@Column(name = "DETALLE", length = 200)
	private String detalle;
	@Size(max = 10)
	@Column(name = "CONTACTO", length = 10)
	private String contacto;
	@Size(max = 100)
	@Column(name = "APELLIDOS", length = 100)
	private String apellidos;
	@Size(max = 100)
	@Column(name = "NOMBRES", length = 100)
	private String nombres;
	@Column(name = "ELIMINADO")
	private Character eliminado;
	@JoinColumn(name = "CODIGO_TIPO_RECLAMO", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoReclamo tipoReclamo;
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	public Sugerencia() {
	}

	public Sugerencia(Long codigo) {
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
		if (!(object instanceof Sugerencia)) {
			return false;
		}
		Sugerencia other = (Sugerencia) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
    public String toString() {
        return "com.api.rest.models.entity.Sugerencia[ codigo=" + codigo + " ]";
    }
}
