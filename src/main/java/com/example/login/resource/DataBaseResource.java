package com.example.login.resource;

import com.example.login.model.LoginRequest;
import com.example.login.model.Respuesta;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/database")
@Api(value = "Database Resource REST EndPoint", description = "Shows the user info")
public class DataBaseResource {

    private String user;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Respuesta database(HttpSession session) {
        Respuesta respuesta = new Respuesta(false, "No session");
        if (session != null && session.getAttribute("user") != null) {
            user = session.getAttribute("user").toString();
            if (user.equals("admin")) {
                respuesta = new Respuesta(true, "This is the secret message only for administrator " + session.getId());
            } else {
                session.invalidate();
                respuesta = new Respuesta(false, "Who the f are you");
            }
        } else {
            session.invalidate();
        }
        return respuesta;
    }
}
