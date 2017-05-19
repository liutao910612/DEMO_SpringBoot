package com.liutao.model;

/**
 * 员工数据模型
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 */
public class Employee {
    private String name;
    private String age;
    private String cellPhone;

    public Employee() {
    }

    public Employee(String name, String age, String cellPhone) {
        this.name = name;
        this.age = age;
        this.cellPhone = cellPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }
}
