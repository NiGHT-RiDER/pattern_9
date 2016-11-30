package validation;

import domaine.CarteDeCredit;
import domaine.Discover;

import java.util.Calendar;

/**
 * Created by akari on 30/11/16.
 */
public class DiscoverGenerateur extends Generateur {
    @Override
    public boolean valider(String numero) {
        int numeroEn3 = Integer.parseInt(numero.substring(0,2));
        int numeroEn2 = Integer.parseInt(numero.substring(0,1));
        int numeroEn4 = Integer.parseInt(numero.substring(0,3));
        int numeroEn6 = Integer.parseInt(numero.substring(0,5));
        if(numero.length() == 16
                &&
                (  (numeroEn3 < 649 &&  numeroEn3 > 643)
                || (numeroEn4 == 6011)
                || (numeroEn6 > 622125 && numeroEn6 < 622926)
                || numeroEn2 == 65))
            return true;
        return false;
    }

    public DiscoverGenerateur(Generateur suivant) {
        super(suivant);
    }

    public DiscoverGenerateur() {

    }

    @Override
    public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
        if(valider(numero))
            return new Discover(numero, dateExpiration, nom);
        return super.creerCarte(numero, dateExpiration, nom );
    }
}
