package com.liutao.dao;

import com.liutao.model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by LIUTAO on 2017/3/22.
 */
public interface CompanyDaoExPagingAndSortingRepository extends PagingAndSortingRepository<Company,Long> {
}
