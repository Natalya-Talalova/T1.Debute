package com.team8.team_management_service.web.security.details;

import com.team8.team_management_service.exception.UserNotFoundException;
import com.team8.team_management_service.web.security.domain.User;
import com.team8.team_management_service.web.security.output.UserClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.atDebug().log("Loading user by email: {}", email);
        User user = userClient.findByEmail(email);
        log.atDebug().log("Loaded user: {}", user);
        if (user == null) {
            throw new UserNotFoundException(email);
        }
        return new UserDetailsImpl(user);
    }

}
