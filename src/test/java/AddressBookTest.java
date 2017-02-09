package hello;
import junit.framework.Assert;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vincentvu on 1/12/2017.
 */
public class AddressBookTest {
    public BuddyInfo b;
    public void setUp(){
        AddressBook a = new AddressBook();
        BuddyInfo b = new BuddyInfo("Vincent", "123 Street", "1234567");
    }

    @org.junit.Test
    public void addBuddy() throws Exception {
        AddressBook a = new AddressBook();
        a.addBuddy(b);
        assertTrue(a.getSize()>0);
    }

    @org.junit.Test
    public void removeBuddy() throws Exception {
        AddressBook a = new AddressBook();
        a.addBuddy(b);
        a.removeBuddy(b);
        assertTrue(a.getSize() == 0);
    }

    @Test
    public void testAddressBookPersist(){
        AddressBook AB = new AddressBook();

        // Creating objects representing buddies
        BuddyInfo buddy1 = new BuddyInfo();
        //buddy1.setID(1);
        buddy1.setAddress("321 Street");
        buddy1.setName("Vincent");
        buddy1.setPhoneNumber("123-4567");

        BuddyInfo buddy2 = new BuddyInfo();
        //buddy2.setID(2);
        buddy2.setAddress("123 Street");
        buddy2.setName("Zak");
        buddy2.setPhoneNumber("765-4321");

        AB.addBuddy(buddy1);
        AB.addBuddy(buddy2);

        buddy1.setAddressBook(AB);
        buddy2.setAddressBook(AB);

        // Connecting to the database through EntityManager Factory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the entity objects
        em.persist(AB);

        // Using cascade to persist only Address Book
        //em.persist(buddy1);
        //em.persist(buddy2);

        tx.commit();
// Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM AddressBook b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of Buddies\n----------------");

        for (AddressBook b : results) {

            b.display();
        }

        // Closing connection
        em.close();

        emf.close();
    }

}