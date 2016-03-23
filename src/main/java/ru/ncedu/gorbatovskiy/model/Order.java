package ru.ncedu.gorbatovskiy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
@Entity
@Table(name = "ORDERS")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Order.findWithUniqueMonth",
//                query = "SELECT DISTINCT MONTH(ORDER_DATE) FROM ORDERS"
                query = "SELECT * FROM ORDERS GROUP BY MONTH(ORDER_DATE)",
                resultClass = Order.class
        ),
        @NamedNativeQuery(
                name = "Order.findGreatBuy",
                query = "SELECT * FROM ORDERS O " +
                        "JOIN CUSTOMER C ON C.ID = O.CUSTOMER_ID " +
                        "WHERE O.PRICE >= 60000",
                resultClass = Order.class
        )
//        @NamedQuery(name = "Order.findOrderTitle",
//                query = "SELECT C.NAME, S.NAME FROM ORDERS O " +
//                        "JOIN CUSTOMER C ON C.ID = O.CUSTOMER_ID " +
//                        "JOIN STORE S ON S.ID = O.STORE_ID"),
//        @NamedQuery(name = "Order.findOrderContext",
//                query = "SELECT O.ORDER_DATE, C.NAME, C.DISCOUNT * B.COST /100, B.NAME, O.COUNT FROM ORDERS O " +
//                        "JOIN CUSTOMER C ON C.ID = O.CUSTOMER_ID " +
//                        "JOIN BOOK B ON B.ID = O.BOOK_ID"),

})

public class Order {

    @Id
    @GeneratedValue(generator = "ORDER_GENERATOR")
    @GenericGenerator(name = "ORDER_GENERATOR", strategy = "increment")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ORDER_DATE")
    private Date date;

    @Column(name = "COUNT")
    private Integer count;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", count=" + count +
                ", price=" + price +
                ", customer=" + customer +
                ", book=" + book +
                ", store=" + store +
                '}';
    }
}

