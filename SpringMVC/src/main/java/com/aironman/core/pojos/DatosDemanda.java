package com.aironman.core.pojos;

import java.math.BigDecimal;

public class DatosDemanda implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6881242488895918782L;

	public static enum ESTADO_DEMANDA {
		ENVIADA_A_JURIDIA, ASIGNADA_A_ABOGADO, CERRADA
	};

	private String urlCertificado;
	private String nombreComunidad;
	private String direccionComunidad;
	private String refCatastral;
	private ESTADO_DEMANDA estadoDemanda;
	private String nombreMoroso;
	private BigDecimal montante;

	public DatosDemanda(String urlCertificado, String nombreComunidad,
			String direccionComunidad, String refCatastral,
			ESTADO_DEMANDA estadoDemanda, String nombreMoroso,
			BigDecimal montante) {
		super();
		this.urlCertificado = urlCertificado;
		this.nombreComunidad = nombreComunidad;
		this.direccionComunidad = direccionComunidad;
		this.refCatastral = refCatastral;
		this.estadoDemanda = estadoDemanda;
		this.nombreMoroso = nombreMoroso;
		this.montante = montante;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	public void setMontante(BigDecimal montante) {
		this.montante = montante;
	}

	public String getUrlCertificado() {
		return urlCertificado;
	}

	public void setUrlCertificado(String urlCertificado) {
		this.urlCertificado = urlCertificado;
	}

	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public String getDireccionComunidad() {
		return direccionComunidad;
	}

	public void setDireccionComunidad(String direccionComunidad) {
		this.direccionComunidad = direccionComunidad;
	}

	public String getRefCatastral() {
		return refCatastral;
	}

	public void setRefCatastral(String refCatastral) {
		this.refCatastral = refCatastral;
	}

	public ESTADO_DEMANDA getEstadoDemanda() {
		return estadoDemanda;
	}

	public void setEstadoDemanda(ESTADO_DEMANDA estadoDemanda) {
		this.estadoDemanda = estadoDemanda;
	}

	public String getNombreMoroso() {
		return nombreMoroso;
	}

	public void setNombreMoroso(String nombreMoroso) {
		this.nombreMoroso = nombreMoroso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((direccionComunidad == null) ? 0 : direccionComunidad
						.hashCode());
		result = prime * result
				+ ((estadoDemanda == null) ? 0 : estadoDemanda.hashCode());
		result = prime * result
				+ ((montante == null) ? 0 : montante.hashCode());
		result = prime * result
				+ ((nombreComunidad == null) ? 0 : nombreComunidad.hashCode());
		result = prime * result
				+ ((nombreMoroso == null) ? 0 : nombreMoroso.hashCode());
		result = prime * result
				+ ((refCatastral == null) ? 0 : refCatastral.hashCode());
		result = prime * result
				+ ((urlCertificado == null) ? 0 : urlCertificado.hashCode());
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
		DatosDemanda other = (DatosDemanda) obj;
		if (direccionComunidad == null) {
			if (other.direccionComunidad != null)
				return false;
		} else if (!direccionComunidad.equals(other.direccionComunidad))
			return false;
		if (estadoDemanda != other.estadoDemanda)
			return false;
		if (montante == null) {
			if (other.montante != null)
				return false;
		} else if (!montante.equals(other.montante))
			return false;
		if (nombreComunidad == null) {
			if (other.nombreComunidad != null)
				return false;
		} else if (!nombreComunidad.equals(other.nombreComunidad))
			return false;
		if (nombreMoroso == null) {
			if (other.nombreMoroso != null)
				return false;
		} else if (!nombreMoroso.equals(other.nombreMoroso))
			return false;
		if (refCatastral == null) {
			if (other.refCatastral != null)
				return false;
		} else if (!refCatastral.equals(other.refCatastral))
			return false;
		if (urlCertificado == null) {
			if (other.urlCertificado != null)
				return false;
		} else if (!urlCertificado.equals(other.urlCertificado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatosDemanda [urlCertificado=" + urlCertificado
				+ ", nombreComunidad=" + nombreComunidad
				+ ", direccionComunidad=" + direccionComunidad
				+ ", refCatastral=" + refCatastral + ", estadoDemanda="
				+ estadoDemanda + ", nombreMoroso=" + nombreMoroso
				+ ", montante=" + montante + "]";
	}

}