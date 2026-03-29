package com.server.impala.enums;

public enum RequestTypeEnum {
    CONFIRM_ACCOUNT("confirm_account"),
    RESET_PASSWORD("reset_password");

    public final String label;

    private RequestTypeEnum(String label) {
        this.label = label;
    }
}
