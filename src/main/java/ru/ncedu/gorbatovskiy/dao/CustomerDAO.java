package ru.ncedu.gorbatovskiy.dao;

import ru.ncedu.gorbatovskiy.model.Customer;

import java.io.Serializable;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class CustomerDAO extends GenericDAO<Customer, Integer> {
    public CustomerDAO() {
        super(Customer.class);
    }

    public Integer getCount() {
        return super.getCount("CUSTOMER");
    }
}
