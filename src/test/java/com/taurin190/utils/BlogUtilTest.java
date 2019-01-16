package com.taurin190.utils;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BlogUtilTest {
    @Test
    public void getBlogJSONObjectList() {
        List<JSONObject> jsonObjectList = BlogUtil.getBlogJSONObjectList();
        assertEquals(2, jsonObjectList.size());
        try {
            assertEquals("test", jsonObjectList.get(0).getString("title"));
            assertEquals("/", jsonObjectList.get(0).getString("directory"));
            assertEquals("hoge", jsonObjectList.get(1).getString("title"));
            assertEquals("/2018/", jsonObjectList.get(1).getString("directory"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getHTMLBodyByEnglishTitle() {
        String html = BlogUtil.getHTMLBodyByEnglishTitle("create_blog_site");
        assertEquals(" \n" +
                " <h2>はじめに</h2> \n" +
                " <p>アウトプットの重要性を感じ、ブログサイトを作成しました。 Qiitaやはてブを使わずに一から作成することで、一から作れるかを確かめられ、 学び直しと次の課題を考えることが出来ました。 仕事から帰ってからや休日などの時間でSpringbootのアプリをGKE上に置いて公開しました。 </p>  \n" +
                "", html);
    }
}
