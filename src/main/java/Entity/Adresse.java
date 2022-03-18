package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String strasse;

    private int numero;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany (mappedBy = "adresseList",fetch = FetchType.LAZY)
    private List<AppUser> appUserList;

    public Adresse(Long id, String strasse, int numero) {
        this.id = id;
        this.strasse = strasse;
        this.numero = numero;
    }

    public Adresse() {
    }

    public void adduser(AppUser appUser) {
        if (appUserList == null) appUserList = new ArrayList<>();
        appUserList.add(appUser);
    }

    public List<AppUser> getUserList() {
        return appUserList;
    }

    public void setUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
