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
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

        assertEquals("test blog", blogEntityList.get(0).getTitle());
        assertEquals("test", blogEntityList.get(0).getEnglishTitle());
        assertEquals("abcdef", blogEntityList.get(0).getSummary());
        assertEquals(" \n <h1>TEST BLOG</h1>  \n", blogEntityList.get(0).getBlogBody());

        assertEquals("ほげ2", blogEntityList.get(1).getTitle());
        assertEquals("hoge", blogEntityList.get(1).getEnglishTitle());
        assertEquals("abcdef", blogEntityList.get(1).getSummary());
        assertEquals(" \n <h1>HOGEHOGE</h1>  \n", blogEntityList.get(1).getBlogBody());

        List<TagEntity> tagEntityList1 = new ArrayList<>(blogEntityList.get(0).getTagList());
        List<TagEntity> tagEntityList2 = new ArrayList<>(blogEntityList.get(1).getTagList());

        assertEquals("ビジネス", tagEntityList1.get(0).getName());
        assertEquals("GCP", tagEntityList1.get(1).getName());

        assertEquals("GCP", tagEntityList2.get(0).getName());
        assertEquals("ビジネス", tagEntityList2.get(1).getName());
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
