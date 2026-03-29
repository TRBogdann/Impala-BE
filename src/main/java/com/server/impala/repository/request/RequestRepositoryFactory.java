package com.server.impala.repository.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.server.impala.entity.requests.Request;
import com.server.impala.enums.RequestTypeEnum;

@Component
public class RequestRepositoryFactory {
    private final ConfirmAccountRequestRepository confirmAccountRequestRepository;

    public RequestRepositoryFactory(
        ConfirmAccountRequestRepository confirmAccountRequestRepository
    ){
        this.confirmAccountRequestRepository = confirmAccountRequestRepository;
    }

    @SuppressWarnings("unchecked")
    public <T extends Request> JpaRepository<T, String> getRepository(RequestTypeEnum type) {
        return switch (type) {
            case CONFIRM_ACCOUNT -> (JpaRepository<T, String>) confirmAccountRequestRepository;
            default -> null;
        };
    }
}
