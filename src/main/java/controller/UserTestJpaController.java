package controller;

import Entity.AppUser;
import Service.Email.EmailSenderService;
import Service.EmailRestRequest;
import Service.UserJpaService;
import Utils.MappingsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restResponse.UserBasicInfoRestResponse;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserTestJpaController {

    @Autowired
    UserJpaService userJpaService;

    @Autowired
    EmailSenderService emailSenderService;

    @GetMapping(path = "/allUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AppUser> findAllUser() {
        return userJpaService.findAllUserJPA();
    }

    @GetMapping(path = "/allUserBasicInfo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserBasicInfoRestResponse> findAllUserBasicInfo() {
        List<AppUser> listUser = userJpaService.findAllUserJPA();
        return MappingsUtils.mappAppUserToAppUserBasicInfo(listUser);
    }

    @GetMapping(path = "/allUser/{age}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AppUser> findAllUser(@PathVariable(value = "age") int age) {
        //userRepository.donnerTousLesUserSelonLage(age);
        return userJpaService.findUserByAgeMoreThanX(age);
    }

    @PostMapping(path = "/saveUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean testEmail(@RequestBody UserBasicInfoRestResponse user){
        userJpaService.saveUserJpa(new AppUser(user.getNom(), user.getPassword(), user.getNom(), user.getVille(), user.getAge(),user.getEmail(),""));
        emailSenderService.sendTestEmail(user.getEmail());
        return true;
    }




}
