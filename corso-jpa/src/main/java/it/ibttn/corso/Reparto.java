package it.ibttn.corso;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the reparto database table.
 * 
 */
@Entity
@NamedQuery(name="Reparto.findAll", query="SELECT r FROM Reparto r")
public class Reparto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPARTO_CODICE_GENERATOR", sequenceName="REPARTO_CODICE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPARTO_CODICE_GENERATOR")
	private Integer codice;

	private String nome;

	private String telefono;
	
	@OneToMany(mappedBy="reparto", fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Persona> impiegati;

	public Reparto() {
	}

	public Integer getCodice() {
		return this.codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Persona> getImpiegati() {
		return impiegati;
	}
	
	public void addImpiegato(Persona p) {
		this.impiegati.add(p);
		p.setReparto(this);
	}

	public void setImpiegati(List<Persona> impiegati) {
		this.impiegati = impiegati;
	}

}