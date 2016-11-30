package validation;

import com.sun.tools.javac.jvm.Gen;
import domaine.CarteDeCredit;
import domaine.Visa;

import java.util.Calendar;

/**
 * Created by akari on 30/11/16.
 */
public class VisaGenerateur extends Generateur {
    @Override
    public boolean valider(String numero) {
        if(numero.length()> 12 && numero.length() < 17 && numero.startsWith("4"))
            return true;
        return false;
    }

    public VisaGenerateur(Generateur suivant) {
        super(suivant);
    }

    public VisaGenerateur() {
    }

    @Override
    public CarteDeCredit creerCarte(String numero, Calendar dateExpiration, String nom) {
        if(valider(numero)){
            return new Visa(numero, dateExpiration, nom);
        }
        return super.creerCarte(numero, dateExpiration, nom);
    }
}
