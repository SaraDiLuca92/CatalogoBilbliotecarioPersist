package catalogoBibliotecario;

import javax.persistence.Entity;


import javax.persistence.Table;

@Entity
@Table(name="Libri")
public class Libri extends Prodotti {
	
	
	private String autore;	
	private String genere;
	
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}

	

}
