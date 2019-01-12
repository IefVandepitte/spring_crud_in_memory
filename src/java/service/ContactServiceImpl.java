/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Contact;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author ief
 */
public class ContactServiceImpl implements ContactService{
    private static List<Contact> contacts = new ArrayList<>();
static {
        contacts.add(new Contact(1L, 1,"Ief","Vandepitte","Student toegepaste informatica",LocalDate.of(1979, Month.AUGUST, 7)));
        contacts.add(new Contact(2L, 2, "firstName2", "lastName2", "description2", LocalDate.now()));
        contacts.add(new Contact(3L, 3, "firstName3", "lastName3", "description3", LocalDate.now()));
        contacts.add(new Contact(4L, 4, "firstName4", "lastName4", "description4", LocalDate.now()));
        contacts.add(new Contact(5L, 5, "firstName5", "lastName5", "description5", LocalDate.now()));
        contacts.add(new Contact(6L, 6, "firstName6", "lastName6", "description6", LocalDate.now()));
        contacts.add(new Contact(7L, 7, "firstName7", "lastName7", "description7", LocalDate.now()));
        contacts.add(new Contact(8L, 81, "firstName8", "lastName8", "description8", LocalDate.now()));
    }
   

    @Override
    public Contact findById(Long id) {
        //TODO
        return contacts.stream().filter(c -> id.compareTo(c.getId()) == 0).findFirst().orElse(null);
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Contact save(Contact contact) {
        ListIterator<Contact> it = contacts.listIterator();
        while (it.hasNext()) {
            Contact c = it.next();
            if (contact.getId().compareTo(c.getId())==0) {
                it.set(contact);
            }
        }
        return contact;
    }
    
}
