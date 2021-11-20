package com.pb.kopejkin.hw8;

public class Auth {

    private String login;
    private String password;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if(login.length() >= 5 && login.length() < 20 && login.matches("^[a-zA-Z0-9.]+$")){
            this.login = login;
        }else{
            throw new WrongLoginException("Login not valid");
        }

        if(password.length() >= 5 && password.matches("^[a-zA-Z0-9._]+$") && password.equals(confirmPassword)){
            this.password = password;
        }else{
            throw new WrongPasswordException("Password does not requirements");
        }

    }

    public void signIn(String login, String password) throws WrongLoginException {
        if(login.equals(this.login) && password.equals(this.password)){

        }else{
            throw new WrongLoginException("Login is wrong");
        }

    }





}
