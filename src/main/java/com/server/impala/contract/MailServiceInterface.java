package com.server.impala.contract;

import com.server.impala.entity.User;

public interface MailServiceInterface {
    void sendConfirmAccountMail(User user);
}
