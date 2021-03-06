package ru.ncedu.gorbatovskiy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Gorbatovskiy on 21.03.2016.
 */
@Entity
@Table(name = "CUSTOMER")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Customer.findWithUniqueAddresses",
                query = "SELECT * FROM CUSTOMER GROUP BY ADDRESS",
                resultClass = Customer.class
        ),
        @NamedNativeQuery(
                name = "Customer.findSpecifyCustomer",
                query = "SELECT * FROM CUSTOMER " +
                        "WHERE ADDRESS LIKE '%Нижегородский район%'",
                resultClass = Customer.class
        )

})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "CUSTOMER_GENERATOR")
    @GenericGenerator(name = "CUSTOMER_GENERATOR", strategy = "increment")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DISCOUNT")
    private Integer discount;

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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", discount=" + discount +
                '}';
    }
}
