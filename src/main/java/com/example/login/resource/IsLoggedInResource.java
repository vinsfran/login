package com.example.login.resource;

import com.example.login.model.IsLoggedIn;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/isloggedin")
@Api(value = "IsLoggedIn Resource REST EndPoint", description = "Shows the user info")
public class IsLoggedInResource {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public IsLoggedIn database(HttpSession session) {
        IsLoggedIn isLoggedIn = new IsLoggedIn(false);
        if (session != null && session.getAttribute("user") != null) {
            isLoggedIn = new IsLoggedIn(true);
        }
        System.out.println(isLoggedIn.toString());
        return isLoggedIn;
    }
}
