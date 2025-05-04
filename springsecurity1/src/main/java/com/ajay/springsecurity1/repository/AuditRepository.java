package com.ajay.springsecurity1.repository;

import com.ajay.springsecurity1.domain.AuditRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends MongoRepository<AuditRequest,String> {
}
