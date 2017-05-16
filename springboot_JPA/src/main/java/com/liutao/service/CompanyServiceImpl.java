package com.liutao.service;

import com.liutao.dao.CompanyDaoQuery;
import com.liutao.dao.CompanyDaoExJpaSpecificationExecutor;
import com.liutao.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIUTAO on 2017/3/22.
 */
@Service
public class CompanyServiceImpl {
    @Autowired
    private CompanyDaoQuery companyDao;
    @Autowired
    private CompanyDaoExJpaSpecificationExecutor cJ;
    public Company findByName(String name) {
        return companyDao.findByName(name);
    }

    public Company findCompanyByAddressAndName(String address, String name) {
        return companyDao.findCompanyByAddressAndName(address,name);
    }

    /**
     * 以下代码是用于演示JpaSpecificationExecutor的使用
     */

    //根据name来查询一个公司
    public Company findCompanyByName(final String name){
        return cJ.findOne(new Specification<Company>() {
            @Override
            public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("name"),name);
                return null;
            }
        });
    }

    //根据name和address来查询一个公司
    public Company findCompanyByNameAndAddress2(final String name,final String address){
        return cJ.findOne(new Specification<Company>() {
            @Override
            public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                Predicate predicate1 = criteriaBuilder.equal(root.get("name"),name);
                Predicate predicate2 = criteriaBuilder.equal(root.get("address"),address);
                list.add(predicate1);
                list.add(predicate2);
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        });
    }

    //组合查询
    public Company findCompanyByCompany(final Company company){
        return  cJ.findOne(new Specification<Company>() {
            @Override
            public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("name"),company.getName());
                criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("address"),company.getAddress()));
                criteriaBuilder.and(predicate,criteriaBuilder.equal(root.get("cellPhone"),company.getCellPhone()));
                return predicate;
            }
        });
    }

    //范围查询in方法，例如查询id在[2,10]中的公司
    public List<Company> findCompanyByIds(final List<Long> ids){
        return cJ.findAll(new Specification<Company>() {

            @Override
            public Predicate toPredicate(Root<Company> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return root.in(ids);
            }
        });
    }

    /**
     * 描述：范围查询gt方法，例如查询公司id大于5的所有公司
     */
    public List<Company> findCompanyByGtId(final Long id){
        return cJ.findAll(new Specification<Company>() {

            @Override
            public Predicate toPredicate(Root<Company> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.gt(root.get("id").as(Long.class), id);
            }
        });
    }

    /**
     * 描述：范围查询lt方法，例如查询公司id小于5的公司
     */
    public List<Company> findCompanyByLtId(final Long id){
        return cJ.findAll(new Specification<Company>() {

            @Override
            public Predicate toPredicate(Root<Company> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lt(root.get("id").as(Long.class), id);
            }
        });
    }

    /**
     * 描述：范围查询between方法，例如查询id在3和10之间的公司
     */
    public List<Company> findCompanyBetweenId(final Long start, final Long end){
        return cJ.findAll(new Specification<Company>() {

            @Override
            public Predicate toPredicate(Root<Company> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.between(root.get("id").as(Long.class), start, end);
            }
        });
    }

    /**
     * 描述：排序和分页操作
     */
    public Page<Company> findCompanyAndOrder(final Long id){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return cJ.findAll(new Specification<Company>() {

            @Override
            public Predicate toPredicate(Root<Company> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.gt(root.get("id").as(Long.class), id);
            }
        }, new PageRequest(0, 5, sort));
    }

    /**
     * 描述：只有排序操作
     */
    public List<Company> findCompanyAndOrderSecondMethod(final Long id){
        return cJ.findAll(new Specification<Company>() {

            @Override
            public Predicate toPredicate(Root<Company> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                cb.gt(root.get("id").as(Long.class), id);
                query.orderBy(cb.desc(root.get("id").as(Long.class)));
                return query.getRestriction();
            }
        });
    }


}

