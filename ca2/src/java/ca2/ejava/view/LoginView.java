/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2.ejava.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@Named("loginView")
public class LoginView {
    
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {

        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequest();

        try {
            req.login(username, password);
        } catch (ServletException ex) {
            FacesMessage msg = new FacesMessage("Incorrect login");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return ("/faces/index.xhtml");
        }

        return ("/secure/menu");
    }
}
