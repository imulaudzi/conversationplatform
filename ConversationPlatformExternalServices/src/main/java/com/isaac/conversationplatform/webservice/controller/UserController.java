package com.isaac.conversationplatform.webservice.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RegistrationTransformer registrationTransformer;

    public UserAccountResponse register(@RequestBody UserAccountRequest register, HttpServletResponse httpServletResponse) {

        UserInfo userInfo = registrationTransformer.userInfoFromXsdObject(register);
        UserAccountStatus userAccountStatus = userInfoService.registerUser(userInfo);

    }

    private UserAccountResponse registrationResponse(HttpServletResponse httpServletResponse,UserAccountStatus userAccountStatus){
        UserAccountResponse response = new UserAccountResponse();
        response.setUserId(userAccountStatus.getUserId());
        response.setResponseCodeMessage(ResponseUtil.responseFromEnum(userAccountStatus.getReturnCodeLookUp()));

        return response;
    }
}
