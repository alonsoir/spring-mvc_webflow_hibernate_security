package com.aironman.core.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORICO_DEMANDAS_VIVIENDAS")
public class HistoricoDemandasViviendasAdeudadas implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8558696916544058779L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Demandas demanda;

	@ManyToOne(fetch = FetchType.LAZY)
	private ViviendasConDeudas deudora;

	private String rutaFisicaDemanda;

	public String getRutaFisicaDemanda() {
		return rutaFisicaDemanda;
	}

	public void setRutaFisicaDemanda(String rutaFisicaDemanda) {
		this.rutaFisicaDemanda = rutaFisicaDemanda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Demandas getDemanda() {
		return demanda;
	}

	public void setDemanda(Demandas demanda) {
		this.demanda = demanda;
	}

	public ViviendasConDeudas getDeudora() {
		return deudora;
	}

	public void setDeudora(ViviendasConDeudas deudora) {
		this.deudora = deudora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((demanda == null) ? 0 : demanda.hashCode());
		result = prime * result + ((deudora == null) ? 0 : deudora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((rutaFisicaDemanda == null) ? 0 : rutaFisicaDemanda
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoDemandasViviendasAdeudadas other = (HistoricoDemandasViviendasAdeudadas) obj;
		if (demanda == null) {
			if (other.demanda != null)
				return false;
		} else if (!demanda.equals(other.demanda))
			return false;
		if (deudora == null) {
			if (other.deudora != null)
				return false;
		} else if (!deudora.equals(other.deudora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rutaFisicaDemanda == null) {
			if (other.rutaFisicaDemanda != null)
				return false;
		} else if (!rutaFisicaDemanda.equals(other.rutaFisicaDemanda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HistoricoDemandasViviendasAdeudadas [id=" + id + ", demanda="
				+ demanda + ", deudora=" + deudora + ", rutaFisicaDemanda="
				+ rutaFisicaDemanda + "]";
	}

}