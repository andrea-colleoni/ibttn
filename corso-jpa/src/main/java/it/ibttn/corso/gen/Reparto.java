package it.ibttn.corso.gen;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="reparto", cascade={CascadeType.ALL})
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
		return this.impiegati;
	}

	public void setImpiegati(List<Persona> impiegati) {
		this.impiegati = impiegati;
	}

	public Persona addImpiegati(Persona impiegati) {
		getImpiegati().add(impiegati);
		impiegati.setReparto(this);

		return impiegati;
	}

	public Persona removeImpiegati(Persona impiegati) {
		getImpiegati().remove(impiegati);
		impiegati.setReparto(null);

		return impiegati;
	}

}