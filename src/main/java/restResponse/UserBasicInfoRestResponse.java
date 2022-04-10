package restResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserBasicInfoRestResponse {
    private Long id;
    private  String nom;
    private String prenom;
    private String ville;
    private String password;
    private int age;
    private String email;
}
