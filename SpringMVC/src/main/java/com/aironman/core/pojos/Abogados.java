package com.aironman.core.pojos;

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
@Table(name = "ABOGADOS")
public class Abogados implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6101101103710630557L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDABOGADO")
	private Long idAbogado;

	@Column(name = "NOMBRE", length = 20)
	private String nombre;

	@Column(name = "APELLIDOS", length = 50)
	private String apellidos;

	@Column(name = "CIUDAD", length = 20)
	private String ciudad;

	@Column(name = "CP", length = 5)
	private String cp;

	@Column(name = "DIRECCION", length = 100)
	private String direccion;

	@Column(name = "TLF")
	private String tlfContacto;

	@OneToMany(mappedBy = "abogado")
	private Collection<Demandas> demandas = new ArrayList<Demandas>();

	public Long getIdAbogado() {
		return idAbogado;
	}

	public void setIdAbogado(Long idAbogado) {
		this.idAbogado = idAbogado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTlfContacto() {
		return tlfContacto;
	}

	public void setTlfContacto(String tlfContacto) {
		this.tlfContacto = tlfContacto;
	}

	public Collection<Demandas> getDemandas() {
		return demandas;
	}

	public void setDemandas(Collection<Demandas> demandas) {
		this.demandas = demandas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result
				+ ((demandas == null) ? 0 : demandas.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result
				+ ((idAbogado == null) ? 0 : idAbogado.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((tlfContacto == null) ? 0 : tlfContacto.hashCode());
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
		Abogados other = (Abogados) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
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
		if (demandas == null) {
			if (other.demandas != null)
				return false;
		} else if (!demandas.equals(other.demandas))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (idAbogado == null) {
			if (other.idAbogado != null)
				return false;
		} else if (!idAbogado.equals(other.idAbogado))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tlfContacto == null) {
			if (other.tlfContacto != null)
				return false;
		} else if (!tlfContacto.equals(other.tlfContacto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Abogados [idAbogado=" + idAbogado + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", ciudad=" + ciudad + ", cp="
				+ cp + ", direccion=" + direccion + ", tlfContacto="
				+ tlfContacto;
	}

}