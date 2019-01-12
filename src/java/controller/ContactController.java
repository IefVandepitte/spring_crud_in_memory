/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Contact;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ContactService;
import utility.Message;

/**
 *
 * @author ief
 */
@RequestMapping("/contacts")
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String listCustomer(Model model){
        model.addAttribute("contactList", contactService.findAll());
        return "contacts/list";
    }
    
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model){
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return"contacts/show";
    }
    
    @RequestMapping(value = "/edit/{id}" , method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("contact", contactService.findById(id));
        return"contacts/edit";
    }
    @RequestMapping(value ="/edit/{id}", method = RequestMethod.POST)
    public String update(
            @PathVariable("id") Long id,
            @Valid Contact contact,
            BindingResult bindingResult,
            Model model,
            Locale locale){
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
            messageSource.getMessage(
            "contact_save_fail", new Object[]{}, locale)));
            //FOUTBOODSCHAP "contact_save_fail"
            return"contacts/edit";
        }
        contact.setId(id);
        contactService.save(contact);
        
        model.addAttribute("contactList", contactService.findAll());
        return "contacts/list";
    }
    

}
