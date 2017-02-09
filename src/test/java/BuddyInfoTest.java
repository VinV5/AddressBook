/*
import org.junit.Test;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.junit.Assert.*;

public class BuddyInfoTest {
    BuddyInfo b;

    @Test
    public void getName() throws Exception {
        BuddyInfo b = new BuddyInfo("Vincent", "123 Street", "1234567");
        assertEquals("Vincent", b.getName());
    }

    @Test
    public void getAddress() throws Exception {
        BuddyInfo b = new BuddyInfo("Vincent", "123 Street", "1234567");
        assertEquals("123 Street", b.getAddress());
    }


    @Test
    public void getPhoneNumber() throws Exception {
        BuddyInfo b = new BuddyInfo("Vincent", "123 Street", "1234567");
        assertEquals("1234567", b.getPhoneNumber());
    }

    @Test
    public void testBuddyInfoPersist(){

        // Creating objects representing buddies
        BuddyInfo buddy1 = new BuddyInfo();
        //buddy1.setID(1);
        buddy1.setAddress("Test");
        buddy1.setName("Vincent");
        buddy1.setPhoneNumber("1234567");

        BuddyInfo buddy2 = new BuddyInfo();
        //buddy2.setID(2);
        buddy2.setAddress("Test2");
        buddy2.setName("Zak");
        buddy2.setPhoneNumber("7654321");

        // Connecting to the database through EntityManager Factory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the buddy entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();
// Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of Buddies\n----------------");

        for (BuddyInfo b : results) {

            System.out.println(b.getName() + " (id=" + b.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();
    }

}*/