package com.cydeo.streotype_annotation.monitorfactory;


import org.springframework.stereotype.Component;

@Component
public class AcerMonitor extends Monitor{


    public AcerMonitor(String model, String manufacturer, int size) {
        super(model, manufacturer, size);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");
    }
}
