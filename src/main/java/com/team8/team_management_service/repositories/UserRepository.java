package com.team8.team_management_service.repositories;

import com.team8.team_management_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}