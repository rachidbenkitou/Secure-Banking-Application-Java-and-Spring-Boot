package com.benkitoucoders.bankservice.repository;

import com.benkitoucoders.bankservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
