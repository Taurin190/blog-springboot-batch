package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.repository.BlogRepository;
import com.taurin190.utils.BlogUtil;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        optionalBlogEntity.map(
                blogEntity -> updateBlogEntity(entity)
        ).orElse(
                saveBlogEntity(entity)
        );
    }

    public List<BlogEntity> getAllBlogEntity() {
        return blogRepository.findAll();
    }

    public BlogEntity updateBlogEntity(BlogEntity entity) {
        return blogRepository.save(entity);
    }

    public BlogEntity saveBlogEntity(BlogEntity entity) {
        return blogRepository.save(entity);
    }
}
