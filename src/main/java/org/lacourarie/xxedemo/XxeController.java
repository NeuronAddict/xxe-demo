package org.lacourarie.xxedemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XxeController {

    @GetMapping
    public Message get() {
        return new Message("Hi! I'm a message, you can post me ;)");
    }

    @PostMapping()
    public Message post(@RequestBody Message message) {
        return message;
    }

}
