package com.liutao.companyTest;

import com.liutao.application.Application;
import com.liutao.dao.CompanyDaoFunctionName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by LIUTAO on 2017/3/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CompanyTestFunctionName {
    @Autowired
    private CompanyDaoFunctionName companyDaoFunctionName;
    @Test
    public void test(){
        System.out.println(companyDaoFunctionName.findByIdLessThan(5l));
    }
}
