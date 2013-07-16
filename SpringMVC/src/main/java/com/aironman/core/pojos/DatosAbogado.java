package com.aironman.core.pojos;

public class DatosAbogado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4216071852304463284L;

	private Long idAbogado;

	private String nombre;

	private String apellidos;

	private String ciudad;

	private String cp;

	private String direccion;

	private String tlfContacto;

	public DatosAbogado(Long idAbogado, String nombre, String apellidos,
			String ciudad, String cp, String direccion, String tlfContacto) {
		super();
		this.idAbogado = idAbogado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.cp = cp;
		this.direccion = direccion;
		this.tlfContacto = tlfContacto;
	}

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

	@Override
	public String toString() {
		return "DatosAbogado [idAbogado=" + idAbogado + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", ciudad=" + ciudad + ", cp="
				+ cp + ", direccion=" + direccion + ", tlfContacto="
				+ tlfContacto + "]";
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
		DatosAbogado other = (DatosAbogado) obj;
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

}