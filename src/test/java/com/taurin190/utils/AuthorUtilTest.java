package com.taurin190.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorUtilTest {
    @Test
    public void getProperties() {
        String authorName = AuthorUtil.getProperty("author_name");
        String selfIntroduction = AuthorUtil.getProperty("self_introduction");
        String twitterAccount = AuthorUtil.getProperty("twitter_account");
        String githubAccount = AuthorUtil.getProperty("github_account");

        assertEquals("Koichi Taura",authorName);
        assertEquals("東京でソフトウェアエンジニアとして働いていて。 PHP, Java, Pythonでバックエンドの開発を行っています。 Docker/Kubernetesへの環境構築移行も行なっております。",selfIntroduction);
        assertEquals("https://twitter.com/Tauitter51",twitterAccount);
        assertEquals("https://github.com/Taurin190",githubAccount);
    }

    @Test
    public void getPropertiesWithDefaultValues() {
        String authorName = AuthorUtil.getProperty("author_name", "Test Taro");
        String facebookAccount = AuthorUtil.getProperty("facebook_account", "no account");

        assertEquals("Koichi Taura",authorName);
        assertEquals("no account",facebookAccount);
    }
}
