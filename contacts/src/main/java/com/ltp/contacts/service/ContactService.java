package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;

import java.util.List;

public interface ContactService {
    Contact getContactById(String id);
    void saveContact(Contact contact);
    List<Contact> getAllContact();
    void updateContact(String id, Contact contact);

    void deleteContact(String id);
    
}
