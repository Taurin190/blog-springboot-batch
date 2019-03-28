package com.taurin190.controller;

import com.taurin190.entity.WorkEntity;
import com.taurin190.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component("com.taurin190.controller.WorkController")
@Controller
public class WorkController implements BatchController {
    @Autowired
    WorkService workService;

    @Override
    public void exec() {
        List<WorkEntity> entityList = workService.getBlogEntitiesByFiles();
        entityList.forEach(entity -> {
            workService.saveOrUpdateBlogEntity(entity);
        });
    }
}
