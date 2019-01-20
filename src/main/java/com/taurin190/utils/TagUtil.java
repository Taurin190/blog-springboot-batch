package com.taurin190.utils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TagUtil extends JSONUtil{
    private static final String TAG_LIST_DIRECTORY = "/blog-contents/tags/";
    private static JSONArray tagListJSON = null;

    public static List<String> getTagListFromJOSNByBlogTitle(String title) {
        List<String> tagList = new ArrayList<>();
        try {
            Resource tag_file_path = new ClassPathResource(TAG_LIST_DIRECTORY + title + ".json");
            File file = tag_file_path.getFile();

            JSONArray tagJSONList = new JSONArray(getStringFromFile(file));
            for (int i = 0; i < tagJSONList.length(); i++) {
                JSONObject object = tagJSONList.getJSONObject(i);
                tagList.add(object.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tagList;
    }
}
