package Utils;

import DBdao.TagDAO;
import Factories.DAOfactory;
import models.*;
import serializers.JSONSerializer;

public class DummyHandler {

    static boolean dummiesFilled = false;

    public static void fillDummies(){

        if (!dummiesFilled){

            Account account = new Account();
            account.setName("docent");
            account.setEmail("docent@scalda.nl");
            account.setPassword(AuthenticationHandler.HashPass("pass"));
            account.setDocent(true);

            Account account2 = new Account();
            account2.setName("student");
            account2.setEmail("student@scalda.nl");
            account2.setPassword(AuthenticationHandler.HashPass("pass"));
            account2.setDocent(false);

            Account account3 = new Account();
            account3.setName("Niels");
            account3.setEmail("niels@student.scalda.nl");
            account3.setPassword(AuthenticationHandler.HashPass("pass"));
            account3.setDocent(false);

            Account account4 = new Account();
            account4.setName("Bowen");
            account4.setEmail("bowen@student.scalda.nl");
            account4.setPassword(AuthenticationHandler.HashPass("pass"));
            account4.setDocent(false);

            Account account5 = new Account();
            account5.setName("Wojtek");
            account5.setEmail("wojtek@student.scalda.nl");
            account5.setPassword(AuthenticationHandler.HashPass("pass"));
            account5.setDocent(false);

            Deck deck = new Deck();
            deck.setAccount(account2);
            deck.setName("Scrum");

            Deck deck2 = new Deck();
            deck2.setAccount(account2);
            deck2.setName("Programmeren");

            Deck deck3 = new Deck();
            deck3.setAccount(account2);
            deck3.setName("Database");

            Deck deck4 = new Deck();
            deck4.setAccount(account3);
            deck4.setName("SEN");

            Deck deck5 = new Deck();
            deck5.setAccount(account3);
            deck5.setName("Front-end");

            Deck deck6 = new Deck();
            deck6.setAccount(account3);
            deck6.setName("Loopbaansturing");

            Deck deck7 = new Deck();
            deck7.setAccount(account4);
            deck7.setName("Loopbaansturing");

            Deck deck8 = new Deck();
            deck8.setAccount(account4);
            deck8.setName("Programmeren");

            Deck deck9 = new Deck();
            deck9.setAccount(account4);
            deck9.setName("SEN");

            Deck deck10 = new Deck();
            deck10.setAccount(account5);
            deck10.setName("Database");

            Deck deck11 = new Deck();
            deck11.setAccount(account5);
            deck11.setName("Scrum");

            Deck deck12 = new Deck();
            deck12.setAccount(account5);
            deck12.setName("Loopbaansturing");

            Card card1 = new Card();
            card1.setName("PO");
            card1.setDeck(deck);
            card1.setDescription("Product Owner");

            Card card2 = new Card();
            card2.setName("SM");
            card2.setDeck(deck);
            card2.setDescription("Scrum Master");

            Card card3 = new Card();
            card3.setName("Development Team");
            card3.setDeck(deck);
            card3.setDescription("Maakt het daadwerkelijke project.");

            Card card4 = new Card();
            card4.setName("MVP");
            card4.setDeck(deck);
            card4.setDescription("Minimum valuable product");

            Card card5 = new Card();
            card5.setName("Planmatig");
            card5.setDeck(deck);
            card5.setDescription("Werken op een manier dat alles op tijd klaar is.");

            Card card6 = new Card();
            card6.setName("Field");
            card6.setDeck(deck2);
            card6.setDescription("Een field is een variabele.");

            Card card7 = new Card();
            card7.setName("Class");
            card7.setDeck(deck2);
            card7.setDescription("Een plaats waar je objecten kan maken.");

            Card card8 = new Card();
            card8.setName("For loop");
            card8.setDeck(deck2);
            card8.setDescription("Dit is de loop die je gebruikt als je weet wat de uitkomst moet zijn.");

            Card card9 = new Card();
            card9.setName("Int");
            card9.setDeck(deck2);
            card9.setDescription("Hiermee geef je aan dat je een getal gaat gebruiken.");

            Card card10 = new Card();
            card10.setName("String");
            card10.setDeck(deck2);
            card10.setDescription("Hiermee geef je aan dat je een rij met tekens gaat gebruiken.");

            Card card11 = new Card();
            card11.setName("Primitive datatypes");
            card11.setDeck(deck2);
            card11.setDescription("byte, short, long, int, float, double, boolean, char");

            Card card12 = new Card();
            card12.setName("Operators");
            card12.setDeck(deck2);
            card12.setDescription("+, -, /, *, % etc.");

            Card card13 = new Card();
            card13.setName("Constuctor");
            card13.setDeck(deck2);
            card13.setDescription("Een method met de zelfde naam als de class, ze hebben geen return type.");

            Card card14 = new Card();
            card14.setName("Package");
            card14.setDeck(deck2);
            card14.setDescription("Een mappenstructuur voor je projecten te organiseren.");

            Card card15 = new Card();
            card15.setName("Exceptie");
            card15.setDeck(deck2);
            card15.setDescription("Een fout op een ongewone toestand, hier zijn 2 soorten van. Namelijk gecontroleerd en ongecontroleerd.");

            Card card16 = new Card();
            card16.setName("Impleciet casten");
            card16.setDeck(deck2);
            card16.setDescription("Van een klein datatype een groot datatype maken.");

            Card card17 = new Card();
            card17.setName("Aggregation");
            card17.setDeck(deck4);
            card17.setDescription("Iets dat twee dingen gezamelijk hebben, zoals katten en honden hebben beide een staart.");

            Card card18 = new Card();
            card18.setName("Selfcall");
            card18.setDeck(deck4);
            card18.setDescription("Dit is een method die terug naar zijn eigen lifeline gaat.");

            Card card19 = new Card();
            card19.setName("Create message");
            card19.setDeck(deck4);
            card19.setDescription("Hierbij word aangegeven dat een object word gemaakt.");

            Card card20 = new Card();
            card20.setName("Actor");
            card20.setDeck(deck4);
            card20.setDescription("Degene die de software gebruikt en het beginpunt van een Sequence diagram.");

            Card card21 = new Card();
            card21.setName("Lifeline");
            card21.setDeck(deck4);
            card21.setDescription("Dit verwijst altijd naar een class.");

            Card card22 = new Card();
            card22.setName("HTML");
            card22.setDeck(deck5);
            card22.setDescription("Hyper text markup language.");

            Card card23 = new Card();

            card23.setName("Div");
            card23.setDeck(deck5);
            card23.setDescription("Gebruik je voor de layout van een website of een applicatie.");

            Card card24 = new Card();
            card24.setName("CSS");
            card24.setDeck(deck5);
            card24.setDescription("Cascading style sheet.");

            Card card25 = new Card();
            card25.setName("Scalaire functies");
            card25.setDeck(deck10);
            card25.setDescription("Worden gebruikt om bewerkingen uit te voeren.");

            Card card26 = new Card();
            card26.setName("syntax AS");
            card26.setDeck(deck10);
            card26.setDescription("Hiermee kan je je gegevens die je hebt uitgeprint benoemen.");

            Card card27 = new Card();
            card27.setName("Hoeveel joins zijn er?");
            card27.setDeck(deck10);
            card27.setDescription("5");

            Card card28 = new Card();
            card28.setName("Gegevens sorteren.");
            card28.setDeck(deck10);
            card28.setDescription("Met de comment ORDER BY.");

            Card card29 = new Card();
            card29.setName("Select statement");
            card29.setDeck(deck10);
            card29.setDescription("Select distinct, from, where en and/or.");

            Card card30 = new Card();
            card30.setName("Insert");
            card30.setDeck(deck10);
            card30.setDescription("Gebruik je om nieuwe values in je Database toe te voegen.");

            Tag tag = new Tag();
            tag.setName("une tag");
            tag.setAccount(account3);

            Tag tag2 = new Tag();
            tag2.setName("gude tag");
            tag2.setAccount(account3);

            Tag tag3 = new Tag();
            tag3.setName("iets compleet anders");
            tag3.setAccount(account3);


            DAOfactory.getAccountDAO().saveOrUpdate(account);
            DAOfactory.getAccountDAO().saveOrUpdate(account2);
            DAOfactory.getAccountDAO().saveOrUpdate(account3);
            DAOfactory.getAccountDAO().saveOrUpdate(account4);
            DAOfactory.getAccountDAO().saveOrUpdate(account5);
            DAOfactory.getDeckDAO().saveOrUpdate(deck);
            DAOfactory.getDeckDAO().saveOrUpdate(deck2);
            DAOfactory.getDeckDAO().saveOrUpdate(deck3);
            DAOfactory.getDeckDAO().saveOrUpdate(deck4);
            DAOfactory.getDeckDAO().saveOrUpdate(deck5);
            DAOfactory.getDeckDAO().saveOrUpdate(deck6);
            DAOfactory.getDeckDAO().saveOrUpdate(deck7);
            DAOfactory.getDeckDAO().saveOrUpdate(deck8);
            DAOfactory.getDeckDAO().saveOrUpdate(deck9);
            DAOfactory.getDeckDAO().saveOrUpdate(deck10);
            DAOfactory.getDeckDAO().saveOrUpdate(deck11);
            DAOfactory.getDeckDAO().saveOrUpdate(deck12);
            DAOfactory.getCardDAO().saveOrUpdate(card1);
            DAOfactory.getCardDAO().saveOrUpdate(card2);
            DAOfactory.getCardDAO().saveOrUpdate(card3);
            DAOfactory.getCardDAO().saveOrUpdate(card4);
            DAOfactory.getCardDAO().saveOrUpdate(card5);
            DAOfactory.getCardDAO().saveOrUpdate(card6);
            DAOfactory.getCardDAO().saveOrUpdate(card7);
            DAOfactory.getCardDAO().saveOrUpdate(card8);
            DAOfactory.getCardDAO().saveOrUpdate(card9);
            DAOfactory.getCardDAO().saveOrUpdate(card10);
            DAOfactory.getCardDAO().saveOrUpdate(card11);
            DAOfactory.getCardDAO().saveOrUpdate(card12);
            DAOfactory.getCardDAO().saveOrUpdate(card13);
            DAOfactory.getCardDAO().saveOrUpdate(card14);
            DAOfactory.getCardDAO().saveOrUpdate(card15);
            DAOfactory.getCardDAO().saveOrUpdate(card16);
            DAOfactory.getCardDAO().saveOrUpdate(card17);
            DAOfactory.getCardDAO().saveOrUpdate(card18);
            DAOfactory.getCardDAO().saveOrUpdate(card19);
            DAOfactory.getCardDAO().saveOrUpdate(card20);
            DAOfactory.getCardDAO().saveOrUpdate(card21);
            DAOfactory.getCardDAO().saveOrUpdate(card22);
            DAOfactory.getCardDAO().saveOrUpdate(card23);
            DAOfactory.getCardDAO().saveOrUpdate(card24);
            DAOfactory.getCardDAO().saveOrUpdate(card25);
            DAOfactory.getCardDAO().saveOrUpdate(card26);
            DAOfactory.getCardDAO().saveOrUpdate(card27);
            DAOfactory.getCardDAO().saveOrUpdate(card28);
            DAOfactory.getCardDAO().saveOrUpdate(card29);
            DAOfactory.getCardDAO().saveOrUpdate(card30);

            DAOfactory.getTagDao().saveOrUpdate(tag);
            DAOfactory.getTagDao().saveOrUpdate(tag2);
            DAOfactory.getTagDao().saveOrUpdate(tag3);

            dummiesFilled = true;
        }

    }

    public static void deleteTagDummie() {
//        Tag tag = (Tag) DAOfactory.getTagDao().findById(1);
//        Tag tag2 = (Tag) DAOfactory.getTagDao().findById(2);
//        Tag tag3 = (Tag) DAOfactory.getTagDao().findById(3);
//
//        DAOfactory.getTagDao().delete(tag);
//        DAOfactory.getTagDao().delete(tag2);
//        DAOfactory.getTagDao().delete(tag3);
    }


}
