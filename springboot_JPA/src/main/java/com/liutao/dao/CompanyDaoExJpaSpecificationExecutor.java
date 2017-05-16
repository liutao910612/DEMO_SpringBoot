package com.liutao.dao;

import com.liutao.model.Company;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by LIUTAO on 2017/3/22.
 */
public interface CompanyDaoExJpaSpecificationExecutor extends CrudRepository<Company, Long>,
        JpaSpecificationExecutor<Company> {

}
