package com.isaac.conversationplatform.transformation;

import com.isaac.conversationplatform.dao.model.UserInfo;
import com.isaac.conversationplatform.generated.UserAccountRequest;

/**
 * Created by isaac on 2016/10/27.
 */
public interface RegistrationTransformer {

    UserInfo userInfoFromXsdObject(UserAccountRequest userAccountRequest);

}
