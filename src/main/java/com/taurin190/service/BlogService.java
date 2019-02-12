package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.TagEntity;
import com.taurin190.repository.BlogRepository;
import com.taurin190.repository.TagRepository;
import com.taurin190.utils.BlogUtil;
import com.taurin190.utils.TagUtil;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    TagRepository tagRepository;

    public List<BlogEntity> getBlogEntitiesByFiles() {
        List<BlogEntity> entities = new ArrayList<>();
        List<JSONObject> blogJSONList = BlogUtil.getBlogJSONObjectList();
        for (JSONObject object : blogJSONList) {
            BlogEntity entity = BlogUtil.getBlogEntityByJSON(object);
            List<String> tags = TagUtil.getTagListFromJOSNByBlogTitle(entity.getEnglishTitle());
            Set<TagEntity> tagEntityList = getTagListByTagNameList(tags);
            entity.setTagList(tagEntityList);
            tagEntityList.forEach(tag -> {
                if (tag.getBlogList() == null) {
                    Set<BlogEntity> blogEntityList = new HashSet<>();
                    tag.setBlogList(blogEntityList);
                }
                tag.getBlogList().add(entity);
            });

            entities.add(entity);
            System.out.println(object);
        }
        return entities;
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

        blogRepository.update(
                entity.getTitle(),
                entity.getEnglishTitle(),
                entity.getBlogBody(),
                entity.isValid(),
                entity.getSummary(),
                entity.getPublishedDate(),
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


    public TagEntity saveOrUpdateTagEntity(TagEntity entity) {
        String name = entity.getName();
        Optional<TagEntity> optionalTagEntity = tagRepository.getTagEntityByNameEquals(name);
        TagEntity newTagEntity;

        if (optionalTagEntity.isPresent()) {
            newTagEntity = updateTagEntity(optionalTagEntity.get(), entity);
        } else {
            newTagEntity = tagRepository.save(entity);
        }
        return newTagEntity;
    }

    public TagEntity saveOrUpdateTagEntityByName(String name) {
        Optional<TagEntity> optionalTagEntity = tagRepository.getTagEntityByNameEquals(name);
        TagEntity newTagEntity = new TagEntity();

        if (optionalTagEntity.isPresent()) {
            newTagEntity = optionalTagEntity.get();
        } else {
            newTagEntity.setName(name);
            newTagEntity.setValid(true);
            newTagEntity = tagRepository.save(newTagEntity);
        }
        return newTagEntity;
    }

    private TagEntity updateTagEntity(TagEntity currentEntity, TagEntity newEntity) {
        TagEntity entity = new TagEntity().builder()
                .id(currentEntity.getId())
                .name(newEntity.getName())
                .isValid(newEntity.isValid())
                .build();
        tagRepository.update(entity.getName(), entity.isValid(), entity.getId());
        return entity;
    }

    private Set<TagEntity> getTagListByTagNameList(List<String> nameList) {
        Set<TagEntity> tagEntityList = new HashSet<>();
        nameList.forEach(name -> tagEntityList.add(getTagEntityByName(name)));
        return tagEntityList;
    }

    private TagEntity getTagEntityByName(String name) {
        Optional<TagEntity> optionalTagEntity = tagRepository.getTagEntityByNameEquals(name);
        TagEntity newTagEntity = new TagEntity();

        if (optionalTagEntity.isPresent()) {
            newTagEntity = optionalTagEntity.get();
        } else {
            newTagEntity.setName(name);
            newTagEntity.setValid(true);
        }
        return newTagEntity;
    }
}
