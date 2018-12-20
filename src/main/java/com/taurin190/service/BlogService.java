package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public BlogEntity getAuthorEntityByFiles() {
        BlogEntity entity = new BlogEntity();
        return entity;
    }

    public Optional<BlogEntity> getAuthorEntityByRepository() { {
        return blogRepository.findById(Integer.valueOf(1));
    }}

    public BlogEntity saveAuthorEntity(BlogEntity entity) {
        return blogRepository.save(entity);
    }
}
