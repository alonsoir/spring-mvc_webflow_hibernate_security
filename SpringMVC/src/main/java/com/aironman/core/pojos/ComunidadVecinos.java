package com.aironman.core.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMUNIDADVECINOS")
public class ComunidadVecinos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8572092475498343895L;

	public enum TIPO_COMUNIDAD {
		URBANA("0"), RUSTICA("1");

		private final String displayName;

		private TIPO_COMUNIDAD(String displayName) {
			this.displayName = displayName;
		}

		@Override
		public String toString() {
			return displayName;
		}

	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOMUNIDAD")
	private Long idComunidad;

	@Column(name = "REFCATASTRAL", length = 20, nullable = true, unique = false)
	private String refCatastral;

	@Column(name = "CIUDAD", length = 20, nullable = true)
	private String ciudad;

	@Column(name = "CP", length = 5, nullable = false)
	private String cp;

	@Column(name = "TIPO_PARCELA", length = 1)
	private TIPO_COMUNIDAD tipoParcela;

	@Column(name = "NOMBRECOMUNIDAD", nullable = false)
	private String nombreComunidad;

	@Column(name = "DIRECCION", length = 100, nullable = false)
	private String direccion;

	@Column(name = "PRESIDENTE", length = 25, nullable = true)
	private String presidenteCC;

	@Column(name = "ADMINFINCAS", length = 25, nullable = false)
	private String administradorFincas;

	@OneToMany(mappedBy = "comunidad")
	private Collection<ViviendasConDeudas> viviendas = new ArrayList<ViviendasConDeudas>();

	@ManyToOne(fetch = FetchType.LAZY)
	private JuntasOrdinarias junta;

	@ManyToOne(fetch = FetchType.LAZY)
	private Users usuario;

	public Long getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(Long idComunidad) {
		this.idComunidad = idComunidad;
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	public String getRefCatastral() {
		return refCatastral;
	}

	public void setRefCatastral(String refCatastral) {
		this.refCatastral = refCatastral;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public TIPO_COMUNIDAD getTipoParcela() {
		return tipoParcela;
	}

	public void setTipoParcela(TIPO_COMUNIDAD tipoParcela) {
		this.tipoParcela = tipoParcela;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Collection<ViviendasConDeudas> getViviendas() {
		return viviendas;
	}

	public void setViviendas(Collection<ViviendasConDeudas> viviendas) {
		this.viviendas = viviendas;
	}

	public String getPresidenteCC() {
		return presidenteCC;
	}

	public void setPresidenteCC(String presidenteCC) {
		this.presidenteCC = presidenteCC;
	}

	public String getAdministradorFincas() {
		return administradorFincas;
	}

	public void setAdministradorFincas(String administradorFincas) {
		this.administradorFincas = administradorFincas;
	}

	public JuntasOrdinarias getJunta() {
		return junta;
	}

	public void setJunta(JuntasOrdinarias junta) {
		this.junta = junta;
	}

	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((administradorFincas == null) ? 0 : administradorFincas
						.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result
				+ ((idComunidad == null) ? 0 : idComunidad.hashCode());
		result = prime * result + ((junta == null) ? 0 : junta.hashCode());
		result = prime * result
				+ ((nombreComunidad == null) ? 0 : nombreComunidad.hashCode());
		result = prime * result
				+ ((presidenteCC == null) ? 0 : presidenteCC.hashCode());
		result = prime * result
				+ ((refCatastral == null) ? 0 : refCatastral.hashCode());
		result = prime * result
				+ ((tipoParcela == null) ? 0 : tipoParcela.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result
				+ ((viviendas == null) ? 0 : viviendas.hashCode());
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
		ComunidadVecinos other = (ComunidadVecinos) obj;
		if (administradorFincas == null) {
			if (other.administradorFincas != null)
				return false;
		} else if (!administradorFincas.equals(other.administradorFincas))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idComunidad == null) {
			if (other.idComunidad != null)
				return false;
		} else if (!idComunidad.equals(other.idComunidad))
			return false;
		if (junta == null) {
			if (other.junta != null)
				return false;
		} else if (!junta.equals(other.junta))
			return false;
		if (nombreComunidad == null) {
			if (other.nombreComunidad != null)
				return false;
		} else if (!nombreComunidad.equals(other.nombreComunidad))
			return false;
		if (presidenteCC == null) {
			if (other.presidenteCC != null)
				return false;
		} else if (!presidenteCC.equals(other.presidenteCC))
			return false;
		if (refCatastral == null) {
			if (other.refCatastral != null)
				return false;
		} else if (!refCatastral.equals(other.refCatastral))
			return false;
		if (tipoParcela != other.tipoParcela)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (viviendas == null) {
			if (other.viviendas != null)
				return false;
		} else if (!viviendas.equals(other.viviendas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComunidadVecinos [idComunidad=" + idComunidad
				+ ", refCatastral=" + refCatastral + ", ciudad=" + ciudad
				+ ", cp=" + cp + ", tipoParcela=" + tipoParcela
				+ ", nombreComunidad=" + nombreComunidad + ", direccion="
				+ direccion + ", presidenteCC=" + presidenteCC
				+ ", administradorFincas=" + administradorFincas + ", usuario="
				+ usuario + "]";
	}

}