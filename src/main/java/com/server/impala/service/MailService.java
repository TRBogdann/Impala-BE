package com.server.impala.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.server.impala.contract.MailServiceInterface;
import com.server.impala.entity.User;
import com.server.impala.entity.requests.ConfirmAccountRequest;
import com.server.impala.entity.requests.Request;
import com.server.impala.repository.request.RequestRepositoryFactory;

import jakarta.transaction.Transactional;

@Service
public class MailService implements MailServiceInterface{
    private final JavaMailSender mailSender;
    private final RequestRepositoryFactory repositoryFactory;

    public MailService(
        JavaMailSender mailSender,
        RequestRepositoryFactory repositoryFactory
    ){
        this.mailSender = mailSender;
        this.repositoryFactory = repositoryFactory;
    }

    @Override
    @Transactional
    public void sendConfirmAccountMail(User user) {
        Request request = new ConfirmAccountRequest();
        request.setUser(user);
        this.repositoryFactory.getRepository(request.getRequestType()).saveAndFlush((ConfirmAccountRequest)request);
    }
        
}
