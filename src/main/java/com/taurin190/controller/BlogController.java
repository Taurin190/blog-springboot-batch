package com.taurin190.controller;

import com.taurin190.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController implements BatchController {
    @Autowired
    BlogService blogService;

    @Override
    public void exec() {
    }
}
