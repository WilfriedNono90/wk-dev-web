package Service;

import Entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface LoginServiceInterface {

    public boolean testName(String name);
    public boolean testAge(int age);
    public boolean testEmail(String email);
    public boolean testMotDePasse(String mdp);
    public boolean saveUser(AppUser appUser);
    public boolean deleteUser(String idUser);
    public List<AppUser> findAllUser();
    public Optional<AppUser> findUserById(String idUser);
    public boolean testLoginDaten(String name, String mdp);
}
