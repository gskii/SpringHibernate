package ru.ncedu.gorbatovskiy.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.ncedu.gorbatovskiy.ApplicationService;
import ru.ncedu.gorbatovskiy.model.Book;

import java.util.List;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class BookDAO extends GenericDAO<Book, Integer> {
    public BookDAO() {
        super(Book.class);
    }

    public List<Book> findUniqueBooks() {
        return findByNamedQuery("Book.findUniqueBooks");
    }

    public List<Book> findWindowsOrExpensiveBooks() {
        return findByNamedQuery("Book.findWindowsOrExpensiveBooks");
    }

    public static void main(String[] args) {
        System.out.println(((DaoFactory) ApplicationService.getApplicationContext().getBean("daoFactory")).getBookDAO().getCount());
        System.out.println(((DaoFactory) ApplicationService.getApplicationContext().getBean("daoFactory")).getBookDAO().findUniqueBooks());
        System.out.println(((DaoFactory) ApplicationService.getApplicationContext().getBean("daoFactory")).getBookDAO().findWindowsOrExpensiveBooks());
    }
}
