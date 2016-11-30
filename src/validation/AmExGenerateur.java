package validation;

import com.sun.tools.javac.jvm.Gen;
import domaine.AmEx;
import domaine.CarteDeCredit;

import java.util.Calendar;

/**
 * Created by akari on 30/11/16.
 */
public class AmExGenerateur extends Generateur {

    public AmExGenerateur() {
    }

    public AmExGenerateur(Generateur suivant) {
        super(suivant);
    }

    @Override
    public boolean valider(String numero) {
        if((numero.startsWith("34") || numero.startsWith("37")) && numero.length() == 15)
            return true;
        return false;
    }

    @Override
    public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
        if(valider(numero)){
            return new AmEx(numero , dateExpiration,nom);
        }
        return super.creerCarte(numero, dateExpiration, nom);
    }
}
