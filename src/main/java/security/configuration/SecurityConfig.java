package security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    on configure ici les regles D'authentification
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    /*
    on configure ici la restriction aux ressources.
    genre tel path est securise, tel non, tel path es uniquement pour les
    admins et ainsi de suite
     */
    protected void configure(HttpSecurity http) throws Exception {
        /*
        desactiver le csrf , utile pour permettre lacces a h2, mais est utilser
        pour lauthentification statefull avec les sessions, dans le cardre stateless
        on sen fou so wie so du csrf car on fonctionne avec les Tokens
         */

        http.csrf().disable();
        //h2 utilise les frame, du coup le desactiver si on veut un acces a H2
        http.headers().frameOptions().disable();
        //lancer le login par defaut de Sping security, ne sert que pour le stateful
        //http.formLogin();


        //toutes les requetes ne necessitent pas une
        http.authorizeRequests().anyRequest().permitAll();
    }
}
