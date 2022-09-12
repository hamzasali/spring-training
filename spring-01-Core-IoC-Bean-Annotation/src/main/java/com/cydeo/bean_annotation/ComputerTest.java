package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.StringIntConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, StringIntConfig.class);
        Monitor monitor = container.getBean(SonyMonitor.class);
        Case myCase = container.getBean(Case.class);
        Motherboard motherboard = container.getBean(Motherboard.class);
        PC myPc = new PC(myCase, monitor, motherboard);

        myPc.powerUp();

        System.out.println("---------------> Multiple Objects <---------------");

        Monitor theMonitor2 = container.getBean("monitorAcer", Monitor.class); // default bean name
        Monitor theMonitor3 = container.getBean("sony", Monitor.class); // custom bean name
        Monitor theMonitor4 = container.getBean(Monitor.class); // @Primary

    }
}
