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
@Table(name = "SOLICITUD", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "p_actualiza_estado", 
			procedureName = "pla_mantenimientos.pkg_solicitud.p_actualiza_estado", 
			resultClasses = { Solicitud.class }, parameters = {
					@StoredProcedureParameter(name = "p_codigo_solicitud", mode = ParameterMode.IN, type = Long.class),
					@StoredProcedureParameter(name = "p_estado", mode = ParameterMode.IN, type = Character.class),
					@StoredProcedureParameter(name = "pv_error_sql", mode = ParameterMode.OUT, type = String.class),
					@StoredProcedureParameter(name = "pv_error_code", mode = ParameterMode.OUT, type = Long.class),
					@StoredProcedureParameter(name = "pv_error", mode = ParameterMode.OUT, type = String.class) })

})
public class Solicitud implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	@GeneratedValue(generator = "GSQ_SOLICITUD")
	@SequenceGenerator(name = "GSQ_SOLICITUD", allocationSize = 1, sequenceName = "GSQ_SOLICITUD")
	private Long codigo;
	@JoinColumn(name = "CODIGO_VINCULACION", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Vinculacion vinculacion;
	@Column(name = "ESTADO")
	private Character estado;
	@Column(name = "FECHA_RESERVA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReserva;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "KILOMETRAJE", precision = 18, scale = 2)
	private BigDecimal kilometraje;
	@Size(max = 100)
	@Column(name = "OBSERVACION", length = 100)
	private String observacion;
	@Column(name = "ELIMINADO")
	private Character eliminado;

	public Solicitud() {
	}

	public Solicitud(Long codigo) {
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
		if (!(object instanceof Solicitud)) {
			return false;
		}
		Solicitud other = (Solicitud) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.Solicitud[ codigo=" + codigo + " ]";
	}

}
