package hello;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by vincentvu on 1/12/2017.
 */
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;

    @ManyToOne
    private AddressBook AB;

    protected BuddyInfo(){}

    public BuddyInfo(String name, String address, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    @JsonIgnore
    public AddressBook getAddressBook() {
        return AB;
    }

    public void setAddressBook(AddressBook addressbook){
        this.AB = addressbook;
    }


    public Long getId(){return id;}

    public void setID(Long id){this.id = id;}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "\nName: " + this.getName()+"\nAddress: "+this.getAddress()+"\nPhone Number: "+this.getPhoneNumber()+"\n";
    }

    public static void main(String[] args){
        System.out.println("Buddy Info");
        BuddyInfo b = new BuddyInfo("Vincent", "123 Street", "1234567");

    }
}
