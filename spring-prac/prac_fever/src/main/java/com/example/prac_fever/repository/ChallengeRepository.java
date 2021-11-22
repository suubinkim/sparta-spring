package com.example.prac_fever.repository;

import com.example.prac_fever.domain.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {
    List<Challenge> findAllByOrderByCreatedAtDesc();
}
