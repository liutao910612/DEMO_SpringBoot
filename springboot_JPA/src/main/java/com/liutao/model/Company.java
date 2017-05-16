package com.liutao.model;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * this model is used to jpa
 * Created by LIUTAO on 2017/3/22.
 */
@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "cellPhone")
    private String cellPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }

    public Company(String name, String address, String cellPhone) {
        this.name = name;
        this.address = address;
        this.cellPhone = cellPhone;
    }

    public Company() {
    }
}
