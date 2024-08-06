package com.org.practice.controller;

import com.org.practice.model.Contact;
import com.org.practice.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Random;

@RequestMapping("/contacts")
@RestController
@RequiredArgsConstructor
public class ContactsRestController {

    private final ContactRepository contactRepository;

    @GetMapping
    public String hello() {
        return "hello from contacts";

    }

    @PostMapping("/saving-contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {

        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);


    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int randumNum = random.nextInt(999999999 - 9999) + 9999;
        return "Serial-number" + randumNum;


    }


}