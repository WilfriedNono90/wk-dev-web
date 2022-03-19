package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    @GetMapping(path = "error", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getError(){

        return "<h1> Welcome to WK-DEV.</h1>" +
                "<h2> You are on the backend Side, please use a route Example : /user/allUser etc.. </h2>";
    }
}
