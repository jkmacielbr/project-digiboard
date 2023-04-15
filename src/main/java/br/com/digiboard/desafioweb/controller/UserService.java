package br.com.digiboard.desafioweb.controller;

import br.com.digiboard.desafioweb.model.User;
import br.com.digiboard.desafioweb.repository.UserRepository;
import br.com.digiboard.desafioweb.security.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private LoginValidator loginValidator;

    @Autowired
    public UserService(UserRepository userRepository, LoginValidator loginValidator) {
        this.userRepository = userRepository;
        this.loginValidator = loginValidator;
    }

    public void add (User user){
        if(userRepository.findByLogin(user.getLogin()) == null){
            userRepository.save(user);
        }

    }

    public boolean validatePassword (String login,String password){
        User user = userRepository.findByLogin(login);
        return loginValidator.validarLogin(user,password);

    }


    public User findByLogin(String login){
        return this.userRepository.findByLogin(login);
    }










}
