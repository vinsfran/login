package com.example.login.resource;

import com.example.login.model.LoginRequest;
import com.example.login.model.Respuesta;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
@Api(value = "Login Resource REST EndPoint", description = "Shows the user info")
public class LoginResource {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Respuesta auth(@RequestBody LoginRequest request, HttpSession session) {
        System.out.println(request.toString());
        Respuesta respuesta;
        if (request.getUsername().equals("admin") && request.getPassword().equals("admin")) {
            session.setAttribute("user", request.getUsername());
            respuesta = new Respuesta(true, "This is the secret no one knows but the admin");
        } else {
            session.invalidate();
            respuesta = new Respuesta(false, "Invalid credentials");
        }
        System.out.println(respuesta.toString());
        return respuesta;
    }
}
