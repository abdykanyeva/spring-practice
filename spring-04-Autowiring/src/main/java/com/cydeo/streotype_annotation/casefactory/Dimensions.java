package com.cydeo.streotype_annotation.casefactory;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor
@Component
public class Dimensions {  // ask this question why we remove AllArgsConstructor

    private int width;
    private int height;
    private int depth;

    public Dimensions(){
        this.width = 20;
        this.height = 10;
        this.depth = 15;
    }



    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
