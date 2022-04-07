package DBdao;

import models.Account;
import models.Card;
import models.Deck;

//import models.Sessioncards;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AccountDAO extends GenericDAO {

    public AccountDAO() {
        super(Account.class);
    }

    public List<Account> getAllStudents(){
        Session session = getSession();
        Query query = session.createQuery("from Account a where a.isDocent = false");
        List<Account> students = (List<Account>) query.getResultList();
        session.close();
        return students;
    }

    public Account findByEmail(String email){
        Session session = getSession();
        Query query = ((org.hibernate.Session) session).createQuery("from Account a where a.email =:email");
        query.setParameter("email", email);
        Account account = (models.Account) query.getSingleResult();
        session.close();
        return account;
    }
}
