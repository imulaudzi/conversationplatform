package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by isaac on 2016/09/19.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT u FROM UserInfo u WHERE u.emailAddress = 'emailAddress'")
    public UserInfo findUserByEmail(@Param("emailAddress") String emailAddress);
}
