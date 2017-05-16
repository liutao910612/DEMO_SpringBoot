package com.liutao.companyTest;

import com.liutao.application.Application;
import com.liutao.model.Company;
import com.liutao.service.CompanyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LIUTAO on 2017/3/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class CompanyTestJpaSpecificationExecutor {
    @Autowired
    private CompanyServiceImpl companyServiceImpl;

    @Test
    public void testFindCompanyByNameAndEmail(){
        Company company = companyServiceImpl.findCompanyByNameAndAddress2("华为", "人民南路");
        System.out.println(company);
    }

}
