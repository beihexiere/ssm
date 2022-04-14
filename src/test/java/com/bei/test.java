package com.bei;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Properties;

public class test {

    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream((new File("src/main/resources/log4j.properties")));
        properties.load(is);
        System.out.println(properties.getProperty("log4j.rootCategory"));
    }
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        InputStream is = new FileInputStream(ResourceUtils.getFile("classpath:log4j.properties"));
        properties.load(is);
        System.out.println(properties.getProperty("log4j.rootCategory"));
    }
    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        String path = Thread.currentThread().getContextClassLoader().getResource("log4j.properties").getPath();
        InputStream is = new FileInputStream((new File(path)));
        properties.load(is);
        System.out.println(properties.getProperty("log4j.rootCategory"));
    }
    @Test
    public void test4() throws IOException {
        Properties properties = new Properties();
        String path = ClassLoader.getSystemResource("log4j.properties").getPath();
        InputStream is = new FileInputStream((new File(path)));
        properties.load(is);
        System.out.println(properties.getProperty("log4j.rootCategory"));
    }
}
