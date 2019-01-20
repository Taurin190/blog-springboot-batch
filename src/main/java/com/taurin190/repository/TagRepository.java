package com.taurin190.repository;

import com.taurin190.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface TagRepository extends JpaRepository<TagEntity, Integer> {

    public Optional<TagEntity> getTagEntityByNameEquals(String name);

    @Modifying
    @Query("UPDATE TagEntity t SET " +
            "t.name = :name, " +
            "t.isValid = :is_valid " +
            "where t.id = :id")
    public Integer update(
            @Param("name") String name,
            @Param("is_valid") boolean is_valid,
            @Param("id") Integer id
    );
}
