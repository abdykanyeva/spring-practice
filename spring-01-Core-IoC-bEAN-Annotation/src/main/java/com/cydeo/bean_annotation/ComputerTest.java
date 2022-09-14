package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.Task;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {


        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, Task.class);

        Monitor theMonitor = container.getBean(Monitor.class);
       // SonyMonitor theMonitor = container.getBean(SonyMonitor.class);
        Case theCase = container.getBean(Case.class);
        Motherboard motherBoard = container.getBean(Motherboard.class);




        PC myPC = new PC( theCase, theMonitor,  motherBoard);

        myPC.powerUp();

        theCase.pressPowerButton();

        System.out.println("*****************Multiple Objects******************");

        Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class); // Default bean name
        Monitor theMonitor3 = container.getBean("sony", Monitor.class); // Custom bean name
        Monitor theMonitor4 = container.getBean( Monitor.class); // Primary








    }

}
