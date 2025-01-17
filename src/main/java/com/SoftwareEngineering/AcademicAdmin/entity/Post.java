package com.SoftwareEngineering.AcademicAdmin.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String writer;

    @Column(name = "post_time")
    private LocalDateTime time;

    @Column(name = "post_content", length = 2000)
    private String content;

    @Column(name = "post_title", length = 100)
    private String title;

    @Column(name = "post_view")
    private Long view;
}
