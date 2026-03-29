package com.server.impala.repository.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.impala.entity.requests.ConfirmAccountRequest;

@Repository
public interface ConfirmAccountRequestRepository extends JpaRepository<ConfirmAccountRequest, String> {
}