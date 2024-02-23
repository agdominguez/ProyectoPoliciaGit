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
import lombok.Data;

@Entity
@Table(name = "MANTENIMIENTO_TIPO", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data
public class MantenimientoTipo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_MANTENIMIENTO_TIPO")
	@SequenceGenerator(name = "GSQ_MANTENIMIENTO_TIPO", allocationSize = 1, sequenceName = "SEQ_MANTENIMIENTO_TIPO")
	private Long codigo;
	@JoinColumn(name = "CODIGO_MANTENIMIENTO", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Mantenimiento mantenimiento;
	@JoinColumn(name = "CODIGO_TIPO_MANTENIMIENTO", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoMantenimiento tipo;
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;

	public MantenimientoTipo() {
	}

	public MantenimientoTipo(Long codigo) {
		this.codigo = codigo;
	}

	public MantenimientoTipo(Long codigo, Character eliminado) {
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
		if (!(object instanceof MantenimientoTipo)) {
			return false;
		}
		MantenimientoTipo other = (MantenimientoTipo) object;
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
