package org.lacourarie.xxedemo;

import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

@Configuration
public class XmlConfig {

    public XmlMapper xmlMapper() {
        XMLInputFactory xmlIn = XMLInputFactory.newInstance();
        XMLOutputFactory xmlOut = XMLOutputFactory.newInstance();
        xmlIn.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);
        XmlFactory xf = new XmlFactory(xmlIn, xmlOut);
        return new XmlMapper(xf);
    }

    @Bean
    public MappingJackson2XmlHttpMessageConverter converter() {
        return new MappingJackson2XmlHttpMessageConverter(xmlMapper());
    }

}
