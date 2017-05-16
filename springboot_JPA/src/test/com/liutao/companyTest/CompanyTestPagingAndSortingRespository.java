package com.liutao.companyTest;

import com.liutao.application.Application;
import com.liutao.dao.CompanyDaoExPagingAndSortingRepository;
import com.liutao.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * Created by LIUTAO on 2017/3/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CompanyTestPagingAndSortingRespository {
    @Autowired
    private CompanyDaoExPagingAndSortingRepository dao;

    @Test
    public void testOrder(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 5, sort);
        Page<Company> page = dao.findAll(pageable);
        System.out.println(page);
        System.out.println(page.getSize());
    }
}
