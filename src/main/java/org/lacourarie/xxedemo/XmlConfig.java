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
        // as per [dataformat-xml#190], disable external entity expansion by default
        //xmlIn.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.TRUE);
        //xmlIn.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.TRUE);
        //xmlIn.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
        XMLOutputFactory xmlOut = XMLOutputFactory.newInstance();
        XmlFactory xf = new XmlFactory(xmlIn, xmlOut);
        return new XmlMapper(xf);
    }

    @Bean
    public MappingJackson2XmlHttpMessageConverter converter() {
        return new MappingJackson2XmlHttpMessageConverter(xmlMapper());
    }

}
