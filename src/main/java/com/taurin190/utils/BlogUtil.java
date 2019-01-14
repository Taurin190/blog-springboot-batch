package com.taurin190.utils;

import com.taurin190.entity.BlogEntity;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class BlogUtil {
    private static final String BLOG_LIST_PATH = "/blog-contents/blogs/blog_list.json";
    private static final String BLOG_LIST_DIRECTORY = "/blog-contents/blogs";
    private static final String BLOG__HTML_DIRECTORY = "/blog-contents/htmls/";
    private static JSONArray blogListJSON = null;

    static {
        try {
            Resource blog_list_file_path = new ClassPathResource(BLOG_LIST_PATH);
            System.out.println(String.format("ファイル名:%s", ((ClassPathResource) blog_list_file_path).getPath()));
            File file = blog_list_file_path.getFile();
            blogListJSON = new JSONArray(getStringFromFile(file));
        } catch (IOException e) {
            // ファイル読み込みに失敗
            System.out.println(String.format("ファイルの読み込みに失敗しました。ファイル名:%s", BLOG_LIST_PATH));
        } catch (JSONException e) {
            System.out.println(String.format("JSOBArrayに変換が失敗しました。ファイル名:%s", BLOG_LIST_PATH));
            e.printStackTrace();
        }
    }

    public static List<String> getBlogTitleList() {
        List<String> blogTitleList = new ArrayList<>();
        if (blogListJSON != null) {
            try {
                for (int i = 0; i < blogListJSON.length(); i++) {
                    JSONObject json = blogListJSON.getJSONObject(i);
                    blogTitleList.add(json.getString("title"));
                }
            } catch(JSONException e) {
                System.out.println(String.format("JSOBArrayに変換が失敗しました。ファイル名:%s", BLOG_LIST_PATH));
                e.printStackTrace();
            }
        }
        return blogTitleList;
    }

    public static List<JSONObject> getBlogJSONObjectList() {
        List<JSONObject> blogJSONObjectList = new ArrayList<>();
        if (blogListJSON != null) {
            try {
                for (int i = 0; i < blogListJSON.length(); i++) {
                    blogJSONObjectList.add(blogListJSON.getJSONObject(i));
                }
            } catch(JSONException e) {
                e.printStackTrace();
            }
        }
        return blogJSONObjectList;
    }

    public static BlogEntity getBlogEntityByJSON(JSONObject object) {
        BlogEntity entity = new BlogEntity();
        try {
            String title = object.getString("title");
            String directory = object.getString("directory");
            Resource blog_file_path = new ClassPathResource(BLOG_LIST_DIRECTORY + directory + title + ".json");
            System.out.println(blog_file_path);
            File file = blog_file_path.getFile();
            JSONObject blogFile = new JSONObject(getStringFromFile(file));
            entity.setTitle(blogFile.getString("title"));
            entity.setSummary(blogFile.getString("summary"));
            entity.setBlogBody(getHTMLBodyByEnglishTitle(title));
            entity.setEnglishTitle(title);
            entity.setAuthorId(blogFile.getInt("author_id"));
            if (!blogFile.isNull("is_valid")) {
                entity.setValid(blogFile.getBoolean("is_valid"));
            } else {
                entity.setValid(false);
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private static String getStringFromFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            StringBuffer sb = new StringBuffer();
            int c;
            while ((c = br.read()) != -1) {
                sb.append((char) c);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    static String getHTMLBodyByEnglishTitle(String englishTitle) {
        String htmlBody = "";
        try {
            Resource blog_html_file_path = new ClassPathResource(BLOG__HTML_DIRECTORY + englishTitle + ".html");
            System.out.println(blog_html_file_path);
            File file = blog_html_file_path.getFile();
            Document document = Jsoup.parse(getStringFromFile(file));
            htmlBody = document.body().toString();
            htmlBody = htmlBody.replace("<body>","");
            htmlBody = htmlBody.replace("</body>","");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlBody;
    }
}
