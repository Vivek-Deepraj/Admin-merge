package com.discom.springmvc.utils;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class UtilityClass {
    public static String dataPath() {
        String path = "";
        try {

            Properties props = new Properties();
            String filePath = null;

            String proppath = getPath();
            System.out.println("proppath " + proppath);
            filePath = proppath + "application.properties";
            System.out.println("filePath " + filePath);
            props.load(new FileInputStream(filePath));
            if (path == null || path.equals("")) {
                System.out.println("path " + path);
                path = props.getProperty("data_path");
                System.out.println("data_path " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    static String getPath() {
        String path = "";
        URL resource;
        try {
            resource = Class.forName("com.discom.springmvc.utils.ConvertDateFormat").getResource("/");

            path = resource.getPath();

            //  path = path.replace("WEB-INF/classes/", "");

            path = path.replace("%20", " ");
            path = path.replaceFirst("/", "");


        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return path;
    }

}
