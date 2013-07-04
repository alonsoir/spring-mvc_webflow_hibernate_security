package com.aironman.core.configuration;

public class CertificadosBean {

	private String DIRECTORIO_DESPLIEGUE;
	private String RUTA_PLANTILLA;
	private String RUTA_CONEXION_DB;
	private String USUARIO_DB;
	private String PASS_DB;

	public CertificadosBean() {

	}

	public CertificadosBean(String dIRECTORIO_DESPLIEGUE,
			String rUTA_PLANTILLA, String rUTA_CONEXION_DB, String uSUARIO_DB,
			String pASS_DB) {
		DIRECTORIO_DESPLIEGUE = dIRECTORIO_DESPLIEGUE;
		RUTA_PLANTILLA = rUTA_PLANTILLA;
		RUTA_CONEXION_DB = rUTA_CONEXION_DB;
		USUARIO_DB = uSUARIO_DB;
		PASS_DB = pASS_DB;
	}

	public String getRUTA_CONEXION_DB() {
		return RUTA_CONEXION_DB;
	}

	public void setRUTA_CONEXION_DB(String rUTA_CONEXION_DB) {
		RUTA_CONEXION_DB = rUTA_CONEXION_DB;
	}

	public String getUSUARIO_DB() {
		return USUARIO_DB;
	}

	public void setUSUARIO_DB(String uSUARIO_DB) {
		USUARIO_DB = uSUARIO_DB;
	}

	public String getPASS_DB() {
		return PASS_DB;
	}

	public void setPASS_DB(String pASS_DB) {
		PASS_DB = pASS_DB;
	}

	public String getDIRECTORIO_DESPLIEGUE() {
		return DIRECTORIO_DESPLIEGUE;
	}

	public void setDIRECTORIO_DESPLIEGUE(String dIRECTORIO_DESPLIEGUE) {
		DIRECTORIO_DESPLIEGUE = dIRECTORIO_DESPLIEGUE;
	}

	public String getRUTA_PLANTILLA() {
		return RUTA_PLANTILLA;
	}

	public void setRUTA_PLANTILLA(String rUTA_PLANTILLA) {
		RUTA_PLANTILLA = rUTA_PLANTILLA;
	}

	@Override
	public String toString() {
		return "CertificadosBean [DIRECTORIO_DESPLIEGUE="
				+ DIRECTORIO_DESPLIEGUE + ", RUTA_PLANTILLA=" + RUTA_PLANTILLA
				+ ", RUTA_CONEXION_DB=" + RUTA_CONEXION_DB + ", USUARIO_DB="
				+ USUARIO_DB + ", PASS_DB=" + PASS_DB + "]";
	}

}
