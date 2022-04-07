package DBdao;

import Factories.DAOfactory;
import models.Account;
import models.Card;
import models.Tag;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TagDAO extends GenericDAO {

    public TagDAO() {
        super(Tag.class);
    }



    public List<Tag> searchByName(int id, String search){
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Tag t where t.account.id = ?1 and t.name like ?2");
            query.setParameter(1, id);
            query.setParameter(2, "%"+search+"%");

            ArrayList<Tag> tags = (ArrayList<Tag>) query.list();

            for (Tag t: tags) {
                t.getCards();

            }

            session.close();

            return tags;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
