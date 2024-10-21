package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
//    @Query("SELECT u FROM User u WHERE u.username LIKE %:query% " +
//            "OR u.name LIKE %:query%" +
//            "OR u.email LIKE %:query%" +
//            "OR u.description LIKE %:query%" +
//            "OR u.firstName LIKE %:query%" +
//            "OR u.lastName LIKE %:query%" +
//            "OR u.phone LIKE %:query%" +
//    "OR u.age LIKE %:query%" +
//    "OR u.skills LIKE %:query%" +
//    "OR u.team.id LIKE %:query%" +
//    "OR u.position LIKE %:query%" +
//    "OR u.areaOfResponsibility LIKE %:query%" +
//    "OR u.role LIKE %:query%" +
//    "OR u.messenger LIKE %:query%" +
//    "OR u.visibility LIKE %:query%" +
//    "OR u.profilePicture LIKE %:query%" +
//            "OR u.experience LIKE %:query%" +
//            "OR u.education LIKE %:query%")
    List<User> searchUsers(@Param("query") String query);

}
