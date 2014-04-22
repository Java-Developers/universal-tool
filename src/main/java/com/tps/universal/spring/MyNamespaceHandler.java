package com.tps.universal.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by Junior on 4/22/14.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport  {
    @Override
    public void init() {
        registerBeanDefinitionParser("foo", new FooBeanRawParser());
        //registerBeanDefinitionParser("foo", new FooBeanParser());
        //registerBeanDefinitionParser("bar", new BarBeanParser());
    }
}
