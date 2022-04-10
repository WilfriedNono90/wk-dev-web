package com.wkdev.wkdevweb;

import Dao.AdresseRepository;
import Dao.CarteAccesRepository;
import Dao.KontoRepository;
import Dao.UserRepository;
import Entity.*;
import Service.Email.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller","Service","Entity","Dao","security","restResponse","Utils"})

@EnableJpaRepositories("Dao")
@EntityScan("Entity")
public class WkDevWebApplication /*implements CommandLineRunner*/ {

    /*
    @Autowired
    UserRepository userRepository;

    @Autowired
    AdresseRepository adresseRepository;
    */

    //@Autowired
    //AccountService accountService;

    private static final Logger log = LoggerFactory.getLogger(WkDevWebApplication.class);




    public static void main(String[] args) {

        SpringApplication.run(WkDevWebApplication.class, args);
        log.info("Server is up");
    }

    //ajout d'un bean au contexte de l'application pour pouvoir le crypter
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Transactional
    CommandLineRunner start(AccountService accountService, KontoRepository kontoRepository, CarteAccesRepository carteAccesRepository, UserRepository userRepository, AdresseRepository adresseRepository, EmailSenderService emailSenderService) {

        return args -> {

            emailSenderService.sendTestEmail("wilfried.nono90@gmail.com");

            if (true ) {
                AppUser appUser1 = new AppUser("wk","1234", "dev", null, 15, null, null);
                AppUser appUser2 = new AppUser("willy","1234", "dev", null, 15, null, null);

                Adresse adresse1 = new Adresse(null, "Am zollstock", 27);
                Adresse adresse2 = new Adresse(null, "Am Ruegenberg", 27);
                Adresse adresse3 = new Adresse(null, "Gruebergerstasse", 27);

                Konto konto1 = new Konto(null,"GIROKONTO");

                CarteAcces carteAcces1 = new CarteAcces();
                CarteAcces carteAcces2 = new CarteAcces();

                appUser1.addAdress(adresse1);
                appUser1.addAdress(adresse2);

                appUser2.addAdress(adresse2);
                appUser2.addAdress(adresse3);

                appUser1.setKonto(konto1);

                //sauvegarde en base de donnee
                adresseRepository.save(adresse1);
                adresseRepository.save(adresse2);
                adresseRepository.save(adresse3);

                kontoRepository.save(konto1);



                userRepository.save(appUser1);
                userRepository.save(appUser2);


                carteAcces1.setUser(appUser1);
                carteAcces2.setUser(appUser1);

                carteAccesRepository.save(carteAcces1);
                carteAccesRepository.save(carteAcces2);


            }

            if (true) {
                accountService.addNewRole(new AppRole(null, "USER"));
                accountService.addNewRole(new AppRole(null, "ADMIN"));
                accountService.addNewRole(new AppRole(null, "CUSTOMER_MANAGER"));
                accountService.addNewRole(new AppRole(null, "PRODUCT_MANAGER"));

                accountService.addNewUser(new AppUser("usersecurity1", "1234", "dev", null, 15, null, null));
                accountService.addNewUser(new AppUser("usersecurity2", "1234", "1234", null, 15, null, null));

                accountService.addRoleToUser("usersecurity1", "USER");
                accountService.addRoleToUser("usersecurity1", "ADMIN");
                accountService.addRoleToUser("usersecurity2", "USER");

            }

        };





    }
}
