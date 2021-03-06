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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
            registrationStatus.setUserInfo(createUser(userInfo));
            registrationStatus.setReturnCodeLookUp(ReturnCodeLookUp.SUCCESS);
            LOGGER.info("After Reg : " + userInfo.toString());
        }
        return registrationStatus;
    }

    UserInfo findThisUser(UserInfo userSearchDetails) {
        UserInfo foundUser = null;
        if (userSearchDetails != null) {
            UserInfo userInfo = new UserInfo();
            if (userSearchDetails.getEmailAddress() != null && searchUserByEmail(userSearchDetails) != null) {
                foundUser = userInfoRepository.findUserByEmail(userSearchDetails.getEmailAddress());
            } else if (userSearchDetails.getIDnumber() != null && searchUserByIDNumber(userSearchDetails) != null) {
                foundUser = userInfoRepository.findUserByIDNumber(userSearchDetails.getIDnumber());
            }
        } else {
            LOGGER.info("UserSearchDetails is null.");
        }
        return foundUser;
    }

    private UserInfo searchUserByEmail(UserInfo userSearchDetails) {
        LOGGER.info(String.format("Searching User with Email Address : %s ", userSearchDetails.getEmailAddress()));
        return userInfoRepository.findUserByEmail(userSearchDetails.getEmailAddress());
    }

    private UserInfo searchUserByIDNumber(UserInfo userSearchDetails) {
        LOGGER.info(String.format("Searching User with ID Number : %s ", userSearchDetails.getIDnumber()));
        return userInfoRepository.findUserByIDNumber(userSearchDetails.getIDnumber());
    }

    @Override
    public UserAccountStatus deRegisterUSer(UserInfo userInfo) {
        UserInfo foundUser;
        UserAccountStatus registrationStatus = new UserAccountStatus();
        foundUser = this.findThisUser(userInfo);
        if (foundUser == null) {
            registrationStatus.setReturnCodeLookUp(ReturnCodeLookUp.USER_DOES_NOT_EXIST);
            LOGGER.info("The User you are attempting to deRegister is not registered on the system");
        } else {
            LOGGER.info("The User you are attempting to deRegister is registered on the system");

            if (AccountStatus.INACTIVE.equals(foundUser.getAccountStatus())) {
                registrationStatus.setReturnCodeLookUp(ReturnCodeLookUp.USER_ALREADY_INACTIVE);
                LOGGER.info("The User you are attempting to deRegister is InActive");
                registrationStatus.setUserInfo(foundUser);
            } else {
                Integer i = userInfoRepository.deRegister(foundUser.getUserId());
                if (i.equals(1)) {
                    registrationStatus.setReturnCodeLookUp(ReturnCodeLookUp.USER_DEREGISTERED_SUCCESS);
                } else {
                    registrationStatus.setReturnCodeLookUp(ReturnCodeLookUp.UNHANDLED_ERROR);
                }
                registrationStatus.setUserInfo(foundUser);
            }
        }
        return registrationStatus;
    }

    @Override
    public UserInfo createUser(UserInfo userInfo) {
        userInfo.setAccountStatus(AccountStatus.PENDING);
        userInfo.setRegisteredOn(LocalDateTime.now());
        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo findbyId(Long userId) {
        return userInfoRepository.findOne(userId);
    }

    @Override
    public UserInfo findbyEmailAddress(String emailAddress) {
        return userInfoRepository.findUserByEmail(emailAddress);
    }

    @Override
    public List<UserInfo> findbyDisplayName(String displayName) {
        return userInfoRepository.findUserByDisplayName(displayName);
    }

    @Override
    public UserInfo findbyIdNumber(String IDNumber) {
        return userInfoRepository.findUserByIDNumber(IDNumber);
    }

    @Override
    public List<UserInfo> findAll() {
        return (List<UserInfo>) userInfoRepository.findAll();
    }
}
