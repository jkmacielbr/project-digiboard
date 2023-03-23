package br.com.digiboard.desafioweb.security;

import br.com.digiboard.desafioweb.model.User;
import org.springframework.stereotype.Component;

import static br.com.digiboard.desafioweb.security.PasswordUtils.hashPassword;


@Component
public class PasswordValidator {

    public boolean validatePassword(User user, String password) {
        String hash = hashPassword(password, user.getSalt());
        return hash.equals(user.getPassword());
    }
}
