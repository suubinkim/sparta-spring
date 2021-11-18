package com.example.test2.repository;

import com.example.test2.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findAllByOrderByCreatedAtDesc();
}
