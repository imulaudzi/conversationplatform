package com.isaac.conversationplatform.web.controller;

/**
 * Created by isaac on 2016/10/27.
 */

import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.dto.UserAccountStatus;
import com.isaac.conversationplatform.generated.UserAccountRequest;
import com.isaac.conversationplatform.generated.UserAccountResponse;
import com.isaac.conversationplatform.service.UserInfoService;
import com.isaac.conversationplatform.transformation.RegistrationTransformer;
import com.isaac.conversationplatform.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RegistrationTransformer registrationTransformer;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserAccountResponse register(@RequestBody UserAccountRequest register) {

        UserInfo userInfo = registrationTransformer.userInfoFromXsdObject(register);
        UserAccountStatus userAccountStatus = userInfoService.registerUser(userInfo);

        return this.registrationResponse(userAccountStatus);
    }

    @RequestMapping(value = "/deregister", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserAccountResponse deRegister(@RequestBody UserAccountRequest deRegister) {
        UserInfo userInfo = registrationTransformer.userInfoFromXsdObject(deRegister);
        UserAccountStatus userAccountStatus = userInfoService.deRegisterUSer(userInfo);

        return this.registrationResponse(userAccountStatus);
    }

    private UserAccountResponse registrationResponse(UserAccountStatus userAccountStatus) {
        UserAccountResponse response = new UserAccountResponse();
        if (userAccountStatus.getUserInfo() != null) {
            response.setUserId(userAccountStatus.getUserInfo().getUserId());
        }
        response.setResponseCodeMessage(ResponseUtil.responseFromEnum(userAccountStatus.getReturnCodeLookUp()));

        return response;
    }
}