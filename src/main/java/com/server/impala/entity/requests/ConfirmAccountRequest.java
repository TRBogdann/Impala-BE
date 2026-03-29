package com.server.impala.entity.requests;

import com.server.impala.enums.RequestTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "confirm_account_request")
public class ConfirmAccountRequest extends Request{

    @Override
    public RequestTypeEnum getRequestType() {
        return RequestTypeEnum.CONFIRM_ACCOUNT;
    }

}
