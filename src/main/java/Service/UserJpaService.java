package Service;

import Dao.UserRepository;
import Entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJpaService {

    @Autowired
    UserRepository userRepository;

    public List<AppUser> findAllUser() {
        List<AppUser> appUserList = userRepository.donnerTousLesUser();
        return appUserList;
    }

    public List<AppUser> findAllUserJPA() {
        List<AppUser> appUserList = userRepository.findAll();
        return appUserList;
    }

    public AppUser loadUserByUserName(String name) {
        return userRepository.findByNom(name);
    }

    public AppUser addAppUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public AppUser findById(Long id) {
        Optional<AppUser> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null ;
    }

    public AppUser saveUserJpa(AppUser appUser) {
        return  userRepository.save(appUser);
    }

    public boolean deleteJPA(Long id) {
        try {
            userRepository.deleteById(id);
            return  true;
        }catch (Exception e) {
            return false;
        }


        //return  findById(id) != null ;

    }

    public List<AppUser> findUserByAgeMoreThanX(int age) {
        return  userRepository.donnerTousLesUserSelonLage(age);
    }

}
