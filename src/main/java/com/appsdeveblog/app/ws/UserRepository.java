package com.appsdeveblog.app.ws;

import com.appsdeveblog.app.ws.io.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}
