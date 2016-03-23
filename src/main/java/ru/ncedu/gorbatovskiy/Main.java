package ru.ncedu.gorbatovskiy;

import ru.ncedu.gorbatovskiy.dao.*;
import ru.ncedu.gorbatovskiy.model.Book;
import ru.ncedu.gorbatovskiy.model.Customer;
import ru.ncedu.gorbatovskiy.model.Order;
import ru.ncedu.gorbatovskiy.model.Store;

import java.text.SimpleDateFormat;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
public class Main {
    private DaoFactory daoFactory;

    public Main(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * CRUD test
     */
    public void genericDaoTest() {
        System.out.println("Main.genericDaoTest");
        System.out.println("===================");

        BookDAO dao = daoFactory.getBookDAO();
        System.out.println("Изначальное количество = " + dao.getCount());

        Book book = new Book();
        book.setName("TEST_BOOK");
        book.setCost(12345.6);
        book.setCount(123);
        book.setStoreHouse("TEST_STORE_HOUSE");
        System.out.println("Создаю book = " + book);

        Integer id = dao.create(book);
        System.out.println("Сохраняю с id = " + id);

        book = dao.read(id);
        System.out.println("Считываю book = " + book);

        book.setName("ANOTHER_TEST_NAME");
        dao.update(book);
        book = dao.read(id);
        System.out.println("Обновляю имя, сохраняю и считываю book = " + book);

        System.out.println("Итого в базе содержится:");
        for (Book item : dao.findAll()) {
            System.out.println(item);
        }

        System.out.println("Количество теперь = " + dao.getCount());

        dao.delete(book);
        System.out.println("Удаляю книгу, количество теперь = " + dao.getCount() + "\n");
    }

    /**
     * Вывод всех различных названий и стоимостей книг;
     */
    public void printUniqueBooks() {
        System.out.println("Main.printUniqueBooks");
        System.out.println("====================");
        BookDAO dao = daoFactory.getBookDAO();
        for (Book book : dao.findUniqueBooks()) {
            System.out.println(book.getName() + "\t" + book.getCost());
        }
        System.out.println();
    }

    /**
     * Вывод всех различных районов, в которых проживают покупатели;
     */
    public void printCustomerWithUniqueAddress() {
        System.out.println("Main.printCustomerWithUniqueAddress");
        System.out.println("==================================");
        CustomerDAO dao = daoFactory.getCustomerDAO();
        for (Customer customer : dao.findWithUniqueAddress()) {
            System.out.println(customer.getAddress());
        }
        System.out.println();
    }

    /**
     * Вывод всех различных месяцев, когда производились покупки
     */
    public void printOrdersWithUniqueMonth() {
        System.out.println("Main.printOrdersWithUniqueMonth");
        System.out.println("==============================");
        OrderDAO dao = daoFactory.getOrderDAO();
        for (Order order : dao.findWithUniqueMonth()) {
            System.out.println(new SimpleDateFormat("MMM").format(order.getDate()));
        }
        System.out.println();
    }

    /**
     * Вывод фамилий и размера скидок всех покупателей, проживающих в Нижегородском районе;
     */
    public void printSpecifyCustomer() {
        System.out.println("Main.printCustomStore");
        System.out.println("====================");
        CustomerDAO dao = daoFactory.getCustomerDAO();
        for (Customer customer : dao.findSpecifyCustomer()) {
            System.out.println(customer.getName() + "\t" + customer.getDiscount());
        }
        System.out.println();
    }

    /**
     * Вывести названия магазинов Сормовского или Советского районов;
     */
    public void printCustomStore() {
        System.out.println("Main.printCustomStore");
        System.out.println("====================");
        StoreDAO dao = daoFactory.getStoreDAO();
        for (Store store : dao.findCustomStore()) {
            System.out.println(store.getName());
        }
        System.out.println();
    }

    /**
     * Названиях и стоимости книг, в которых встречается слово Windows, или стоящих более 20000 руб.
     * Вывод результатов организовать по названию и убыванию цены книг.
     */
    public void printWindowsOrExpensiveBooks() {
        System.out.println("Main.printWindowsOrExpensiveBooks");
        System.out.println("================================");
        BookDAO dao = daoFactory.getBookDAO();
        for (Book book : dao.findWindowsOrExpensiveBooks()) {
            System.out.println(book.getName() + "\t" + book.getCost());
        }
        System.out.println();
    }

    /**
     * Вывести фамилию покупателя и название магазина, где производилась покупка;
     */
    public void printOrderTitle() {
        System.out.println("Main.printOrderTitle");
        System.out.println("====================");
        OrderDAO dao = daoFactory.getOrderDAO();
        for (Order order : dao.findAll()) {
            System.out.println(order.getBook().getName() + "\t" + order.getStore().getName());
        }
        System.out.println();
    }

    /**
     * Вывести дату, фамилию покупателя, скидку, название и количество купленных книг.
     */
    public void printOrderContext() {
        System.out.println("Main.printOrderContext");
        System.out.println("======================");
        OrderDAO dao = daoFactory.getOrderDAO();
        for (Order order : dao.findAll()) {
            System.out.println(order.getDate() + "\t"
                    + order.getCustomer().getName() + "\t"
                    + order.getCustomer().getDiscount() + "\t"
                    + order.getBook().getName() + "\t"
                    + order.getCount()
            );
        }
        System.out.println();
    }

    /**
     * Вывести номер заказа, фамилию покупателя и дату для покупок,
     * в которых было продано книг на сумму не меньшую чем 60000 руб
     */
    public void printGreatBuy() {
        System.out.println("Main.printGreatBuy");
        System.out.println("==================");
        OrderDAO dao = daoFactory.getOrderDAO();
        for (Order order : dao.findGreatBuy()) {
            System.out.println(order.getId() + "\t"
                    + order.getCustomer().getName() + "\t"
                    + order.getDate()
            );
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Main main = (Main) ApplicationService.getApplicationContext().getBean("main");

        // Задание 1: CRUD для таблиц
        main.genericDaoTest();

        // Задание 2:
        main.printUniqueBooks();
        main.printCustomerWithUniqueAddress();
        main.printOrdersWithUniqueMonth();

        // Задание 3:
        main.printSpecifyCustomer();
        main.printCustomStore();
        main.printWindowsOrExpensiveBooks();

        // Задание 4:
        main.printOrderTitle();
        main.printOrderContext();

        // Задание 5:
        main.printGreatBuy();

    }
}
