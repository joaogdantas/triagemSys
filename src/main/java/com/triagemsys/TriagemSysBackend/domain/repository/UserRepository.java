package com.triagemsys.TriagemSysBackend.domain.repository;

import com.triagemsys.TriagemSysBackend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
