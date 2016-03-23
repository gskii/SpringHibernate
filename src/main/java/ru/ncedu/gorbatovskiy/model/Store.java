package ru.ncedu.gorbatovskiy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
@Entity
@Table(name = "STORE")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Store.findCustomStore",
                query = "SELECT * FROM STORE " +
                        "WHERE ADDRESS LIKE '%Сормовский район%' " +
                        "AND ADDRESS LIKE '%Советский район%'",
//                query = "SELECT NAME FROM STORE " +
//                        "WHERE ADDRESS LIKE '%Сормовский район%' " +
//                        "AND ADDRESS LIKE '%Советский район%'",
                resultClass = Store.class
        )

})
public class Store implements Serializable {

    @Id
    @GeneratedValue(generator = "STORE_GENERATOR")
    @GenericGenerator(name = "STORE_GENERATOR", strategy = "increment")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "COMMISSION")
    private Float commission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", commission=" + commission +
                '}';
    }
}
