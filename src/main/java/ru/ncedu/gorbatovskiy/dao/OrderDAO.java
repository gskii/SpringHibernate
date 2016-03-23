package ru.ncedu.gorbatovskiy.dao;

import ru.ncedu.gorbatovskiy.ApplicationService;
import ru.ncedu.gorbatovskiy.model.Order;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class OrderDAO extends GenericDAO<Order, Integer> {
    public OrderDAO() {
        super(Order.class);
    }

    public List<Order> findWithUniqueMonth() {
        return findByNamedQuery("Order.findWithUniqueMonth");
    }

    public List<Order> findGreatBuy() {
        return findByNamedQuery("Order.findGreatBuy");
    }

    public static void main(String[] args) {
        System.out.println(((DaoFactory) ApplicationService.getApplicationContext().getBean("daoFactory")).getOrderDAO().findWithUniqueMonth().size());
    }
}
