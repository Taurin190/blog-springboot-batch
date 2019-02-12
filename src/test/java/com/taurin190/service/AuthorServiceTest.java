package com.taurin190.service;

import com.taurin190.entity.AuthorEntity;
import com.taurin190.repository.AuthorRepository;
import com.taurin190.utils.AuthorUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {
    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAuthorEntityByProperties() {
        AuthorEntity actual = authorService.getAuthorEntityByProperties();

        assertEquals("Koichi Taura", actual.getAuthorName());
        assertEquals("東京でソフトウェアエンジニアとして働いていています。", actual.getSelfIntroduction());
        assertEquals("https://twitter.com/Tauitter51", actual.getTwitterAccount());
        assertEquals("https://github.com/Taurin190", actual.getGithubAccount());
        assertTrue(actual.isValid());
    }

    @Test
    public void getAuthorEntityByRepository() {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .id(1)
                .authorName("Yamada Hanataro")
                .selfIntroduction("こんにちは")
                .twitterAccount("https://twitter.com/hanataro_yamada")
                .githubAccount("https://github.com/hanataro_yamada")
                .isValid(true)
                .build();

        when(authorRepository.findById(any(Integer.class))).thenReturn(Optional.of(authorEntity));

        AuthorEntity actual = authorService.getAuthorEntityByRepository().get();

        assertEquals("Yamada Hanataro", actual.getAuthorName());
        assertEquals("こんにちは", actual.getSelfIntroduction());
        assertEquals("https://twitter.com/hanataro_yamada", actual.getTwitterAccount());
        assertEquals("https://github.com/hanataro_yamada", actual.getGithubAccount());
        assertTrue(actual.isValid());
    }
}
