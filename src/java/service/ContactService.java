/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Contact;
import java.util.List;

/**
 *
 * @author ief
 */
public interface ContactService {
    
    Contact findById(Long id);

    public List<Contact> findAll();

    public Contact save(Contact contact);
    
}
