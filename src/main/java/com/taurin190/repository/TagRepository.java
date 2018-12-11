package com.taurin190.repository;

import com.taurin190.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<BlogEntity, Integer> {
}
