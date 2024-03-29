package com.api.rest.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "MANTENIMIENTO", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data


@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "p_inserta_mantenimiento", 
			procedureName = "pla_mantenimientos.pkg_mantenimiento.p_inserta_mantenimiento", 
			resultClasses = { Mantenimiento.class }, parameters = {
					@StoredProcedureParameter(name = "p_codigo_solicitud", mode = ParameterMode.IN, type = Long.class),
					@StoredProcedureParameter(name = "p_asunto", mode = ParameterMode.IN, type = String.class),
					@StoredProcedureParameter(name = "p_detalle", mode = ParameterMode.IN, type = String.class),
					@StoredProcedureParameter(name = "p_kilometraje_actual", mode = ParameterMode.IN, type = BigDecimal.class),
					@StoredProcedureParameter(name = "p_codigo", mode = ParameterMode.OUT, type = Long.class),
					@StoredProcedureParameter(name = "pv_error_sql", mode = ParameterMode.OUT, type = String.class),
					@StoredProcedureParameter(name = "pv_error_code", mode = ParameterMode.OUT, type = Long.class),
					@StoredProcedureParameter(name = "pv_error", mode = ParameterMode.OUT, type = String.class) })
})

public class Mantenimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_MANTENIMIENTO")
	@SequenceGenerator(name = "GSQ_MANTENIMIENTO", allocationSize = 1, sequenceName = "SEQ_MANTENIMIENTO")
	private Long codigo;
	@JoinColumn(name = "CODIGO_SOLICITUD", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Solicitud solicitud;
	@Size(max = 100)
	@Column(name = "ASUNTO", length = 100)
	private String asunto;
	@Size(max = 100)
	@Column(name = "DETALLE", length = 100)
	private String detalle;
	@Column(name = "FECHA_INGRESO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;
	@Column(name = "KILOMETRAJE_ACTUAL")
	private BigDecimal kilometrajeActual;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;

	public Mantenimiento() {
	}

	public Mantenimiento(Long codigo) {
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
		if (!(object instanceof Mantenimiento)) {
			return false;
		}
		Mantenimiento other = (Mantenimiento) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.Mantenimiento[ codigo=" + codigo + " ]";
	}

}
