package DBdao;

import models.Card;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CardDAO extends GenericDAO {

    public CardDAO() {
        super(Card.class);
    }
}
