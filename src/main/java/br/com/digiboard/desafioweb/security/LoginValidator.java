package br.com.digiboard.desafioweb.security;

import br.com.digiboard.desafioweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginValidator {
    @Autowired
    private PasswordValidator passwordValidator;
    public boolean validarLogin(User user, String password) {
        return passwordValidator.validatePassword(user, password);
    }
}
