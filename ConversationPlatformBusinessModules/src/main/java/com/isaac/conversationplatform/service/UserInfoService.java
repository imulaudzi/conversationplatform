package com.isaac.conversationplatform.service;

import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.dto.UserAccountStatus;

import java.util.List;

/**
 * Created by isaac on 2016/10/13.
 */
public interface UserInfoService {

    UserAccountStatus registerUser(UserInfo userInfo);

    UserInfo deRegisterUSer(UserInfo userInfo);

    UserInfo createUser(UserInfo userInfo);

    UserInfo findbyId(Long userId);

    UserInfo findbyEmailAddress(String emailAddress);

    List<UserInfo> findbyDisplayName(String displayName);

    List<UserInfo> findAll();


}
