package com.example.pathfinder_fromscratch.domain.repositories;

import com.example.pathfinder_fromscratch.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

}
