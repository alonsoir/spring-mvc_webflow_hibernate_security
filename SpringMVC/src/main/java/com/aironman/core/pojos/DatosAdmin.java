package com.aironman.core.pojos;

public class DatosAdmin implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5412984910396601936L;
	private Long idAbogado;
	private Long idDemanda;

	public DatosAdmin() {

	}

	public Long getIdAbogado() {
		return idAbogado;
	}

	public void setIdAbogado(Long idAbogado) {
		this.idAbogado = idAbogado;
	}

	public Long getIdDemanda() {
		return idDemanda;
	}

	public void setIdDemanda(Long idDemanda) {
		this.idDemanda = idDemanda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAbogado == null) ? 0 : idAbogado.hashCode());
		result = prime * result
				+ ((idDemanda == null) ? 0 : idDemanda.hashCode());
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
		DatosAdmin other = (DatosAdmin) obj;
		if (idAbogado == null) {
			if (other.idAbogado != null)
				return false;
		} else if (!idAbogado.equals(other.idAbogado))
			return false;
		if (idDemanda == null) {
			if (other.idDemanda != null)
				return false;
		} else if (!idDemanda.equals(other.idDemanda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatosAdmin [idAbogado=" + idAbogado + ", idDemanda="
				+ idDemanda + "]";
	}

}