package com.aironman.core.pojos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7156022020456062249L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USERNAME", unique = true)
	private String userName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private boolean enabled;

	@Column(name = "CREATED_ON", nullable = true)
	private Date createdOn;

	@Transient
	@Column(name = "LAST_LOGIN_ON", nullable = true)
	private Date lastLoginOn;

	@OneToMany(mappedBy = "usuario")
	private final Collection<ComunidadVecinos> comunidades = new ArrayList<ComunidadVecinos>();

	@OneToMany(mappedBy = "usuario")
	private final Collection<Demandas> demandasContratadas = new ArrayList<Demandas>();

	@OneToMany(mappedBy = "usuario")
	private final Collection<Abogados> abogados = new ArrayList<Abogados>();

	public Users() {
	}

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<ComunidadVecinos> getComunidades() {
		return comunidades;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastLoginOn() {
		return lastLoginOn;
	}

	public void setLastLoginOn(Date lastLoginOn) {
		this.lastLoginOn = lastLoginOn;
	}

	public Collection<Demandas> getDemandasContratadas() {
		return demandasContratadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((abogados == null) ? 0 : abogados.hashCode());
		result = prime * result
				+ ((comunidades == null) ? 0 : comunidades.hashCode());
		result = prime * result
				+ ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime
				* result
				+ ((demandasContratadas == null) ? 0 : demandasContratadas
						.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result
				+ ((lastLoginOn == null) ? 0 : lastLoginOn.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		Users other = (Users) obj;
		if (abogados == null) {
			if (other.abogados != null)
				return false;
		} else if (!abogados.equals(other.abogados))
			return false;
		if (comunidades == null) {
			if (other.comunidades != null)
				return false;
		} else if (!comunidades.equals(other.comunidades))
			return false;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (demandasContratadas == null) {
			if (other.demandasContratadas != null)
				return false;
		} else if (!demandasContratadas.equals(other.demandasContratadas))
			return false;
		if (enabled != other.enabled)
			return false;
		if (lastLoginOn == null) {
			if (other.lastLoginOn != null)
				return false;
		} else if (!lastLoginOn.equals(other.lastLoginOn))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", enabled=" + enabled
				+ ", createdOn=" + createdOn + ", lastLoginOn=" + lastLoginOn
				+ ", comunidades=" + comunidades + ", demandasContratadas="
				+ demandasContratadas + ", abogados=" + abogados + "]";
	}

}
