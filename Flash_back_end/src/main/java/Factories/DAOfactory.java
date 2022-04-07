package Factories;

import DBdao.*;
//import models.Sessioncard;

public abstract class DAOfactory {

        private static DAOfactory theFactory;

        private static CardDAO cardDAO;
        private static DeckDAO deckDAO;
        private static AccountDAO accountDAO;
        private static TagDAO tagDAO;
        private static SessionPracticeDAO sessionDAO;
        private static SessionCardDAO SessionCardDAO;

        public static DAOfactory getTheFactory() {
                return theFactory;
        }

        public static CardDAO getCardDAO() {
                if (cardDAO == null){
                        cardDAO = new CardDAO();
                }
                return cardDAO;
        }

        public static DeckDAO getDeckDAO() {
                if (deckDAO == null){
                        deckDAO = new DeckDAO();
                }
                return deckDAO;
        }

        public static AccountDAO getAccountDAO() {
                if (accountDAO == null){
                        accountDAO = new AccountDAO();
                }
                return accountDAO;
        }

        public static TagDAO getTagDao() {
                if (tagDAO == null){
                        tagDAO = new TagDAO();
                }
                return tagDAO;
        }

        public static SessionPracticeDAO getSessionDao(){
                if (sessionDAO == null){
                        sessionDAO = new SessionPracticeDAO();
                }
                return sessionDAO;
        }
        public static SessionCardDAO getSessionCardDao(){
                if (SessionCardDAO == null){
                        SessionCardDAO = new SessionCardDAO();
                }
                return SessionCardDAO;
        }
}
