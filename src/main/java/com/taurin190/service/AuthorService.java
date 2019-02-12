package com.taurin190.service;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.repository.AuthorRepository;
import com.taurin190.utils.AuthorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorEntity getAuthorEntityByProperties() {
        AuthorEntity entity = new AuthorEntity();
        entity.setAuthorName(AuthorUtil.getProperty("author_name"));
        entity.setSelfIntroduction(AuthorUtil.getProperty("self_introduction"));
        entity.setTwitterAccount(AuthorUtil.getProperty("twitter_account"));
        entity.setGithubAccount(AuthorUtil.getProperty("github_account"));
        entity.setValid(Boolean.valueOf(AuthorUtil.getProperty("is_valid")));
        return entity;
    }

    public Optional<AuthorEntity> getAuthorEntityByRepository() { {
        return authorRepository.findById(Integer.valueOf(1));
    }}

    public AuthorEntity saveAuthorEntity(AuthorEntity entity) {
        return authorRepository.save(entity);
    }
}
