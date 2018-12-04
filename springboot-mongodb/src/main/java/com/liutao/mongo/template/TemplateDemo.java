package com.liutao.mongo.template;

import com.liutao.publiz.model.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

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


    /**
     * 演示findOne,查找一个结果
     * 这里findOne有两个重载函数，还是一个传入了集合名称一个没有
     *
     * @param username
     * @param collectionName
     * @return
     */
    public User findByUsername(String username,String collectionName){
        Query query = new Query(Criteria.where("username").is(username));
        User user;
        if(StringUtils.isEmpty(collectionName)){
            user = mongoTemplate.findOne(query,User.class,collectionName);
            return user;
        }
        user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    /**
     * 查找多个对象
     * 这里传入的find函数依然包含两个重载函数，当然在这里我们可以猜想MongoTemplate的函数应该都是成对出现的。
     * @param username
     * @param collectionName
     * @return
     */
    public List<User> findUsersByUsername(String username,String collectionName){
        Query query = new Query(Criteria.where("username").is(username));
        List<User> users = mongoTemplate.find(query,User.class,collectionName);
        return users;
    }

    /**
     * 删除对象,这里通过传入对象来指定删除的内容。
     * 我们还可以通过传入Query参数来指定要删除的内容的属性
     * @param user
     */
    public long deleteUserByUser(User user){
       DeleteResult deleteResult =  mongoTemplate.remove(user);
       return deleteResult.getDeletedCount();
    }

    /**
     * 更新数据
     * 这里我们查看源码可以发现updateFirst有很多重载函数，这些函数都用于更改第一个匹配的元素。
     * 我们也可以调用对应的updateMulti函数来更改所有匹配的数据
     * @param oldUsername
     * @param newUsername
     * @param collectionName
     * @return
     */
    public long updateUserByUsername(String oldUsername,String newUsername,String collectionName){
        Update up = new Update();
        up.set("username",newUsername);
        Query query = new Query(Criteria.where("username").is(oldUsername));
        UpdateResult updateResult = mongoTemplate.updateFirst(query,up,collectionName);
        return updateResult.getModifiedCount();
    }


}
