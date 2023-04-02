package catalogoBibliotecario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Prestiti")
public class Prestito {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="utente_id", nullable=false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name="libro_prestato_ISBN")
    private Libri libro;

    @ManyToOne
    @JoinColumn(name="rivista_prestata_ISSN")
    private Riviste rivista;

    @Column(name="data_inizio_prestito", nullable=false)
    private LocalDate dataInizioPrestito;

    private LocalDate data_restituzione_prevista;

    @Column(name="data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.data_restituzione_prevista = dataInizioPrestito.plusDays(30);
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libri getLibro() {
        return libro;
    }

    public void setLibro(Libri libro) {
        this.libro = libro;
    }

    public Riviste getRivista() {
        return rivista;
    }

    public void setRivista(Riviste rivista) {
        this.rivista = rivista;
    }

    public LocalDate getData_restituzione_prevista() {
        return data_restituzione_prevista;
    }

    public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

}
