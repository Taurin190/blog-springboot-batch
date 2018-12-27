package com.taurin190.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "english_title")
    String englishTitle;
    String title;
    @Column(name = "sub_date")
    String subTitle;
    @Column(name = "published_date")
    String publishedDate;
    @Column(name = "blog_body", length = 30000)
    String blogBody;
    @Column(name = "is_valid")
    boolean isValid;
    @Column(name = "author_id")
    Integer authorId;
}