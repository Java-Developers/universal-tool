package com.tps.universal.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 4/22/14.
 */
public class FooBeanRawParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition fooDef = new RootBeanDefinition();
        fooDef.setBeanClass(Foo.class);
        String id = element.getAttribute("id");

        ManagedList mList = new ManagedList();
        mList.setMergeEnabled(true);
        mList.setSource(parserContext.getReaderContext().extractSource(element));

        NodeList nodes = element.getChildNodes();
        for(int i=0; i<nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element ele = (Element) node;
                String name = ele.getAttribute("name");
                String buz = ele.getAttribute("external");
                RootBeanDefinition barDef = new RootBeanDefinition();
                barDef.getPropertyValues().addPropertyValue("name", name);
                barDef.getPropertyValues().addPropertyValue("baz", new RuntimeBeanReference(buz));
                barDef.setBeanClass(Bar.class);
                mList.add(barDef);
            }
        }

        fooDef.getPropertyValues().addPropertyValue("bars", mList);


        BeanDefinitionHolder holder = new BeanDefinitionHolder(fooDef, id);
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, parserContext
                .getRegistry());
        return fooDef;
    }
}
