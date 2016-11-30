package validation;

import domaine.CarteDeCredit;
import domaine.MasterCard;

import java.util.Calendar;

/**
 * Created by akari on 30/11/16.
 */
public class MasterCardGenerateur extends Generateur {

    public MasterCardGenerateur(Generateur suivant) {
        super(suivant);
    }

    public MasterCardGenerateur() {
    }

    @Override
    public boolean valider(String numero) {
        int debut = Integer.parseInt(numero.substring(0,2));
        if(numero.length() > 15 && numero.length()< 20 && (debut >50 && debut < 56))
            return true;
        return false;
    }

    @Override
    public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
        if(valider(numero)){
            return new MasterCard(numero, dateExpiration, nom);
        }
        return super.creerCarte(numero, dateExpiration, nom);
    }
}
