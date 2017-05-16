package com.liutao.companyTest;

import com.liutao.application.Application;
import com.liutao.dao.CompanyDaoExCrudRepository;
import com.liutao.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIUTAO on 2017/3/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class CompanyTestCrudRepository {
    @Autowired
    private CompanyDaoExCrudRepository companyDaoExCrudRepository;

    /**
     * 添加单个
     */
    @Test
    public void testSave(){
        Company company = new Company("阿里巴巴","天府三街","028-99991234");
        System.out.println("result:"+companyDaoExCrudRepository.save(company));
    }

    /**
     * 批量添加
     */
    @Test
    public void testSaveMore(){
        List<Company> companyListList = new ArrayList<Company>();
        companyListList.add(new Company("京东","一环路南三段","028-99991235"));
        companyListList.add(new Company("TCL","一环路南二段","028-99991236"));
        companyListList.add(new Company("金立","一环路南一段","028-99991237"));
        System.out.println("result:"+companyDaoExCrudRepository.save(companyListList));
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate(){
        //注意要采用这种方式实现更新需要在Service上加@Transaction注解
        Company company = companyDaoExCrudRepository.findOne(3l);
        company.setAddress("北京路12号");
    }

    /**
     * 删除(根据Id)
     */
    @Test
    public void testDeleteById(){
        companyDaoExCrudRepository.delete(2l);
    }

    /**
     * 删除(根据对象)
     */
    @Test
    public void testDeleteByDomain(){
        companyDaoExCrudRepository.delete(new Company("金立","一环路南一段","028-99991237"));
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll(){
        System.out.println("result:"+companyDaoExCrudRepository.findAll());
    }

    /**
     * 查询指定Id对象
     */
    @Test
    public void testExist(){
        System.out.println("result:"+companyDaoExCrudRepository.exists(1l));
    }

    /**
     * 判断指定的Id对象是否存在
     */
    @Test
    public void testFindById(){
        System.out.println("result:"+companyDaoExCrudRepository.findOne(1l));
    }

    /**
     * 通过Id列表来查询
     */
    @Test
    public void testFindByIdlist(){
        List<Long> idList = new ArrayList<Long>();
        idList.add(1l);
        idList.add(3l);
        idList.add(4l);
        System.out.println("result:"+companyDaoExCrudRepository.findAll(idList));
    }



}
