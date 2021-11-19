package com.example.test2.domain;

import com.example.test2.dto.ArticleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class Article extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String comment;


    public Article(ArticleRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.comment = requestDto.getComment();
    }

}
