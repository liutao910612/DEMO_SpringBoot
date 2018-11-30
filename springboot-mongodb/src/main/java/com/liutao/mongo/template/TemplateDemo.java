package com.liutao.mongo.template;

import com.liutao.publiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 演示mongoTemplate的使用
 *
 * @author: LIUTAO
 * @Date: Created in 2018/11/30  19:38
 * @Modified By:
 */
@Component
public class TemplateDemo {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 演示save
     * 针对mongoTemplate的save函数，如果指定了集合名称则存入指定的集合名称当中，
     * 否则将传入的对象的类的首字母小写作为集合名称
     * @param user
     */
    public void saveUser(User user,String collectionName){
        if(StringUtils.isEmpty(collectionName)){
            mongoTemplate.save(user);
        }else {
            mongoTemplate.save(user,collectionName);
        }
    }

    public User findByUsername(String username,String collectionName){
        Query query = new Query(Criteria.where("username").is(username));
        User user = mongoTemplate.findOne(query,User.class,collectionName);
        return user;
    }
}
