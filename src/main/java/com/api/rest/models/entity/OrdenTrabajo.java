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
@Table(name = "ORDEN_TRABAJO", catalog = "", schema = "PLA_MANTENIMIENTOS")
@Data

@NamedStoredProcedureQueries({	
	@NamedStoredProcedureQuery(
			name = "p_actualiza_estado_orden", 
			procedureName = "pla_mantenimientos.pkg_orden_trabajo.p_actualiza_estado_orden", 
			resultClasses = { Mantenimiento.class }, parameters = {
					@StoredProcedureParameter(name = "p_codigo_orden", mode = ParameterMode.IN, type = Long.class),
					@StoredProcedureParameter(name = "p_estado", mode = ParameterMode.IN, type = Character.class),
					@StoredProcedureParameter(name = "pv_error_sql", mode = ParameterMode.OUT, type = String.class),
					@StoredProcedureParameter(name = "pv_error_code", mode = ParameterMode.OUT, type = Long.class),
					@StoredProcedureParameter(name = "pv_error", mode = ParameterMode.OUT, type = String.class) })
})
public class OrdenTrabajo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_ORDEN_TRABAJO")
	@SequenceGenerator(name = "GSQ_ORDEN_TRABAJO", allocationSize = 1, sequenceName = "SEQ_ORDEN_TRABAJO")
	private Long codigo;
	@Column(name = "ESTADO")
	private Character estado;
	@Column(name = "FECHA_ENTREGA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEntrega;
	@JoinColumn(name = "CODIGO_PERSONAL_RETIRA", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private PersonalPolicial personalRetira;
	@Column(name = "KILOMETRAJE_MANTENIMIENTO")
	private BigDecimal kilometrajeMantenimiento;
	@Size(max = 100)
	@Column(name = "OBSERVACION", length = 100)
	private String observacion;
	@JoinColumn(name = "CODIGO_MANTENIMIENTO", referencedColumnName = "CODIGO", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Mantenimiento mantenimiento;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ELIMINADO", nullable = false)
	private Character eliminado;

	public OrdenTrabajo() {
	}

	public OrdenTrabajo(Long codigo) {
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
		if (!(object instanceof OrdenTrabajo)) {
			return false;
		}
		OrdenTrabajo other = (OrdenTrabajo) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.OrdenTrabajo[ codigo=" + codigo + " ]";
	}

}
