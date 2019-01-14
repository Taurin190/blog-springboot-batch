package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.repository.BlogRepository;
import com.taurin190.utils.BlogUtil;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public List<BlogEntity> getBlogEntitiesByFiles() {
        List<BlogEntity> entities = new ArrayList<>();
        List<JSONObject> blogJSONList = BlogUtil.getBlogJSONObjectList();
        for (JSONObject object : blogJSONList) {
            BlogEntity entity = BlogUtil.getBlogEntityByJSON(object);
            entities.add(entity);
            System.out.println(object);
        }
        return entities;
    }

    public Optional<BlogEntity> getAuthorEntityByRepository() {
        return blogRepository.findById(Integer.valueOf(1));
    }

    public void saveOrUpdateBlogEntity(BlogEntity entity) {
        Optional<BlogEntity> optionalBlogEntity = blogRepository.getBlogEntityByEnglishTitleEquals(entity.getEnglishTitle());
        if (optionalBlogEntity.isPresent()) {
            updateBlogEntity(optionalBlogEntity.get(), entity);
        } else {
            saveBlogEntity(entity);
        }
    }

    public List<BlogEntity> getAllBlogEntity() {
        return blogRepository.findAll();
    }

    public void updateBlogEntity(BlogEntity prevEntity, BlogEntity entity) {
        prevEntity.setAuthorId(entity.getAuthorId());
        prevEntity.setTitle(entity.getTitle());
        prevEntity.setBlogBody(entity.getBlogBody());

        blogRepository.update(
                entity.getTitle(),
                entity.getEnglishTitle(),
                entity.getBlogBody(),
                entity.isValid(),
                prevEntity.getId());
    }

    public BlogEntity saveBlogEntity(BlogEntity entity) {
        if (entity.getPublishedDate() == null) {
            SimpleDateFormat format = new SimpleDateFormat("MMM d, YYYY");
            Date date = new Date();
            entity.setPublishedDate(format.format(date));
        }
        return blogRepository.save(entity);
    }
}
