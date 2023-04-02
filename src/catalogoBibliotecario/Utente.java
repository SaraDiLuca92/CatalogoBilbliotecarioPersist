package catalogoBibliotecario;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name="Utenti")

public class Utente {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="id",nullable=false)
	private long id;
	@Column(name="name",nullable=false)
	private String nome;
	@Column(name="cognome",nullable=false)
	private String cognome;
	 @Column(name="data_nascita", nullable=false)
	    private LocalDate dataNascita;
	@Column(name="numero_tessera",nullable=false)
	private long numero_tessera;
	
    public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
	public long getNumero_tessera() {
		return numero_tessera;
	}
	public void setNumero_tessera(long numero_tessera) {
		this.numero_tessera = numero_tessera;
	}
	

}
