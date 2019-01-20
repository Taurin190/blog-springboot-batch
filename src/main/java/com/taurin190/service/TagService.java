package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.TagEntity;
import com.taurin190.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public void saveOrUpdateByBlogEntity(BlogEntity blogEntity) {
        List<TagEntity> tagEntityList = blogEntity.getTagList();
        if (tagEntityList.size() == 0) return;
        tagEntityList.forEach(this::saveOrUpdate);
    }

    public void saveOrUpdate(TagEntity entity) {
        String name = entity.getName();
        Optional<TagEntity> optionalTagEntity = tagRepository.getTagEntityByNameEquals(name);

        if (optionalTagEntity.isPresent()) {
            update(optionalTagEntity.get(), entity);
        } else {
            tagRepository.save(entity);
        }
    }

    private void update(TagEntity currentEntity, TagEntity newEntity) {
        tagRepository.update(newEntity.getName(), newEntity.isValid(), currentEntity.getId());
    }
}
