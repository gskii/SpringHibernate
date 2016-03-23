package ru.ncedu.gorbatovskiy.dao;

import ru.ncedu.gorbatovskiy.ApplicationService;
import ru.ncedu.gorbatovskiy.model.Store;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class StoreDAO extends GenericDAO<Store, Integer> {
    public StoreDAO() {
        super(Store.class);
    }

    public List<Store> findCustomStore() {
        return findByNamedQuery("Store.findCustomStore");
    }

    public static void main(String[] args) {
        System.out.println(((DaoFactory) ApplicationService.getApplicationContext().getBean("daoFactory")).getStoreDAO().findCustomStore().size());
    }
}
