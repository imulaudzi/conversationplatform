package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Created by isaac on 2016/09/19.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {


    @Query("SELECT u FROM UserInfo u WHERE u.emailAddress = 'emailAddress'")
    public UserInfo findUserByEmail(@Param("emailAddress") String emailAddress);

    @Query("SELECT u FROM UserInfo u WHERE u.IDnumber = 'idNumber'")
    public UserInfo findUserByIDNumber(@Param("idNumber") String idNumber);
}
