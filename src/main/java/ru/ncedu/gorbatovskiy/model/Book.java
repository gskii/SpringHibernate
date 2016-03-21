package ru.ncedu.gorbatovskiy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

    @Id
    @GeneratedValue(generator = "BOOK_GENERATOR")
    @GenericGenerator(name = "BOOK_GENERATOR", strategy = "increment")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "COUNT")
    private Integer count;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COST")
    private Double cost;

    @Column(name = "STORE_HOUSE")
    private String storeHouse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(String storeHouse) {
        this.storeHouse = storeHouse;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", storeHouse='" + storeHouse + '\'' +
                '}';
    }
}
