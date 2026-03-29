package com.server.impala.listener;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.server.impala.event.UserCreatedEvent;
import com.server.impala.service.MailService;

@Component
public class UserListener {

    private final MailService mailService;

    public UserListener(MailService mailService) {
        this.mailService = mailService;
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onUserCreated(UserCreatedEvent event) {
        mailService.sendConfirmAccountMail(event.getUser());
    }
}
