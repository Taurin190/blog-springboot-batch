package com.taurin190.controller;

import com.taurin190.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkController implements BatchController {
    @Autowired
    WorkService workService;

    @Override
    public void exec() {

    }
}
