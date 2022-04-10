package Utils;

import Entity.AppUser;
import restResponse.UserBasicInfoRestResponse;

import java.util.ArrayList;
import java.util.List;

public class MappingsUtils {

    public static List<UserBasicInfoRestResponse> mappAppUserToAppUserBasicInfo(List<AppUser> userList) {
        List<UserBasicInfoRestResponse> responseList = new ArrayList();
        if (!userList.isEmpty()) {
            userList.stream().forEach(u -> {
                responseList.add(new UserBasicInfoRestResponse(u.getIdUser(), u.getNom(), u.getPrenom(), u.getVille(), u.getPassword(), u.getAge(), u.getEmail()));
            });
        }

        return responseList;
    }
}
