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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "PERSONAL_POLICIAL", catalog = "", schema = "PLA_PERSONAS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "IDENTIFICACION" }) })
@Data
public class PersonalPolicial implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GSQ_PERSONAL_POLICIAL")
	@SequenceGenerator(name = "GSQ_PERSONAL_POLICIAL", allocationSize = 1, sequenceName = "SEQ_PERSONAL_POLICIAL")
	private Long codigo;
	@Size(max = 13)
	@Column(name = "IDENTIFICACION", length = 13)
	private String identificacion;
	@Size(max = 50)
	@Column(name = "NOMBRE_COMPLETO", length = 50)
	private String nombreCompleto;
	@Column(name = "FECHA_NACIMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	@JoinColumn(name = "CODIGO_TIPO_SANGRE", referencedColumnName = "CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoSangre tipoSangre;
	@JoinColumn(name = "CODIGO_CIUDAD_NACIMIENTO", referencedColumnName = "CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Dependencia ciudadNacimiento;
	@Size(max = 10)
	@Column(name = "TELEFONO_CELULAR", length = 10)
	private String telefonoCelular;
//	@Column(name = "CODIGO_DEPENDENCIA")
//	private BigInteger codigoDependencia;
	@Column(name = "FECHA_INGRESO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;
	@Column(name = "ELIMINADO")
	private Character eliminado;
	@JoinColumn(name = "CODIGO_RANGO", referencedColumnName = "CODIGO")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private RangoPolicial rango;

	public PersonalPolicial() {
	}

	public PersonalPolicial(Long codigo) {
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
		if (!(object instanceof PersonalPolicial)) {
			return false;
		}
		PersonalPolicial other = (PersonalPolicial) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.PersonalPolicial[ codigo=" + codigo + " ]";
	}
}
