package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.UserInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by isaac on 2016/09/19.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
@Transactional
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {


    @Query("SELECT u FROM UserInfo u WHERE u.emailAddress = :emailAddress")
    public UserInfo findUserByEmail(@Param("emailAddress") String emailAddress);

    @Query("SELECT u FROM UserInfo u WHERE u.IDnumber = :idNumber")
    public UserInfo findUserByIDNumber(@Param("idNumber") String idNumber);

    @Query("SELECT u FROM UserInfo u WHERE u.displayName = :displayName")
    public List<UserInfo> findUserByDisplayName(@Param("displayName") String displayName);

    //TODO Add update method. For DeRegister use case
    @Modifying
    @Query("UPDATE UserInfo u set u.accountStatus = 'INACTIVE' WHERE u.userId = :userId")
    public Integer deRegister(@Param("userId") Long userId);

}
