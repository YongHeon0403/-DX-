package org.zerock.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.house.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // username으로 사용자를 찾는 메서드
    Optional<User> findByUsername(String username);
}