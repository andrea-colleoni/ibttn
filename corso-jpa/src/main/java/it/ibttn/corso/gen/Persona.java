package it.ibttn.corso.gen;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSONA_CODICEFISCALE_GENERATOR", sequenceName="REPARTO_CODICE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSONA_CODICEFISCALE_GENERATOR")
	private String codicefiscale;

	private Integer altezza;

	private String cognome;

	private Timestamp datanascita;

	private String nome;

	private String obbli;

	//bi-directional many-to-one association to Reparto
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="reparto")
	private Reparto reparto;

	public Persona() {
	}

	public String getCodicefiscale() {
		return this.codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public Integer getAltezza() {
		return this.altezza;
	}

	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Timestamp getDatanascita() {
		return this.datanascita;
	}

	public void setDatanascita(Timestamp datanascita) {
		this.datanascita = datanascita;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObbli() {
		return this.obbli;
	}

	public void setObbli(String obbli) {
		this.obbli = obbli;
	}

	public Reparto getReparto() {
		return this.reparto;
	}

	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}

}