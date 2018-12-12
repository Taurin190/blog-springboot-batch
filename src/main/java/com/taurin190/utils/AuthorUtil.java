package com.taurin190.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class AuthorUtil {
    private static final String AUTHOR_FILE_PATH = "resourse/common.properties";
    private static final Properties properties;

    private AuthorUtil() throws Exception {

    }

    static {
        properties = new Properties();
        try {
            properties.load(Files.newBufferedReader(Paths.get(AUTHOR_FILE_PATH), StandardCharsets.UTF_8));
        } catch (IOException e) {
            // ファイル読み込みに失敗
            System.out.println(String.format("ファイルの読み込みに失敗しました。ファイル名:%s", AUTHOR_FILE_PATH));
        }
    }

    public static String getProperty(final String key) {
        return getProperty(key, "");
    }

    public static String getProperty(final String key, final String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}