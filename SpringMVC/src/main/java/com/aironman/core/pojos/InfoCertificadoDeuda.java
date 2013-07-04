package com.aironman.core.pojos;

public class InfoCertificadoDeuda implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8154877087575495L;
	private String cp = null;
	private String direccionMoroso = null;
	private String nif = null;
	private String nombre = null;
	private String tlf = null;
	private String ciudadMoroso = null;
	private String ciudadComunidad = null;
	private String nombreComunidad = null;
	private String direccionComunidad = null;
	private String adminComunidad = null;
	private String presi = null;
	private String fechaCelebracion = null;
	private String textoLibre = null;

	private String estado = null;

	public InfoCertificadoDeuda() {

	}

	public InfoCertificadoDeuda(String cp, String direccionMoroso, String nif,
			String nombre, String tlf, String ciudadMoroso,
			String ciudadComunidad, String nombreComunidad,
			String direccionComunidad, String adminComunidad, String presi,
			String fechaCelebracion, String textoLibre) {
		super();
		this.cp = cp;
		this.direccionMoroso = direccionMoroso;
		this.nif = nif;
		this.nombre = nombre;
		this.tlf = tlf;
		this.ciudadMoroso = ciudadMoroso;
		this.ciudadComunidad = ciudadComunidad;
		this.nombreComunidad = nombreComunidad;
		this.direccionComunidad = direccionComunidad;
		this.adminComunidad = adminComunidad;
		this.presi = presi;
		this.fechaCelebracion = fechaCelebracion;
		this.textoLibre = textoLibre;
	}

	public void setEstado(String estado) {

		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setDireccionMoroso(String direccionMoroso) {
		this.direccionMoroso = direccionMoroso;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public void setCiudadMoroso(String ciudadMoroso) {
		this.ciudadMoroso = ciudadMoroso;
	}

	public void setCiudadComunidad(String ciudadComunidad) {
		this.ciudadComunidad = ciudadComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public void setDireccionComunidad(String direccionComunidad) {
		this.direccionComunidad = direccionComunidad;
	}

	public void setAdminComunidad(String adminComunidad) {
		this.adminComunidad = adminComunidad;
	}

	public void setPresi(String presi) {
		this.presi = presi;
	}

	public void setFechaCelebracion(String fechaCelebracion) {
		this.fechaCelebracion = fechaCelebracion;
	}

	public void setTextoLibre(String textoLibre) {
		this.textoLibre = textoLibre;
	}

	public String getCp() {
		return cp;
	}

	public String getDireccionMoroso() {
		return direccionMoroso;
	}

	public String getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTlf() {
		return tlf;
	}

	public String getCiudadMoroso() {
		return ciudadMoroso;
	}

	public String getCiudadComunidad() {
		return ciudadComunidad;
	}

	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public String getDireccionComunidad() {
		return direccionComunidad;
	}

	public String getAdminComunidad() {
		return adminComunidad;
	}

	public String getPresi() {
		return presi;
	}

	public String getFechaCelebracion() {
		return fechaCelebracion;
	}

	public String getTextoLibre() {
		return textoLibre;
	}

	@Override
	public String toString() {
		return "InfoCertificadoDeuda [cp=" + cp + ", direccionMoroso="
				+ direccionMoroso + ", nif=" + nif + ", nombre=" + nombre
				+ ", tlf=" + tlf + ", ciudadMoroso=" + ciudadMoroso
				+ ", ciudadComunidad=" + ciudadComunidad + ", nombreComunidad="
				+ nombreComunidad + ", direccionComunidad="
				+ direccionComunidad + ", adminComunidad=" + adminComunidad
				+ ", presi=" + presi + ", fechaCelebracion=" + fechaCelebracion
				+ ", textoLibre=" + textoLibre + "]";
	}

}