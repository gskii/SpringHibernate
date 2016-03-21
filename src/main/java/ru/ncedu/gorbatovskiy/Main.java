package ru.ncedu.gorbatovskiy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ncedu.gorbatovskiy.model.Book;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        System.out.println("weeeeeeee");
        Session session = sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, 1);
        System.out.println("book = " + book);
        session.close();


    }
}
