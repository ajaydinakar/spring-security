package com.ajay.springsecurity1.service;

import com.ajay.springsecurity1.Config.CustomGsonBuilder;
import com.ajay.springsecurity1.domain.AuditRequest;
import com.ajay.springsecurity1.repository.AuditRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
@AutoConfigureJsonTesters
@ComponentScan(basePackages = "com.ajay.springsecurity1")
@ActiveProfiles("test")
class SampleServiceTest {

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private SampleService sampleService;

    @BeforeEach
    void setUp() {
        auditRepository.deleteAll();
    }

    @Test
    void getSampleString() {
        String sampleString = sampleService.getSampleString();
        assertNotNull(sampleString);
    }

    @Test
    void getLastLoginRequest() {
        sampleService.getSampleString(); // Add a sample login request
        String lastLoginRequest = sampleService.getLastLoginRequest();
        assertNotNull(lastLoginRequest);
    }

    @Test
    void getLastFiveLoginRequests() {
        for (int i = 0; i < 6; i++) {
            sampleService.getSampleString(); // Add multiple sample login requests
        }
        String lastFiveLoginRequests = sampleService.getLastFiveLoginRequests();
        List<AuditRequest> auditRequests = CustomGsonBuilder.getGson().fromJson(lastFiveLoginRequests, List.class);
        assertEquals(5, auditRequests.size());
    }
}