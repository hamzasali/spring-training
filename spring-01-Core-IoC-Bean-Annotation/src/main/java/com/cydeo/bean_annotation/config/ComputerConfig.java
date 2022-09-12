package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {

    @Bean("sony")
    public Monitor monitorSony() {
        return new SonyMonitor("25\" Beast", "Sony", 25);
    }

    @Bean
    @Primary
    public Monitor monitorAcer() {
        return new AcerMonitor("29\" Beast", "Acer", 29);
    }

    @Bean
    public Motherboard motherboardAsus() {
        return new AsusMotherboard("CT-900", "Asus", 4, 4, "p1.30");
    }

    @Bean
    public Case caseDell() {
        return new DellCase("320Clear", "Dell", "220");
    }
}
