package com.liutao.dao;

import com.liutao.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by LIUTAO on 2017/3/22.
 */
public interface CompanyDaoQuery extends JpaRepository<Company,Long> {
    Company findByName(String name);

    /**
     * 命名参数
     * @param address
     * @param name
     * @return
     */
    @Query("from Company c where c.name=:name and c.address=:address")
    Company findCompanyByAddressAndName(@Param("address") String address,@Param("name") String name);

    /**
     * 索引参数
     * @param name
     * @return
     */
    @Query("from Company c where c.name=?1")
    Company findCompanyByNameUseIndex(String name);

    /**
     * 执行更新
     * @param address
     * @param name
     * @return
     */
    @Modifying
    @Query("update Company c set c.name = :name where c.address = :address ")
    int updateCompany(@Param("address") String address,@Param("name") String name);


}
