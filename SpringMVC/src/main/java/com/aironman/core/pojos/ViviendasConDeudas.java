package com.aironman.core.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VIVIENDASCONDEUDAS")
public class ViviendasConDeudas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5594620866658796808L;

	public enum TIPOVIVIENDA {
		PISO, LOCAL, APARTAMENTO, ATICO, DUPLEX, LOFT, VILLA, CHALET, PALACIO, BUNGALOW, PREFABRICADO, BARRACA, CORTIJO, DACHA, IGLU, ISBA, PALAFITO, RUCA, TIPI, YURTA, RANCHO, HACIENDA, ESTANCIA, MASIA, PROTECCION_PUBLICA
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDEUDA")
	private Long idDeuda;

	@Column(name = "MONTANTE", length = 10)
	private BigDecimal montante;

	@Column(name = "DIRECCION_VIV_DEUDORA", length = 100, nullable = false)
	private String direccionViviendaDeudora;

	@Column(name = "TIPO", length = 1)
	private TIPOVIVIENDA tipo;

	@Column(name = "TEXTOLIBRE", length = 255, nullable = true)
	private String textoLibreViviendasConDeudas;

	@OneToMany(mappedBy = "deudora")
	private Collection<HistoricoDemandasViviendasAdeudadas> historicoDemanda = new ArrayList<HistoricoDemandasViviendasAdeudadas>();

	@ManyToOne(fetch = FetchType.LAZY)
	private ComunidadVecinos comunidad;

	@ManyToOne(fetch = FetchType.LAZY)
	private Moroso moroso;

	public Long getIdDeuda() {
		return idDeuda;
	}

	public void setIdDeuda(Long idDeuda) {
		this.idDeuda = idDeuda;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	public void setMontante(BigDecimal montante) {
		this.montante = montante;
	}

	public TIPOVIVIENDA getTipo() {
		return tipo;
	}

	public void setTipo(TIPOVIVIENDA tipo) {
		this.tipo = tipo;
	}

	public ComunidadVecinos getComunidad() {
		return comunidad;
	}

	public void setComunidad(ComunidadVecinos comunidad) {
		this.comunidad = comunidad;
	}

	public Moroso getMoroso() {
		return moroso;
	}

	public void setMoroso(Moroso moroso) {
		this.moroso = moroso;
	}

	public String getDireccionViviendaDeudora() {
		return direccionViviendaDeudora;
	}

	public void setDireccionViviendaDeudora(String direccionViviendaDeudora) {
		this.direccionViviendaDeudora = direccionViviendaDeudora;
	}

	public String getTextoLibreViviendasConDeudas() {
		return textoLibreViviendasConDeudas;
	}

	public void setTextoLibreViviendasConDeudas(
			String textoLibreViviendasConDeudas) {
		this.textoLibreViviendasConDeudas = textoLibreViviendasConDeudas;
	}

	public Collection<HistoricoDemandasViviendasAdeudadas> getHistoricoDemanda() {
		return historicoDemanda;
	}

	public void setHistoricoDemanda(
			Collection<HistoricoDemandasViviendasAdeudadas> historicoDemanda) {
		this.historicoDemanda = historicoDemanda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comunidad == null) ? 0 : comunidad.hashCode());
		result = prime
				* result
				+ ((direccionViviendaDeudora == null) ? 0
						: direccionViviendaDeudora.hashCode());
		result = prime
				* result
				+ ((historicoDemanda == null) ? 0 : historicoDemanda.hashCode());
		result = prime * result + ((idDeuda == null) ? 0 : idDeuda.hashCode());
		result = prime * result
				+ ((montante == null) ? 0 : montante.hashCode());
		result = prime * result + ((moroso == null) ? 0 : moroso.hashCode());
		result = prime
				* result
				+ ((textoLibreViviendasConDeudas == null) ? 0
						: textoLibreViviendasConDeudas.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		ViviendasConDeudas other = (ViviendasConDeudas) obj;
		if (comunidad == null) {
			if (other.comunidad != null)
				return false;
		} else if (!comunidad.equals(other.comunidad))
			return false;
		if (direccionViviendaDeudora == null) {
			if (other.direccionViviendaDeudora != null)
				return false;
		} else if (!direccionViviendaDeudora
				.equals(other.direccionViviendaDeudora))
			return false;
		if (historicoDemanda == null) {
			if (other.historicoDemanda != null)
				return false;
		} else if (!historicoDemanda.equals(other.historicoDemanda))
			return false;
		if (idDeuda == null) {
			if (other.idDeuda != null)
				return false;
		} else if (!idDeuda.equals(other.idDeuda))
			return false;
		if (montante == null) {
			if (other.montante != null)
				return false;
		} else if (!montante.equals(other.montante))
			return false;
		if (moroso == null) {
			if (other.moroso != null)
				return false;
		} else if (!moroso.equals(other.moroso))
			return false;
		if (textoLibreViviendasConDeudas == null) {
			if (other.textoLibreViviendasConDeudas != null)
				return false;
		} else if (!textoLibreViviendasConDeudas
				.equals(other.textoLibreViviendasConDeudas))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ViviendasConDeudas [idDeuda=" + idDeuda + ", montante="
				+ montante + ", direccionViviendaDeudora="
				+ direccionViviendaDeudora + ", tipo=" + tipo
				+ ", textoLibreViviendasConDeudas="
				+ textoLibreViviendasConDeudas + ", historicoDemanda="
				+ historicoDemanda + ", comunidad=" + comunidad + ", moroso="
				+ moroso + "]";
	}

}