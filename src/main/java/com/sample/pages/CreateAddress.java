package com.sample.pages;

import com.sample.entities.Address;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

public class CreateAddress {

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String emailId;

    @Property
    private String phoneNumber;

    @Property
    private long zip;

    @Property
    private String city;

    @Property
    private String state;

    @Property
    private Address address;

    @Property
    private Form createAddressForm;

    @Inject
    private Session session;

    @OnEvent(value = "submit")
    @CommitAfter
    Object onSuccess() {

        Address address = new Address();
        address.setFirstName(firstName);
        address.setLastName(lastName);
        address.setEmailId(emailId);
        address.setPhoneNumber(phoneNumber);
        address.setZip(zip);
        address.setCity(city);
        address.setState(state);
        session.persist(address);
        return "viewAddress";
    }
}
