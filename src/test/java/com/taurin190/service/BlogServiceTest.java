package com.taurin190.service;

import com.taurin190.entity.BlogEntity;
import com.taurin190.entity.TagEntity;
import com.taurin190.repository.BlogRepository;
import com.taurin190.repository.TagRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BlogServiceTest {
    @Mock
    private BlogRepository blogRepository;

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private BlogService blogService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getBlogEntitiesByFiles() {
        List<BlogEntity> blogEntityList = blogService.getBlogEntitiesByFiles();

        assertEquals(2, blogEntityList.size());
    }

    @Test
    public void getAuthorEntityByRepository() {

    }

    @Test
    public void saveOrUpdateTagEntity() {

    }

    @Test
    public void saveOrUpdateTagEntityByName() {

    }

    @Test
    public void getTagListByTagNameList() {

    }

    @Test
    public void getTagEntityByName() {

    }
}
