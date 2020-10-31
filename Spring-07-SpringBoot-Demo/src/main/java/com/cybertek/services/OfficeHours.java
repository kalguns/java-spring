package com.cybertek.services;

import com.cybertek.ExtraSessionHours;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSessionHours {
    @Override
    public int getHour() {
        return 2;
    }
}
