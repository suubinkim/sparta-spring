package com.example.prac_fever.controller;


import com.example.prac_fever.domain.Challenge;
import com.example.prac_fever.dto.ChallengeRequestDto;
import com.example.prac_fever.service.ChallengeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping("/challenge")
    public void createChallenge(@RequestBody ChallengeRequestDto requestDto){
        challengeService.createChallenge(requestDto);
    }

    @GetMapping("/challenge")
    public List<Challenge> getChallenge(){
        return challengeService.getChallenge();
    }
}
