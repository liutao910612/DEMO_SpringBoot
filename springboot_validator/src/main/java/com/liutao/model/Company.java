package com.liutao.model;

import com.liutao.annotation.ListNotHasNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

/**
 * 公司数据模型
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 * @since
 */
public class Company {

    @NotEmpty(message = "公司名字不能为空")
    private String name;

    @Length(min = 2,max = 20,message = "地址信息必须在2到20个字符之间")
    private String address;

    @NotEmpty(message = "员工信息不能为空")
    @ListNotHasNull
    @Valid
    private List<Employee> employees;

    public Company() {
    }

    public Company(String name, String address, List<Employee> employees) {
        this.name = name;
        this.address = address;
        this.employees = employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                '}';
    }
}
