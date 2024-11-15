package com.bitroot.ai.edde.domain.controller;

import com.bitroot.ai.edde.configuration.InfoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info/")
public class InfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

    private final InfoProperties infoProperties;

    public InfoController(InfoProperties infoProperties) {
        this.infoProperties = infoProperties;
    }

    @GetMapping
    public InfoProperties getInfo() {

        LOGGER.info("Edde wants to know about version {}", infoProperties.getVersion());
        return infoProperties;
    }
}
