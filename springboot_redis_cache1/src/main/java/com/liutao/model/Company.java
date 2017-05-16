package com.liutao.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LIUTAO
 * @version 2017/4/27
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Company implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;
    private String address;

    public Company() {
    }

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
