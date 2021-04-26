package com.hawaya.socialaway.repostories;

import com.hawaya.socialaway.controllers.v1.QueryUsersByLocation;
import com.hawaya.socialaway.domains.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<User> listByGEOLocation(QueryUsersByLocation payload) {
        final Query query = new Query();



        Point point = new Point(payload.getLat(), payload.getLng());
        Criteria criteria = Criteria.where("loc").nearSphere(point).maxDistance(1000);
        query.addCriteria(criteria);
        if (payload.getUserID() != null) {
            List<ObjectId> Ids = new ArrayList<>();
            Ids.add(new ObjectId(payload.getUserID()));
            query.addCriteria(Criteria.where("_id").nin(Ids));
        }

        if (payload.getGenders() != null) {
            query.addCriteria(Criteria.where("gender").in(payload.getGenders()));
        }

        int page = 0;
        int limit = 10;
        if (payload.getPage() != null) {
            page = payload.getPage();
        }
        if (payload.getLimit() != null) {
            limit = payload.getLimit();
        }
        int skip = 0;
        if (page > 0) {
            skip = limit * page;
        }
        List<User> users =
                mongoTemplate.find(query.limit(limit).skip(skip), User.class);
        return users;
    }
}
