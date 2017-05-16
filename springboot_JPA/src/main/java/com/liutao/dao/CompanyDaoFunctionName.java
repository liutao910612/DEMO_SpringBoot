package com.liutao.dao;

import com.liutao.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by LIUTAO on 2017/3/22.
 */
public interface CompanyDaoFunctionName extends JpaRepository<Company,Long> {
    /**
     * 说明：按照Spring data 定义的规则，查询方法以find|read|get开头
     * 涉及条件查询时，条件的属性用条件关键字连接，要注意的是：条件属性首字母需大写
     */



    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.name = :name and c.address = :address
     * 参数名大写，条件名首字母大写，并且接口名中参数出现的顺序必须和参数列表中的参数顺序一致
     */
    Company findByNameAndAddress(String name, String address);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.name = ?1 or c.address = ?2
     */
    List<Company> findByNameOrAddress(String name, String address);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.id between ?1 and ?2
     */
    List<Company> findByIdBetween(Long start, Long end);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.id < ?1
     */
    List<Company> findByIdLessThan(Long end);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.id > ?1
     */
    List<Company> findByIdGreaterThan(Long start);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.name is null
     */
    List<Company> findByNameIsNull();

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.name is not null
     */
    List<Company> findByNameIsNotNull();

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.name like ?1
     */
    List<Company> findByNameLike(String name);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.name not like ?1
     */
    List<Company> findByNameNotLike(String name);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.address = ?1 order by c.id desc
     */
    List<Company> findByAddressOrderByIdDesc(String address);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.name <> ?1
     */
    List<Company> findByNameNot(String name);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.id in ?1
     */
    List<Company> findByIdIn(List<Long> ids);

    /**
     * 注：此处这个接口相当于发送了一条SQL:select c from Company c where c.id not in ?1
     */
    List<Company> findByIdNotIn(List<Long> ids);
}
