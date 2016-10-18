package com.isaac.conversationplatform.service.impl;

import com.isaac.conversationplatform.dao.UserInfoRepository;
import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.dao.model.enums.AccountStatus;
import com.isaac.conversationplatform.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by isaac on 2016/10/13.
 */
public class UserServiceImpl implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);
    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public UserInfo registerUser(UserInfo userInfo) {
        UserInfo foundUser;
        foundUser = this.findThisUser(userInfo);
        if (foundUser != null) {
            LOGGER.info("User already registered.");
        } else {
            LOGGER.info("This user is not registered. Will continue and create the user...");
            foundUser = createUser(userInfo);
        }
        return foundUser;
    }

    UserInfo findThisUser(UserInfo userSearchDetails) {
        UserInfo foundUser = null;
        if (userSearchDetails != null) {

            if (userSearchDetails.getEmailAddress() != null) {
                LOGGER.info(String.format("Searching User with Email Address : %s ", userSearchDetails.getEmailAddress()));
                foundUser = userInfoRepository.findUserByEmail(userSearchDetails.getEmailAddress());
            } else if (userSearchDetails.getIDnumber() != null) {
                LOGGER.info(String.format("Searching User with ID Number : %s ", userSearchDetails.getIDnumber()));
                foundUser = userInfoRepository.findUserByIDNumber(userSearchDetails.getIDnumber());

            }

        } else {
            LOGGER.info("UserSearchDetails is null.");
        }
        return foundUser;
    }


    @Override
    public UserInfo deRegisterUSer(UserInfo userInfo) {
        return null;
    }

    @Override
    public UserInfo createUser(UserInfo userInfo) {
        userInfo.setAccountStatus(AccountStatus.PENDING);
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo findbyId(Long userId) {
        return null;
    }

    @Override
    public UserInfo findbyEmailAddress(String emailAddress) {
        return null;
    }

    @Override
    public List<UserInfo> findbyDisplayName(String displayName) {
        return null;
    }

    @Override
    public List<UserInfo> findAll() {
        return null;
    }
}
