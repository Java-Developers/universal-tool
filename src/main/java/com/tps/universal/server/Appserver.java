package com.tps.universal.server;

import com.tps.universal.spring.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Junior on 4/22/14.
 */
public class Appserver {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/tags.xml");

        Foo foo = (Foo) ctx.getBean("foooooo");

        System.out.println(foo.getBars().size());
    }
}
