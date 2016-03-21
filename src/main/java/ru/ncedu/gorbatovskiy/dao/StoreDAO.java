package ru.ncedu.gorbatovskiy.dao;

import ru.ncedu.gorbatovskiy.model.Store;

import java.io.Serializable;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class StoreDAO extends GenericDAO<Store, Integer> {
    public StoreDAO() {
        super(Store.class);
    }

    public Integer getCount() {
        return super.getCount("STORE");
    }
}
