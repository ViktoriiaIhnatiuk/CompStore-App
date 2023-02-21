package com.example.compstore.repository;

import com.example.compstore.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"roles"})
    Optional<User> findUserByEmail(String email);
}
