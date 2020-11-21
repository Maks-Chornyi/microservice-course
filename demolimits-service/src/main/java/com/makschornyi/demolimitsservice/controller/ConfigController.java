package com.makschornyi.demolimitsservice.controller;

import com.makschornyi.demolimitsservice.config.Configuration;
import com.makschornyi.demolimitsservice.model.LimitConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {


    private final Configuration configs;

    public ConfigController(Configuration configs) {
        this.configs = configs;
    }

    @GetMapping("/limits")
    public LimitConfiguration getConfigs() {
        return new LimitConfiguration(configs.getMin(), configs.getMax());
    }
}
