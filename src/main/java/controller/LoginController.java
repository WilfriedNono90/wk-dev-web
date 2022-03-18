package controller;

import Service.EmailRestRequest;
import Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;
    @GetMapping(path = "testemail/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String testEmail(@PathVariable(value = "email") String email){

        if ( loginService.testEmail(email) ) {
            return  "l'Email est bon";
        } else {
            return "l'Email est mauvais";
        }
    }

    @GetMapping(path = "testemail", produces = {MediaType.APPLICATION_JSON_VALUE})
    public EmailRestRequest testEmail(){
       return new EmailRestRequest("Wilfried@gmail.com");
    }

    @PostMapping(path = "testemail", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String testEmail(@RequestBody EmailRestRequest emailRestRequest){

        if ( loginService.testEmail(emailRestRequest.getEmail()) ) {
            return  "l'Email est bon";
        } else {
            return "l'Email est mauvais";
        }
    }

    @PutMapping(path = "testemail/modifiaction/{newEmail}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String testEmail(@RequestBody EmailRestRequest emailRestRequest,@PathVariable(value = "newEmail") String email){

        if ( loginService.testEmail(emailRestRequest.getEmail()) ) {
            return  "l'Email est bon";
        } else {
            return "l'Email est mauvais";
        }
    }

    @DeleteMapping(path = "testemail/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteEmail(@PathVariable(value = "id") String id){
        if ( loginService.testEmail(id) ) {
            return  "l'Email est bon";
        } else {
            return "l'Email est mauvais";
        }
    }






}
