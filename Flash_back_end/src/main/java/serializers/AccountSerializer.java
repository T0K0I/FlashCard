package serializers;

import models.Account;

public class AccountSerializer {
    String naam;
    int id;
    boolean isDocent;
    String pass;

    public AccountSerializer(Account account) {
        this.naam = account.getName();
        this.id = account.getId();
        this.isDocent = account.getDocent();
        this.pass = "empty";
    }

    public AccountSerializer(Account account, String pass) {
        this.naam = account.getName();
        this.id = account.getId();
        this.isDocent = account.getDocent();
        this.pass = pass;
    }
}
