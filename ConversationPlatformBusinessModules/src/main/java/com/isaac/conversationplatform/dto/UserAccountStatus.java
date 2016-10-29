package com.isaac.conversationplatform.dto;

import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.util.ReturnCodeLookUp;

/**
 * Created by isaac on 2016/10/18.
 */
public class UserAccountStatus {

    private Long userId;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ReturnCodeLookUp getReturnCodeLookUp() {
        return returnCodeLookUp;
    }

    public void setReturnCodeLookUp(ReturnCodeLookUp returnCodeLookUp) {
        this.returnCodeLookUp = returnCodeLookUp;
    }

    private UserInfo userInfo;
    private ReturnCodeLookUp returnCodeLookUp;

}
