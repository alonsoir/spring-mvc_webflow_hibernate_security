package com.aironman.core.pojos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
@Table(name = "DEMANDAS")
public class Demandas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8286587390749463972L;

	// Ojo, que estos estados seguramente ser‡n insuficientes. Preguntar a Jorge
	public enum ESTADO_DEMANDA {
		ENVIADA_A_JURIDIA, ASIGNADA_A_ABOGADO, CERRADA
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDEMANDA")
	private Long idDemanda;

	@Column(name = "TIPO", length = 1)
	private ESTADO_DEMANDA estado;

	@Column(name = "TEXTOLIBRE", nullable = true)
	private String textoLibreDemanda;

	@Column(name = "FECHAINICIO", nullable = false)
	private Date fechaInicio;

	@Column(name = "FECHAFIN", nullable = true)
	private Date fechaFin;

	@OneToMany(mappedBy = "demanda")
	private Collection<HistoricoDemandasViviendasAdeudadas> historicoDemanda = new ArrayList<HistoricoDemandasViviendasAdeudadas>();

	@ManyToOne(fetch = FetchType.LAZY)
	private Abogados abogado;

	// es el usuario logado en el sistema, el usuario que quiere contratar a
	// jorge para llevar esta demanda
	@ManyToOne(fetch = FetchType.LAZY)
	private Users usuario;

	public Long getIdDemanda() {
		return idDemanda;
	}

	public void setIdDemanda(Long idDemanda) {
		this.idDemanda = idDemanda;
	}

	public String getTextoLibreDemanda() {
		return textoLibreDemanda;
	}

	public void setTextoLibreDemanda(String textoLibreDemanda) {
		this.textoLibreDemanda = textoLibreDemanda;
	}

	public Abogados getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogados abogado) {
		this.abogado = abogado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Collection<HistoricoDemandasViviendasAdeudadas> getHistoricoDemanda() {
		return historicoDemanda;
	}

	public void setHistoricoDemanda(
			Collection<HistoricoDemandasViviendasAdeudadas> historicoDemanda) {
		this.historicoDemanda = historicoDemanda;
	}

	public ESTADO_DEMANDA getEstado() {
		return estado;
	}

	public void setEstado(ESTADO_DEMANDA estado) {
		this.estado = estado;
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abogado == null) ? 0 : abogado.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result
				+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime
				* result
				+ ((historicoDemanda == null) ? 0 : historicoDemanda.hashCode());
		result = prime * result
				+ ((idDemanda == null) ? 0 : idDemanda.hashCode());
		result = prime
				* result
				+ ((textoLibreDemanda == null) ? 0 : textoLibreDemanda
						.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Demandas other = (Demandas) obj;
		if (abogado == null) {
			if (other.abogado != null)
				return false;
		} else if (!abogado.equals(other.abogado))
			return false;
		if (estado != other.estado)
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (historicoDemanda == null) {
			if (other.historicoDemanda != null)
				return false;
		} else if (!historicoDemanda.equals(other.historicoDemanda))
			return false;
		if (idDemanda == null) {
			if (other.idDemanda != null)
				return false;
		} else if (!idDemanda.equals(other.idDemanda))
			return false;
		if (textoLibreDemanda == null) {
			if (other.textoLibreDemanda != null)
				return false;
		} else if (!textoLibreDemanda.equals(other.textoLibreDemanda))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Demandas [idDemanda=" + idDemanda + ", estado=" + estado
				+ ", textoLibreDemanda=" + textoLibreDemanda + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin
				+ ", historicoDemanda=" + historicoDemanda + ", abogado="
				+ abogado + ", usuario=" + usuario + "]";
	}

}