package br.com.digiboard.desafioweb.beans;

import br.com.digiboard.desafioweb.controller.UserService;
import br.com.digiboard.desafioweb.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "userBean")
@Getter
@Setter
@ViewScoped
public class UserBean implements Serializable {

    private User user= new User();
    private UserService userService;


}
