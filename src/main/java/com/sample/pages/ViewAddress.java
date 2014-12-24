package com.sample.pages;

import com.sample.entities.Address;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import java.util.List;

public class ViewAddress {

    @Property
    private String searchBox;

    @Inject
    private Session session;

    public List<Address> getAddresses() {

        return session.createCriteria(Address.class).list();
    }
}
