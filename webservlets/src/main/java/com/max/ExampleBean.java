package com.max;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ExampleBean {
    private String login;
    private String password;
    private boolean logged = false;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void doLogin() {
        logged = true;
    }
}
