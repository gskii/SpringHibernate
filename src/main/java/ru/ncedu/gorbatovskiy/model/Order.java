package ru.ncedu.gorbatovskiy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
@Table(name = "ORDERS")
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

