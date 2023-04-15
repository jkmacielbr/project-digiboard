package br.com.digiboard.desafioweb.beans;

import br.com.digiboard.desafioweb.controller.UserService;
import br.com.digiboard.desafioweb.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "userBean")
@Getter
@Setter
@SessionScope
@Component
public class UserBean implements Serializable {


    @Autowired
    private UserService userService;
    private String login, password;
    private User user;

    public String logar(){
        if(userService.validatePassword(login,password)){
            user = userService.findByLogin(login);
            return "/restricted/lista.app?faces-redirect=true";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Inválido",""));
        return null;
    }

    public boolean isAutenticado(){
        return this.user != null;
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        user = null;

        return "/login.app?faces-redirect=true";
    }


}
