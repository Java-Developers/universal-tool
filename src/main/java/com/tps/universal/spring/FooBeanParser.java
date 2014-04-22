package com.tps.universal.spring;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 4/22/14.
 */
public class FooBeanParser extends AbstractSingleBeanDefinitionParser  {


    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {


        List<Bar> barList = new ArrayList<Bar>();

        NodeList barNodes = element.getChildNodes();
        for(int i=0; i<barNodes.getLength(); i++) {
            Node item = barNodes.item(i);
            String localName = item.getLocalName();

            if("bar".equals(localName) && item.getNodeType() == Node.ELEMENT_NODE) {
                Element barEle = (Element) item;
                String name = barEle.getAttribute("name");
                Bar bar = new Bar();
                bar.setName(name);
                barList.add(bar);
                System.out.println("New bar added");
            }
        }



        builder.addPropertyValue("bars", barList);
    }

    @Override
    protected Class getBeanClass(Element element) {
        return Foo.class;
    }

}
