package com.taurin190.controller;

import com.taurin190.entity.BlogEntity;
import com.taurin190.service.BlogService;
import com.taurin190.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component("com.taurin190.controller.BlogController")
@Controller
public class BlogController implements BatchController {
    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;

    @Override
    public void exec() {
        List<BlogEntity> entityList = blogService.getBlogEntitiesByFiles();
        entityList.forEach(entity -> {
            tagService.saveOrUpdateByBlogEntity(entity);
            blogService.saveOrUpdateBlogEntity(entity);
        });
    }
}
