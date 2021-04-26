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
        final List<Criteria> criteria = new ArrayList<>();

       /* if (payload.getUserID() != null) {
            List<ObjectId> Ids = new ArrayList<>();
            Ids.add(new ObjectId(payload.getUserID()));
            criteria.add(Criteria.where("_id").nin(Ids));
        }*/


        criteria.add(Criteria.where("loc").near(new Point(payload.getLng(), payload.getLat())).maxDistance(payload.getDistance()));
    /*    if (payload.getGenders() != null) {
            criteria.add(Criteria.where("gender").in(payload.getGenders()));
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
        query.limit(limit).skip(skip);
*/

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return mongoTemplate.find(query, User.class,"users");
    }
}
