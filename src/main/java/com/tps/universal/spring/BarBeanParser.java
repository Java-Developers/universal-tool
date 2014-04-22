package com.tps.universal.spring;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * Created by Junior on 4/22/14.
 */
public class BarBeanParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        String name = element.getAttribute("name");
        builder.addPropertyValue("name", name);
    }

    @Override
    protected Class getBeanClass(Element element) {
        return Bar.class;
    }
}
