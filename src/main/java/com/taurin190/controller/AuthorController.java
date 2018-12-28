package com.taurin190.controller;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component("com.taurin190.controller.AuthorController")
@Controller
public class AuthorController implements BatchController {
    @Autowired
    AuthorService authorService;

    @Override
    public void exec() {
        AuthorEntity entity = authorService.getAuthorEntityByProperties();
        entity.setId(new Integer(1));
        authorService.saveAuthorEntity(entity);
    }
}
