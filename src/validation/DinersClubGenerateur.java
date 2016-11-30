package validation;

import domaine.CarteDeCredit;
import domaine.DinersClub;

import java.util.Calendar;

/**
 * Created by akari on 30/11/16.
 */
public class DinersClubGenerateur extends Generateur {

    public DinersClubGenerateur(Generateur suivant) {
        super(suivant);
    }

    public DinersClubGenerateur() {
    }

    @Override
    public boolean valider(String numero) {
        if(numero.length() == 14
                && (numero.startsWith("300")
                ||numero.startsWith("301")
                ||numero.startsWith("302")
                ||numero.startsWith("303")
                ||numero.startsWith("304")
                ||numero.startsWith("305")))
            return true;
        return false;
    }

    @Override
    public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
        if(valider(numero)){
            return new DinersClub(numero, dateExpiration, nom);
        }
        return super.creerCarte(numero, dateExpiration, nom);
    }
}
