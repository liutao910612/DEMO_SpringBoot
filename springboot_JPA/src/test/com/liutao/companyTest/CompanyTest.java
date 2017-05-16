package com.liutao.companyTest;

import com.liutao.application.Application;
import com.liutao.dao.CompanyDaoQuery;
import com.liutao.service.CompanyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;

/**
 * Created by LIUTAO on 2017/3/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class CompanyTest {

    @Autowired
    private CompanyServiceImpl companyServiceImpl;

    @Autowired
    private CompanyDaoQuery companyDaoQuery;

    @Test
    public void testOne(){
        System.out.println("company:"+companyServiceImpl.findByName("华为"));
    }

    @Test
    public void testFindCompanyByAddressAndName(){
        System.out.println("enter testFindCompanyByAddressAndName");
        System.out.println("company:"+companyServiceImpl.findCompanyByAddressAndName("人民南路","华为"));
    }

    @Test
    public void testQuery(){
        System.out.println("result:"+companyDaoQuery.findCompanyByNameUseIndex("华为"));
        companyDaoQuery.updateCompany("人民南路","宏图物流");
        System.out.println(companyServiceImpl.findByName("华为"));
        System.out.println("result:"+companyDaoQuery.findCompanyByAddressAndName("人民南路","华为"));
    }
}
