package hello;
/**
 * Created by vincentvu on 1/12/2017.
 */
import javax.persistence.*;
import java.util.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "AB", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> l;

    public AddressBook(){
        l = new ArrayList<BuddyInfo>();
    }

    public List<BuddyInfo> getBuddy(){
        return l;
    }

    public void setBuddy(List<BuddyInfo> b){
        this.l = b;
    }

    public void addBuddy(BuddyInfo b){
            l.add(b);
            b.setAddressBook(this);
    }

    public void removeBuddy(BuddyInfo b){
        l.remove(b);
    }

    public List getBuddyList(){
        return l;
    }

    public String display()
    {
        StringBuilder sb = new StringBuilder();

        for(BuddyInfo b : l)
        {
            sb.append(b.toString());
        }

        return sb.toString();
    }

    public int getSize(){
        return l.size();
    }

    public static void main(String[] args){
        System.out.println("Address Book\n");
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Vincent", "123 Street", "1234567");
        BuddyInfo buddy2 = new BuddyInfo("Friend", "777 Street", "7654321");
        book.addBuddy(buddy);
        book.addBuddy(buddy2);

        book.display();

    }

}
