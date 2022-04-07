package controller;

import Utils.AuthenticationHandler;
import Utils.DummyHandler;
import com.opensymphony.xwork2.ActionSupport;
import models.Account;
import serializers.JSONSerializer;

public class AccountController extends ActionSupport {

    private String name;
    private int accountID;
    private String email;
    private String password;
    private JSONSerializer serializer = new JSONSerializer();
    private String responseJson;

    public String start() {
        DummyHandler.fillDummies();
        return SUCCESS;
    }

    public String login() {

        Account user = Account.getByEmail(email);

        if (user.isEmailValid(email)) {
            //kijken of een docent inlogt
            user.isEmailForDocent(email);
            if (AuthenticationHandler.checkHash(password, user.getPassword())) {
                //goed
                accountID = user.getId();
                return SUCCESS;
            }
        }
        return ERROR;
    }


    public String register() {
        if (Account.isEmailValid(email)){
            Account account = new Account();
            String hashedPassword = AuthenticationHandler.HashPass(password);
            account.setPassword(hashedPassword);
            account.setEmail(email);

            if (account.isEmailForDocent(email)) {
                account.setDocent(account.isEmailForDocent(email));
            }

            account.setName(name);
            account.save();
            return SUCCESS;
        }
        return ERROR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }


    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
