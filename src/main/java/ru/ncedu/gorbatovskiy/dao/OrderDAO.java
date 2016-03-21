package ru.ncedu.gorbatovskiy.dao;

import ru.ncedu.gorbatovskiy.model.Order;

import java.io.Serializable;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class OrderDAO extends GenericDAO<Order, Integer> {
    public OrderDAO() {
        super(Order.class);
    }

    public Integer getCount() {
        return super.getCount("ORDERS");
    }
}
