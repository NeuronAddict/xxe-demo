package org.lacourarie.xxedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLInputFactory;
import java.util.logging.Logger;

@RestController("/api")
public class XxeController {

    private static final Logger LOGGER = Logger.getLogger(XMLInputFactory.class.getCanonicalName());

    @Value("#{new Boolean('${org.lacourarie.xxedemo.obfuscated}')}")
    private Boolean obfuscated;

    @RequestMapping(method = RequestMethod.GET)
    public Message get() {
        return new Message("Hi! I'm a message, you can post me ;)");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Message post(@RequestBody Message message) {

        LOGGER.info("a message is send..." + message);

        // Send message ...

        return new Message(String.format("Your message (%s) has been send",
                (this.obfuscated) ? "###" : message.getText()));
    }

}
