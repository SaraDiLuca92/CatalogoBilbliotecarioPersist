package catalogoBibliotecario;





import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass


public abstract class  Prodotti {



@Id
	private long ISBN;
	

	private String titolo;
	private int anno_di_pubblicazione;
	private int numero_di_pagine;
	
	
	
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnno_di_pubblicazione() {
		return anno_di_pubblicazione;
	}
	public void setAnno_di_pubblicazione(int anno_di_pubblicazione) {
		this.anno_di_pubblicazione = anno_di_pubblicazione;
	}
	public int getNumero_di_pagine() {
		return numero_di_pagine;
	}
	public void setNumero_di_pagine(int numero_di_pagine) {
		this.numero_di_pagine = numero_di_pagine;
	}
	
	
}
