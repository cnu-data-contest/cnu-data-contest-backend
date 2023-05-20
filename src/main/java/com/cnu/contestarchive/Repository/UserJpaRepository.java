package com.cnu.contestarchive.Repository;

import com.cnu.contestarchive.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, String> {
    Optional<User> findById(String id);

}
