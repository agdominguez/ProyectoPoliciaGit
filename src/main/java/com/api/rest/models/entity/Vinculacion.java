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
@Table(name = "VINCULACION", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data
public class Vinculacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	@GeneratedValue(generator = "GSQ_VINCULACION_FLOTA_PERSONAL")
	@SequenceGenerator(name = "GSQ_VINCULACION_FLOTA_PERSONAL", allocationSize = 1, sequenceName = "SEQ_VINCULACION_FLOTA_PERSONAL")
	private Long codigo;
	@JoinColumn(name = "CODIGO_VIN_PERSONAL", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private VinculacionPersonalSubcircuito vinculacionPersonal;
	@JoinColumn(name = "CODIGO_VIN_FLOTA", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private VinculacionFlotaSubcircuito vinculacionFlota;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;

	public Vinculacion() {
	}

	public Vinculacion(Long codigo) {
		this.codigo = codigo;
	}

	public Vinculacion(Long codigo, Character eliminado) {
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
		if (!(object instanceof Vinculacion)) {
			return false;
		}
		Vinculacion other = (Vinculacion) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.Vinculacion[ codigo=" + codigo + " ]";
	}

}
