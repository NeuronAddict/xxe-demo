package org.lacourarie.xxedemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class XxeController {

    @GetMapping
    public Message get() {
        return new Message("Hi! I'm a message, you can post me ;)");
    }

    @PostMapping()
    public Message post(@RequestBody Message message) throws JsonProcessingException {
        return message;
    }

}
