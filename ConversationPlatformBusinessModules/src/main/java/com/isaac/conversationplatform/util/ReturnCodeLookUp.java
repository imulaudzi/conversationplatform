package com.isaac.conversationplatform.util;

/**
 * Created by isaac on 2016/10/18.
 */
public enum ReturnCodeLookUp {
    UNKNOWN_ERROR(-1, "An unknown error occurred"),
    SUCCESS(1,"Success"),
    USER_ALREADY_REGISTERED(2,"User already registered"),
    UNHANDLED_ERROR(1999,"Unhandled exception");

    private final Integer returnCode;

    private final String returnMessage;

    private ReturnCodeLookUp(final Integer aReturnCode, final String aReturnMessage) {
        this.returnCode = aReturnCode;
        this.returnMessage = aReturnMessage;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

}