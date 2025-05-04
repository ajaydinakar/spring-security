package com.ajay.springsecurity1.service;

import com.ajay.springsecurity1.Config.CustomGsonBuilder;
import com.ajay.springsecurity1.domain.AuditRequest;
import com.ajay.springsecurity1.domain.LoginRequest;
import com.ajay.springsecurity1.repository.AuditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SampleService {
    @Autowired
    AuditRepository repository;
    public String getSampleString() {

        LoginRequest request=new LoginRequest("sds1000","ajaydinakar@gmail.com","UserLogin");
        String sample_string = CustomGsonBuilder.getGson().toJson(request);

        log.info(sample_string);
        repository.save(request);
        return sample_string;
    }
    public String getLastLoginRequest() {
        String sample_string = CustomGsonBuilder.getGson().toJson( repository.findAll(Sort.by(Sort.Direction.DESC, "eventTime")).stream().findFirst().orElse(null));
    return sample_string;
    }

    public String getLastFiveLoginRequests() {
        return CustomGsonBuilder.getGson().toJson(repository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "eventTime"))).getContent());

    }


}
