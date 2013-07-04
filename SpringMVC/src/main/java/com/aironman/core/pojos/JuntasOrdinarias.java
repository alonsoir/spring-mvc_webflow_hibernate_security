package com.aironman.core.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JUNTAS_ORDINARIAS")
public class JuntasOrdinarias implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4817222551858288855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDJUNTA")
	private Long idJunta;

	@Column(name = "FECHACELEBRACION", length = 25, nullable = true)
	private String fechaCelebracion;

	@Column(name = "TEXTOLIBRE", length = 255, nullable = true)
	private String textoLibre;

	@OneToMany(mappedBy = "junta")
	private Collection<ComunidadVecinos> comunidad = new ArrayList<ComunidadVecinos>();

	public String getFechaCelebracion() {
		return fechaCelebracion;
	}

	public void setFechaCelebracion(String fechaCelebracion) {
		this.fechaCelebracion = fechaCelebracion;
	}

	public Long getIdJunta() {
		return idJunta;
	}

	public void setIdJunta(Long idJunta) {
		this.idJunta = idJunta;
	}

	public String getTextoLibre() {
		return textoLibre;
	}

	public void setTextoLibre(String textoLibre) {
		this.textoLibre = textoLibre;
	}

	public Collection<ComunidadVecinos> getComunidad() {
		return comunidad;
	}

	public void setComunidad(Collection<ComunidadVecinos> comunidad) {
		this.comunidad = comunidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comunidad == null) ? 0 : comunidad.hashCode());
		result = prime
				* result
				+ ((fechaCelebracion == null) ? 0 : fechaCelebracion.hashCode());
		result = prime * result + ((idJunta == null) ? 0 : idJunta.hashCode());
		result = prime * result
				+ ((textoLibre == null) ? 0 : textoLibre.hashCode());
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
		JuntasOrdinarias other = (JuntasOrdinarias) obj;
		if (comunidad == null) {
			if (other.comunidad != null)
				return false;
		} else if (!comunidad.equals(other.comunidad))
			return false;
		if (fechaCelebracion == null) {
			if (other.fechaCelebracion != null)
				return false;
		} else if (!fechaCelebracion.equals(other.fechaCelebracion))
			return false;
		if (idJunta == null) {
			if (other.idJunta != null)
				return false;
		} else if (!idJunta.equals(other.idJunta))
			return false;
		if (textoLibre == null) {
			if (other.textoLibre != null)
				return false;
		} else if (!textoLibre.equals(other.textoLibre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JuntasOrdinarias [idJunta=" + idJunta + ", fechaCelebracion="
				+ fechaCelebracion + ", textoLibre=" + textoLibre;
	}

}
