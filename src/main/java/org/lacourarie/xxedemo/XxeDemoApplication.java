package org.lacourarie.xxedemo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.sun.xml.internal.fastinfoset.stax.factory.StAXInputFactory;
import com.sun.xml.internal.fastinfoset.stax.factory.StAXOutputFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

@SpringBootApplication
public class XxeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxeDemoApplication.class, args);
    }

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
