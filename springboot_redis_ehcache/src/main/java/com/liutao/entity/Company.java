package com.liutao.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LIUTAO
 * @version 2017/4/27
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
public class Company {
    private long id;
    private String name;
    private String address;
    private String cellPhone;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "cellPhone")
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (address != null ? !address.equals(company.address) : company.address != null) return false;
        if (cellPhone != null ? !cellPhone.equals(company.cellPhone) : company.cellPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        return result;
    }
}
