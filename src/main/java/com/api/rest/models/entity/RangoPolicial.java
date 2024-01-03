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
@Table(name = "RANGO_POLICIAL", catalog = "", schema = "PLA_PERSONAS")
@Data
public class RangoPolicial implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	@Column(name = "TIPO_RANGO")
	private Character tipoRango;
	@Size(max = 50)
	@Column(name = "NOMBRE_RANGO", length = 50)
	private String nombreRango;
	@Column(name = "ELIMINADO")
	private Character eliminado;
//	@OneToMany(mappedBy = "codigoRango", fetch = FetchType.LAZY)
//	private List<PersonaPolicial> personaPolicialList;

	public RangoPolicial() {
	}

	public RangoPolicial(Long codigo) {
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
		if (!(object instanceof RangoPolicial)) {
			return false;
		}
		RangoPolicial other = (RangoPolicial) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rest.models.entity.RangoPolicial[ codigo=" + codigo + " ]";
	}

}
