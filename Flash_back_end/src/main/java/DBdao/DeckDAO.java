package DBdao;

import models.Card;
import models.Deck;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeckDAO extends GenericDAO {


    public DeckDAO() {
        super(Deck.class);
    }
}
