package com.isaac.conversationplatform.util;

/**
 * Created by isaac on 2016/10/18.
 */
public enum ReturnCodeLookUp {
    UNKNOWN_ERROR(-1, "An unknown error occurred"),
    SUCCESS(1,"Success"),
    USER_ALREADY_REGISTERED(2,"User already registered"),
    UNHANDLED_ERROR(1999,"Unhandled exception"),
    USER_DEREGISTERED_SUCCESS(3000,"The user de-registered successfully"),
    USER_DOES_NOT_EXIST(3001,"The user does not exist"),
    USER_ALREADY_INACTIVE(3002, "The user is already inactive");

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
