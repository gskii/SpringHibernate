package ru.ncedu.gorbatovskiy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ncedu.gorbatovskiy.dao.DaoFactory;
import ru.ncedu.gorbatovskiy.model.Book;
import ru.ncedu.gorbatovskiy.model.Store;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DaoFactory factory = (DaoFactory) context.getBean("daoFactory");
        System.out.println(factory.getBookDAO().read(1));
        System.out.println(factory.getBookDAO().getCount());
        System.out.println(factory.getOrderDAO().read(1));
        System.out.println(factory.getOrderDAO().getCount());
        System.out.println(factory.getStoreDAO().read(1));
        System.out.println(factory.getStoreDAO().getCount());
        System.out.println(factory.getCustomerDAO().read(1));
        System.out.println(factory.getCustomerDAO().getCount());

        Store store = factory.getStoreDAO().read(1);
        store.setAddress("weeeee");
        factory.getStoreDAO().update(store);
    }
}
