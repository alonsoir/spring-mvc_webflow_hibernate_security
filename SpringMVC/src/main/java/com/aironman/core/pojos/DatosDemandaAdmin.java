package com.aironman.core.pojos;

import java.math.BigDecimal;

public class DatosDemandaAdmin implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6929252613039126003L;

	private BigDecimal montante;

	private String rutaCertificado;
	private String direccionVivienda;
	private String nombreMoroso;
	private String tlfFijoMoroso;
	private String tlfMovilMoroso;
	private String fechaIniciaDemanda;
	private String estadoDemanda;

	private String usernameFincas;
	private Long idDemanda;

	public DatosDemandaAdmin(BigDecimal montante, String estadoDemanda,
			String rutaCertificado, String direccionVivienda,
			String nombreMoroso, String tlfFijoMoroso, String tlfMovilMoroso,
			String fechaIniciaDemanda, String usernameFincas, Long idDemanda) {
		super();
		this.estadoDemanda = estadoDemanda;
		this.montante = montante;
		this.rutaCertificado = rutaCertificado;
		this.direccionVivienda = direccionVivienda;
		this.nombreMoroso = nombreMoroso;
		this.tlfFijoMoroso = tlfFijoMoroso;
		this.tlfMovilMoroso = tlfMovilMoroso;
		this.fechaIniciaDemanda = fechaIniciaDemanda;
		this.usernameFincas = usernameFincas;
		this.idDemanda = idDemanda;
	}

	public String getEstadoDemanda() {
		return estadoDemanda;
	}

	public void setEstadoDemanda(String estadoDemanda) {
		this.estadoDemanda = estadoDemanda;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	public void setMontante(BigDecimal montante) {
		this.montante = montante;
	}

	public String getRutaCertificado() {
		return rutaCertificado;
	}

	public void setRutaCertificado(String rutaCertificado) {
		this.rutaCertificado = rutaCertificado;
	}

	public String getDireccionVivienda() {
		return direccionVivienda;
	}

	public void setDireccionVivienda(String direccionVivienda) {
		this.direccionVivienda = direccionVivienda;
	}

	public String getNombreMoroso() {
		return nombreMoroso;
	}

	public void setNombreMoroso(String nombreMoroso) {
		this.nombreMoroso = nombreMoroso;
	}

	public String getTlfFijoMoroso() {
		return tlfFijoMoroso;
	}

	public void setTlfFijoMoroso(String tlfFijoMoroso) {
		this.tlfFijoMoroso = tlfFijoMoroso;
	}

	public String getTlfMovilMoroso() {
		return tlfMovilMoroso;
	}

	public void setTlfMovilMoroso(String tlfMovilMoroso) {
		this.tlfMovilMoroso = tlfMovilMoroso;
	}

	public String getFechaIniciaDemanda() {
		return fechaIniciaDemanda;
	}

	public void setFechaIniciaDemanda(String fechaIniciaDemanda) {
		this.fechaIniciaDemanda = fechaIniciaDemanda;
	}

	public String getUsernameFincas() {
		return usernameFincas;
	}

	public void setUsernameFincas(String usernameFincas) {
		this.usernameFincas = usernameFincas;
	}

	public Long getIdDemanda() {
		return idDemanda;
	}

	public void setIdDemanda(Long idDemanda) {
		this.idDemanda = idDemanda;
	}

	@Override
	public String toString() {
		return "DatosDemandaAdmin [montante=" + montante + ", rutaCertificado="
				+ rutaCertificado + ", direccionVivienda=" + direccionVivienda
				+ ", nombreMoroso=" + nombreMoroso + ", tlfFijoMoroso="
				+ tlfFijoMoroso + ", tlfMovilMoroso=" + tlfMovilMoroso
				+ ", fechaIniciaDemanda=" + fechaIniciaDemanda
				+ ", usernameFincas=" + usernameFincas + ", idDemanda="
				+ idDemanda + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((direccionVivienda == null) ? 0 : direccionVivienda
						.hashCode());
		result = prime
				* result
				+ ((fechaIniciaDemanda == null) ? 0 : fechaIniciaDemanda
						.hashCode());
		result = prime * result
				+ ((idDemanda == null) ? 0 : idDemanda.hashCode());
		result = prime * result
				+ ((montante == null) ? 0 : montante.hashCode());
		result = prime * result
				+ ((nombreMoroso == null) ? 0 : nombreMoroso.hashCode());
		result = prime * result
				+ ((rutaCertificado == null) ? 0 : rutaCertificado.hashCode());
		result = prime * result
				+ ((tlfFijoMoroso == null) ? 0 : tlfFijoMoroso.hashCode());
		result = prime * result
				+ ((tlfMovilMoroso == null) ? 0 : tlfMovilMoroso.hashCode());
		result = prime * result
				+ ((usernameFincas == null) ? 0 : usernameFincas.hashCode());
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
		DatosDemandaAdmin other = (DatosDemandaAdmin) obj;
		if (direccionVivienda == null) {
			if (other.direccionVivienda != null)
				return false;
		} else if (!direccionVivienda.equals(other.direccionVivienda))
			return false;
		if (fechaIniciaDemanda == null) {
			if (other.fechaIniciaDemanda != null)
				return false;
		} else if (!fechaIniciaDemanda.equals(other.fechaIniciaDemanda))
			return false;
		if (idDemanda == null) {
			if (other.idDemanda != null)
				return false;
		} else if (!idDemanda.equals(other.idDemanda))
			return false;
		if (montante == null) {
			if (other.montante != null)
				return false;
		} else if (!montante.equals(other.montante))
			return false;
		if (nombreMoroso == null) {
			if (other.nombreMoroso != null)
				return false;
		} else if (!nombreMoroso.equals(other.nombreMoroso))
			return false;
		if (rutaCertificado == null) {
			if (other.rutaCertificado != null)
				return false;
		} else if (!rutaCertificado.equals(other.rutaCertificado))
			return false;
		if (tlfFijoMoroso == null) {
			if (other.tlfFijoMoroso != null)
				return false;
		} else if (!tlfFijoMoroso.equals(other.tlfFijoMoroso))
			return false;
		if (tlfMovilMoroso == null) {
			if (other.tlfMovilMoroso != null)
				return false;
		} else if (!tlfMovilMoroso.equals(other.tlfMovilMoroso))
			return false;
		if (usernameFincas == null) {
			if (other.usernameFincas != null)
				return false;
		} else if (!usernameFincas.equals(other.usernameFincas))
			return false;
		return true;
	}

}