package validation;

import java.util.Calendar;

import domaine.CarteDeCredit;

public abstract class Generateur {

    private Generateur suivant;

    public Generateur(Generateur suivant) {
        this.suivant = suivant;
    }

    public Generateur() {
        suivant = null;
    }

    public abstract boolean valider(String numero);

    public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom){
        if(suivant != null){
            return suivant.creerCarte(numero, dateExpiration,nom);
        }
		return null;
	}
}
