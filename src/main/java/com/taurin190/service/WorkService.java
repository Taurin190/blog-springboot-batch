package com.taurin190.service;

import com.taurin190.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;


}
