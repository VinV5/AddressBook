package hello;
/**
 * Created by vincentvu on 2/2/2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository, BuddyInfoRepository buddyrepo) {

        return (args) -> {
            // save a couple of customers
            AddressBook AB1 = new AddressBook();

            BuddyInfo buddy1 = new BuddyInfo("Vincent", "123 Street", "1234567");
            BuddyInfo buddy2 = new BuddyInfo("Vincent", "321 Street", "7654321");
            BuddyInfo buddy3 = new BuddyInfo("Zak", "123 Street", "1111111");

            AB1.addBuddy(buddy1);
            AB1.addBuddy(buddy2);
            AB1.addBuddy(buddy3);

            repository.save(AB1);

            buddyrepo.save(buddy1);
            buddyrepo.save(buddy2);
            buddyrepo.save(buddy3);

            // fetch all customers
            log.info("AddressBooks found with findAll():");
            log.info("-------------------------------");
            for (AddressBook ab : repository.findAll()) {
                log.info(ab.display());
            }


            for(BuddyInfo bud : buddyrepo.findByName("Zak")) {
                log.info(bud.toString());
            }

        };
    }
}
