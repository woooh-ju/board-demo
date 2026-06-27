package com.wooohju.board.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDate createDate;

    protected Post() {}

    public Post(String title, String content)
    {
        this.title = title;
        this.content = content;
        this.createDate = LocalDate.now();
    }

}
