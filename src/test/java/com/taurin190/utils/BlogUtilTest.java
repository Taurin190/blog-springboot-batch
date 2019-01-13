package com.taurin190.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlogUtilTest {
    @Test
    public void getBlogJSONObjectList() {

    }

    @Test
    public void getHTMLBodyByEnglishTitle() {
        String html = BlogUtil.getHTMLBodyByEnglishTitle("create_blog_site");
        assertEquals("<body> \n" +
                " <h2>はじめに</h2> \n" +
                " <p>アウトプットの重要性を感じ、ブログサイトを作成しました。 Qiitaやはてブを使わずに一から作成することで、一から作れるかを確かめられ、 学び直しと次の課題を考えることが出来ました。 仕事から帰ってからや休日などの時間でSpringbootのアプリをGKE上に置いて公開しました。 </p>  \n" +
                "</body>", html);
    }
}
