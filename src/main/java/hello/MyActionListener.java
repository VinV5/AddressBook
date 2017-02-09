package hello;/**
 * Created by vincentvu on 1/26/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyActionListener implements ActionListener {

    private JTextField name;
    private JTextField street;
    private JTextField phone;
    private AddressBook addressBook;
    private JTextArea JTextArea;

    @Autowired
    public void setName(JTextField name){
        this.name = name;
    }
    @Autowired
    public void setStreet(JTextField street){
        this.street = street;
    }
    @Autowired
    public void setPhone(JTextField phone){
        this.phone = phone;
    }
    @Autowired
    public void setAddressBook(AddressBook addressBook){
        this.addressBook = addressBook;
    }

    @Autowired
    public void setJTextArea(JTextArea JTextArea){
        this.JTextArea = JTextArea;
    }

    public void actionPerformed(ActionEvent e) {
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName(name.getText());
        buddy.setAddress(street.getText());
        buddy.setPhoneNumber(phone.getText());
        addressBook.addBuddy(buddy);

        JTextArea.setText(addressBook.display());

    }
}
