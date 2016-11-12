package com.isaac.conversationplatform.service.impl;

import com.isaac.conversationplatform.dao.UserInfoRepository;
import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.dao.model.enums.AccountStatus;
import com.isaac.conversationplatform.dto.UserAccountStatus;
import com.isaac.conversationplatform.service.UserInfoService;
import com.isaac.conversationplatform.util.ReturnCodeLookUp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by isaac on 2016/10/13.
 */
@Service
@Transactional
public class UserServiceImpl implements UserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);
    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public UserAccountStatus registerUser(UserInfo userInfo) {
        UserInfo foundUser;
        UserAccountStatus registrationStatus = new UserAccountStatus();
        foundUser = this.findThisUser(userInfo);
        if (foundUser != null) {
            registrationStatus.setReturnCodeLookUp(ReturnCodeLookUp.USER_ALREADY_REGISTERED);
            LOGGER.info("User already registered.");
        } else {
            LOGGER.info("This user is not registered. Will continue and create the user...");
            registrationStatus.setUserInfo( createUser(userInfo));
        }
        return registrationStatus;
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
