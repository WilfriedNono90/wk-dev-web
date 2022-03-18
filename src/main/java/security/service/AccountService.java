package security.service;

import Dao.RoleRepository;
import Dao.UserRepository;
import Entity.AppRole;
import Entity.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    public AccountService(UserRepository userRepository, RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUser loadUserByUserName(String name) {
        return userRepository.findByNom(name);
    }

    public AppUser addNewUser(AppUser appUser) {
        String pwd = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pwd));
        return userRepository.save(appUser);
    }

    public AppRole addNewRole(AppRole appRole) { return  roleRepository.save(appRole);}

    public void addRoleToUser(String username, String rolename) {
        AppRole appRole = roleRepository.findByRoleName(rolename);
        AppUser appUser = userRepository.findByNom(username);

        appUser.getAppRoleCollection().add(appRole);
    }
}
