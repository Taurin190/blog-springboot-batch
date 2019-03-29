package com.taurin190.service;

import com.taurin190.BaseTest;
import com.taurin190.entity.WorkEntity;
import com.taurin190.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

public class WorkServiceTest extends BaseTest {
    @Mock
    WorkRepository workRepository;

    @InjectMocks
    WorkService workService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBlogEntitiesByFiles() {
        List<WorkEntity> workEntityList = getTestWorkEntityList();
        when(workRepository.findAll()).thenReturn(workEntityList);

        List<WorkEntity> actual = workService.getBlogEntitiesByFiles();
    }
}
