package com.example.prac_fever.domain;

import com.example.prac_fever.dto.ChallengeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Challenge extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int people;

    @Column
    private String img;


    public Challenge(ChallengeRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.people = requestDto.getPeople();
        this.img = requestDto.getImg();
    }

}
