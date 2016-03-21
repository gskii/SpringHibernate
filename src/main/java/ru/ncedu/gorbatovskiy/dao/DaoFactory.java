package ru.ncedu.gorbatovskiy.dao;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public interface DaoFactory {
    BookDAO getBookDAO();

    StoreDAO getStoreDAO();

    OrderDAO getOrderDAO();

    CustomerDAO getCustomerDAO();
}
