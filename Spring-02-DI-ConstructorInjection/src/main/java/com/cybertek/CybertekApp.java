package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course java = container.getBean("java",Course.class);
        java.getTeachingHours();
        Course selenium = container.getBean("selenium",Course.class);
        selenium.getTeachingHours();

        java.getTeachingHours();
    }
}
