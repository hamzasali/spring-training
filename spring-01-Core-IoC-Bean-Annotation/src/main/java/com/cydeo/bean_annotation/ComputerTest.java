package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.StringIntConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, StringIntConfig.class);
        Monitor monitor = container.getBean(Monitor.class);
        Case myCase = container.getBean(Case.class);
        Motherboard motherboard = container.getBean(Motherboard.class);
        PC myPc = new PC(myCase, monitor, motherboard);

        myPc.powerUp();
    }
}
