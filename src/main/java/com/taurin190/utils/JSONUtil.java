package com.taurin190.utils;

import java.io.*;

public class JSONUtil {
    protected static String getStringFromFile(File file) throws IOException {
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
}
