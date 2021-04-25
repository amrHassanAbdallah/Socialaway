package com.hawaya.socialaway.repostories;

import com.hawaya.socialaway.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
