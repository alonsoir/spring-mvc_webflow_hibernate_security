package com.aironman.core.pojos;

import java.io.Serializable;

/**
 * Esta clase va a ser la respuesta para todos los metodos addSERVICIO_X
 * */
public class ServiceResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4903575905248408627L;
	private String mensaje;
	private Boolean estado;
	private Long idGenerado;

	public ServiceResponse() {

	}

	public ServiceResponse(String mensaje, Boolean estado) {
		this.mensaje = mensaje;
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Long getIdGenerado() {
		return idGenerado;
	}

	public void setIdGenerado(Long idGenerado) {
		this.idGenerado = idGenerado;
	}

	@Override
	public String toString() {
		return "ServiceResponse [mensaje=" + mensaje + ", estado=" + estado
				+ ", idGenerado=" + idGenerado + "]";
	}

}
