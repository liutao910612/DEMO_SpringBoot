package com.liutao.model;

import com.liutao.validateInterface.PersonAddView;
import com.liutao.validateInterface.PersonUpdateView;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * person数据模型
 *
 * @author LIUTAO
 * @version 2017/5/19
 * @see
 */
public class Person {
    private Long id;

    /**
     * 针对验证标签里面添加groups说明仅仅在特定的验证规则里面起作用，如果不加，那么就在默认的验证规则里面起作用。
     */

    @NotNull(groups = {PersonAddView.class},message = "添加的姓名不能为空")
    @Length(min = 2,max = 10,groups = {PersonUpdateView.class},message = "修改时的姓名必须在2到10个字符之间")
    private String name;

    @NotNull(groups = {PersonAddView.class}, message = "添加用户时地址不能为空")
    private String address;

    @Min(value = 18, groups = {PersonAddView.class}, message = "年龄不能低于18岁")
    @Max(value = 30, groups = {PersonUpdateView.class}, message = "年龄不能超过30岁")
    private Integer age;

    public Person() {
    }

    public Person(Long id, String name, String address, Integer age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
