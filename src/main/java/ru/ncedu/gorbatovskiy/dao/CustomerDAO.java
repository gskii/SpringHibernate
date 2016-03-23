package ru.ncedu.gorbatovskiy.dao;

import ru.ncedu.gorbatovskiy.ApplicationService;
import ru.ncedu.gorbatovskiy.model.Customer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class CustomerDAO extends GenericDAO<Customer, Integer> {
    public CustomerDAO() {
        super(Customer.class);
    }

    public List<Customer> findWithUniqueAddress() {
        return findByNamedQuery("Customer.findWithUniqueAddresses");
    }

    public List<Customer> findSpecifyCustomer() {
        return findByNamedQuery("Customer.findSpecifyCustomer");
    }

    public static void main(String[] args) {
        System.out.println(((DaoFactory) ApplicationService.getApplicationContext().getBean("daoFactory")).getCustomerDAO().findWithUniqueAddress().size());
        System.out.println(((DaoFactory) ApplicationService.getApplicationContext().getBean("daoFactory")).getCustomerDAO().findSpecifyCustomer().size());
    }
}
