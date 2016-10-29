package com.isaac.conversationplatform.transformation.impl;

import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.generated.UserAccountRequest;
import com.isaac.conversationplatform.transformation.RegistrationTransformer;

/**
 * Created by isaac on 2016/10/27.
 */
public class RegistrationTransformerImpl implements RegistrationTransformer{
    @Override
    public UserInfo userInfoFromXsdObject(UserAccountRequest xsdUser) {

        UserInfo userInfo = new UserInfo();
        userInfo.setName(xsdUser.getName());
        userInfo.setSurname(xsdUser.getSurname());
        userInfo.setDisplayName(xsdUser.getDisplayName());
        userInfo.setDateOfBirth(xsdUser.getDateOfBirth());
        userInfo.setEmailAddress(xsdUser.getEmailAddress());
        userInfo.setIDnumber(xsdUser.getIdNumber());

        return userInfo;
    }
}
