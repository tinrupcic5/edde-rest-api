package com.bitroot.ai.edde.domain.controller;

import com.bitroot.ai.edde.configuration.InfoProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info/")
public class InfoController {

    private final InfoProperties infoProperties;

    public InfoController(InfoProperties infoProperties) {
        this.infoProperties = infoProperties;
    }

    @GetMapping
    public InfoProperties getInfo() {
        return infoProperties;
    }
}
