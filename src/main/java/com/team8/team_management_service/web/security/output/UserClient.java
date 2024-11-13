package com.team8.team_management_service.web.security.output;

import com.team8.team_management_service.web.security.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8765")
public interface UserClient {

    @GetMapping("/users/email/{email}")
    User findByEmail(@PathVariable("email") String email);
}