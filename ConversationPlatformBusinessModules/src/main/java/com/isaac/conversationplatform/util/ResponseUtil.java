package com.isaac.conversationplatform.util;

import com.isaac.conversationplatform.generated.ResponseCodeMessage;

/**
 * Created by isaac on 2016/10/28.
 */
public class ResponseUtil {

    private ResponseUtil() {
    }

    public static ResponseCodeMessage responseFromEnum (ReturnCodeLookUp codeLookUp){
        ResponseCodeMessage responseCodeMessage = new ResponseCodeMessage();
        responseCodeMessage.setCode(codeLookUp.getReturnCode());
        responseCodeMessage.setMessage(codeLookUp.getReturnMessage());
        return responseCodeMessage;
    }
}
