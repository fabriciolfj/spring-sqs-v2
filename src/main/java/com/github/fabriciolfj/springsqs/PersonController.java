package com.github.fabriciolfj.springsqs;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {

    private final MessageSender messageSender;

    @PostMapping
    public void create(@RequestBody final Person person) {
        messageSender.send(person);
    }
}
