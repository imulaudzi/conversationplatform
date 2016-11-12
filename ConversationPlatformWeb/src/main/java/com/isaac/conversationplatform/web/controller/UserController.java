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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RegistrationTransformer registrationTransformer;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String hello() {
        return "welcome";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserAccountResponse register(@RequestBody UserAccountRequest register) {

        UserInfo userInfo = registrationTransformer.userInfoFromXsdObject(register);
        UserAccountStatus userAccountStatus = userInfoService.registerUser(userInfo);

        return this.registrationResponse( userAccountStatus);
    }

    private UserAccountResponse registrationResponse(  UserAccountStatus userAccountStatus) {
        UserAccountResponse response = new UserAccountResponse();
        response.setUserId(userAccountStatus.getUserId());
        response.setResponseCodeMessage(ResponseUtil.responseFromEnum(userAccountStatus.getReturnCodeLookUp()));

        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {

        ModelAndView model = new ModelAndView("welcome");
        model.addObject("msg", "hello world");

        return model;
    }
}