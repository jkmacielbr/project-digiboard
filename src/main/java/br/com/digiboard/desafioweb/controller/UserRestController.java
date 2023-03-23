package br.com.digiboard.desafioweb.controller;

import br.com.digiboard.desafioweb.beans.UserBean;
import br.com.digiboard.desafioweb.model.Person;
import br.com.digiboard.desafioweb.model.User;

import br.com.digiboard.desafioweb.security.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public User add(@RequestBody Map<String,String> json) {
        User user = new User();
        user.setLogin(json.get("login"));
        user.setSalt(PasswordUtils.generateSalt());
        user.setPassword(PasswordUtils.hashPassword(json.get("password"),user.getSalt()));
        userService.add(user);
        return user;
    }

    @PostMapping( value = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean check(@RequestBody Map<String,String> json) {

        return userService.validatePassword(json.get("login"),json.get("password"));
    }



}
