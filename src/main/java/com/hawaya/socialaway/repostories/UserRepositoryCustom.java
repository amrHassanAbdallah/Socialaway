package com.hawaya.socialaway.repostories;

import com.hawaya.socialaway.controllers.v1.QueryUsersByLocation;
import com.hawaya.socialaway.domains.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> listByGEOLocation(QueryUsersByLocation payload);
}
