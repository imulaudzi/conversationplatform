package com.isaac.conversationplatform.dto;

import com.isaac.conversationplatform.util.ReturnCodeLookUp;

/**
 * Created by isaac on 2017/01/24.
 */
public class PostMessageStatus {
    private ReturnCodeLookUp returnCodeLookUp;

    public ReturnCodeLookUp getReturnCodeLookUp() {
        return returnCodeLookUp;
    }

    public void setReturnCodeLookUp(ReturnCodeLookUp returnCodeLookUp) {
        this.returnCodeLookUp = returnCodeLookUp;
    }

}
