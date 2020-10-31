package com.cybertek.services;

import com.cybertek.ExtraSessionHours;
import com.cybertek.interfaces.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Value("${instructor}")
    private String instructorName;

    private ExtraSessionHours extraSessionHours;

    @Autowired
    public Java(ExtraSessionHours extraSessionHours) {
        this.extraSessionHours = extraSessionHours;
    }

    @Override
    public int getTeachingHours() {
        return 20 + extraSessionHours.getHour();
    }
}
