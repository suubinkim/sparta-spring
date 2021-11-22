package com.example.prac_fever.service;

import com.example.prac_fever.domain.Challenge;
import com.example.prac_fever.dto.ChallengeRequestDto;
import com.example.prac_fever.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public List<Challenge> getChallenge(){
        return challengeRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public void createChallenge(ChallengeRequestDto requestDto){
        Challenge challenge = new Challenge(requestDto);
        challengeRepository.save(challenge);
    }


}
