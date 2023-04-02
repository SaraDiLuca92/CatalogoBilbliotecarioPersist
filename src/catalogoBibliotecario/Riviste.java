package catalogoBibliotecario;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="Riviste")

public class Riviste extends Prodotti{


private String periodicità;

public String getPeriodicità() {
	return periodicità;
}

public void setPeriodicità(String mensile) {
	this.periodicità = mensile;
}

public static boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}



}
