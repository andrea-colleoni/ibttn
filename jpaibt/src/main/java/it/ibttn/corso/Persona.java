package it.ibttn.corso;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Persona {

	@Id
//	@SequenceGenerator(name="b", sequenceName="REPARTO_COD_REP_SEQ")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="b")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;
	private String cognome;
	private Date dataNascita;
	private int altezza;
	
	@ManyToOne()
	@JoinColumn(name="codice_rep", referencedColumnName="cod_rep")
	private Reparto reparto;
	
	public Reparto getReparto() {
		return reparto;
	}
	public void setReparto(Reparto reparto) {
		this.reparto = reparto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public int getAltezza() {
		return altezza;
	}
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	
	
	
}
