package Tests;

import DBdao.SessionPracticeDAO;
import com.google.gson.Gson;
import models.Account;
import models.SessionPractice;

public class test {



    public static void main(String[]args){

//        Account toSave = new Account();
//        toSave.setEmail("iets");
//        toSave.setName("een naam");

        Account account = Account.getById(1);
        Gson gson = new Gson();
        System.out.println(gson.toJson(account));

    }
}
