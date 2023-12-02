package com.app.dashboard.services;

import com.app.dashboard.models.AddUserRequest;
import com.app.dashboard.models.CreateShelterRequest;
import com.app.dashboard.models.Shelter;
import com.app.dashboard.models.User;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public User findById(String id) {
        Assert.notNull(id, "ID must not be null");
        return mongoTemplate.findById(new ObjectId(id), User.class);
    }

    public User findByEmail(String email) {
        Assert.notNull(email, "Email must not be null");
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, User.class);
    }

    public User addUser(AddUserRequest userRequest) {
        Document document = userRequest.toDocument();
        mongoTemplate.insert(document, "User");
        return mongoTemplate.getConverter().read(User.class, document);
    }

}

