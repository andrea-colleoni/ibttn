package it.ibttn.corso;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 * The persistent class for the reparto database table.
 * 
 */
@Entity
@NamedQuery(name="Reparto.findAll", query="SELECT r FROM Reparto r")
public class Reparto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codiceReparto;
	private String interno;
	private String nome;
	private List<Persona> impiegati;
	private String capoReparto;

	public Reparto() {
	}
	
	@Transient
	public String getCapoReparto() {
		return capoReparto;
	}


	public void setCapoReparto(String capoReparto) {
		this.capoReparto = capoReparto;
	}	
	
	@OneToMany(mappedBy="reparto", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Persona> getImpiegati() {
		return impiegati;
	}

	public void setImpiegati(List<Persona> impiegati) {
		this.impiegati = impiegati;
	}	


	@Id
	//@SequenceGenerator(name="a", sequenceName="REPARTO_COD_REP_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="a")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cod_rep")
	public Integer getCodiceReparto() {
		return this.codiceReparto;
	}

	public void setCodiceReparto(Integer codiceReparto) {
		this.codiceReparto = codiceReparto;
	}


	public String getInterno() {
		return this.interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}