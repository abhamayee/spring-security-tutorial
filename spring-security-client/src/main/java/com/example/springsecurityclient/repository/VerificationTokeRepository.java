package com.example.springsecurityclient.repository;

import com.example.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokeRepository extends JpaRepository<VerificationToken, Long> {
}
