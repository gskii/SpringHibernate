package ru.ncedu.gorbatovskiy.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ncedu.gorbatovskiy.model.Book;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class BookDAO extends GenericDAO<Book, Integer> {
    public BookDAO() {
        super(Book.class);
    }

    public Integer getCount() {
        return super.getCount("BOOK");
    }
}
