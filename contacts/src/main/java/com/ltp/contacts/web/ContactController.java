package com.ltp.contacts.web;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id){
        Contact   contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("/contact")
    public ResponseEntity<List<Contact>> getAllContact(){
        List<Contact> contact = contactService.getAllContact();
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> saveContact(@Valid @RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> updateContact(@PathVariable("id") String id, @Valid @RequestBody Contact contact){
        contactService.updateContact(id, contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") String id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
