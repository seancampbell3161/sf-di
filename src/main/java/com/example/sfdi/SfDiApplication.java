package com.example.sfdi;

import com.example.sfdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfDiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfDiApplication.class, args);

        i18nController iController = (i18nController) ctx.getBean("i18nController");
        System.out.println(iController.sayHello());

        // ask Spring context for controller instance
        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("------ Primary Bean");
        System.out.println(myController.sayHello());

        // Property injection
        System.out.println("------ Property");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController)
                ctx.getBean("propertyInjectedController");

        System.out.println(propertyInjectedController.getGreeting());

        // Setter injection
        System.out.println("------ Setter");

        SetterInjectedController setterInjectedController = (SetterInjectedController)
                ctx.getBean("setterInjectedController");

        System.out.println(setterInjectedController.getGreeting());

        // Constructor injection
        System.out.println("------ Constructor");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)
                ctx.getBean("constructorInjectedController");

        System.out.println(constructorInjectedController.getGreeting());
    }

}
