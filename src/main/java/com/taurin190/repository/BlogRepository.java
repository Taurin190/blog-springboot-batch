package com.taurin190.repository;

import com.taurin190.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
    public Optional<BlogEntity> getBlogEntityByEnglishTitleEquals(String englishTitle);

    @Modifying
    @Query("UPDATE BlogEntity b SET " +
            "b.title = :title, " +
            "b.englishTitle = :english_title, " +
            "b.blogBody = :blog_body, " +
            "b.summary = :summary, " +
            "b.publishedDate = :published_date, " +
            "b.isValid = :is_valid " +
            "where b.id = :id")
    public Integer update(
            @Param("title") String title,
            @Param("english_title") String english_title,
            @Param("blog_body") String blog_body,
            @Param("is_valid") boolean is_valid,
            @Param("summary") String summary,
            @Param("published_date") String published_date,
            @Param("id") Integer id
     );
}
