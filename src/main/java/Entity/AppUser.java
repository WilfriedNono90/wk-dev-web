package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
//@Table(name = "appuserwkdev")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    //@Column(name = "nom_wkdev")
    private  String nom, prenom, ville;

    @JsonIgnore
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private int age;
    private String email;
    private String role ;

    @ManyToMany (fetch = FetchType.LAZY)
    private Collection<AppRole> appRoleCollection = new ArrayList<>();


    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_adresse",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "adresse_id")
    )
    private List<Adresse> adresseList;

    @OneToOne
    private Konto konto;

    @OneToMany
    private List<CarteAcces> carteAccesList = new ArrayList<>();

    public void addcarteAcces(CarteAcces carteAcces){
        carteAccesList.add(carteAcces);
    }

    public AppUser() {
    }

    public void addRole(AppRole role){
        appRoleCollection.add(role);
    }

    public AppUser(String nom,String password, String prenom, String ville, int age, String email, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.age = age;
        this.email = email;
        this.role = role;
        this.password = password;
        appRoleCollection = new ArrayList<>();
    }

    public void addAdress(Adresse adresse ) {
        if (adresseList == null) adresseList = new ArrayList<>();

        adresseList.add(adresse);
    }


}
