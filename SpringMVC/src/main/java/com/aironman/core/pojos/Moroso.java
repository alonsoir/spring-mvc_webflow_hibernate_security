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
@Table(name = "MOROSO")
public class Moroso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2095065620165430791L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDMOROSO")
	private Long idMoroso;

	@Column(name = "NIFCIF", length = 9, unique = true)
	private String nifCif;

	@Column(name = "TLF_FIJO", length = 11)
	private String tlffijo;

	@Column(name = "TLF_MOVIL", length = 11)
	private String tlfmovil;

	@Column(name = "CP", length = 5)
	private String cp;

	@Column(name = "NOMBRE", length = 25)
	private String nombreCompleto;

	@Column(name = "CIUDAD", length = 25)
	private String ciudad;

	@Column(name = "DIRECCION", length = 50)
	private String direccionMoroso;

	// @ReadOnly
	@OneToMany(mappedBy = "moroso")
	private Collection<ViviendasConDeudas> deudas = new ArrayList<ViviendasConDeudas>();

	public String getTlffijo() {
		return tlffijo;
	}

	public void setTlffijo(String tlffijo) {
		this.tlffijo = tlffijo;
	}

	public String getTlfmovil() {
		return tlfmovil;
	}

	public void setTlfmovil(String tlfmovil) {
		this.tlfmovil = tlfmovil;
	}

	public Long getIdMoroso() {
		return idMoroso;
	}

	public void setIdMoroso(Long idMoroso) {
		this.idMoroso = idMoroso;
	}

	public String getNifCif() {
		return nifCif;
	}

	public void setNifCif(String nifCif) {
		this.nifCif = nifCif;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Collection<ViviendasConDeudas> getDeudas() {
		return deudas;
	}

	public void setDeudas(Collection<ViviendasConDeudas> deudas) {
		this.deudas = deudas;
	}

	public String getDireccionMoroso() {
		return direccionMoroso;
	}

	public void setDireccionMoroso(String direccionMoroso) {
		this.direccionMoroso = direccionMoroso;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((deudas == null) ? 0 : deudas.hashCode());
		result = prime * result
				+ ((direccionMoroso == null) ? 0 : direccionMoroso.hashCode());
		result = prime * result
				+ ((idMoroso == null) ? 0 : idMoroso.hashCode());
		result = prime * result + ((nifCif == null) ? 0 : nifCif.hashCode());
		result = prime * result
				+ ((nombreCompleto == null) ? 0 : nombreCompleto.hashCode());
		result = prime * result + ((tlffijo == null) ? 0 : tlffijo.hashCode());
		result = prime * result
				+ ((tlfmovil == null) ? 0 : tlfmovil.hashCode());
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
		Moroso other = (Moroso) obj;
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
		if (deudas == null) {
			if (other.deudas != null)
				return false;
		} else if (!deudas.equals(other.deudas))
			return false;
		if (direccionMoroso == null) {
			if (other.direccionMoroso != null)
				return false;
		} else if (!direccionMoroso.equals(other.direccionMoroso))
			return false;
		if (idMoroso == null) {
			if (other.idMoroso != null)
				return false;
		} else if (!idMoroso.equals(other.idMoroso))
			return false;
		if (nifCif == null) {
			if (other.nifCif != null)
				return false;
		} else if (!nifCif.equals(other.nifCif))
			return false;
		if (nombreCompleto == null) {
			if (other.nombreCompleto != null)
				return false;
		} else if (!nombreCompleto.equals(other.nombreCompleto))
			return false;
		if (tlffijo == null) {
			if (other.tlffijo != null)
				return false;
		} else if (!tlffijo.equals(other.tlffijo))
			return false;
		if (tlfmovil == null) {
			if (other.tlfmovil != null)
				return false;
		} else if (!tlfmovil.equals(other.tlfmovil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Moroso [idMoroso=" + idMoroso + ", nifCif=" + nifCif
				+ ", tlffijo=" + tlffijo + ", tlfmovil=" + tlfmovil + ", cp="
				+ cp + ", nombreCompleto=" + nombreCompleto + ", ciudad="
				+ ciudad + ", direccionMoroso=" + direccionMoroso + ", deudas="
				+ deudas + "]";
	}

}