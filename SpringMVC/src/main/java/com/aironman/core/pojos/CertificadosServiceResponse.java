package com.aironman.core.pojos;

import java.io.Serializable;

/**
 * Esta clase va a ser la respuesta para todos los metodos addSERVICIO_X
 * */
public class CertificadosServiceResponse extends ServiceResponse implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -709719752866764237L;
	private String rutaPdf;
	private String rutaHtml;
	private String rutaDoc;

	public CertificadosServiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CertificadosServiceResponse(String mensaje, Boolean estado) {
		super(mensaje, estado);
	}

	public CertificadosServiceResponse(String mensaje, Boolean estado,
			String rutaPdf, String rutaHtml, String rutaDoc) {
		super(mensaje, estado);
		this.rutaPdf = rutaPdf;
		this.rutaHtml = rutaHtml;
		this.rutaDoc = rutaDoc;
	}

	public String getRutaPdf() {
		return rutaPdf;
	}

	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}

	public String getRutaHtml() {
		return rutaHtml;
	}

	public void setRutaHtml(String rutaHtml) {
		this.rutaHtml = rutaHtml;
	}

	public String getRutaDoc() {
		return rutaDoc;
	}

	public void setRutaDoc(String rutaDoc) {
		this.rutaDoc = rutaDoc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((rutaDoc == null) ? 0 : rutaDoc.hashCode());
		result = prime * result
				+ ((rutaHtml == null) ? 0 : rutaHtml.hashCode());
		result = prime * result + ((rutaPdf == null) ? 0 : rutaPdf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CertificadosServiceResponse other = (CertificadosServiceResponse) obj;
		if (rutaDoc == null) {
			if (other.rutaDoc != null)
				return false;
		} else if (!rutaDoc.equals(other.rutaDoc))
			return false;
		if (rutaHtml == null) {
			if (other.rutaHtml != null)
				return false;
		} else if (!rutaHtml.equals(other.rutaHtml))
			return false;
		if (rutaPdf == null) {
			if (other.rutaPdf != null)
				return false;
		} else if (!rutaPdf.equals(other.rutaPdf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CertificadosServiceResponse [rutaPdf=" + rutaPdf
				+ ", rutaHtml=" + rutaHtml + ", rutaDoc=" + rutaDoc + "]";
	}

}
