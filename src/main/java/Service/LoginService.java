package Service;

import Entity.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class LoginService implements LoginServiceInterface {

    //nom doit etre superieur a quatre caractere`s et ne pas contenir de caractere speciaux !"§$%&/()=?
    @Override
    public boolean testName(String name) {

        return  name.length() < 4 ? false : testCaracSpeciaux(name) ? false : true;
    }

    @Override
    public boolean testAge(int age) {
        return age > 17 ? true : false;
    }

    @Override
    public  boolean testEmail (String email){
        String regex = ("[A-Za-z0-9_.]+@[a-z0-9-]+\\.[a-z]{1,3}+");
        if (email.matches(regex)) {
            return true;
        }


        return false;
    }

    /*
    contient au moins deux classes de caractere
    chiffre
    minuscule
    majuscule
    caracterespeciaux
     */
    @Override
    public boolean testMotDePasse(String mdp) {
        int compteurDeClasse = 0;
        if (testLettreMinuscule(mdp)) {
            compteurDeClasse++;
        }
        if (testLettreMajuscule(mdp)) {
            compteurDeClasse++;
        }
        if (testChiffre(mdp)) {
            compteurDeClasse++;
        }
        if (testCaracSpeciaux(mdp)) {
            compteurDeClasse++;
        }

        return compteurDeClasse >= 2 ? true : false;
    }

    private boolean testChiffre(String mot) {
        String regex = ".*[0-9].*";
        return  mot.matches(regex);
    }

    private boolean testLettreMinuscule(String mot) {
        String regex = ".*[a-z].*";
        return mot.matches(regex);
    }

    private boolean testLettreMajuscule(String mot) {
        String  regex = ".*[A-Z].*";
        return mot.matches(regex);
    }


    private boolean testCaracSpeciaux(String mot) {
        String regex =  ".*["+ Pattern.quote("!\"§$%&/()=?") +"].*";

        return  mot.matches(regex);
    }

    @Override
    public boolean saveUser(AppUser appUser) {
        //nbuff...write(user.getnom()+";"+user.get)
        return false;
    }

    @Override
    public boolean deleteUser(String idUser) {
        return false;
    }

    @Override
    public List<AppUser> findAllUser() {
        return null;
    }

    @Override
    public Optional<AppUser> findUserById(String idUser) {
        return Optional.empty();
    }

    @Override
    public boolean testLoginDaten(String name, String mdp) {
        return false;
    }
}
