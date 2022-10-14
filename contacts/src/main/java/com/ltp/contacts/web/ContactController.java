package com.ltp.contacts.web;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;
import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.Contact;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Contact-Controller", description = "Create and retrieve contacts")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Contact doesn't exist", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "200", description = "Successful retrieval of contact", content = @Content(schema = @Schema(implementation = Contact.class))),
    })
    @Operation(summary = "Retrieves contacts By Id", description = "Provides a list of contacts by id")
    public ResponseEntity<Contact> getContact(@PathVariable String id){
        Contact   contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping(value = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponse(responseCode = "200", description = "Successful retrieval of contacts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class))))
    @Operation(summary = "Retrieves contacts", description = "Provides a list of all contacts")
    public ResponseEntity<List<Contact>> getAllContact(){
        List<Contact> contact = contactService.getAllContact();
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful creation of contact"),
            @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @ApiResponse(responseCode = "204", description = "Successful save of contacts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class))))
    @Operation(summary = "Create Contact", description = "Creates a contact from the provided payload")
    public ResponseEntity<HttpStatus> saveContact(@Valid @RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/contact/{id}")
    @ApiResponse(responseCode = "200", description = "Successful update of contacts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class))))
    @Operation(summary = "Update Contact", description = "Update a contact from the provided payload")
    public ResponseEntity<HttpStatus> updateContact(@PathVariable("id") String id, @Valid @RequestBody Contact contact){
        contactService.updateContact(id, contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    @ApiResponse(responseCode = "204", description = "Successful deleted of contacts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class))))
    @Operation(summary = "Deleted Contact", description = "Delete a contact from the provided payload")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") String id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
